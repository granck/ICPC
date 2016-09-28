import java.io.*;
import java.math.BigInteger;

public class Palindrome{

	public static void main(String[] args){
		FileReader reader = null;
		BufferedReader buffer = null;

		int numberCases = 0;

		try{
			reader = new FileReader("palinTest.txt");
			buffer = new BufferedReader(reader);

			numberCases = Integer.parseInt(buffer.readLine());
		} catch(IOException ex){
			System.out.println("No file found");
		}

		System.out.println("Number of test cases: " + numberCases);

		for(int x = 0; x < numberCases; x++){
			String current = null;	
			try{
			current = buffer.readLine();
			System.out.println("current: " + current);
			} catch(IOException ex){
				System.out.println("error");
			}

			boolean isPalindrome = false;
			while(isPalindrome == false){

			isPalindrome = checkPalindrome(current);
			if(isPalindrome == false)
				current = addPalindrome(current);
			
			if(isPalindrome == true)
				System.out.println("palindrome at: " + current);
			}//end while
		}//end for
		

	}//end main method

	public static boolean checkPalindrome(String currentNumber){
		int size = currentNumber.length();
		int j = size - 1;
		boolean isPalindrome = false;
		
		System.out.println("number: " + currentNumber);
		System.out.println("size: " + size);
		for(int i = 0; i < size/2 + 1; i++){
			
			if(size == 1){
				isPalindrome = true;
				break;
			}
			else if(currentNumber.charAt(i) != currentNumber.charAt(j)){
				isPalindrome = false;
				break;
			}
			else if(j <= i){
				isPalindrome = true;
				break;
			}
			j--;
		}
		return isPalindrome;
	}//end method checkPalindrome

	public static String addPalindrome(String currentNumber){
		System.out.println("current: " + currentNumber);
		BigInteger number = new BigInteger(currentNumber);
		number = number.add(new BigInteger("1"));
		
		return number.toString();
		//return String.valueOf(((Long.parseLong(currentNumber) + 1)));

	}//end method addPalindrome
}//end class Palindrom
