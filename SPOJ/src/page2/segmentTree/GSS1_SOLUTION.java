package page2.segmentTree;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * SPOJ 1043 - Can you answer these queries I
 * Created by Darren on 14-7-23.
 * Typical application of segment tree.
 */
public class GSS1_SOLUTION {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new GSS1_SOLUTION().run();
    }

    private int n;
    private int[] sequence; // The given sequence
    private int[] sum;      // sum[i]: sum of sequence[1...i]
    private int[] max;      // Max consecutive sum for each node
    private int[] maxPrefix;    // Max prefix sum for each node
    private int[] maxSuffix;    // Max suffix sum for each node

    void run() throws IOException {
        n = in.nextInt();
        sequence = new int[n+1];
        sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sequence[i] = in.nextInt();
            sum[i] = sum[i-1] + sequence[i];
        }
        maxPrefix = new int[n<<2];  // The tree may not be complete, thus more space than necessary
        maxSuffix = new int[n<<2];
        max = new int[n<<2];

        build(1, n, 1);

        int queries = in.nextInt();
        while (queries-- > 0) {
            out.println(query(in.nextInt(), in.nextInt(), 1, n, 1, new int[3]));
        }
        out.flush();
    }

    /**
     * Build a segment tree with a given interval.
     * @param rangeLeft left side of the interval.
     * @param rangeRight right side of the interval.
     * @param index index of the node representing the current interval.
     */
    void build(int rangeLeft, int rangeRight, int index) {
        // A singleton interval
        if (rangeLeft == rangeRight) {
            maxPrefix[index] = maxSuffix[index] = max[index] = sequence[rangeLeft];
            return;
        }

        int middle = (rangeLeft+rangeRight) >> 1;
        int leftChild = index<<1, rightChild = leftChild+1;

        // Recursively build the segment tree
        build(rangeLeft, middle, leftChild);
        build(middle+1, rangeRight, rightChild);

        // Update max, maxPrefix, and maxSuffix
        // max[index] = max{ max[leftChild], max[rightChild],
        // maxSurfix[leftChild]+maxPrefix[rightChild] }
        max[index] = (max[leftChild] > max[rightChild]) ? max[leftChild] : max[rightChild];
        max[index] = (max[index] > maxSuffix[leftChild]+maxPrefix[rightChild]) ? max[index] :
                maxSuffix[leftChild]+maxPrefix[rightChild];
        // maxPrefix[index] = max{ maxPrefix[leftChild],
        // sum_of_the_sequence_in_the_left_child+maxPrefix[rightChild] }
        maxPrefix[index] = (maxPrefix[leftChild] > sum[middle]-sum[rangeLeft-1]+maxPrefix[rightChild])
                ? maxPrefix[leftChild] : sum[middle]-sum[rangeLeft-1]+maxPrefix[rightChild];
        // maxSuffix[index] = max{ maxSuffix[rightChild],
        // maxSuffix[leftChild]+sum_of_the_sequence_in_the_right_child }
        maxSuffix[index] = (maxSuffix[rightChild] > maxSuffix[leftChild]+sum[rangeRight]-sum[middle])
                ? maxSuffix[rightChild] : maxSuffix[leftChild]+sum[rangeRight]-sum[middle];
    }

    /**
     * Find the max consecutive sum of the subsequence in a given interval.
     * @param queryLeft left side of the queried interval
     * @param queryRight right side of the queried interval
     * @param rangeLeft left side of the interval current node represent
     * @param rangeRight right side of the interval current node represent
     * @param index index of the node representing the current interval.
     * @param info an array of size 3 used to store additional information.
     *             info[0]: max prefix sum in the queried interval
     *             info[1]: max suffix sum in the queried interval
     *             info[2]: sum of whole sequence in the queried interval
     * @return the max consecutive sum of the subsequence in the queried interval.
     */
    int query(int queryLeft, int queryRight, int rangeLeft, int rangeRight, int index,
              int[] info) {
        // The current interval is within the queried interval
        if (queryLeft <= rangeLeft && queryRight >= rangeRight) {
            info[0] = maxPrefix[index];
            info[1] = maxSuffix[index];
            info[2] = sum[rangeRight] - sum[rangeLeft-1];
            return max[index];
        }

        // The queried interval is in either half of the current interval
        int middle = (rangeLeft+rangeRight) >> 1;
        int leftChild = index << 1, rightChild = leftChild+1;
        if (queryRight <= middle)
            return query(queryLeft, queryRight, rangeLeft, middle, leftChild, info);
        if (queryLeft > middle)
            return query(queryLeft, queryRight, middle+1, rangeRight, rightChild, info);

        // The queried interval intersects with both halves
        int[] infoLeft = new int[3], infoRight = new int[3];
        int maxLeft = query(queryLeft, queryRight, rangeLeft, middle, leftChild, infoLeft);
        int maxRight = query(queryLeft, queryRight, middle+1, rangeRight, rightChild, infoRight);

        // Below is similar to what we did when building the tree
        int max = (maxLeft > maxRight) ? maxLeft : maxRight;
        max = (max > infoLeft[1]+infoRight[0]) ? max : infoLeft[1]+infoRight[0];
        info[0] = (infoLeft[0] > infoLeft[2]+infoRight[0]) ? infoLeft[0] : infoLeft[2]+infoRight[0];
        info[1] = (infoRight[1] > infoRight[2]+infoLeft[1]) ? infoRight[1] : infoRight[2]+infoLeft[1];
        info[2] = infoLeft[2] + infoRight[2];
        return max;
    }

    /**
     * A fast parser taking in an InputStream, with self-maintained buffer
     */
    static class Parser {
        final private int BUFFER_SIZE = 65536;  // 2^16, a good compromise for some problems
        private InputStream din;    // Underlying input stream
        private byte[] buffer;      // Self-maintained buffer
        private int bufferPointer;  // Current read position in the buffer
        private int bytesRead;      // Effective bytes in the buffer read from the input stream

        public Parser(InputStream in) {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        /**
         * Read the next integer from the input stream.
         * @return The next integer.
         * @throws java.io.IOException
         */
        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
            if (neg) return -result;
            return result;
        }

        /**
         * Read the next byte of data from the input stream.
         * @return the next byte of data, or -1 if the end of the stream is reached.
         * @throws IOException if an I/O error occurs.
         */
        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        /**
         * Read data from the input stream into the buffer
         * @throws IOException if an I/O error occurs.
         */
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}
