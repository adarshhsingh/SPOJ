/*
394. Alphacode

Problem code: ACODE

Alice and Bob need to send secret messages to each other and are discussing
ways to encode their messages:

Alice: “Let’s just use a very simple code: We’ll assign ‘A’ the code word 1, 
‘B’ will be 2,and so on down to ‘Z’ being assigned 26.”

Bob: “That’s a stupid code, Alice. Suppose I send you the word ‘BEAN’ 
encoded as 25114.You could decode that in many different ways!”
Alice: “Sure you could, but what words would you get? 
Other than ‘BEAN’, you’d get ‘BEAAD’, ‘YAAD’, ‘YAN’, ‘YKD’ and ‘BEKD’. 
I think you would be able to figure out the correct decoding. 
And why would you send me the word ‘BEAN’ anyway?”
Bob: “OK, maybe that’s a bad example, but I bet you that if you got a 
string of length 5000 there would be tons of different decodings and 
with that many you would find at least two different ones that would 
make sense.” Alice: “How many different decodings?”
Bob: “Jillions!”

For some reason, Alice is still unconvinced by Bob’s argument, 
so she requires a program that will determine how many decodings 
there can be for a given string using her code.

Input

Input will consist of multiple input sets. 
Each set will consist of a single line of at most 5000 digits representing
a valid encryption (for example, no line will begin with a 0). 
There will be no spaces between the digits. 
An input line of ‘0’ will terminate the input and should not be processed.

Output

For each input set, output the number of possible decodings for the 
input string. All answers will be within the range of a 64 bit signed 
integer.

Example

Input:

25114
1111111111
3333333333
0

Output:

6
89
1
 */
package page1;


import java.util.Scanner;

public class ACODE {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    Scanner sc=new Scanner(System.in);
		    ACODE obj = new ACODE();
			String code; 
			while(!(code=sc.next()).equals("0"))
		    {
				int a[]=new int[code.length()+1];
				for(int i=1;i<=code.length();i++) {
					a[i]=Integer.parseInt(Character.toString(code.charAt(i-1)));
				}
				
				long dp[]=new long[a.length+1];
				dp[0]=1;
				dp[1]=1;
				
				int n=code.length();
//				System.out.println("\na["+(a.length)+"]");
//				System.out.print("[");
//				for (int i = 0; i < a.length; i++) {
//					System.out.print(a[i]+" ");
//				}
//				System.out.println("]");
//				System.out.println("dp["+(dp.length)+"]");
//				System.out.print("[");
//				for (int i = 0; i < dp.length; i++) {
//					System.out.print(dp[i]+" ");
//				}	
//				System.out.print("]");
				for(int i=2;i<=n;i++){
					
					if(a[i]==0)
					{
						dp[i]=dp[i-2];	
					}
					else if(a[i-1]*10+a[i]<=26 && a[i-1]!=0)
					{
							dp[i]=dp[i-1]+dp[i-2];	
					}
					else
					{
							dp[i]=dp[i-1];	
					}	
//					System.out.println(a[i]+" "+dp[i]);
				}


//			//	ans=dp[a.length-1];
//				System.out.println("\ndp -> ");
//				System.out.print("[");
//				for (int i = 0; i < dp.length; i++) {
//					System.out.print(dp[i]+" ");
//				}
//				System.out.print("]");
				System.out.println(dp[a.length-1]);
		   	
		    }
	}
}
