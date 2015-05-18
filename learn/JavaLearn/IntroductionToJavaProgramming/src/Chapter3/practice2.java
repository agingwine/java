package Chapter3;
import java.util.Scanner;
public class practice2 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter an integer:");
		int num=input.nextInt();
		if(num%2==0){
			System.out.println("Is "+num+" an even number? true");
		}
		else{
			System.out.println("Is "+num+" an even number? false");
		}
	}
}