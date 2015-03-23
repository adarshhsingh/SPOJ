package page2.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class QUADAREA {
	
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		String str[];
		double a,b,c,d,s,area;
		while(t-- >0)
		{
			str = br.readLine().split(" ");
			a=Double.parseDouble(str[0]);
			b=Double.parseDouble(str[1]);
			c=Double.parseDouble(str[2]);
			d=Double.parseDouble(str[3]);
			
			s=(a+b+c+d)/2;
			area = Math.sqrt((s-a)*(s-b)*(s-c)*(s-d)); 
			pw.println(area);
		}
		pw.close();
	}
}
