/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package page1;


/**
 *
 * @author Adarsh
 */
import java.io.*;
import java.lang.*;
import java.util.*;

class EIGHTS {
    public static void main(String args[])throws IOException
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        
        //for test case
        /*
           int t = sc.nextInt();
           while(t-->0)
            {}
           System.out.println();
        */
       
        int n=sc.nextInt();
        String ans="";
        int arr[]={942,192,442,692};
        while(n-->0)
        {
            long x = sc.nextLong();
            int y = (int)(x%4);
            long z = (x-1)/4;
            System.out.println((z>0?z:"")+""+arr[y]);
        }
        

    }
}