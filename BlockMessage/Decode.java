import java.util.Scanner;

public class Decode{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		while(input.hasNextLine()){

			String columnNumString= input.nextLine();
			int numColumn = Integer.parseInt(columnNumString);
			if(numColumn == 0){
				break;
			}
			String message = input.nextLine();
			int length = message.length();
			int numRow = length / numColumn;
			char[][] decode = new char[numRow][numColumn];
			int rowNum = 0;
			int columnNum = 0;


			for(int counter= 0; counter < length; counter++){

				if(columnNum >= numColumn){
					columnNum = numColumn - 1;
					rowNum++;
				}
				else if(columnNum < 0){
					columnNum = 0;
					rowNum++;
				}
				if((rowNum % 2) == 0){
					decode[rowNum][columnNum] = message.charAt(counter);
					columnNum++;
				}
				else if((rowNum % 2) != 0){
					decode[rowNum][columnNum] = message.charAt(counter);
					columnNum--;
				}

			}

			for(int i = 0; i < numColumn; i++){
				for(int j = 0; j < numRow; j++){

					System.out.print(decode[j][i]);
				}
			}
			System.out.println("");

		}


	}

}
