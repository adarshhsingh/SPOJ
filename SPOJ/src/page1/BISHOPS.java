package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
class BISHOPS {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String inp;
		while ((inp=br.readLine())!=null) {
			BigInteger b=new BigInteger(inp);
			if(b.equals(BigInteger.ONE))b=BigInteger.ONE;
			else b=b.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(2));
			pw.println(b);
		}
		pw.close();
	}
}
