package Chapter2;

import java.util.Scanner;
public class practice22 {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter the side: ");
		double side=input.nextDouble();
		double area=3.0*Math.sqrt(3.0)/2*Math.pow(side, 2);
		System.out.println("The area of the hexagon is "+area);
		input.close();
	}
}
