package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class ANARC09A {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
    static int testcases;
    static String inp;
    static String in;
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException {
		inp = br.readLine();
		Stack<Character> st = new Stack<Character>();
		char c ;
		int open = 0;
		int close = 0;
		int moves = 0;
		int testcase = 0;
		while(inp.indexOf('-')<0) {
			moves = 0;
			++testcase;
			open = 0;
			for(int i=0; i<inp.length(); i++) {
				c = inp.charAt(i);
				if( c == '{') {
					//st.push(c);
					open++;
				} else {
					if(open == 0) {
						moves++;
						open++;
						//st.push('{');
					} else {
						open--;
					}
				}
			}
			if(open > 0) {
				moves += open/2;
			}
			pw.println(testcase+". "+moves);
			inp = br.readLine();
		}
	}
}
