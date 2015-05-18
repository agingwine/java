package Chapter2;

import java.util.Scanner;

public class practice9 {
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
		System.out.println("Your amount "+amount+" consist of \n"+
				"\t"+numberOfOneDollars+" dollars\n"+
				"\t"+numberOfQuarters+" quarters\n"+
				"\t"+numberOfDimes+" dimes\n"+
				"\t"+numberOfNickels+" nickels\n"+
				"\t"+numberOfPennies+" pennies"
				);
		input.close();
	}
}
