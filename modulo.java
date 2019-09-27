package Labs;

public class modulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(3*4%15 +" " +  modMult(3,4,15));
		System.out.println((int)Math.pow(3, 4)%15 +" " +  modPow(3,4,15));
	}
	public static long modPow(long number, long power, long modulus){
			 if(power==0)
				 return 1;
			 else if (power%2==0) {
				 long halfpower=modPow(number, power/2, modulus);
				 return modMult(halfpower,halfpower,modulus);
			 }else{
				 long halfpower=modPow(number, power/2, modulus);
				 long firstbit = modMult(halfpower,halfpower,modulus);
				 return modMult(firstbit,number,modulus);
			 }
		 }
		 public static long modMult(long first, long second, long modulus){
		
			 if(second==0)
				 return 0;
			 else if (second%2==0) {
				 long half=modMult(first, second/2, modulus);
				 return (half+half)%modulus;
			 }else{
				 long half=modMult(first, second/2, modulus);
				 return (half+half+first)%modulus;
			 }
		 }
		 
		 
		 public static long modPow2(long number, long power, long modulus){
			 if(power==0) return 1;
			 else if(power ==1) return number%modulus;
			 
			 long rest = power - power/2;
			 
			 
			 long oneHalf = modPow2(number, power/2,modulus);
			 long otherHalf = modPow2(number, rest, modulus);
			 return modMult(oneHalf,otherHalf, modulus);
		 }
		 
}
