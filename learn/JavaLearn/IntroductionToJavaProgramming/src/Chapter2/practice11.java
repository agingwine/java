package Chapter2;
import java.util.*;

import javax.swing.*;

public class practice11 {
	public static void main(String[] args){
		//console();
		jOptionPane();
	}
	private static void console(){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter employee's name: ");
		String name=input.next();
		System.out.print("Enter number of hours worked in a week: ");
		int hours=input.nextInt();
		System.out.print("Enter hourly pay rate: ");
		double hourPayRate=input.nextDouble();
		System.out.print("Enter federal tax withholding rate: ");
		double federalRate=input.nextDouble();
		System.out.print("Enter state tax withholding rate: ");
		double stateRate=input.nextDouble();
		double grossPay=hours*hourPayRate;
		double federalTax=grossPay*federalRate;
		double stateTax=grossPay*stateRate;
		double totalTax=federalTax+stateTax;
		double netPay=grossPay-totalTax;
		System.out.println("Employee Name: "+name+"\n"+
				"Hours Worked: "+hours+"\n"+
				"Pay Rate: $"+hourPayRate+"\n"+
				"Gross Pay: $"+grossPay+"\n"+
				"Deductions: "+"\n"+
				"\t"+"Federal Withholding ("+federalRate*100+"): $"+federalTax+"\n"+
				"\t"+"State Withholding ("+stateRate*100+"): $"+stateTax+"\n"+
				"\t"+"total Deduction: $"+totalTax+"\n"+
				"Net Pay: $"+netPay);
		input.close();
	}
	private static void jOptionPane(){
		String input=JOptionPane.showInputDialog("Enter employee's name: ");
		String name=input;
		input=JOptionPane.showInputDialog("Enter number of hours worked in a week: ");
		int hours=Integer.parseInt(input);
		input=JOptionPane.showInputDialog("Enter hourly pay rate: ");
		double hourPayRate=Double.parseDouble(input);
		input=JOptionPane.showInputDialog("Enter federal tax withholding rate: ");
		double federalRate=Double.parseDouble(input);
		input=JOptionPane.showInputDialog("Enter state tax withholding rate: ");
		double stateRate=Double.parseDouble(input);
		double grossPay=hours*hourPayRate;
		double federalTax=grossPay*federalRate;
		double stateTax=grossPay*stateRate;
		double totalTax=federalTax+stateTax;
		double netPay=grossPay-totalTax;
		JOptionPane.showMessageDialog(null, "Employee Name: "+name+"\n"+
				"Hours Worked: "+hours+"\n"+
				"Pay Rate: $"+hourPayRate+"\n"+
				"Gross Pay: $"+grossPay+"\n"+
				"Deductions: "+"\n"+
				"\t"+"Federal Withholding ("+federalRate*100+"): $"+federalTax+"\n"+
				"\t"+"State Withholding ("+stateRate*100+"): $"+stateTax+"\n"+
				"\t"+"total Deduction: $"+totalTax+"\n"+
				"Net Pay: $"+netPay);

	}
}
