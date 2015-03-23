/*
 * 1724. Counting Triangles

Problem code: TRICOUNT



We define the LEVEL of a triangle as in the following illustrative image:

Task: Your task is very easy. All you have to do is to count all triangles in the biggest one (Level N).

Input

The first line of the input contains an integer T (T ≤ 10000) - the number of test cases and T lines follow.
 Each line contains an integer N (1 ≤ N ≤ 10^6) which is the level of the triangle in that test case.

Output

For each test case, you should write a seperate line: the number of triangles in the biggest one (Level N). 
(All answers will fit within the range of a 64-bit integer)

Example

Input:
3
1
2
3

Output:
1
5
13

Algorithm :

1. 

 * */package page1;

 import java.io.PrintWriter;
 import java.util.*;
 class TRICOUNT {
	 public static void main(String[] args){
		 Scanner sc=new Scanner(System.in);
		 PrintWriter pw = new PrintWriter(System.out);
		 int t,n;
		 t=sc.nextInt();
		 while(t-->0)
		 {
			 n=sc.nextInt();
			 if(n%2==0)pw.println(n*(n+2)*(2*n+1)/8);
			 else pw.println((n*(n+2)*(2*n+1)-1)/8);
		 }
		 pw.close();
	 }
 }
