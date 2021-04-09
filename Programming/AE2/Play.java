public class Play {

	public static void main(String[] args) {
		//Create board, any rows, columns work
		Board board = new Board(10,5);	
		
		//Add Players and add to the board
		Player pl1 = new Player('T');
		board.addingNewPlayers(pl1);
		Player pl2 = new Player('H');
		board.addingNewPlayers(pl2);
		Player pl3 = new Player('D');
		board.addingNewPlayers(pl3);
		//Task 5, include a user input Player
		Player pl4 = new HumanPlayer('R'); 		//Hide to run the whole game automatically.
		board.addingNewPlayers(pl4);			//
		
		//Add Snakes(-) and Ladders(+)
		board.whichSquare(4).setDelta(12);
		board.whichSquare(1).setDelta(20);
		board.whichSquare(47).setDelta(-17);
		board.whichSquare(38).setDelta(-8);
		board.whichSquare(22).setDelta(-7);
		board.whichSquare(46).setDelta(-10);
		board.whichSquare(26).setDelta(12);

//		System.out.print(board);
		board.takeTurns();
		
	}

}
