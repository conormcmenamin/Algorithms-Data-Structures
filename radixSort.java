import java.util.Arrays;
import java.util.Scanner;

public class Radix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		String ar[] =in.split("");
		ar=radixSort(ar);
		in="";
		for(String i:ar) {
			in+=i;
		}
		System.out.println(in);
		
	}
	
	public static String[] radixSort(String ar[]) {
		return radixSort(ar, ar.length);
	}
	public static String[] radixSort(String ar[], int n) {
		
		int maxLength=0;
		int i=0;
		
		for(i=0;i<=ar.length-1;i++) {
			if(ar[i].length()>maxLength) {
				maxLength= ar[i].length();
			}
			
		}
		
		for(i=0;i<maxLength;i++) {
			
			ar=countSort(ar,ar.length, i);
		}
		return ar;
	}
	
	public static String[] countSort(String ar[], int n, int ind) {
	
		int count[]=new int[129];
		String output[]=new String[n];
		Arrays.fill(count, 0);
		//count occurrences of ascii characters
		for(int i =0;i<=ar.length-1; i++) {
			if(ar[i].length()>ind)
				count[(int)ar[i].charAt(ind)]++;
			
		}
		
		for(int i=1;i<=count.length-1;i++) {
			count[i]+=count[i-1];
		}
		
		for(int i= 0;i< ar.length;i++) {
			if(ind<ar[i].length()) {
				int m=(int)ar[i].charAt(ind);
				output[count[m]-1]= ar[i];
				count[m]--;
			}else {
				output[i]=ar[i];
			}
			
		}
		return output;
	}

}
