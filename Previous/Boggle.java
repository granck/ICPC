import java.io.*;

public class Boggle{


	public static void main(String[] args){
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String fileName = args[0];
		String line = null;
		int lineNum = 1;
		String[] dictionary = null;
		int sizeOfGrid = 0;

		try{
			//get file and create buffer
			fileReader = new FileReader(fileName);

			bufferedReader = new BufferedReader(fileReader);
			
			//determine size of dictionary and fill with words
			int sizeOfDictionary = Integer.parseInt(bufferedReader.readLine());
			dictionary = new String[sizeOfDictionary];

			for(int x = 0; x < sizeOfDictionary; x++){
				dictionary[x] = bufferedReader.readLine();
				System.out.println("location " + x + " in dictionary = " + dictionary[x]);
			}
			int gridSize = 0;

			//outer while gets grid size
			while((line = bufferedReader.readLine()) != null){

				gridSize = Integer.parseInt(line);	

				char[][] grid = new char[gridSize][gridSize];
				for(int y = 0; y < gridSize; y++){
					line = bufferedReader.readLine();
					for(int x = 0; x < gridSize; x++){
						grid[y][x] = line.charAt(x);
						System.out.print(grid[y][x] + "  ");

					}//end inner for
					System.out.print("\n");


				}//end outer for
			findWords(grid, dictionary);	
			}//end while
		}catch(FileNotFoundException ex){
			System.out.println("File not found");
		}catch(IOException ex){
			System.out.println("IO exception");
		}

	}//end main method


	public static void findWords(char[][] grid, String[] dictionary){
		
		//iteratre through words in dictionary
		for(int wordInDictionary = 0; wordInDictionary < dictionary.length; wordInDictionary++){
			

			int wordExist = 0; //1 = found, -1 = not found
			int charInWord = 0;
			String[] word = dictionary[wordInDictionary].split("");
			//iteratre through grid with characters in word
			while(wordExist == 0){
				
				//iterate through column and rows
				for(int indexInColumn = 0; indexInColumn < grid[].size(); indexInColumn++){
					for(int indexInRow = 0; indexInRow < grid[].size(); indexInRow++){

						if(grid[indexInRow][indexInColumn].compareTo(word[charInWord])){
								
						}

					}//end inner for
				}//end outer for	
			}//end while

		}//end for
	}//end method wordsFound



}//end 
