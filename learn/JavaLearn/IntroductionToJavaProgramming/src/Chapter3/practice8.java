package Chapter3;
import java.util.*;
public class practice8 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter three integers:");
		int a=input.nextInt();
		int b=input.nextInt();
		int c=input.nextInt();
		int temp;
		if(a>b){
			temp=a;
			a=b;
			b=temp;
		}
		if(a>c){
			temp=a;
			a=c;
			c=temp;
		}
		if(b>c){
			temp=b;
			b=c;
			c=temp;
		}
		System.out.println("The Asc ordered numbers is: "+a+" "+b+" "+c);
			
	}
}
