package page1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class JAVAC {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
 
	public static void main(String[] args) throws Exception {
		try {
			compute();
		} finally {
			pw.close();
		}
	}
 
	private static void compute() throws Exception {
	String inp;
	char un='_';
	while((inp=br.readLine())!=null)
	{
		
		char a[]=inp.toCharArray();
		String out = "";
		int i=0;
		boolean error=false;
		boolean underscore=false;
	
		if(inp.matches(".*[A-Z].*"))
		{
			// it is not c++
			if(inp.matches(".*_.*") || (a[0]<='Z' && a[0]>='A') )
			{
				error=true;
			}
			else
			{
				i=0;
				while(i<a.length)
				{
					if(a[i]<='Z' && a[i]>='A')
					{
						out+=("_"+(char)(a[i]+32));
					}
					else
					{
						out+=a[i];
					}
					++i;
				}
			}
		}
		else
		{
			if(inp.matches(".*__.*") || a[0]=='_' || a[a.length-1]=='_' )
			{
				error=true;
			}
			else{
				i=0;
			
			while(i<a.length)
			{
				if(a[i]=='_')
				{
					++i;
					out+=(char)(a[i]-32);
				}
				else
				{
					out+=a[i];
				}
				++i;
			}
			}
		}
		
		System.out.println(error?"Error!":out);
		

		
	}
	}
}

