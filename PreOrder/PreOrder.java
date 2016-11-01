import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class PreOrder{
	//static File sourceFile = new File("C:\\Users\\Garrick\\workspace\\PreOrder_Traversal\\src\\input.txt");
	static Scanner source;

	public static void main(String[] args){

		//source = new Scanner(sourceFile);
		source = new Scanner(System.in);

		ArrayList<Integer> currentTree;
		int caseNum = 1;
		for(currentTree = nextTree(); currentTree.isEmpty() == false; currentTree = nextTree()){

			boolean correct = isValid(currentTree, 0, currentTree.size() - 1);
			System.out.println("Case " + caseNum + ": " + correct);
			caseNum++;
		}


	}

	public static  ArrayList<Integer> nextTree(){

		ArrayList<Integer> treeArray = new ArrayList<Integer>();
		int tempNum = 0;
		boolean endTree = false;
		while(source.hasNext() && !endTree){
			tempNum = source.nextInt();
			if(tempNum < 0){
				endTree = true;
			}
			else{
				treeArray.add(tempNum);
			}

		}

		return treeArray;

	}

	public static boolean isValid(ArrayList<Integer> tree, int begin, int end){
		boolean valid = false;
		int root = tree.get(begin);
		int pointer;
		for(pointer = begin + 1; pointer <= end && tree.get(pointer) < root; pointer++){
			System.out.println("pointer at: " + tree.get(pointer) + " and is less than " + root);
		}

		if(pointer < end){
			if(allGreater(tree, pointer + 1, end, root) && isValid(tree, begin + 1, pointer - 1) && isValid(tree, pointer + 1, end)){
				valid = true;
			}
			else{
				valid = false;
			}
		}

		return valid;
	}

	public static boolean allGreater(ArrayList<Integer> tree, int begin, int end, int current){
		boolean isGreater = true;
		while(begin <= end && isGreater){
			if(current > tree.get(begin)){
				isGreater = false;
			}
			begin++;
		}
		return isGreater;
	}


}
