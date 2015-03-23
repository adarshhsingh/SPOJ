package page2.dynamicProg;
/*
 * FJ has purchased N (1 <= N <= 2000) yummy treats for the cows who get money for
 *  giving vast amounts of milk. FJ sells one treat per day and wants to maximize 
 *  the money he receives over a given period time. The treats are interesting for many reasons:
 *  The treats are numbered 1..N and stored sequentially in single file in a long box that is open
 *  at both ends. On any day, FJ can retrieve one treat from either end of his stash of treats.
 *  Like fine wines and delicious cheeses, the treats improve with age and command greater prices.
 *  The treats are not uniform: some are better and have higher intrinsic value. 
 *  Treat i has value v(i) (1 <= v(i) <= 1000).
 *  Cows pay more for treats that have aged longer: a cow will pay v(i)*a for a treat of age a.
 *  Given the values v(i) of each of the treats lined up in order of the index i in their box,
 *  what is the greatest value FJ can receive for them if he orders their sale optimally?
 *  
 *  The first treat is sold on day 1 and has age a=1. Each subsequent day increases the age by 1.
 *  
 *  Input
 *  
 *  Line 1: A single integer, N
 *  Lines 2..N+1: Line i+1 contains the value of treat v(i)
 *  
 *  Output
 *  
 *  The maximum revenue FJ can achieve by selling the treats
 *  
 *  Example
 *  Input:
5
1
3
1
5
2

Output:
43
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TRT {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
    static int dp[][]=new int[2000][2000];
	static int yummy[]=new int[2000];
	static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException{
		// TODO Auto-generated method stub
		n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)	{
			Arrays.fill(dp[i], -1);
			yummy[i] = Integer.parseInt(br.readLine());
		}
		int ans=treat(0,n-1);
		pw.print(ans);
	
	}

	private static int treat(int top, int bottom) {
		if(top > bottom) return 0;
		
		if(dp[top][bottom]!=-1)	{
			return dp[top][bottom];
		}
		int day = n - bottom + top;
		
		dp[top][bottom] = Math.max((treat(top+1,bottom)+yummy[top]*day), (treat(top,bottom-1)+yummy[bottom]*day)) ;
		
		return dp[top][bottom];
	}
}
