public class Square {
	
	private int position;
	private int delta;
	char[] namesArray = new char[0];							//Array which saves the names of Players at one Square at a time.

	//Constructor 
	Square(int potision) {
		this.position = potision;
	}

	Square(int position, int delta) {
		this.position = position;
		this.delta= delta; 	
	}
	
	//Getters and Setters
	public void setDelta(int delta) {
		this.delta = delta;
	}
	
	public int getDelta() {		
		return delta;
	}
	
	public int getPosition() {
		return position;
	}
	
	////Help Methods for Player at a Position
	//Add Player to array which stores all the players at one specific square at a time.
	public void addNameAtPosition(Player player) {
		int currentLength = namesArray.length;
		char[] namesArrayTemp = new char[currentLength+1]; 			//To increase array size to add new player, we create a Temp array with +1
		for(int i=0;i<currentLength;i++) {							
			namesArrayTemp[i] = namesArray[i];						//Pass our main array value to Temp
		}
		namesArrayTemp[currentLength] = player.getName(); 			//Add the new player to the last free position of the temp array
		this.namesArray = namesArrayTemp;							// We change the reference of the allPlayers to the new object including the new player
	}
	
	//Remove Player to array which stores all the players at one specific square at a time.
	public void removeNameAtPosition(Player player) {
		int currentLength = namesArray.length;
		char[] namesArrayTemp = new char[currentLength-1];			//Decrease temporal array size by one
		for(int i=0, k=0;i<(currentLength);i++) {					//have two i and k
			if(namesArray[i] != player.getName()) {					
				namesArrayTemp[k++] = namesArray[i];				//We add players except the name we want to REMOVE!
			} 
		}
		this.namesArray = namesArrayTemp;				
		}
	
	public char[] getNamesAtPosition() {
		return namesArray;
	}
	
	//Output
	public String toString() {
		String name = "";
		for(int i=0; i<namesArray.length; i++) {					//Print name that exist on the array on one square at a time
			if(i==0) {
				name += String.valueOf(namesArray[i]);
			}
			if (i>0) {
				name += ","+ String.valueOf(namesArray[i]);
			}
		}
		
		if(delta==0) {												//when we have zero delta, print empty
			return String.format("%3s %3d",name,position) + "(   ) ";
		} else {
			return String.format("%3s %3d(%3d) ", String.valueOf(namesArray), position,delta);
		}
		
		
	}
			
}
