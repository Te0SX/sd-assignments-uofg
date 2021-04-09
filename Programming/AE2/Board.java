public class Board {
	//Task 2 Create board, add 2  players and print
	public static void main(String[] args) {
		Board board = new Board(10,5);
		Player pl1 = new Player('T');		
		board.addingNewPlayers(pl1);		
		Player pl2 = new Player('H');
		board.addingNewPlayers(pl2);
		System.out.println(board);
		
	}

	//Attributes 
	private int rows;
	private int cols;
	private Player[] allPlayers = new Player[0] ;
	Square[][] board = new Square[rows][cols];
	
	//Contractor
	Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.board = new Square[rows][cols];
		createBoard();

	}
		
	//Create 2D board in normal order
	public Square[][] createBoard() {
		int position = 0;
		for(int i=0; i<rows; i++) {
			for(int j=0;j<cols;j++) {
				board[i][j] = new Square(position, 0);
				position++;	
			}
		}
		return board;
	}

	//Print the board in wrap mode so the 0 is always at the bottom left
	public void printBoard(Square[][] board) {
		for(int i=(rows-1);i!=-1;i--) {						//backward than usual each row in order to wrap it
			if(i%2!=0) { for(int j=(cols-1);j!=-1;j--) {	//if row is odd, then print backwards
					System.out.print(board[i][j]);
				}
			} else {
				for(int j=0; j<cols; j++) {					//if row even, print normal
					System.out.print(board[i][j]);
				}
			}
			System.out.println("\n");
		}
	}
	
	//Output 
	public String toString() {
		String output = "";
		for(int i=(rows-1);i!=-1;i--) {						//backward than usual each row in order to wrap it
			if(i%2!=0) { for(int j=(cols-1);j!=-1;j--) {	//if row is odd, then print backwards
					output += board[i][j].toString();
				}
			} else {
				for(int j=0; j<cols; j++) {					//if row even, print normal
					output += board[i][j].toString();
				}
			}
			output += ("\n");
		}
		return output;
	}
	
	
	//Adding Player and add position to board
	public void addingNewPlayers(Player player) {
		allPlayers(player);								//Add new player too the list of all players
		board[0][0].addNameAtPosition(player);			//Add the player to start position of 0
		
	}
	
	//Setter for Players array where we'll track all the players references
	public void allPlayers(Player player) {
		int currentLength = allPlayers.length;
		Player[] allPlayersTemp = new Player[currentLength+1]; //To increase array size to add new player, we create a Temp array with +1
		for(int i=0;i<currentLength;i++) {
			allPlayersTemp[i] = allPlayers[i]; 					//Pass our main array value to Temp
		}
		allPlayersTemp[currentLength] = player; 				//Add the new player to the last free position of the temp array
		this.allPlayers = allPlayersTemp;						// We change the reference of the allPlayers to the new object including the new player
	}
	
	//Getter for Players
	public Player[] allPlayers() {
		return allPlayers;
	}
	
	//////Helper Methods 
	//Return column and row based on particular position
	public int whichRow(int position) {
		int whichRow = position/cols;							//Basic math to get the rows, cols etc based on position and the opposite.
		return whichRow;
	}
	public int whichColumn(int position) {
		int whichColumn = position%cols;
		return whichColumn;
	}
	
	//Return position based on rows,cols in computer logic.
	public int whichPosition(int whichRows,int whichCols) {
		int position = (whichRows)*(whichCols) + whichCols;
		return position;
	}
	//Returns a reference to the Square object at any integer position.
	public Square whichSquare(int position) {
		return board[whichRow(position)][whichColumn(position)];
	}
	//Winning Point
	public int winningPosition() {
		return (rows*cols-1);									//for Move() on Player class so we don't have errors wiht players out of the board
	}
	
	
	
	//Task 3. A method which runs in loop for every player to trigg3r his move until someone get on or after winning point
	public void takeTurns() {
		char winner = ' ';
		boolean endgame = false;								//Boolean which will become true when someone go to the winning point and turnTurn will terminate
		int rounds = 1;
		printBoard(board);										//Print default table with players and deltas before the game start
		while (endgame == false) {
			System.out.println("-------------------------------------------------------------------------------- \n Round number: " + rounds); //To separate boards
			for(int i=0; i<allPlayers.length;i++) {					//Loop for each player who has to roll dice
				if(endgame==false) {
					endgame = allPlayers[i].move(this);				//Roll of the dice, add the new steps to Players and set him to the board!!!
					if (endgame == true) {					
						winner = allPlayers[i].getName();			
					}
				} 
			}	
			printBoard(board);
			if (endgame==true) {
				System.out.println("The winner is " + String.valueOf(winner) +".");		//Print winner when game is done.
			} else {
				rounds++;
			}
		}	
	}
}
	

