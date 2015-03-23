package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;

public class BEENUMS {
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
	
		Vector s = new Vector<Integer>();
		int n=1;
		int i=2;
		s.add(0);
		while(n<1000000000)
		{
			s.add(n);
			n+=i;
			++i;
		}
		int inp;
		while((inp=Integer.parseInt(br.readLine()))!=-1)
		{
			if((inp-1)%6!=0)pw.println('N');
			else
			{
				pw.println(s.contains((inp-1)/6)?'Y':'N');
			}
		}
	}
}
