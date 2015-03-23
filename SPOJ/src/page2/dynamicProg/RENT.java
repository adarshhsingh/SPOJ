package page2.dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class RENT {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	static int testcases ;
	static int order[][];
	static int profit[]=new int[10000];
	//static int dp[][]=new int[10000][1000000];
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
			int n = Integer.parseInt(br.readLine());
			String inp[][]=new String[n][3];
			for (int i = 0; i < n; i++) {
				inp[i]=br.readLine().split(" ");
			}
			order=parse(inp);
			order = putNextPotentialStartAtEnd(order);
		    Arrays.fill(profit, -1);	
			System.out.println(maxProfit(0,order[0][0]));
			
		}
	}

	private static int[][] putNextPotentialStartAtEnd(int[][] order) {
		int i=0;
		int j=1;
		while(i<order.length && j<order.length) {
			if(order[j][0]< order[i][1]) j++;
			else {
				order[i][1]=order[j][0];
				i++;
			}
		}
		for(;i<order.length;i++)order[i][1]=-1;
		
		return order;
	}

	private static int[][] parse(String[][] inp) {
		int o[][]=new int[inp.length][3];
		for (int i = 0; i < o.length; i++) {
			o[i][0]=Integer.parseInt(inp[i][0]);
			o[i][1]=Integer.parseInt(inp[i][1])+o[i][0];
			o[i][2]=Integer.parseInt(inp[i][2]);
		//	Arrays.fill(dp[i],-1);
		}
		return o;
	}

	private static int maxProfit(int i, int sT) {

		//if(profit[i]!=-1 || order[i][0]>sT){
		if(order[i][0] == sT) {			
			if(i == order.length-1) profit[i]= order[i][2];
			else
			profit[i]= Math.max((order[i][2]+maxProfit(i+1, order[i][1])),
							maxProfit(i+1, sT));
		} else if(order[i][0] > sT && sT!=-1) {
			profit[i]= maxProfit(i, order[i][0]);
		} else {
			if(i == order.length-1) profit[i]= 0;
			else profit[i]= maxProfit(i+1, sT);
		}
		//}
		return profit[i];

	}

}
