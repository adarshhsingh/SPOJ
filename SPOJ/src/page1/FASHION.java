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
class FASHION {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        double t = sc.nextDouble();
        int x[]= new int[11];
        int y[]= new int[11];
        int i , j , sum ;
        
        while(t-->0)
        {
            int n=sc.nextInt();
            Arrays.fill(y, 0);
            Arrays.fill(x, 0);
            for(i=0;i<n;i++)x[sc.nextInt()]++;
            for(i=0;i<n;i++)y[sc.nextInt()]++;
            j=10 ;
            i=10;
            sum=0;
           while(i!=0 && j!=0)
            {
                if(x[i]>=y[j]){sum+=(i*j)*y[j]; x[i]-=y[j]; y[j]=0;}
                if(y[j]>=x[i]){sum+=(i*j)*x[i]; y[j]-=x[i]; x[i]=0;}
                if(x[i]==0)i--;
                if(y[j]==0)j--;
            }
                
            System.out.println(sum);
        }
    }
}
