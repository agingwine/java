package Chapter1;

public class practice7 {
	public static void main(String[] args){
		int flag=1;
		double result=0;
		for(int i=1;i<1000000;i+=2){
			result+=1.0/i*flag;
			flag*=-1;
		}
		System.out.println(result*4);
	}
}
