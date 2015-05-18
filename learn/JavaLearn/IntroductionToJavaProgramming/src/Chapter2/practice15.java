package Chapter2;
import java.util.*;
public class practice15 {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter the monthly deposit amount: ");
		int amount=input.nextInt();
		System.out.print("Enter the yearly deposit rate: ");
		double rate=input.nextDouble()/12;
		System.out.print("Enter the month you want to see: ");
		int month=input.nextInt();
		double total=amount;
		for(int i=0;i<month;i++){
			total*=1+rate;
			if(i==month-1){
				break;
			}
			total+=amount;
		}

		System.out.println("The total amount after "+month+" months is "+total);
		input.close();
	}
}
