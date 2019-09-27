package Lab_work;

import java.util.Random;
import java.util.Scanner;

public class BitcoinRoll {

	private static Random random;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int t =scan.nextInt();
		
		int successes =0;
		
		for(int i =0; i<=1000000; i++) {
			
			int counter =0;
			for(int j=1; j<=n;j++) {
				
				double random = Math.random();
				
				if(random <0.5)
				{
					counter++;
				}
			}
			if(counter>=t) {
				successes++;
			}
		}
		
		System.out.println((successes*100)/1000000);
	}
}
