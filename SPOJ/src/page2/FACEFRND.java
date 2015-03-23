package page2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;

public class FACEFRND {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
	
    public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException{
		int n = Integer.parseInt(br.readLine());
		Vector<Integer> friendsFriendsList = new Vector<Integer>();
		int BOB = -1,f,m,ff;
		int a[]=new int[10000];
		String[] inp;
		while(n-- >0) {
			inp = br.readLine().split(" ");
			
			f = Integer.parseInt(inp[0]);
			a[f]=BOB;
			if(friendsFriendsList.contains(f)) {
				friendsFriendsList.removeElement(f);
			}
			m = Integer.parseInt(inp[1]);
			for(int i=2; i< m+2;i++) {
				ff = Integer.parseInt(inp[i]);
				if(a[ff]!=BOB) { 
					//a[ff] = f;
					if(!friendsFriendsList.contains(ff)) {
						friendsFriendsList.add(ff);
					}
				}
			}
		}
		//System.out.println(friendsFriendsList);
		pw.println(friendsFriendsList.size());
		
		
	}
}
