package Chapter3;
import java.util.*;
public class practice9 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter number:");
		int number=input.nextInt();
		int d9=number%10;
		number/=10;
		int d8=number%10;
		number/=10;
		int d7=number%10;
		number/=10;
		int d6=number%10;
		number/=10;
		int d5=number%10;
		number/=10;
		int d4=number%10;
		number/=10;
		int d3=number%10;
		number/=10;
		int d2=number%10;
		number/=10;
		int d1=number%10;
		number/=10;
		
		int d10=(d1*1+d2*2+d3*3+d4*4+d5*5+d6*6+d7*7+d8*8+d9*9)%11;
		if(d10==10){
			System.out.println(""+d1+d2+d3+d4+d5+d6+d7+d8+d9+"X");
		}
		else{
			System.out.println(""+d1+d2+d3+d4+d5+d6+d7+d8+d9+d10);
		}

	}
}
