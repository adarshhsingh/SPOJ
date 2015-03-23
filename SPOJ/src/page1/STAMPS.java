/*
 3375. Stamps

Problem code: STAMPS



Everybody hates Raymond. He’s the largest stamp collector on planet earth
 and because of that he 
always makes fun of all the others at the stamp collector parties. 
Fortunately everybody loves Lucy, 
and she has a plan. She secretly asks her friends whether they could lend her some stamps, so that she 
can embarrass Raymond by showing an even larger collection than his. Raymond is so sure about his superiority 
that he always tells how many stamps he’ll show.And since Lucy knows how many she owns, she knows how many more
 she needs. She also knows how many friends would lend her some stamps and how many each would lend. But she’s 
 like to borrow from as few friends as possible and if she needs too many then she’d rather not do it at all. 
 Can you tell her the minimum number of friends she needs to borrow from?

Input

The first line contains the number of scenarios.
 Each scenario describes one collectors party and its first line
 tells you how many stamps (from 1 to 1000000)
  Lucy needs to borrow and how many friends (from 1 to 1000) offer 
 her some stamps. In a second line you’ll get the number of stamps 
 (from 1 to 10000) each of her friends id offering.

Output

The output for every scenario begins with a line containing “Scenario #i:”, where i is the number of the scenario
starting at 1. Then print a single line with the minimum number of friends Lucy needs to borrow stamps from. If 
it’s impossible even if she borrows everything from everybody, write impossible. Terminate the output for the 
scenario with a blank line.

Example

Input:
3
100 6
13 17 42 9 23 57
99 6
13 17 42 9 23 57
1000 3
314 159 265


Output:
Scenario #1:
3

Scenario #2:
2

Scenario #3:
impossible

Added by:	Daniel Gómez Didier
Date:	2008-11-17
Time limit:	3s
Source limit:	50000B
Memory limit:	256MB
Cluster:	Pyramid (Intel Pentium III 733 MHz)
Languages:	All except: ERL JS
Resource:	2007 - Circuito de Maratones ACIS / REDIS

 */
package page1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class STAMPS {

	public static void main(String[] args)throws IOException  {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
	    int i , need , remaining , noF ,friend[]=new int[1000];	
		for(int s=1;s<=t;s++)
		{
			String str[]=br.readLine().split(" ");
			need=Integer.parseInt(str[0]);
			remaining=need;
			noF=Integer.parseInt(str[1]);
			String str2[]=br.readLine().split(" ");
			for(i=0;i<noF;i++)
				{
				friend[i]=Integer.parseInt(str2[i]);
				}
				Arrays.sort(friend,0,noF);
			for(i=noF-1;i>=0;i--)
				{
					remaining-=friend[i];
					if(remaining<=0)break;
				}
			if(remaining<=0)
				pw.println("Scenario #"+s+":\n"+(noF-i)+"\n");
			else pw.println("Scenario #"+s+":\nimpossible\n");
		}
		pw.close();
	}
	
	
	

}
