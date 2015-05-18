package Chapter2;

import java.util.Scanner;

public class practice8 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter an ASCII code:");
		char c=(char)input.nextInt();
		System.out.println("The character for ASCII code "+(int)c+" is "+c);
		input.close();
	}
}