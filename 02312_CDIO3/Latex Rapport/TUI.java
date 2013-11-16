package Boundary;

import java.util.Scanner;

import Entity.Player;

/**
 * Class to handle input/output to/from the console.
 * 
 * @author DTU 02312 Gruppe 19
 * 
 */
public class TUI {
	/**
	 * Prints game rules.
	 */
	public static void printRules() {
		System.out.println("");
		System.out
				.println("--------------------------------------------------------------");
		System.out
				.println("| Rules:                                                     |");
		System.out
				.println("| You roll two dice. The sum determines which field you hit. |");
		System.out
				.println("| Each field have it's own value.                            |");
		System.out
				.println("| You get points on some, and loses points on others.        |");
		System.out
				.println("| The first player to hit 3000 points win.                   |");
		System.out
				.println("| Press \"Enter\" to roll, press \"q\" to exit.                  |");
		System.out
				.println("--------------------------------------------------------------");
		System.out.println("");
	}

	/**
	 * Method to get the name of a field from the field number.
	 * The names are given according to the game rules, but could be translated.
	 * 
	 * @param fieldNumber The number of the field to get a name for. 
	 * @return The name of the field with the given number. Null if the field doesn't exist.
	 */
	public static String getFieldName(int fieldNumber) {
		switch (fieldNumber) {
		case 2:
			return "Tower";
		case 3:
			return "Crater";
		case 4:
			return "Palace gates";
		case 5:
			return "Cold Desert";
		case 6:
			return "Walled city";
		case 7:
			return "Monastery";
		case 8:
			return "Black cave";
		case 9:
			return "Huts in the mountain";
		case 10:
			return "The Wearwall";
		case 11:
			return "The pit";
		case 12:
			return "Goldmine";
		}

		return null;
	}

	/**
	 * Method to get the description of a field from the field number.
	 * The descriptions are given according to the game rules, but could be translated.
	 * 
	 * @param fieldNumber The number of the field to get a description for. 
	 * @return The description for the field with the given number. Null if the field doesn't exist.
	 */
	public static String getFieldDescription(int fieldNumber) {
		switch (fieldNumber) {
		case 2:
			return "You entered the tower. Gain 250 credits for climbing it.";
		case 3:
			return "You crashed into the road creating a crater. Pay 200 credits towards repair costs.";
		case 4:
			return "You went sightseeing at the palace gates but got robbed. Pay 100 credits.";
		case 5:
			return "You ran out of gas exploring the Cold Desert. Pay 20 credits for more gas to get home.";
		case 6:
			return "You bet on a race in the Walled City and won. Gain 180 credits.";
		case 7:
			return "You climbed the mountain and gained wisdom. Do nothing.";
		case 8:
			return "You got lost in the black cave. Pay a park ranger 70 credits for helping you out.";
		case 9:
			return "You accidentally set fire to a hut on the mountain. Pay 60 credits for materials to rebuild.";
		case 10:
			return "You got caught naked and drunk strolling around in Wearwall. Pay the police a fine of 80 credits.\nThey felt sorry for you. Recieve another turn.";
		case 11:
			return "You tried to steal a police car. Pay 90 credits as bail.";
		case 12:
			return "You travelled to Alaska and struck it big in gold. Recieve 650 credits.";
		}

		return null;
	}

	/**
	 * Prints a short text, asking the specified player to type his name.
	 * 
	 * @param playerNo The player number to print as part of the message.
	 */
	public static void printNameRequest(int playerNumber) {
		System.out
				.println("Insert name for player " + (playerNumber + 1) + ".");
	}

	/**
	 * Prints a short text, telling the player who's turn it is, and asking him to
	 * roll.
	 * 
	 * @param name The name to print as part of the message.
	 */
	public static void printTurn(String name) {
		System.out.print("\nIt's " + name + "'s turn. Press enter to roll.");
	}

	/**
	 * Prints the current status of the game. Thats all players score and the
	 * sum of the dice.
	 * 
	 * @param players An array of players to get the information from.
	 * @param sum The value that was hit with the dice.
	 */
	public static void printStatus(Player[] players, int sum) {
		System.out.println("You hit field number " + sum + ", "
				+ getFieldName(sum) + "\n" + getFieldDescription(sum));
		System.out.println("The score is now:");

		int i;
		for (i = 0; i < players.length; i++) {
			System.out.print(players[i].getName() + " = "
					+ players[i].getAccount().getAccountValue() + "\t");
		}

		System.out.println();
	}

	/**
	 * Prints the name and score of the winning player.
	 * 
	 * @param name The name of the player who should be declared the winner.
	 * @param score The score for the winning player.
	 */
	public static void printWinner(String name, int score) {
		System.out.println("Congratulations! " + name + " has won with "
				+ score + " points!\nPress Enter to exit.");
	}

	/**
	 * Prints the name and score of the losing player.
	 * 
	 * @param name The name of the player who should be declared the loser.
	 * @param score The score for the losing player.
	 */
	public static void printLoser(String name, int score) {
		System.out.println("Sorry! " + name + " you have lost with " + score
				+ " points!\nPress Enter to exit.");
	}

	/**
	 * Reads a line from the console.
	 * 
	 * @param scanner The scanner to read from
	 * @return Whatever the user inputs.
	 */
	public static String getUserInput(Scanner scanner) {
		return scanner.nextLine();
	}
}