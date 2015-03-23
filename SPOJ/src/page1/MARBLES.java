package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MARBLES {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException {
		br.readLine();
		String inp;
		String str[];
		while((inp=br.readLine())!=null)
		{
			str=inp.split(" ");
			long n = Long.parseLong(str[0]);
			long k = Long.parseLong(str[1]);
			pw.println(nCr(n-1,k-1));
		}
	}

	private static long nCr(long l, long m) {
		
		if(m>(l/2))m=l-m;
		long res = 1 , i=0;
		for(;i<m;i++,l--)
		{
			res*=l;
			res/=(i+1);
		}
		return res;
	}
}
