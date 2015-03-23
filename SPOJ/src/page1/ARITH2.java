package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ARITH2 {
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
		int t= Integer.parseInt(br.readLine());
		while(t-->0)
		{
			br.readLine();
			StringTokenizer inp = new StringTokenizer(br.readLine());
			long a = 0;
			long b =0;
			String x1 ;
			a=Long.parseLong(inp.nextToken());
			while(inp.hasMoreTokens())
			{
			   x1 = inp.nextToken();
			   switch(x1.charAt(0))			  
			   {
			    case '+':a+=Long.parseLong(inp.nextToken());break;
				case '-':a-=Long.parseLong(inp.nextToken());break;
				case '*':a*=Long.parseLong(inp.nextToken());break;
				case '/':a/=Long.parseLong(inp.nextToken());break;
				case '=':break; 
			   }
			   
			}
			pw.println(a);
			
		}
	}
}
