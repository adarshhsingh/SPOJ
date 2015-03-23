package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

import page1.TEST;

public class AMR10G {
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
			inp=br.readLine().split(" ");
			int n = Integer.parseInt(inp[0]);
			int k = Integer.parseInt(inp[1]);
			int a[]=new int[n];
			inp=br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				a[i]=Integer.parseInt(inp[i]);
			}
			Arrays.sort(a);
			int d=0;
			int minD=1000000001;
			for (int i = 0, j=k-1 ; j < a.length; i++,j++) {
				d = a[j]-a[i];
				minD = (minD < d)?minD:d;
			}
			pw.println(minD);
			testcases--;
		}
	}

}
