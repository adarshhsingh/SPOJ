package page1;
/*ULTRA EASY*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class NGM {
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
	long n = Long.parseLong(br.readLine());
	if(n%10==0)pw.println(2);
	else {
			pw.println(1);
			pw.println(n%10);
	}
	
	}
}
