package page2;

import java.util.Arrays;
import java.util.Scanner;

public class PARTY {
static int fees[]=new int[101];
static int fun[]=new int[101];
//static int dp[][]=new int[501][101];
static int r , c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		while(r!=0 && c!=0)
		{
			int dp[][]=new int[r+1][c+1];
			Arrays.fill(fun,0);
			Arrays.fill(fees, 0);
			for(int i=1;i<=c;i++){fees[i]=sc.nextInt();fun[i]=sc.nextInt();}
			knapsack(dp);
			int score=dp[r][c];
			while(r-1>=0&&dp[r-1][c]==score){r--;}
			System.out.println(r+" "+dp[r][c]);
			r=sc.nextInt();
			c=sc.nextInt();
		}
	}


	private static void knapsack(int[][]dp) {

		for(int w=0,i=0;i<=c;i++)dp[w][i]=0;
		for(int i=0,w=0;w<=r;w++)dp[w][i]=0;
		
		for(int i=1;i<=c;i++)
		{
			for(int w=1;w<=r;w++)
			{
				if(w<fees[i])dp[w][i]=dp[w][i-1];
				else
				dp[w][i]=Math.max(dp[w][i-1], dp[w-fees[i]][i-1]+fun[i]);
			}
		}
	}
}
