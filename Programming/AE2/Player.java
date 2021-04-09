import java.util.Random;

public class Player {
	//Task 1 Creation of player, assignment to square and print with toString method of both
	public static void main(String[] args) {
		Player pl = new Player('T'); 				//Creation of a player with name T
		Square sq = new Square(0, 0);				//Creation of square at position 0, with delta 0 
		sq.addNameAtPosition(pl);					//Assign Player to square

		System.out.println(pl); 					//Print from toString
		System.out.println(sq);

	}
	
	//Attributes
	private char name=' ';
	private int position;	
	
	//Constructor 
	Player(char plchar) {
		this.name = plchar;
	}
	
	//Getters and Setters
	public char getName() {
		return name;
	}
	//Set new position for the Player
	public void setPosition(Square newPosition) {
		position = newPosition.getPosition();
	}
	
	//Output
	public String toString() {
		return String.valueOf(name);
	}
	
	//Task 3 Moveeeee
	public boolean move(Board board) {
		boolean endgame = false;
		
		//Remove player from its previous position
		int oldRow = board.whichRow(this.position);
		int oldCol = board.whichColumn(this.position);
		board.board[oldRow][oldCol].removeNameAtPosition(this);
		
		//New Position after roll the dice
		int rolldice = newSteps();									//Takes an a random integer from 1-6 from the method() below
		int newPosition = this.position + rolldice;					//New Position after the roll of the dice
		
		//If New Position bigger than the board, put on the last spot
		if(newPosition > board.winningPosition()) {				
			newPosition = board.winningPosition();					//To avoid errors when search for potential delta
		}	
		
		//Take delta from the Square in that Position and save it to variable delta
		int delta = board.whichSquare(newPosition).getDelta();		
		
		//New position after a player step in a snake(-) or ladder(+)
		if(delta < 0 ) {
			System.out.println("--- Oh dam ಠ╭╮ಠ, Player " + getName() + " got swallowed by a snake and went back " + delta + " steps.");
			newPosition = newPosition + delta;
		} else if(delta > 0) {
			System.out.println("--- w0000t ᕦ(ò_óˇ)ᕤ, Player " + getName() + " clibmed up a ladder of " + delta + " steps.");
			newPosition = newPosition + delta;
		}
		//If New Position bigger than the board, Player wins and will be put on the last Square.
		if(newPosition >= board.winningPosition()) {
			newPosition = board.winningPosition();					//To avoid errors when put Player to his new position which has to be into the table
			endgame = true;	
		}
		
		//pass the Player to its new position
		board.board[board.whichRow(newPosition)][board.whichColumn(newPosition)].addNameAtPosition(this);

		System.out.println("Player " + getName() + " is currently at " + newPosition + ", after rolled dice " + rolldice);
		this.position = newPosition;
		return endgame;
	}
	//Random numbers a the dice for the player
	public int newSteps() {			
		Random r = new Random();
		int steps = r.nextInt(6) + 1;	
		return steps;
	}
	
}
	
	