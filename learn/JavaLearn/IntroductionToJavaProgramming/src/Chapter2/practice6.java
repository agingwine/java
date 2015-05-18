package Chapter2;

import java.util.Scanner;

public class practice6 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a integer between 0 and 1000:");
		int number=input.nextInt();
		
		int ones=number%10;
		int digits=(number/10)%10;
		int hundreds=(number/100)%10;
		System.out.println("The sum of the digits is "+(ones+digits+hundreds));
		input.close();
	}
}
