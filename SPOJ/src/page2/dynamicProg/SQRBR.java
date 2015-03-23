package page2.dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Vector;

public class SQRBR {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	static int testcases ;
    static Vector<Integer> v ;
    static int n,k;
    static int dp[][]=new int[38][38];
    public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException{
		testcases=Integer.parseInt(br.readLine());
		while( testcases-- > 0) {
			String inp[]=br.readLine().split(" ");
			 n = Integer.parseInt(inp[0]);
			 k = Integer.parseInt(inp[1]);
			inp=br.readLine().split(" ");
			v = fill(inp);
			System.out.println(count());
		}
	}

	private static int count() {
		
/*		if(i==2*n-1) {
			dp[i][open]=(open==1 && !v.contains(i))?1:0;
		}
		
		if(dp[i][open]==-1) {
		
		if(i==2*n-1) {
			dp[i][open]=(open==1 && !v.contains(i))?1:0;
		}
		if(v.contains(i)) {
			dp[i][open]= count(i+1, open+1);
		}
		else {
			if(open == 0)
				dp[i][open] = count(i+1, open+1);
			else dp[i][open] = count(i+1, open+1)+count(i+1, open-1);
		}
		}*/
		
		for(int i=2*n-1;i>=0;i--) {
			for(int open=0;open<=2*n-1;open++) {
				if(i==2*n-1) {
					dp[i][open]=(open==1 && !v.contains(i))?1:0;
				} else {
					if(v.contains(i)) {
						dp[i][open]= dp[i+1][open+1];
					}
					else {
						if(open == 0)
							dp[i][open] = dp[i+1][open+1];
						else dp[i][open] = dp[i+1][open+1]+dp[i+1][open-1];
					}
				}
			}
		}
		
		
		return dp[0][0];
	}

	private static Vector<Integer> fill(String[] inp) {
		Vector<Integer> x = new Vector<Integer>();
		for (int i = 0; i < inp.length; i++) {
			x.add(Integer.parseInt(inp[i])-1);
		}
		return x;
	}
}
