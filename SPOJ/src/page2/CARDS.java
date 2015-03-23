package page2;

import java.util.Scanner;

public class CARDS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int i=0;
		int a[]=new int[1000001];
		a[1]=2;
		for(i=2;i<1000001;i++)a[i]=(a[i-1]+i-1+2*i)%1000007;
		while(t-->0)
		{
			i=sc.nextInt();
			System.out.println(a[i]);
		}
	}
}
