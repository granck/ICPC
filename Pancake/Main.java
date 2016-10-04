import java.util.Scanner;
import java.util.ArrayList;

class Main{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		int iteration = 1;
		while(input.hasNext()){

			int stackSize = input.nextInt();
			int numFlips = 0;
			ArrayList<Integer> flipOrder = new ArrayList<Integer>();
			if(stackSize == 0){
				break;
			}//end if

			int[] pancakes = new int[stackSize];

			for(int counter = 0; counter < stackSize; counter++){

				pancakes[counter] = input.nextInt();
			}//end for

			for(int pancakeNum = stackSize ; pancakeNum > 0; pancakeNum--){

				for(int location = 0; location < pancakeNum; location++){

					if(pancakes[location] == pancakeNum){

						if(location == (pancakeNum - 1)){
						}//end if
						else{
							pancakes = flip(location, pancakeNum, pancakes);
							if(location != 0){
								flipOrder.add(location + 1);
								numFlips++;
							}//end if
							if(pancakeNum > 1){
								flipOrder.add(pancakeNum);
								numFlips++;
							}//end if
						}//end else
					}//end if
				}//end for


			}//end for

			if(iteration != 1){
				System.out.print("\n" + numFlips);
			}
			else{
				System.out.print(numFlips);
			}
			for(int counter = 0; counter < flipOrder.size(); counter++){
				System.out.print(" " + flipOrder.get(counter));
			}
			iteration++;

		}//end while loop


	}//end main method

	private static int[] flip(int flipPoint, int pancakeNum, int[] pancakes){

		int[] temp = new int[pancakeNum];


		for(int counter = 0; counter < pancakeNum; counter++){
		}//end for


		for(int counter = 0; counter <= flipPoint; counter++){
			temp[counter] = pancakes[counter];
		}//end for

		int pancakeStack = 0;
		for(int counter = flipPoint; counter >= 0; counter--){
			pancakes[pancakeStack] = temp[counter];
			pancakeStack++;
		}//end for
		for(int counter = 0; counter < pancakeNum; counter++){
			temp[counter] = pancakes[counter];
		}//end for

		pancakeStack = 0;
		for(int counter = pancakeNum - 1; counter >= 0; counter--){
			pancakes[pancakeStack] = temp[counter];
			pancakeStack++;
		}//end for


		for(int counter = 0; counter < pancakeNum; counter++){
		}//end for


		return pancakes;

	}//end method flip
}//end class
