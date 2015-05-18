package Chapter2;

import java.util.Scanner;

public class practice3 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a value for feet:");
		double feet=input.nextDouble();
		System.out.println(feet+" feet is "+(int)(feet*0.305*100)/100.0+" meters");
		input.close();
	}
}
