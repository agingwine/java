package Chapter3;

import java.util.Scanner;

public class practice7 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter an amount in interger, for example 1156: ");
		int amount=input.nextInt();
		int remainingAmount=amount;
		
		int numberOfOneDollars=remainingAmount/100;
		remainingAmount%=100;
		
		int numberOfQuarters=remainingAmount/25;
		remainingAmount%=25;
		
		int numberOfDimes=remainingAmount/10;
		remainingAmount%=10;
		
		int numberOfNickels=remainingAmount/5;
		remainingAmount%=5;
		
		int numberOfPennies=remainingAmount;
		System.out.println("Your amount "+amount+" consist of ");
		if(numberOfOneDollars==1){
			System.out.println("\t"+numberOfOneDollars+" dollar");
		}
		else if(numberOfOneDollars>1){
			System.out.println("\t"+numberOfOneDollars+" dollars");
		}
		if(numberOfQuarters==1){
			System.out.println("\t"+numberOfQuarters+" quarter");
		}
		else if(numberOfQuarters>1){
			System.out.println("\t"+numberOfQuarters+" quarters");
		}
		if(numberOfDimes==1){
			System.out.println("\t"+numberOfDimes+" dime");
		}
		else if(numberOfDimes>1){
			System.out.println("\t"+numberOfDimes+" dimes");
		}
		if(numberOfNickels==1){
			System.out.println("\t"+numberOfNickels+" nickel");
		}
		else if(numberOfNickels>1){
			System.out.println("\t"+numberOfNickels+" nickels");
		}
		if(numberOfPennies==1){
			System.out.println("\t"+numberOfPennies+" pennie");
		}
		else if(numberOfPennies>1){
			System.out.println("\t"+numberOfPennies+" pennies");
		}
		input.close();
	}
}
