import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Game{
	public static Board board;
	
	public static void main(String[] args){
		int[] working = new int[81];
		int[] solved = new int[81];
		try{
			File gameFile = new File("board.txt");
			Scanner fileReader = new Scanner(gameFile);
			for(int i = 0; i < 81; ++i){
				working[i] = fileReader.nextInt();
			}
			for(int i = 0; i < 81; ++i){
				solved[i] = fileReader.nextInt();
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		board = new Board(9, working, solved);
		
		printBoard();
		Scanner input = new Scanner(System.in);
		while(!board.isSolved()){
			int row, column, value, index;
			System.out.print("Please enter row, column, and value you wish to place there: ");
			row = input.nextInt();
			column = input.nextInt();
			value = input.nextInt();
			index = (column - 1) + (9 * (row - 1));
			board.setSquare(index, value);
			printBoard();
		}
		System.out.println("You Win!!!");
		
	}
	
	static void printBoard(){
		for(int i = 0; i < 9; ++i){
			for(int j = 0; j < 9; ++j){
				System.out.print(board.getSquare(j + 9 * i) + " ");
			}
			System.out.println("");
		}
	}
}