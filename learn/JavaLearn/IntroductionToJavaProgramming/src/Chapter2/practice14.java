package Chapter2;
import java.util.*;
public class practice14 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter weight in pounds: ");
		double weight=input.nextDouble()*0.45359237D;
		System.out.print("Enter height in inches: ");
		double height=input.nextDouble()*0.0254;
		System.out.println("BMI is "+weight/Math.pow(height,2));
		input.close();
	}
}
