package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TWOSQRS {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
    static int testcases;
    static String inp[];
    static String in;
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException {
		testcases = Integer.parseInt(br.readLine());
		boolean flag = false;
		while(testcases-- > 0) {
			flag = false;
			long inp=Long.parseLong(br.readLine());
			long x = 0; 
			long y = (int) Math.sqrt(inp);
			while(x<=y) {
				if(x*x+y*y==inp) {
					flag = true;
					break;
				} else if(x*x+y*y > inp) {
					y--;
				} else {
					x++;
				}
			}
			pw.println(flag?"Yes":"No");
		}
	}
}
