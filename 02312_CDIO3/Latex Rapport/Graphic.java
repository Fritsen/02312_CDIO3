package Boundary;

import Entity.Player;
import boundaryToMatador.GUI;

/**
 * Class to send commands to the GUI.
 *
 * @author DTU 02312 Gruppe 19
 *
 */
public class Graphic {
	/**
	 * Method to set the value of the dice on the GUI.
	 * 
	 * @param die1 Value of die1.
	 * @param die2 Value of die2.
	 */
	public static void setDice(int die1, int die2) {
		GUI.setDice(die1, die2);
	}
	
	/**
	 * Method to add a player.
	 * 
	 * @param playerName The name of the player to add.
	 * @param playerScore The score of the player to add.
	 */
	public static void addPlayer(String playerName, int playerScore) {
		GUI.addPlayer(playerName, playerScore);
	}
	
	/**
	 * Method to update all players information on the GUI according to a given array of player objects.
	 * 
	 * @param players The array of player objects to get the information from.
	 */
	public static void updatePlayers(Player[] players) {
		int i;
		
		for(i = 0; i<players.length; i++) {
			GUI.setBalance(players[i].getName(), players[i].getAccount().getAccountValue());
		}
	}
	
	/**
	 * Close the GUI window.
	 */
	public static void close() {
		GUI.close();
	}
	
	/**
	 * Method to setup all the fields on the GUI, according to the rules of the game.
	 * Also clears all the unused fields.
	 */
	public static void setupFields() {
		createField("Tower", "+250", 2);
		createField("Crater", "-200", 3); 
		createField("Palace gates", "-100", 4); 
		createField("Cold Desert", "-20", 5); 
		createField("Walled city", "+180", 6); 
		createField("Monastery", "0", 7); 
		createField("Black cave", "-70", 8); 
		createField("Huts in the mountain", "-60", 9); 
		createField("The Wearwall", "-80", 10); 
		createField("The pit", "-90", 11);
		createField("Goldmine", "+650", 12); 
		
		//Remove unused fields from GUI
		int i;
		createField("", "", 1);
		for(i=13; i<41; i++) {
			createField("", "", i);
		}
	}
	
	/**
	 * Method to move a car from any field to the field number given.
	 * 
	 * @param playerName The name of the player who's car should be moved.
	 * @param fieldNumber The number of the field the car should be moved to.
	 */
	public static void moveCar(String playerName, int fieldNumber) {
		GUI.removeAllCars(playerName);
		GUI.setCar(fieldNumber, playerName);
	}
	
	/**
	 * Helper method to setup all the parameters of a field on the GUI at the same time.
	 * 
	 * @param title The title to set.
	 * @param subTitle The subtitle to set.
	 * @param fieldNumber The number of the field to change.
	 */
	private static void createField(String title, String subTitle, int fieldNumber) {
		GUI.setTitleText(fieldNumber, title);
		GUI.setSubText(fieldNumber, subTitle);
		GUI.setDescriptionText(fieldNumber, title);
	}
}
