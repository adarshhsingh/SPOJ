package page1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ARMYS {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(System.out);
	int t=Integer.parseInt(in.readLine());
	int maxG,maxM;
	while(t-->0)
	{
		in.readLine();
		in.readLine();
		maxG=0;
		maxM=0;

		for(StringTokenizer st = new StringTokenizer(in.readLine()); st.hasMoreTokens(); ) maxG = max(maxG, Integer.parseInt(st.nextToken()));
		for(StringTokenizer st = new StringTokenizer(in.readLine()); st.hasMoreTokens(); ) maxM = max(maxM, Integer.parseInt(st.nextToken()));
		
		if(maxG>=maxM)pw.println("Godzilla");
		else pw.println("MechaGodzilla");
	}
	pw.close();	   
}

	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		return (a>b)?a:b;
	}
}
