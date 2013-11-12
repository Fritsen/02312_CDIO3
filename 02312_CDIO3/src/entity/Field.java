package entity;

/**
 * Class to create a field. This class can be used to contain the score of a field and a value for extra turn.
 *
 * @author DTU 02312 Gruppe 19
 *
 */
public abstract class Field {
	protected int number;
	protected String name; 
	
	public abstract void landOnField(Player player);
	
	//TODO: Lav brugbar toString, eller måske flyt til underklasserne...?
	/**
	 * Prints a nice string with field score and the value for extra turn.
	 * 
	 * @return The field score and extra turn value as a string.
	 */
	public String toString() {
		return "SomeInfo...";
	}
}
