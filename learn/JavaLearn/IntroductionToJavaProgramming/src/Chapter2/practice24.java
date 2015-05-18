package Chapter2;

import java.util.Scanner;
public class practice24 {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter v and a: ");
		double v=input.nextDouble();
		double a=input.nextDouble();
		double length=v*v/(2*a);
		System.out.println("The minimum runway length for this airplane is "+length);
		input.close();
	}
}
