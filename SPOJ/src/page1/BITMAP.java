package page1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BITMAP {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	private static int dx[]={1,-1,0,0};
	private static int dy[]={0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		try {
			compute();
		} finally {
			pw.close();
		}
	}
 
	private static void compute() throws Exception {
	
		int t=Integer.parseInt(br.readLine());
		String inp[];
		while(t-->0)
		{
			inp=br.readLine().split(" ");
			int n=Integer.parseInt(inp[0]);
			int m=Integer.parseInt(inp[1]);
			char[][] g = new char[n][m];
			int a[][]=new int[n][m];
			String str;
			int x = 0 , y=0 ;
			boolean foundFirstWhite=false;
			for (int i = 0; i < n; i++) {
				g[i]=(str=br.readLine()).toCharArray();
				Arrays.fill(a[i],10000);
				if(!foundFirstWhite)
				{
					if(str.indexOf('1')>-1){foundFirstWhite=true;x=i;y=str.indexOf('1');}
				}
			}
			
			
			a=bfs(g,a,x,y,n,m);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					pw.print(a[i][j]+" ");	
				}
				pw.println();
				}
			pw.println();
			br.readLine();
		}
		
		
	}

	private static int[][] bfs(char[][] g, int[][] a, int x, int y, int n, int m) {
		// TODO Auto-generated method stub
		 
		 int i , j;
		 int newI , newJ ;
		 Queue<Integer> q = new LinkedList<Integer>();
		 q.add(x*m+y);
		 a[x][y]=0;
		 while(!q.isEmpty())
		 {
			 int pos = q.poll();
			 i=pos/m;
			 j=pos%m;
//			 System.out.println("At : "+i+" , "+j);
			 for (int k = 0; k < 4; k++) {
				newI=i+dx[k];
				newJ=j+dy[k];
				if(newI<n && newI>-1 && newJ<m && newJ>-1)
				{
					if( g[newI][newJ]=='0' && a[i][j]+1<a[newI][newJ])
					{
//						System.out.println("At : ----> "+i+" , "+j);
						a[newI][newJ]=a[i][j]+1;
						q.add(newI*m+newJ);
					}
					else if(g[newI][newJ]=='1' && a[newI][newJ]!=0)
					{
//						 System.out.println("At : ----> "+i+" , "+j);		
						a[newI][newJ]=0;
						q.add(newI*m+newJ);
					}
				}
				
					
			 }
		}
		 
		 return a;
	}
}
