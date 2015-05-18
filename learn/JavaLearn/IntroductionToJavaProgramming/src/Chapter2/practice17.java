package Chapter2;
import java.util.*;
public class practice17 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the temperature in Fahrenheit: ");
		double fTemp=input.nextDouble();
		System.out.print("Enter the wind speed miles per hour: ");
		double speed=input.nextDouble();
		double temp=35.74+0.6215*fTemp-35.75*Math.pow(speed,0.16)+0.4275*fTemp*Math.pow(speed,0.16);
		System.out.println("The wind chill index is "+temp);
		input.close();
	}
}
