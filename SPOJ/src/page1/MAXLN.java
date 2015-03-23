package page1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MAXLN {
	
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
		int t=Integer.parseInt(br.readLine());
		double r ;
		double s ;
		for (int i = 0; i < t ; i++) {
			r =Double.parseDouble(br.readLine());
			s = (double)(4*r*r + 0.25) ; 
			pw.println("Case "+(i+1)+": "+s);
		}
		
	}
}
