package Chapter2;

import java.util.Scanner;
public class practice18 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.printf("%-6c%-6c%s\n", 'a','b',"pow(a,b)");
		for(int i=1;i<6;i++){
			System.out.printf("%-6d%-6d%d\n", i,i+1,(int)Math.pow(i,(i+1)));
		}
		input.close();
	}
}
