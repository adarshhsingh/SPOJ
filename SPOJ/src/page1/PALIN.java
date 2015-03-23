/*
A positive integer is called a palindrome if its representation in the decimal system 
is the same when read from left to right and from right to left. 
For a given positive integer K of not more than 1000000 digits, write
the value of the smallest palindrome larger than K to output.
Numbers are always displayed without leading zeros.

Input :
The first line contains integer t, the number of test cases. Integers K are given in the next t lines.

Output 
For each K, output the smallest palindrome larger than K.

Example

Input:
2
808
2133

Output:
818
2222
 */

package page1;

import java.util.*;
/**
 *
 * @author Adarsh
 */
public class PALIN {

public static String theNextPalindrome(String n)
{
   
    char num[]=n.toCharArray();
    int len=num.length;
    
    for(int i=0;i<len/2;i++)num[len-i-1]=num[i];
    
    //check if number formed is less or greater than actual number
    String newN=new String(num);
    if(newN.compareTo(n) > 0)return newN;
    
    
    int j=(len/2)-1;
    boolean flag=false; // to check from where does we come out of loop
    
    if(len%2==1) {j++;}
    
    while(j>=0 && !flag)
    {
        if(num[j]!='9') 
        {num[j]++;  if(j!=(len-j-1)){num[len-j-1]++;} flag=true;  break;}
        else 
        {num[j]='0'; num[len-j-1]='0';  j--;}
    }
    if(flag)
    {newN=new String(num); return newN; }
    else
    {
     newN="1";
     for(int i=0;i<len-1;i++)newN+="0";
     newN+="1";
     
    return newN;}

}
public static void main(String []args)
{
    Scanner sc=new Scanner(System.in);
   // int TC=sc.nextInt();
         
  /*  while(TC-->0)
    {
        String n=sc.next();
        StringBuffer s=new StringBuffer("abba.");
        String ss=s.substring(0,s.length()-1);
        System.out.println(ss);
        System.out.println(theNextPalindrome(n));
    }
          */// Scanner sc=new Scanner(System.in);
        int i=1;
        StringBuffer s=new StringBuffer(sc.next());
        StringBuffer s1=new StringBuffer();
        while(s!=null)
        {
         if(s.charAt(s.length()-1)=='!'||s.charAt(s.length()-1)=='.'||s.charAt(s.length()-1)=='?')   
         {
            if(i%2==1){s1=new StringBuffer(s.substring(0,s.length()-1)); s1.reverse(); s1.append(s.charAt(s.length()-1));s=new StringBuffer(s1);}
         }
         else
         {
             if(i%2==1){s.reverse();}
         }
         ++i;
         System.out.print(s+" ");
         s=new StringBuffer(sc.next());   
        }
        
}
}
