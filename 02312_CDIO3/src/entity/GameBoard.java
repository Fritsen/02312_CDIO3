package entity;

import java.util.Scanner;

/**
 * Class to create a game board. This class takes in a lot of fields and makes
 * it a board.
 * 
 * @author DTU 02312 Gruppe 19
 * 
 */
public class GameBoard {
	private DieCup dieCup;
	Field[] fields;

	/**
	 * Constructor that makes an array of fields and sets it according to the
	 * rules of the game.
	 */
	public GameBoard(Scanner scanner) {
		dieCup = new DieCup();
		
		fields = new Field[22];

		// Create the fields
		fields[1] = new Territory("Tribe Encampment", 100, 1000, scanner);
		fields[2] = new Territory("Crater", 300, 1500, scanner);
		fields[3] = new Territory("Mountain", 500, 2000, scanner);
		fields[4] = new Territory("Cold Dessert", 700, 3000, scanner);
		fields[5] = new Territory("Black Cave", 1000, 4000, scanner);
		fields[6] = new Territory("The Werewall", 1300, 4300, scanner);
		fields[7] = new Territory("Mountain Village", 1600, 4750, scanner);
		fields[8] = new Territory("South Citadel", 2000, 5000, scanner);
		fields[9] = new Territory("Palace ates", 2600, 5500, scanner);
		fields[10] = new Territory("Tower", 3200, 6000, scanner);
		fields[11] = new Territory("Castle", 4000, 8000, scanner);

		fields[12] = new Refuge("Walled city", 5000);
		fields[13] = new Refuge("Monastry", 500);

		fields[14] = new LaborCamp("Huts in the mountain", 100, 2500, this, scanner);
		fields[15] = new LaborCamp("The pit", 100, 2500, this, scanner);

		fields[16] = new Tax("Goldmine", 2000);
		fields[17] = new Tax("Caravan", 4000, 10, this);

		fields[18] = new Fleet("Second Sail", 4000, this, scanner);
		fields[19] = new Fleet("Sea Grover", 4000, this, scanner);
		fields[20] = new Fleet("The Buccaneers", 4000, this, scanner);
		fields[21] = new Fleet("Privateer armade", 4000, this, scanner);
	}

	public void landOnField(Player player) {
		fields[player.getLocation()].landOnField(player);
	}

	public void clearFieldOwners(Player player) {
		int i;
		for(i = 0; i<=21; i++) {
			if(getOwner(i) == player) {
				((Ownable)fields[i]).owner = null;
			}
		}
	}
	
	public Player getOwner(int fieldNumber) {
		if(getOwnableField(fieldNumber) != null) {
			return getOwnableField(fieldNumber).owner;
		}

		return null;
	}
	
	public int getPrice(int fieldNumber) {
		return getOwnableField(fieldNumber).price;
	}
	
	public String getName(int fieldNumber) {
		return fields[fieldNumber].getName();
	}
	
	public void shakeDieCup() {
		dieCup.shakeDieCup();
	}
	
	public int getDieCupSum() {
		return dieCup.getSum();
	}
	
	public int getDieValue1() {
		return dieCup.getValueDie1();
	}
	
	public int getDieValue2() {
		return dieCup.getValueDie2();
	}
	
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
	
	private Ownable getOwnableField(int fieldNumber) {
		if (fields[fieldNumber] instanceof Ownable) {
			return (Ownable)fields[fieldNumber];
		}
		
		return null;
	}
}