package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class SBANK {
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
			
			int n = Integer.parseInt(br.readLine());
			
			String a[][]=new String[n][6];
			
			for( int i=0;i<n;i++) {
				a[i]=br.readLine().split(" ");
			}
			
			Arrays.sort(a, 0, a.length, new Comparator<String[]>() {

				@Override
				public int compare(String a[], String b[]) {
					return (a[0]+a[1]+a[2]+a[3]+a[4]+a[5]).compareTo(b[0]+b[1]+b[2]+b[3]+b[4]+b[5]);
				}
			});
			
			int i=0;
			int c=1;
			while(i<n) {
				if(i+1<n && ((a[i+1][0]+a[i+1][1]+a[i+1][2]+a[i+1][3]+a[i+1][4]+a[i+1][5])).equals((a[i][0]+a[i][1]+a[i][2]+a[i][3]+a[i][4]+a[i][5]))) {
					c++;
				}else {
					pw.println((a[i][0]+" "+a[i][1]+" "+a[i][2]+" "+a[i][3]+" "+a[i][4]+" "+a[i][5])+" "+c);
					c=1;
				}
				i++;
			}
			
			testcases--;
			if(testcases > 0){pw.println();br.readLine();}
		}
	}
}
