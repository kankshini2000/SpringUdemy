import java.util.Scanner;

public class Mynumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no:");
		int n = sc.nextInt();
		System.out.println(n);
		int add =0;
		while(n>0) {
			add+= (n%10);
			System.out.println("The remainder is"+ add);
			n/=10;
			System.out.println("The dividend is " +n);
		}
		System.out.println(add);
	}

}
