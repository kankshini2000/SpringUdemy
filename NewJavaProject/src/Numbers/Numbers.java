package Numbers;

import java.util.Scanner;

public class Numbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First Number:");
		int readNumber = scanner.nextInt();
		System.out.println("Your entered Number is " + readNumber);	
		int sum =0;
		while (readNumber != 0) {       
	        sum = sum + readNumber % 10;  
	        readNumber = readNumber/10;  
	    }
		System.out.print("Sum:"+ sum);
		scanner.close();
	}
}
