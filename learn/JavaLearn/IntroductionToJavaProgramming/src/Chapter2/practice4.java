package Chapter2;

import java.util.Scanner;

public class practice4 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a number in pounds:");
		double pounds=input.nextDouble();
		System.out.println(pounds+" pounds is "+(int)(pounds*0.454*1000)/1000.0+" kilograms");
		input.close();
	}
}
