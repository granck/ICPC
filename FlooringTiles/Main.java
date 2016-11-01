import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;

class Main{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		getTileCount();

		int unique = input.nextInt();

		while(unique != 0){

			System.out.println(unique);
			unique = input.nextInt();

		}//end while

	}//end main method

	public static void getTileCount(){

		ArrayList<Integer> arrayUniques = new ArrayList<Integer>();
		BigInteger maxTileCount = new BigInteger("1000000000000000000");

		for(BigInteger tileCounter = new BigInteger("1"); tileCounter.compareTo(maxTileCount) == -1; tileCounter = tileCounter.add(new BigInteger("1"))){
			System.out.println(tileCounter.toString());
			BigInteger sqrCounter = sqrt(tileCounter);
			System.out.println("Square root = " + sqrCounter);
			numUnique(sqrCounter, tileCounter);



		}//end for loop
	}//end method getTileCount

	public static BigInteger sqrt(BigInteger x) {
		BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
		BigInteger div2 = div;
		//Loop until we hit the same value twice in a row, or wind
		// up alternating.
		for(;;) {
			BigInteger y = div.add(x.divide(div)).shiftRight(1);
			if (y.equals(div) || y.equals(div2))
				return y;
			div2 = div;
			div = y;
		}
	}//end method sqrt


	public static int numUnique(BigInteger sqrCounter, BigInteger tileCounter){
		int numUniques = 0;
		BigInteger[] division;
		for(BigInteger numTiles = new BigInteger("1"); numTiles.compareTo(sqrCounter) <= 0; numTiles.add(new BigInteger("1"))){
			division = tileCounter.divideAndRemainder(numTiles);	
			System.out.println(division[0].toString());
			if(division[1] == new BigInteger("0")){
				numUniques++;
			}//end if


		}//end for
		return numUniques;


	}//end method numUnique





}//end class Main
