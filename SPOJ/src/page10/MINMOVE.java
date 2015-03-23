package page10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MINMOVE {

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
		char a[] = br.readLine().toCharArray();
		int start = 0;
		int end = a.length-1;
		System.out.println(a);
	}
}
