package Entity;

/**
 * Class to create a field. This class can be used to contain the score of a field and a value for extra turn.
 *
 * @author DTU 02312 Gruppe 19
 *
 */
public class Field {
	private int fieldScore;
	private boolean givesExtraTurn;

	/**
	 * Constructor for a field.
	 * Takes only the score of the field, and assumes the field does not give an extra turn.
	 *  
	 * @param fieldScore The value that should be added to a player if they hit this field.
	 */
	public Field(int fieldScore) {
		this.fieldScore = fieldScore;
		this.givesExtraTurn = false;
	}
	
	/**
	 * Constructor for a field.
	 * Takes the score of the field and a true/false value for wether the field gives an extra turn.
	 * 
	 * @param fieldScore The value that should be added to a player if they hit this field.
	 * @param givesExtraTurn A value for wether the field should give an extra turn
	 */
	public Field(int fieldScore, boolean givesExtraTurn) {
		this.fieldScore = fieldScore;
		this.givesExtraTurn = givesExtraTurn;
	}
	
	/**
	 * Gets the score from a field.
	 * 
	 * @return The field score.
	 */
	public int getFieldScore() {
		return fieldScore;
	}
	
	/**
	 * Gets the true/false value for wether the field should give an extra turn.
	 * 
	 * @return True for extra turn, otherwise false.
	 */
	public boolean getGivesExtraTurn() {
		return givesExtraTurn;
	}
	
	/**
	 * Prints a nice string with field score and the value for extra turn.
	 * 
	 * @return The field score and extra turn value as a string.
	 */
	public String toString() {
		return "Field score: " + fieldScore + ", gives extra turn: " + givesExtraTurn;
	}
}
