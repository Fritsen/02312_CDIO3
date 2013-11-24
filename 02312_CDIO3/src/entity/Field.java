package entity;

/**
 * Class to create a field. This class can be used to contain the score of a field and a value for extra turn.
 *
 * @author DTU 02312 Gruppe 19
 *
 */
public abstract class Field {
	protected String name;
	
	public Field(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public abstract void landOnField(Player player);
}
