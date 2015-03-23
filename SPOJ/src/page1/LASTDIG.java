package page1;
import java.util.*;public class LASTDIG { public static void main(String args[]){Scanner sc=new Scanner(System.in);int t=sc.nextInt();int b, lastD , ans=0; int two[]={6,2,4,8};  int three[]={1,3,9,7};  int seven[]={1,7,9,3};  int eight[]={6,8,4,2};while(t-->0){ lastD = (sc.nextInt())%10;b=sc.nextInt();
if(b==0)ans=1;
else if(lastD==0||lastD==1||lastD==5||lastD==6)ans=lastD;
else{
switch(lastD)
   {
    case 2 : ans=two[b%two.length];break;
    case 3 : ans=three[b%three.length];break;
    case 4 : ans=(b%2==0)?6:4;break;
    case 7 : ans=seven[b%seven.length];break;
    case 8 : ans=eight[b%eight.length];break;
    case 9 : ans=(b%2==0)?1:9;break;
   }
}
   System.out.println(ans);
  }
 }
}
