/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package page1;


import java.util.*;

/**
 *
 * @author Adarsh
 */
public class CANDY {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n ;
        int a[]=new int[10000];
        int sum=0;
        int count=0;
        while((n=sc.nextInt())!=-1)
              {
                  count=0;
                  sum=0;
                  for(int i=0;i<n;i++){a[i]=sc.nextInt();sum+=a[i];}
                  if((sum/n)*n==sum)
                  {
                      int eq=sum/n;
                      for(int i=0;i<n;i++){if(a[i]>eq)count+=(a[i]-eq);}
                  }
                  else
                      count=-1;
                  System.out.println(count);
              }
    }
}
