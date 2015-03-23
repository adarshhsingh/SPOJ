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
public class ACPC10A {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a1 , a2 , a3 ;
        a1=sc.nextInt();
        a2=sc.nextInt();
        a3=sc.nextInt();
        int next;
        while(a1!=0 || a2!=0 || a3!=0)
        {
            if(a3==(a2+(a2-a1))){next=a3+(a2-a1);System.out.println("AP "+next);}
            else if(a3==(a2*(a2/a1))){next=a3*(a2/a1);System.out.println("GP "+next);}
        a1=sc.nextInt();
        a2=sc.nextInt();
        a3=sc.nextInt();
        }
        
    }
}
