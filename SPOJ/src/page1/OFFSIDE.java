package page1;
/*ULTRA EASY*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OFFSIDE {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}
 
	private static void compute() throws IOException {
	
		int a , d ;
		StringTokenizer inp = new StringTokenizer(br.readLine());
		a=Integer.parseInt(inp.nextToken());
		d=Integer.parseInt(inp.nextToken());
	    while(a!=0 && d!=0)
	    {
	    	int attackers[]=new int[a];
	    	int defenders[]=new int[d];
	    	StringTokenizer inp2 = new StringTokenizer(br.readLine());
			int att=10001;
			int def1=10001 , def2=10001 ;
	    	for (int i = 0; i < attackers.length; i++) {
	    		int x=Integer.parseInt(inp2.nextToken());
				if(x<att)att=x;
			}
	    	StringTokenizer inp3 = new StringTokenizer(br.readLine());
			for (int i = 0; i < defenders.length; i++) {
				int x=Integer.parseInt(inp3.nextToken());
				if(x<def1){def2=def1;def1=x;}
				else if(x<def2)def2=x;
			}
			if(att<def2)pw.println("Y");
			else pw.println("N");
	    	StringTokenizer inp1 = new StringTokenizer(br.readLine());
			a=Integer.parseInt(inp1.nextToken());
			d=Integer.parseInt(inp1.nextToken());
		    	
	    }
	}
}
