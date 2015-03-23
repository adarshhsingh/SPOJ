package page1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PT07Z {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws Exception {
		try {
			compute();
		} finally {
			pw.close();
		}
	}
 
	private static void compute() throws Exception {
		Map <Integer , List<Integer>> AdjacencyList = new HashMap<Integer,List<Integer>>();
		int n=Integer.parseInt(br.readLine());
		int vertex=n;
		for (int i = 1; i <= n; i++) {
			AdjacencyList.put(i, new LinkedList<Integer>());
			}
		boolean visited[]=new boolean[n+1];
		int x,y;
		List<Integer> slist;
		n--;
		String inp[];
		while(n-->0)
		{
			inp=br.readLine().split(" ");
			x=Integer.parseInt(inp[0]);
			y=Integer.parseInt(inp[1]);
			slist= AdjacencyList.get(x);
			slist.add(y);
			slist= AdjacencyList.get(y);
			slist.add(x);
		}
		int i = 1; // start first bfs from here
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		while(!q.isEmpty())
		{
			i=q.poll();
			visited[i]=true;
			slist=AdjacencyList.get(i);
			for (Integer x1 : slist) {
				if(!visited[x1]){visited[x1]=true;q.add(x1);}
			}	
		}
	//	System.out.print("->"+i);
		q.add(i);
		int d[]=new int[vertex+1];
		d[i]=0;
		Arrays.fill(visited, false);
		while(!q.isEmpty())
		{
			i=q.poll();
			visited[i]=true;
			slist=AdjacencyList.get(i);
			for (Integer x1 : slist) {
				if(!visited[x1]){visited[x1]=true;q.add(x1);d[x1]=d[i]+1;}
			}
		}
		

		//System.out.print("--"+i+" = "+d[i]);
		pw.print(d[i]);
	}
}
