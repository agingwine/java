package Chapter3;
import java.util.Scanner;
public class practice1 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a,b,c:");
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		double delta=Math.pow(b,2)-4*a*c;
		if(delta>0){
			System.out.println("The roots are "+((-b+Math.sqrt(delta))/(2*a))+" and"+((-b-Math.sqrt(delta))/(2*a)));
		}
		else if(delta==0){
			System.out.println("The root is "+((-b+Math.sqrt(delta))/(2*a)));
		}
		else{
			System.out.println("The equation has no real roots");
		}
		input.close();
	}
}
