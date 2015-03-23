package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class PIGBANK {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	static final int MAX=10000;
	static int p[]=new int[500];
	static int w[]=new int[500];
	static int W , N ;
	static long dp[]=new long[MAX+1];
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException {
	
	int t=Integer.parseInt(br.readLine());
	String str;
	String inp[];
	while(t-- >0)
	{
		inp=br.readLine().split(" ");
		W = Integer.parseInt(inp[1])-Integer.parseInt(inp[0]);
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			str=br.readLine();
			inp=str.split(" ");
			p[i]=Integer.parseInt(inp[0]);
			w[i]=Integer.parseInt(inp[1]);
		}
		Arrays.fill(dp, 0);
		for(int i=0;i<N;i++)
		{
			for(int j=w[i];j<=W;j++)
			{
				if(dp[j]==0)
				{
					if(j-w[i]==0)
						{
						  dp[j]=p[i];
						}
					else if(dp[j-w[i]]!=0)
						dp[j]=dp[j-w[i]]+p[i];
				}
				else 
				{
					if(j-w[i]==0){ if(dp[j]>p[i])dp[j]=p[i];}
					else if(dp[j-w[i]]!=0) if(dp[j]>(dp[j-w[i]]+p[i]))dp[j]=dp[j-w[i]]+p[i];
				}
			}
		}
		
		pw.println((dp[W]==0)?"This is impossible.":"The minimum amount of money in the piggy-bank is "+dp[W]+".");
	}
	}
	
}

	
	
