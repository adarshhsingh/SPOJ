package page2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class DOTAA {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
    private static final int INT_MIN = 2147483647;
	static long testcases;
    static String inp[];
    static String in;
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException {
		int n , m ;
		float a, d;
		int towerFall;
		testcases = Integer.parseInt(br.readLine());
		//br.readLine();
		while(testcases-- > 0) {
				inp = br.readLine().split(" ");
				//br.readLine();
				n = Integer.parseInt(inp[0]);
				m = Integer.parseInt(inp[1]);
				d = Float.parseFloat(inp[2]);
				towerFall = 0;
				while(n-->0) {
					a = Float.parseFloat(br.readLine());
					//br.readLine();
					int x =  (int) ((a-1)/d);
					if(x >=1) {
						towerFall += x;
					}
				//	System.err.println(x);
				//	System.out.println(towerFall);
				}
				pw.println(towerFall>=m?"YES":"NO");
				//br.readLine();br.readLine();
				
		}
	}
}
