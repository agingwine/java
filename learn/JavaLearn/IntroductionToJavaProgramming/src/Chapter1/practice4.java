package Chapter1;

public class practice4 {
	public static void main(String[] args){
		System.out.printf("%-6s%-6s%s\n","a","a^2","a^3");
		for(int i=1;i<5;i++){
			System.out.printf("%-6d%-6d%d\n",i,(int)Math.pow(i,2),(int)Math.pow(i,3));
		}
	}
}
