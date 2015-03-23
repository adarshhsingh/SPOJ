package page1;

import java.util.Scanner;

public class FENCE1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		double n; 
		while(!((int)(n=sc.nextDouble())==0))
	    {
	      double ans = (n*n*7)/44;
	      System.out.printf("%.2f",ans);
	    }
	}
}
