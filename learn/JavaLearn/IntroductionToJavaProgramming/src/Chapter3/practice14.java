package Chapter3;

import java.util.Scanner;

public class practice14 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int number=(int)(10*Math.random());
		number%=2;
		//boolean random=number%2==0?true:false;
		System.out.print("Enter a number(0 or 1): ");
		int guess=input.nextInt();
		System.out.println("Your guess is "+(number==guess));
		input.close();
	}
	
}
