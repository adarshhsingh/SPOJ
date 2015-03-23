package page1;

import java.io.PrintWriter;
import java.util.Scanner;



public class GIRLSNBS {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int x,y,ans;
		x = sc.nextInt();
		y = sc.nextInt();
		while (x!=-1 && y!=-1) {
			if(y>x){x=x+y;y=x-y;x=x-y;}
			ans=x/(y+1);
			if(x%(y+1)!=0)ans++;
			pw.println(ans);
			x = sc.nextInt();
			y = sc.nextInt();

		}
		pw.close();
	}
}
