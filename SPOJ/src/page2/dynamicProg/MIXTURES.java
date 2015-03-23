package page2.dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class MIXTURES {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
    private static final int INT_MIN = 2147483647;
	static long testcases;
    static String inp[];
    static String in;
    static SegmentTree st ;
    static int smoke[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException {
		int n;
		
		while((in=br.readLine())!=null) {
		
			n = Integer.parseInt(in);
			inp = br.readLine().split(" ");
			int[] a = new int[n];
			for(int i=0;i<n;i++) {
				a[i] = Integer.parseInt(inp[i]);
			}
			smoke = new int[n][n];
			for (int j = 0; j < smoke.length; j++) {
				Arrays.fill(smoke[j], -1);
			}
		
			st = new SegmentTree(a.length);
			st.constructSegmentTree(a);
			System.out.println(getSmoke(a,0,n-1));
			
		}
		
	}

	// use memozization
	private static int getSmoke(int[] a, int i, int j) {
		if(smoke[i][j]!=-1) return smoke[i][j];
		if(i == j) return 0;
		int k;
		int smoke1 = 0;
		int minSmoke = INT_MIN;  

		for( k=i; k<j; k++) {
			//System.out.println("i="+i+", k="+k+", j="+j);
			if(smoke[i][k]==-1) smoke[i][k]=getSmoke(a, i, k);
			if(smoke[k+1][j]==-1) smoke[k+1][j]=getSmoke(a, k+1, j);
			
			smoke1 =smoke[i][k]  +smoke[k+1][j] + (st.getSum(i,k)*st.getSum(k+1,j));
			//System.out.println(smoke);
			if(smoke1 < minSmoke) minSmoke = smoke1;
		}
		//System.out.println("min = "+minSmoke);
		return minSmoke;
	}

	// reduce sum time by using Segment Tree
	private static int sum(int[] a, int i, int j) {
		int s = 0;
		for(;i<=j;i++) {
			s+=a[i];
		}
		return s%100;
	}
}
class SegmentTree {
	
	int height ;
	int maxNodes;
	int tree[];

	private static int START= 0;
	private static int ROOT = 0;
	private static int END;
	
	public SegmentTree(int size) {
		height = (int) Math.ceil(Math.log(size)/Math.log(2));
		maxNodes = 2*(int) Math.pow(2, height);
		tree = new int[maxNodes-1];
		END = size-1;
//		System.out.println("height="+height+" , maxNodes="+maxNodes+" size="+size);

	}
	
	public void constructSegmentTree(int a[]) {
		constructSegmentTreeUtil(a,START,END,ROOT);
/*		System.out.println("tree");
		for(int i=0;i<tree.length;i++) {
			System.out.print(tree[i]+ " ");
		}
		System.out.println("tree");*/
	}

	private int constructSegmentTreeUtil(int[] a, int i, int j, int current) {
		int mid;
		if(i>j) return 0;
		
		if(i == j) {
			tree[current] = a[i];
		}
		else {
		mid = (i+j)/2;
		tree[current] = constructSegmentTreeUtil(a, i, mid, current*2+1) + constructSegmentTreeUtil(a, mid+1, j, current*2+2);
		}
		
		return tree[current]; 
	}
	
	public int getSum(int i, int j) {
		
		return getSumUtil(i, j, START, END, ROOT)%100;
	}

	private int getSumUtil(int queryStart, int queryEnd, int start, int end, int current) {
		//System.out.println("queryStart=" + queryStart+" queryEnd="+queryEnd+" start="+start+" end="+end+" current="+current);
		
		if(queryStart <= start  && queryEnd>= end) return tree[current];
		
		if(queryStart > end || queryEnd < start) return 0;
		
		int mid = (start+end)/2;
		
		return getSumUtil(queryStart, queryEnd, start, mid, current*2+1) + getSumUtil(queryStart, queryEnd, mid+1, end, current*2+2);
	}	
}