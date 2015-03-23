package page2;

import java.io.*;

public class SUMITR {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
    static int testcases;
    static String inp[];
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
			int l =  Integer.parseInt(br.readLine());
			int[][] arr = input(l);
			System.out.println(getMaxSum(arr,l));
		}
	}

	private static int getMaxSum(int[][] arr, int l) {
		int max=0;
		for(int i=1;i<l;i++) {
			arr[i][0]+=arr[i-1][0];
			for(int j=1;j<=i;j++) {
				arr[i][j]+=Math.max(arr[i-1][j-1],arr[i-1][j]);
				max = (arr[i][j]>max)?arr[i][j]:max;
			}
		}
		return max;
	}

	private static int[][] input(int l) throws IOException {
		int arr[][]=new int[l][l];
		for(int i=0;i<l;i++) {
			inp=br.readLine().split(" ");
			for(int j=0;j<inp.length;j++) {
				arr[i][j]=Integer.parseInt(inp[j]);
			}
		}
		return arr;
	}
}
