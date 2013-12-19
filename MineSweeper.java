import java.util.Scanner;
import java.util.Random; 

public class MineSweeper
{
	public static void main(String[] args)
	{
		//Create arrays for game board
		int[][] gameboard = new int[8][8];
		boolean[][] boardCheck = new boolean[8][8];
		
		int uncoveredSquares = 64; //8 times 8 = 64 squares in total
		int row = 0; 
		int column = 0;
		
		Scanner console = new Scanner(System.in); 
		
		//Initialize the gameboard and draw it
		initGameboard(gameboard);
		drawBoard(gameboard, boardCheck);
		
		while(uncoveredSquares > 10) {
			System.out.println("Please select a row value between 0 and 7");
			row = console.nextInt(); 
			
			//Check to see if user input is within range
			while( row > 7 || row < 0 ) {
				System.out.println("Invalid value. Please select a row value between 0 and 7");
				//Allow user to input again
				row = console.nextInt();
			}
			
			System.out.println("Please select a column value between 0 and 7");
			column = console.nextInt();
			
			//Check to see if user input is within range
			while( column > 7 || column < 0 ) {
				System.out.println("Invalid value. Please select a column value between 0 and 7");
				//Allow user to input again
				column = console.nextInt();
			}
			
			if(uncoveredSquares <= 10) {
				System.out.println("Congratulations! You won!");
				return;
			}
			
			//End game if a bomb is hit
			if(gameboard[row][column] == -1) {
				System.out.println("Sorry, you hit a bomb! The game will now end.");
				return;
			}
			
			exposeSquare(gameboard, boardCheck, row, column);
			drawBoard(gameboard, boardCheck);
		}
		
		
	}
	
	public static void exposeSquare(int[][] gameboard, boolean[][] boardCheck, int row, int column)
	{
		boardCheck[row][column] = true; 
		
		if(gameboard[row][column] == 0) {
			if(column > 0) {
				if(row > 0) {
					boardCheck[row-1][column-1] = true; 
				}
				
				boardCheck[row][column-1] = true; 
				
				if(row<7) {
				boardCheck[row+1][column-1] = true; 
				}
			}
			
			if(row > 0) {
				boardCheck[row-1][column] = true; 
			}
			
			if(row < 7) {
				boardCheck[row+1][column] = true; 
			}
			
			if(column < 7) {
				if(row > 0) {
					boardCheck[row-1][column+1] = true;
				}
				
				
				boardCheck[row][column+1] = true;
				
				if(row < 7) {
					boardCheck[row+1][column+1] = true; 
				}
			}
		}
	}
	
	
	public static void drawBoard(int[][] gameboard, boolean[][] boardCheck) 
	{
		//Draw the top
		System.out.println("  | 0 1 2 3 4 5 6 7");
		System.out.println("---------------------");
		
		//Draw the main board area
		for(int i= 0; i<8; i++) {
			
			System.out.print(i + " |");
			
			for(int j= 0; j<8; j++) {
				
				if(boardCheck[i][j] == true) {
					
					if(gameboard[i][j] == -1) {
						System.out.print(" X");
					} else if(gameboard[i][j] ==0) {
						System.out.print(" ");
					} else{
						System.out.print(" " + gameboard[i][j]);
					}
					
				} else {
					System.out.print(" .");
				}
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static void initGameboard(int[][] gameboard) { 
		int x = 0;
		int y = 0;
		int bomb = -1;
		
		Random numGen = new Random(); 
		
		for(int i=0; i<10; i++) {
			
			//Randomly generate a new spot
			x = numGen.nextInt(8);
			y = numGen.nextInt(8); 
			
			//Place bomb
			while (gameboard[y][x] == bomb) {
				x= numGen.nextInt(8);
				y= numGen.nextInt(8);
			} 
			
			gameboard[y][x] = bomb;
			
			//Increment numbers around the bomb 
			//Increment to the left
			if(x>0) {
				if(y>0) {
					if(gameboard[y-1][x-1] != bomb) {
						gameboard[y-1][x-1] += 1;
					}
				}
				
				if(gameboard[y][x-1] != bomb) {
					gameboard[y][x-1] += 1;
				}
				
				if(y<7) {
					if(gameboard[y+1][x-1] != bomb) {
						gameboard[y+1][x-1] += 1;
					}
				}
			}
			
			//Increment top and bottom
			if(y>0) {
				if(gameboard[y-1][x] != bomb){
					gameboard[y-1][x] += 1;
				}
			}
			
			if(y<7) {
				if (gameboard[y+1][x] != bomb){
					gameboard[y+1][x] += 1;
				}
			}
			
			//Increment to the right
			if(x<7) {
				if(y>0) {
					if(gameboard[y-1][x+1] != bomb) {
						gameboard[y-1][x+1] += 1;
					}
				}
				
				if(gameboard[y][x+1] != bomb) {
					gameboard[y][x+1] += 1;
				} 
				
				if(y<7) {
					if(gameboard[y+1][x+1] != bomb) {
						gameboard[y+1][x+1] += 1;
					}
				}
			}
		} 
	}
	
	
}




