package Chapter2;
import java.util.*;
public class practice16 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the amount of water in kilograms: ");
		double amount=input.nextDouble();
		System.out.print("Enter the initial temperature: ");
		double initTemp=input.nextDouble();
		System.out.print("Enter the final temperature: ");
		double finalTemp=input.nextDouble();
		System.out.printf("The energy needed is %e", amount*(finalTemp-initTemp)*4184);
		input.close();
	}
}
