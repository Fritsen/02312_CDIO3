package entity;

/**
 * Class to create a game board. This class takes in a lot of fields and makes it a board.
 *
 * @author DTU 02312 Gruppe 19
 *
 */
public class GameBoard {
	Field[] fields;
	
	/**
	 * Constructor that makes an array of fields and sets it according to the rules of the game.
	 */
	public GameBoard() {
		fields = new Field[22];
		
    	//Create the fields
		fields[1] = new Territory("Tribe Encampment", 1, 100, 1000);
		fields[2] = new Territory("Crater", 2, 300, 1500);
		fields[3] = new Territory("Mountain", 3, 500, 2000);
		fields[4] = new Territory("Cold Desert", 4, 700, 3000);
		fields[5] = new Territory("Black cave", 5, 1000, 4000);
		fields[6] = new Territory("The Werewall", 6, 1300, 4300);
		fields[7] = new Territory("Mountain village", 7, 1600, 4750);
		fields[8] = new Territory("South Citadel", 8, 2000, 5000);
		fields[9] = new Territory("Palace gates", 9, 2600, 5500);
		fields[10] = new Territory("Tower", 10, 3200, 6000);
		fields[11] = new Territory("Castle", 11, 4000, 8000);
		
		fields[12] = new Refuge("Walled city", 12, 5000);
		fields[13] = new Refuge("Monastery", 13, 500);
		
		fields[14] = new LaborCamp("Huts in the mountain", 14, 100, 2500);
		fields[15] = new LaborCamp("The pit", 15, 100, 2500);
		
		fields[16] = new Tax("Goldmine", 16, 2000, -1);
		fields[17] = new Tax("Caravan", 17, 4000, 10);
		
		fields[18] = new Fleet("Second Sail", 18);
		fields[19] = new Fleet("Sea Grover", 19);
		fields[20] = new Fleet("The Buccaneers", 20);
		fields[21] = new Fleet("Privateer armade", 21);
	}

	/**
	 * Takes the number of a field and gives the corresponding field-object.
	 * 
	 * @param fieldNumber The number of the field to get.
	 * @return The field object corresponding to the number given.
	 */
	public Field getField(int fieldNumber) {
		return fields[fieldNumber];
	}
	
	/**
	 * A method to generate a nice string containing the value of all the fields.
	 * 
	 * @return All the field values as a string.
	 */
	public String toString() {
		String output = "";
		int i;
		
		for(i=0; i<fields.length; i++) {
			if(fields[i] != null) {
				output = output + fields[i] + "\n";
			}
		}
		
		return output;
	}
}
