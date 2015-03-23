package page1;

import java.util.Scanner;
import java.util.Stack;

class STPAR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int n; 
		while(!((n=sc.nextInt())==0))
	    {
	       int a[]=new int[n];
	       Stack<Integer> st=new Stack<Integer>();
	       int i=0,j=0;
	       for(i=0;i<n;i++)a[i]=sc.nextInt();
	       i=1;
	       while(true)
	       {
	    	   if(j<n && a[j]==i){j++;i++; }
	    	   else if(!st.isEmpty() && st.peek()==i){st.pop(); i++;  } 
	    	   else if(j<n){st.push(a[j]); j++;}
	    	   else break;
	       }
	       System.out.println((i==n+1)?"yes":"no");
	    }
	}

}
