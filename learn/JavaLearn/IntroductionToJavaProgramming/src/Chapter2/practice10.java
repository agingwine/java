package Chapter2;

import java.util.Scanner;
import javax.swing.JOptionPane;
public class practice10 {
	public static void main(String[] args){
		String input=JOptionPane.showInputDialog("Enter an amount in interger, for example 1156: ");
		int amount=Integer.parseInt(input);
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
		JOptionPane.showMessageDialog(null, "Your amount "+amount+" consist of \n"+
				"\t"+numberOfOneDollars+" dollars\n"+
				"\t"+numberOfQuarters+" quarters\n"+
				"\t"+numberOfDimes+" dimes\n"+
				"\t"+numberOfNickels+" nickels\n"+
				"\t"+numberOfPennies+" pennies");
	}
}
