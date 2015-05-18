package Chapter3;
import java.util.*;
public class practice4 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int number1=(int)(Math.random()*100);
		int number2=(int)(Math.random()*100);
		System.out.print("What is "+number1+" + "+number2+"?");
		int answer=input.nextInt();
		System.out.println(number1+" + "+number2+" = "+answer+" is "+(number1+number2==answer));
	}
}
