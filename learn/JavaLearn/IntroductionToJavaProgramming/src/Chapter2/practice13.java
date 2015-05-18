package Chapter2;
import java.util.*;

public class practice13 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter investment amount: ");
		int amount=input.nextInt();
		System.out.print("Enter monthly interest rate: ");
		double rate=input.nextDouble();
		System.out.print("Enter number of years: ");
		int years=input.nextInt();
		System.out.println("Accumulated valus is "+amount*Math.pow(1+rate/100,years*12));
		input.close();
	}
}
