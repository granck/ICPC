import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.math.BigInteger;

public class Factorial{
	
	static File sourceFile = new File("C:\\Users\\Garrick\\workspace\\PreOrder_Traversal\\src\\input.txt");
	static Scanner source;
	
	public static void main(String[] args){
		
		try {
			source = new Scanner(sourceFile);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		BigInteger bigNum = new BigInteger("100000000000000009");
		allPrimes(bigNum);
		
	    
	}
	
	static void allPrimes(BigInteger factorial){
		int n;

	    for (BigInteger i = new BigInteger("2"); i.compareTo(factorial) < 1; i = i.add(BigInteger.ONE)) {
	        n = 0;
	        while (factorial.remainder(i).compareTo(BigInteger.ZERO) == 0) {
	            factorial = factorial.divide(i);
	            n++;

	        }

	        if (n != 0) {
	            for (int j = n; j > 0; j--) {
	                System.out.print(i);

	                if (factorial.compareTo(BigInteger.ONE) != 0) {
	                    System.out.print("*");
	                }
	            }
	        }
	    }
	}
	
	
	static boolean checkPrime(BigInteger number){
		boolean checkPrime=true;
		BigInteger temp;

		for(BigInteger i= new BigInteger("2");i.compareTo(number.divide(BigInteger.valueOf(2))) < 1;i = i.add(BigInteger.ONE))
		{
	       temp=number.remainder(i);
		   if(temp.compareTo(BigInteger.ZERO) == 0)
		   {
		      checkPrime = false;
		      break;
		   }
		}
		return checkPrime;
	}
}