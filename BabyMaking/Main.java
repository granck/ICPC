import java.util.Random;
import java.util.Scanner;

class Main{
	

	public static void main(String[] args){
		
		Random baby = new Random();
		Scanner input = new Scanner(System.in);

		System.out.println("How many families are trying to have a boy?");
		int numFamilies = input.nextInt();

		int numBoys = 0;
		int numGirls = 0;

		for(int familyCounter = 0; familyCounter < numFamilies; familyCounter++){
			
			while(baby.nextInt(2) == 1){
				System.out.println("Family " + (familyCounter + 1) + " had a girl");
				numGirls++;			
			}//end while loop
			System.out.println("Family " + (familyCounter + 1) + " had a boy");
			numBoys++;

		}//end for loop

		System.out.println("Num of boys: " + numBoys + " | Num of girls: " + numGirls);




	}//end main method
}//end class Main
