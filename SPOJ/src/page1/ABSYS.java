/*
2157. Anti-Blot System

Problem code: ABSYS



Jimmy is a hard-working pupil in his second year at primary school. Recently he decided to convert 
all his notes into an electronic version. Sadly, he found that his math notes were full of ink blots.
He scanned the notes and sent them through his own OCR package (yes, he coded it all by himself at the age of 8).
The OCR package replaced all ink blots by the string "machula".

Problem specification
You are given Jimmy's notes, processed by the OCR. They contain simple math exercises,
which were used to practice addition on positive integers. Your task is to recover
the damaged part of the notes.

Input specification
The first line of the input file contains an integer T specifying the number of test cases. 

Each test case is preceded by a blank line.

Each test case consists of exactly one line.

The line represents an equation of the form "number + number = number", where each number is a positive integer.

One part of the equation will be replaced by the string "machula". 
The string always covers a contiguous non-empty sequence of digits, possibly even an entire number. 
You may assume that for each equation in the input there will be exactly one way to fill in the missing digits.

Output specification
                                                                     0    1  2     3  4
For each test case, the output shall contain one line of the form "number + number = number". 
The line must represent the equation from that test case with all missing digits filled in.

Example

Input:
3

23 + 47 = machula

3247 + 5machula2 = 3749

machula13 + 75425 = 77038

Output:
23 + 47 = 70
3247 + 502 = 3749
1613 + 75425 = 77038

Note: int in C++/C/Java or longint in Pascal is enough.
*/

package page1;

import java.util.Scanner;

public class ABSYS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();
		    int ans=0;
		    String solution="";
		    String num1  , num2  , num3;
			while(t-->0)
		    {
				num1=sc.next();
				sc.next();
				num2=sc.next();
				sc.next();
				num3=sc.next();
				
				if(num1.indexOf('m')>-1){
					ans=Integer.parseInt(num3)-Integer.parseInt(num2);
					solution=ans+" "+"+"+" "+num2+" = "+num3;
				}
				else if(num2.indexOf('m')>-1){
					ans=Integer.parseInt(num3)-Integer.parseInt(num1);
					solution=num1+" "+"+"+" "+ans+" = "+num3;
				}
				else if(num3.indexOf('m')>-1){
					ans=Integer.parseInt(num1)+Integer.parseInt(num2);
					solution=num1+" "+"+"+" "+num2+" = "+ans;
				}
				else
					solution=num1+" "+"+"+" "+num2+" = "+num3;
				
				System.out.println(solution);
		    }
	}

}
