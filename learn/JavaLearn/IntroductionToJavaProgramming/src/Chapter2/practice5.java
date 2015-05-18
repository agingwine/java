package Chapter2;

import java.util.Scanner;
public class practice5 {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter the subtotal and a gratuity rate:");
		double subTotal=input.nextDouble();
		int gratuityRate=input.nextInt();
		double gratuity=(int)(subTotal*gratuityRate/100.0*100)/100.0;
		double total=(int)(subTotal*(1+gratuityRate/100.0)*100)/100.0;
		System.out.println("The gratuity is "+gratuity+" and total is "+total);
		input.close();
	}
}
