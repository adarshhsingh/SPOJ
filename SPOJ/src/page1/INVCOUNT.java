package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class INVCOUNT {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
    private static long count=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}
 
	private static void compute() throws IOException {
	int t=Integer.parseInt(br.readLine());
	while(t-->0)
	{
		br.readLine();
		int n=Integer.parseInt(br.readLine());
		int a[]=new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i]=Integer.parseInt(br.readLine());
		}
		count=0;
		a=MergeSort(a,0,a.length-1);
		pw.println(count);
	}
	}



	private static int[] MergeSort(int[] a , int start , int end) {
		// TODO Auto-generated method stub
		if(end-start==0) return  a;
		
		int i= start;
		int j=(end+start)/2;
		a=MergeSort(a, i, j);
		a=MergeSort(a, j+1, end);
		a=MergeAndCount(a , i , j , j+1 , end);
		return a;
				
	}

	private static int[] MergeAndCount(int[] a, int aS, int aE, int bS, int bE) {
		// TODO Auto-generated method stub
		int i=aS,j=bS;
		while(i<=aE && j<=bE)
		{
			if(a[j]<a[i])
			{
				count+=(aE-i+1);
				++j;
			}
			else
			{	++i;
			}
		}
		Arrays.sort(a,aS,bE+1);
		return a;
	}

}
