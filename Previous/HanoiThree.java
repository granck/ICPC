import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HanoiThree{

	public static int numMovePassed = 0;
	public static String step = null;
	public static int caseNum = 0;
	public static int moveNum = -1;
	public static void main(String[] args){

		BufferedReader bufferedReader;
		String caseString = null;
		int numOfDisk = -1;
		
		try{
			//open file
			FileReader fileReader = new FileReader("input.txt");
			
			//place file into buffer
			bufferedReader = new BufferedReader(fileReader);
			
			while(moveNum != 0 && numOfDisk !=0){
							
				caseString = bufferedReader.readLine();
				moveNum = Integer.parseInt(String.valueOf(caseString.charAt(0)));
				numOfDisk = Integer.parseInt(String.valueOf(caseString.charAt(2)));
				numMovePassed = 0;
				step = null;
			
				System.out.println("Number of disks : " + numOfDisk);
				System.out.println("Move number: " + moveNum);
				if(moveNum == 0 && numOfDisk ==0){
					System.out.println("break");
					break;
				}
				else{
					caseNum++;
					move(numOfDisk, "A", "B", "C");
					System.out.println(step);
				}
				
			
			
			}
				
		}catch(IOException e){
			System.out.println(e);
		}	
	
	}//end main method

	public static void move(int numDisk, String start, String spare, String end){
		//numMovePassed++;
		if(numMovePassed == moveNum){
			return;
		}

		else if(numDisk == 1){
			step = numMovePassed + ": Case " + caseNum + ": " + numDisk + " " + start + " " + end;
			System.out.println("Step: " + (numMovePassed + 1) + " Moved " + numDisk + " from " + start + " -> " + end);
			numMovePassed++;
		}
		else{
			//numMovePassed++;
			//move(numDisk - 1, start, end, spare);
			
			//if(numMovePassed != moveNum){
				move(numDisk - 1, start, end, spare);

				step = numMovePassed + ": Case " + caseNum + ": " + numDisk + " " + start + " " + end;
				System.out.println("Step: " + (numMovePassed + 1) + " Moved " + numDisk + " from " + start + " -> " + end);
				numMovePassed++;

		//	}
			
			//System.out.println("Step: " + (numMovePassed + 1) + " Moved " + numDisk + " from " + start + " -> " + end);
			//numMovePassed++;

		//	if(numMovePassed != moveNum){
				move(numDisk - 1, spare, start, end);
			
				//step = "Case " + caseNum + ": " + numDisk + " " + start + " " + end;
		//	}
			
		}
	}
}//end class HanoiThree.java
