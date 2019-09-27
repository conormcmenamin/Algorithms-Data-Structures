package Lab_work;

import java.util.Scanner;

public class Luhns 
{

	public static void main(String[] args) 
	{
		//Start at the last digit (check digit)
		//Count back to the start, double the value of every second digit along the way, and add every other digit to the sum variable
		//If it's double is greater than 9, add the product's digits or subtract 9 from the product
		//Otherwise do nothing 
		//add this to a sum variable
		//At the end, mod by 10. if(sum%10 == 0) then it is valid
		
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		boolean second  = false;
		int sum = 0;
		
		for(int i = s.length()-1 ;i>=0;i--) {
			int dig = Integer.parseInt("" + s.charAt(i));
	
			if(second == true) {
				dig *=2;
				if(dig>=10) {
					dig-=9;
				}
				sum += dig;
			}else {
				sum += dig;
			}
			second = !second;
		}
		
		if(sum%10==0) {
			System.out.println("Valid!");
		}else {
			System.out.println("Invalid!");
		}
		

	}

}
