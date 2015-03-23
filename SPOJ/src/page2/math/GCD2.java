package page2.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GCD2 {
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
		
		while(testcases > 0) {
			
			inp = br.readLine().split(" ");
			int rem = mod(inp[0],inp[1]);
			
			testcases--;
			
			
		}
	}

	private static int mod(String inp, String inp2) {
		int a = Integer.parseInt(inp);
		int b=0;
		int l = inp.length();
		int l2 = inp2.length();
		boolean divComplete = false;
		int x=0;
		int s = 0;
		int rem=0;
		StringBuilder divisor=new StringBuilder();
		while(!divComplete) {
			if(rem!=0)divisor.append(rem);
			int lD = divisor.length();
			if( l2-s+lD < l){
				break;
			}
			divisor.append(inp2.substring(s, s+l-lD));
			s =  s+l-lD;
			x = Integer.parseInt(divisor.toString());
			if( x < a) {
				divisor.append(inp2.substring(s, s+l-lD+1));
				s =  s+l-lD+1;
				x = Integer.parseInt(divisor.toString());
			}
			rem = x%a;
			if(rem==0)break;
			divisor.delete(0,divisor.length());
		}
		
		System.out.println(rem);
		
		return rem;
	}
}
