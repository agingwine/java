package Chapter2;
import java.util.*;

import javax.swing.*;

public class practice12 {
	public static void main(String[] args){
		//console();
		jOptionPane();
	}
	private static void console(){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter balance and interest rate(e.g., 3 for 3%): ");
		int balance=input.nextInt();
		double rate=input.nextDouble();
		System.out.println("The  interest is "+balance*(rate/1200));
		input.close();
	}
	private static void jOptionPane(){
		String input=JOptionPane.showInputDialog("Enter balance and interest rate(e.g., 3 for 3%): ");
		String[] str=input.split(" ");
		int balance=Integer.parseInt(str[0]);
		double rate=Double.parseDouble(str[1]);
		JOptionPane.showMessageDialog(null,"The  interest is "+balance*(rate/1200));
	}
}