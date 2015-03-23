package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author naruto
 *
 */
public class CANDY3 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
    
	public static void main(String[] args) throws Exception {
		try {
			compute();
		} finally {
			pw.close();
		}
	}
 
	/**
	 * @throws Exception
	 */
	private static void compute() throws Exception {
		long testcases = Long.parseLong(br.readLine());
		while(testcases-->0)
		{
			br.readLine();
		    long childrens = Long.parseLong(br.readLine());
		    long sum = 0;
		    for (long i = 0; i < childrens; i++) {
		    	sum=(sum+Long.parseLong(br.readLine()))%childrens;
		    }
		    pw.println((sum==0)?"YES":"NO");
		}
	}
}
