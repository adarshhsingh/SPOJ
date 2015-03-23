package page1;
/*Naive String Search*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class NY10A {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	static String find[]={"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};
	static int found[]=new int[8];
	public static void main(String[] args) throws Exception {
		try {
			compute();
		} finally {
			pw.close();
		}
	}
 
	private static void compute() throws Exception {
		int t=Integer.parseInt(br.readLine());
		String toss;
		for (int t1 = 1; t1 <= t; t1++) 
		{
			br.readLine();
			toss=br.readLine();
		    pw.print(t1+" ");
			for(int i=0;i<8;i++)
		    {
		    	found[i]=0;
		    	for(int j=0;j<38;j++)
		    	{
		    		if(toss.substring(j, j+3).equals(find[i]))++found[i];	
		    	}
		    	pw.print(found[i]+" ");
		    }
			pw.println();
		}
	}
}
