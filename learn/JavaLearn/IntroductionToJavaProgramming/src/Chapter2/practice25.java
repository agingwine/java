package Chapter2;

import java.util.Scanner;
public class practice25 {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter the time zone offset to GMT: ");
		int offset=input.nextInt();
		long totalMilliseconds=System.currentTimeMillis();
		
		long totalSeconds=totalMilliseconds/1000;
		
		long currentSecond=totalSeconds%60;
		
		long totalMinutes=totalSeconds/60;
		
		long currentMinute=totalMinutes%60;
		
		long totalHours=totalMinutes/60;
		
		long currentHour=totalHours%24;
		
		long hour=(currentHour+offset)%24;
		
		System.out.println("The current time is "+hour+":"+currentMinute+":"+currentSecond);
		input.close();
	}
}
