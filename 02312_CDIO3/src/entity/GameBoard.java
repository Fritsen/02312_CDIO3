package entity;

<<<<<<< HEAD
<<<<<<< HEAD
import control.Game;
=======
import java.util.Scanner;
>>>>>>> 36ff0e4aeb37abe209819cce739e758c9d893da8
=======
import java.util.Scanner;
>>>>>>> 36ff0e4aeb37abe209819cce739e758c9d893da8

/**
 * Class to create a game board. This class takes in a lot of fields and makes
 * it a board.
 * 
 * @author DTU 02312 Gruppe 19
 * 
 */
public class GameBoard {
	Field[] fields;
	private Game game;

	/**
	 * Constructor that makes an array of fields and sets it according to the
	 * rules of the game.
	 */
	public GameBoard(Scanner scanner) {
		fields = new Field[22];
<<<<<<< HEAD
<<<<<<< HEAD

		// Create the fields
		fields[1] = new Territory(100, 1000);
		fields[2] = new Territory(300, 1500);
		fields[3] = new Territory(500, 2000);
		fields[4] = new Territory(700, 3000);
		fields[5] = new Territory(1000, 4000);
		fields[6] = new Territory(1300, 4300);
		fields[7] = new Territory(1600, 4750);
		fields[8] = new Territory(2000, 5000);
		fields[9] = new Territory(2600, 5500);
		fields[10] = new Territory(3200, 6000);
		fields[11] = new Territory(4000, 8000);

		fields[12] = new Refuge(5000);
		fields[13] = new Refuge(500);

		fields[14] = new LaborCamp(100, 2500, this);
		fields[15] = new LaborCamp(100, 2500, this);

		fields[16] = new Tax(2000, -1);
		fields[17] = new Tax(4000, 10);

		fields[18] = new Fleet(4000, this);
		fields[19] = new Fleet(4000, this);
		fields[20] = new Fleet(4000, this);
		fields[21] = new Fleet(4000, this);
=======
		
    	//Create the fields
		fields[1] = new Territory(100, 1000, scanner);
		fields[2] = new Territory(300, 1500, scanner);
		fields[3] = new Territory(500, 2000, scanner);
		fields[4] = new Territory(700, 3000, scanner);
		fields[5] = new Territory(1000, 4000, scanner);
		fields[6] = new Territory(1300, 4300, scanner);
		fields[7] = new Territory(1600, 4750, scanner);
		fields[8] = new Territory(2000, 5000, scanner);
		fields[9] = new Territory(2600, 5500, scanner);
		fields[10] = new Territory(3200, 6000, scanner);
		fields[11] = new Territory(4000, 8000, scanner);
		
		fields[12] = new Refuge(5000);
		fields[13] = new Refuge(500);
=======
		
    	//Create the fields
		fields[1] = new Territory(100, 1000, scanner);
		fields[2] = new Territory(300, 1500, scanner);
		fields[3] = new Territory(500, 2000, scanner);
		fields[4] = new Territory(700, 3000, scanner);
		fields[5] = new Territory(1000, 4000, scanner);
		fields[6] = new Territory(1300, 4300, scanner);
		fields[7] = new Territory(1600, 4750, scanner);
		fields[8] = new Territory(2000, 5000, scanner);
		fields[9] = new Territory(2600, 5500, scanner);
		fields[10] = new Territory(3200, 6000, scanner);
		fields[11] = new Territory(4000, 8000, scanner);
		
		fields[12] = new Refuge(5000);
		fields[13] = new Refuge(500);
>>>>>>> 36ff0e4aeb37abe209819cce739e758c9d893da8
		
		fields[14] = new LaborCamp(100, 2500, scanner);
		fields[15] = new LaborCamp(100, 2500, scanner);
		
		fields[16] = new Tax(2000);
		fields[17] = new Tax(4000, 10, this);
		
		fields[18] = new Fleet(4000, this, scanner);
		fields[19] = new Fleet(4000, this, scanner);
		fields[20] = new Fleet(4000, this, scanner);
		fields[21] = new Fleet(4000, this, scanner);
<<<<<<< HEAD
>>>>>>> 36ff0e4aeb37abe209819cce739e758c9d893da8
=======
>>>>>>> 36ff0e4aeb37abe209819cce739e758c9d893da8
	}

	public void landOnField(Player player) {
		fields[player.getLocation()].landOnField(player);
	}

	public Player getOwner(int fieldNumber) {
		Fleet fleet = (Fleet) fields[fieldNumber];
		return fleet.getOwner();
	}
<<<<<<< HEAD

	public int calcRentLabor(int baseRent) {
		game.xtraShake();
		return baseRent;
	}

=======
	
	public Ownable getOwnableField(int fieldNumber) {
		if(fields[fieldNumber] instanceof Ownable) {
			return (Ownable)fields[fieldNumber];
		}
		
		return null;
	}
	
<<<<<<< HEAD
>>>>>>> 36ff0e4aeb37abe209819cce739e758c9d893da8
=======
>>>>>>> 36ff0e4aeb37abe209819cce739e758c9d893da8
	/**
	 * A method to generate a nice string containing the value of all the
	 * fields.
	 * 
	 * @return All the field values as a string.
	 */
	public String toString() {
		String output = "";
		int i;

		for (i = 0; i < fields.length; i++) {
			if (fields[i] != null) {
				output = output + fields[i] + "\n";
			}
		}

		return output;
	}
}
