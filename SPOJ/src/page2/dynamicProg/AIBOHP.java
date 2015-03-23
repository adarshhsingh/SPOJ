package page2.dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AIBOHP {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	static int testcases ;
	static int dp[][] = new int[6100][6100];
	static boolean calc[][]=new boolean[6100][6100];
	static int endI;
    public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException{
		testcases=Integer.parseInt(br.readLine());
		char[] a;
		int start =0;
		while( testcases-- > 0) {
			a = br.readLine().toCharArray();
			endI = a.length - 1;
			System.out.println(minInsertToMakePalin(a,start,endI));
		}
	
	}

	private static int minInsertToMakePalin(char[] a, int start, int end) {
		
//		// if not already calculate
//		if(!calc[start][end]) {
//			
//			calc[start][end] = true;
//			
//			if( start == end ) {
//				// if our substring is of length -> 1
//				dp[start][end]= 0;
//			} else if(end - start == 1) {
//				// if our substring is of length -> 2
//				if( a[start] == a[end]) dp[start][end] = 0;
//				else dp[start][end] = 1;
//			}
//			else if(a[start] == a[end])  {
//				// if our substring has first and last character same
//				if(!calc[start+1][end-1]) minInsertToMakePalin(a, start+1, end-1);
//				dp[start][end]= dp[start+1][end-1];
//			}
//			else {
//				// added a[start] character in the end , and calculate for middle 
//				if(!calc[start+1][end]) minInsertToMakePalin(a, start+1, end);
//				
//				// added a[end] character in the start , and calculate for middle 
//				if(!calc[start][end-1]) minInsertToMakePalin(a, start, end-1);
//				dp[start][end] = 1 + Math.min(dp[start+1][end],dp[start][end-1]);
//			}
//		}
//		return dp[start][end];
		
		
		for(int i=end; i>=0; i--) {
			for( int j=i; j<=end; j++) {				
				if(i == j) {
					dp[i][j] = 0;
				} else if(j - i == 1){
					if( a[i] == a[j]) dp[i][j]=0;
					else dp[i][j]=1;
				} else if( a[i] == a[j]){
					dp[i][j]= dp[i+1][j-1];
				}else {
					dp[i][j] = 1+ Math.min(dp[i+1][j],dp[i][j-1]);
				}
			}
		}
		return dp[start][end];
	}
}
