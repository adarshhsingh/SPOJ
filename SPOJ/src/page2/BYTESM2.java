package page2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BYTESM2 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws Exception {
		
		int t=Integer.parseInt(br.readLine());
		StringTokenizer inp;
		int maxSum=0,H,W;
		while(t-->0)
			{
				inp=new StringTokenizer(br.readLine());
				H=Integer.parseInt(inp.nextToken());
				W=Integer.parseInt(inp.nextToken());
				int arr[][]=new int[H+1][W+2];
				maxSum=0;
				int j=1;
				int a=0;
					for(int i=1;i<H+1;i++) {
				
					inp=new StringTokenizer(br.readLine());
					j=1;
					while(inp.hasMoreTokens()) {
						// System.out.println(i+" "+j);
					try{	 a= Math.max(arr[i-1][j-1], Math.max(arr[i-1][j], arr[i-1][j+1]));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} int x=0;
							x = Integer.parseInt(inp.nextToken());
						
						 arr[i][j]=x+a;
						 maxSum=(arr[i][j]>maxSum)?arr[i][j]:maxSum;
					//	 System.out.println(x+ " "+a+" "+arr[i][j]);
						 ++j;
					}
					}
				pw.println(maxSum);
			}
		pw.close();
	}

}
