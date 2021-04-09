import java.util.Scanner;

public class HumanPlayer extends Player{
		
	char name;
	public HumanPlayer(char name) {
		super(name);
		this.name = name;
	}	
	
	//Copy of the newSteps() from the Player which is used to the move() method. This time it is replaced by manual steps rather than random dice rolling.
	public int newSteps() {
		Scanner s = new Scanner(System.in);			
		System.out.println("Player " + this.name + ": Type an integer from 1 to 6 to be his next steps.");
		int steps = s.nextInt();			//Input and take the first integer
		return steps;
		
	}

}
