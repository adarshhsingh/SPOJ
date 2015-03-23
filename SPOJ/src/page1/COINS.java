/**
 *
 * @author Adarsh
 */package page1;

import java.io.*;
import java.lang.*;
import java.util.*;

class COINS {
    
    static long arr[]=new long[1000000];
    public static void main(String args[])throws IOException
    {
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        long i,sum;
        Arrays.fill(arr,0);
        for(long j=0;j<=10;j++)
        arr[(int)j]=j;
        long ans=0;
        for(long j=11;j<1000000;j++)
        {
            sum=arr[(int)(j/2)]+arr[(int)j/3]+arr[(int)j/4];
            if(sum>j)arr[(int)j]=sum;
            else arr[(int)j]=j;
        }
        long A[]=new long[10];
       Scanner s = new Scanner(System.in);
       long n=0;
       while (s.hasNextInt()) {
             A[(int)n] = s.nextLong();
             n++;
       }
       for(long j=0;j<n;j++)
           {
                    i = A[(int)j];  
                    if(i<1000000)ans=arr[(int)i];
                    else ans=solve(i);
                    System.out.println(ans);
                    
            }  
         
    }
        
        public static long solve(long n)
        {
            long x;
            if(n<1000000)return arr[(int)n];
            else{
            x=solve(n/2)+solve(n/3)+solve(n/4);
            if(x > n)return x;
            else return n;
            }
        }

    
}

