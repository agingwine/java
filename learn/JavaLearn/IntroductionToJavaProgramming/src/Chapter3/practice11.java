package Chapter3;

import java.util.Scanner;

public class practice11 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter months and years:");
		int month=input.nextInt();
		int year=input.nextInt();
		int days;
		String[] months={"January","February","March","April","May","June","July","August","October","November","December"};
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			days=31;
		}
		else if(month==2){
			if(isLeapYear(year)){
				days=29;
			}
			else{
				days=28;
			}
		}
		else{
			days=30;
		}
		
		System.out.println(months[month-1]+" "+year+" has "+days+" days");
		input.close();
	}
	
	private static boolean isLeapYear(int year){
		return (year%4==0&&year%100!=0)||year%400==0;
	}
}