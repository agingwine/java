package Chapter2;

import java.util.Scanner;

public class practice1 {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter a degree in Celsius:");
		double cDegree=input.nextDouble();
		double fDegree=(9.0/5)*cDegree+32;
		System.out.println(cDegree+" Celsius is "+fDegree+" Fahrenheit");
		input.close();
	}
}
