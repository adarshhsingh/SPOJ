/**
 Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls.
The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other
once put into a stall. To prevent the cows from hurting each other, FJ want to assign the cows
to the stalls,such that the minimum distance between any two of them is as large as possible. 
What is the largest minimum distance?

Input

t – the number of test cases, then t test cases follows. 
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output

For each test case output one integer: the largest minimum distance.
Example

Input:

1
5 3
1
2
8
4
9
Output:

3
Output details:

FJ can put his 3 cows in the stalls at positions 1, 4 and 8, 
resulting in a minimum distance of 3.
@author naruto
*/
package page2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AGGRCOW {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	static int t , i , j;
	static 	int n, c;
	static int pos[]=new int[100001];
	static String inp[];
	// Integer.parseInt(br.readLine());
	//Integer.parseInt(inp[0]);
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute()throws IOException {
	
		t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			inp = br.readLine().split(" ");
			n = Integer.parseInt(inp[0]);
			c = Integer.parseInt(inp[1]);
			
			for (i = 0; i < n; i++) {
				pos[i]=Integer.parseInt(br.readLine());
			}
			Arrays.sort(pos,0,n);
			
			System.out.println(binaySearch(pos));
		}
	
	}

	private static int binaySearch(int[] pos) {
		
		int start = 0 , end = pos[n-1];
		int mid = (-start+end)/2;
		while( start < end ) {
		//	System.out.println(start+" "+end+" "+mid);
			if(  f(mid) == 1 ) {
				start = mid+1;
			} else {
				end = mid-1;
			}
			mid = (start+end)/2;
		}
		return (f(mid)==1?mid:mid-1);
	}

	private static int f(int d) {
		int cowPlaced = 1;
		int prev = 0;
		for( int i=1;i<n;i++) {
			
			if( pos[i]-pos[prev] >= d) {
				++cowPlaced;
				prev = i;
				if(cowPlaced == c)return 1;
			}
		}
		return 0;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
