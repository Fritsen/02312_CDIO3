package boundary;

import java.awt.Color;

import boundaryToMatador.GUI;
import entity.Player;

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
	 * @param die1
	 *            Value of die1.
	 * @param die2
	 *            Value of die2.
	 */
	public static void setDice(int die1, int die2) {
		GUI.setDice(die1, die2);
	}

	/**
	 * Method to add a player.
	 * 
	 * @param playerName
	 *            The name of the player to add.
	 * @param playerScore
	 *            The score of the player to add.
	 */
	public static void addPlayer(String playerName, int playerScore, int playerNumber) {
		GUI.addPlayer(playerName, playerScore, getColor(playerNumber));
	}

	/**
	 * Method to update all players information on the GUI according to a given
	 * array of player objects.
	 * 
	 * @param players
	 *            The array of player objects to get the information from.
	 */
	public static void updatePlayers(Player[] players) {
		int i;

		for (i = 0; i < players.length; i++) {
			GUI.setBalance(players[i].getName(), players[i].getAccountValue());
		}
	}

	/**
	 * Close the GUI window.
	 */
	public static void close() {
		GUI.close();
	}

	/**
	 * Method to move a car from any field to the field number given.
	 * 
	 * @param playerName
	 *            The name of the player who's car should be moved.
	 * @param fieldNumber
	 *            The number of the field the car should be moved to.
	 */
	public static void moveCar(String playerName, int fieldNumber) {
		GUI.removeAllCars(playerName);
		GUI.setCar(fieldNumber, playerName);
	}
	
	public static void removeOwner(int fieldNumber) {
		GUI.removeOwner(fieldNumber);
	}
	
	public static void removePlayer(String name) {
		GUI.removeAllCars(name);
	}

	/**
	 * Helper method to setup all the parameters of a field on the GUI at the
	 * same time.
	 * 
	 * @param title
	 *            The title to set.
	 * @param subTitle
	 *            The subtitle to set.
	 * @param fieldNumber
	 *            The number of the field to change.
	 */
	public static void createField(String title, String subTitle, int fieldNumber) {
		GUI.setTitleText(fieldNumber, title);
		GUI.setSubText(fieldNumber, subTitle);
		GUI.setDescriptionText(fieldNumber, title);
	}

	private static Color getColor(int playerNumber) {
		switch(playerNumber) {
		case 0:
			return Color.RED;
		case 1:
			return Color.BLUE;
		case 2:
			return Color.YELLOW;
		case 3:
			return Color.WHITE;
		case 4:
			return Color.GREEN;
		default:
			return Color.BLACK;
		}
	}
}
