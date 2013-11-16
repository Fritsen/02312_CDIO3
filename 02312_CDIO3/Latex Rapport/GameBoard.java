package Entity;

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
		fields = new Field[13];
		
    	//Create the fields
		fields[2] = new Field(250);
		fields[3] = new Field(-200);
		fields[4] = new Field(-100);
		fields[5] = new Field(-20);
		fields[6] = new Field(180);
		fields[7] = new Field(0);
		fields[8] = new Field(-70);
		fields[9] = new Field(-60);
		fields[10] = new Field(-80, true);
		fields[11] = new Field(-90);
		fields[12] = new Field(650);
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
