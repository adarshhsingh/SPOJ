package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class WILLITST {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        String num=in.readLine();
        long s = Long.parseLong(num);
        if((s&(s-1))==0)pw.println("TAK");
        else pw.println("NIE");
        pw.close();
 }

}
