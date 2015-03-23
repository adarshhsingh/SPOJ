package page1;
import java.io.*;
import java.math.BigInteger;
class LASTDIG2{
	public static void main(String[]q)throws Exception
	{
		BigInteger a=new BigInteger("2"),c=new BigInteger("4");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);int t2[]={6,2,4,8}, t3[]={1,2,9,7}, f[]={6,4}, s[]={1,7,9,3},e[]={6,8,4,2},n[]={1,9};int t=Integer.parseInt(br.readLine());String i[];while(t-->0){i=br.readLine().split("");int ans=0;char x=i[0].charAt(i[0].length()-1);BigInteger b=new BigInteger(i[1]);if(b.equals(0))ans=1;else{switch(x){case '0':ans=0;break;case '1':ans=1;break;case '2':ans=t2[b.mod(c).intValue()];break;case '3':ans=t3[b.mod(c).intValue()];break;case '4':ans=f[b.mod(a).intValue()];break;case'5':ans=5;break;case '6':ans=6;break;case '7':ans=s[b.mod(a).intValue()];break;case '8':ans=e[b.mod(c).intValue()];break;case '9':ans=n[b.mod(a).intValue()];break;}}pw.println(ans);}}}