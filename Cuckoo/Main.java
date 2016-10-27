import java.util.Scanner;

class Main{
	
	static Scanner input = new Scanner(System.in);
	static int[] tableOneArray;
	static int[] tableTwoArray;


	
	public static void main(String[] args){
		
		//cycles through each case
		while(input.hasNext()){
			
			int tableOne = input.nextInt();
			int tableTwo = input.nextInt();
			int entries = input.nextInt();

			tableOneArray = new int[tableOne];
			tableTwoArray = new int[tableTwo];

			if(tableOne == 0 && tableTwo == 0 && entries == 0){
				System.out.println("Breaking.");
				break;
			}//end break test case

			System.out.println("TableOne size: " + tableOne + " | tableTwo size: " + tableTwo);
			System.out.println("Number of entires: " + entries);
			for(int cycleEntries = 1; cycleEntries <= entries; cycleEntries++){
				placeEntry(input.nextInt(), 1);
			
			}//end for

		}//end while

	}//end main method

	static void placeEntry(int currentTableEntry, int currentTable){
		

		if(currentTable == 1){

			int entryInTable = currentTableEntry % (tableOneArray.length);
			System.out.println("Trying to fit (table1)" + currentTableEntry + " as " + entryInTable);

			//if index already has value, replace with currentTableEntry
			//Attempt to place previoius entry into table 2
			if(tableOneArray[entryInTable] != 0){
				System.out.println("Value (table1) " + tableOneArray[entryInTable] + " current exists");
				int removedEntry = tableOneArray[entryInTable];
				tableOneArray[entryInTable] = currentTableEntry;
				placeEntry(removedEntry, 2);
			}//end inner if

			//else if no value is in index
			//place currentTableEntry inside location
			else if(tableOneArray[entryInTable] == 0){
				tableOneArray[entryInTable] = currentTableEntry;
			}//end inner else if
		}//end table1

		else{
	
			int entryInTable = currentTableEntry % (tableTwoArray.length);
			System.out.println("Trying to fit (table2)" + currentTableEntry + " as " + entryInTable);
			//if index already has value, replace with currentTableEntry
			//Attempt to place previoius entry into table 1
			if(tableTwoArray[entryInTable] != 0){
				System.out.println("Value (table2) " + tableTwoArray[entryInTable] + " currently exists");
				int removedEntry = tableTwoArray[entryInTable];
				tableTwoArray[entryInTable] = currentTableEntry;
				placeEntry(removedEntry, 1);
			}//end inner if

			//else if no value is in index
			//place currentTableEntry inside location
			else if(tableTwoArray[entryInTable] == 0){
				tableTwoArray[entryInTable] = currentTableEntry;
			}//end inner else if

		}//end table2

	}//end method placeEntry

}//end main class
