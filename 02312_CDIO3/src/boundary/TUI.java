package boundary;

import java.util.Scanner;

import entity.Player;

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
				.println("| A player wins when the others go bankrupt.                  |");
		System.out
				.println("| Press \"Enter\" to roll, press \"q\" to exit.                  |");
		System.out
				.println("--------------------------------------------------------------");
		System.out.println("");
	}

	public static int getNumberOfPlayers(Scanner scanner) {
		int numberOfPlayers = 0;

		// Get the number of players from console. Keep trying until input is
		// valid
		while (numberOfPlayers == 0) {
			printNumberRequest();
			try {
				numberOfPlayers = new Integer(getUserInput(scanner));
				if (numberOfPlayers < 0 || numberOfPlayers > 6) {
					numberOfPlayers = 0;
				}
			} catch (Exception e) {
				numberOfPlayers = 0;
			}
		}

		return numberOfPlayers;
	}

	public static boolean getYesNo(Scanner scanner) {
		String input;
		
		while(true) {
			input = getUserInput(scanner);
			if ("Y".equals(input) || "y".equals(input)) {
				return true;
			}
			
			if("N".equals(input) || "n".equals(input)) {
				return false;
			}
			
			System.out.print("Not valid. Must be \"Y\" og \"N\"");
		}
	}

	/**
	 * Method to get the name of a field from the field number. The names are
	 * given according to the game rules, but could be translated.
	 * 
	 * @param fieldNumber
	 *            The number of the field to get a name for.
	 * @return The name of the field with the given number. Null if the field
	 *         doesn't exist.
	 */
	public static String getFieldName(int fieldNumber) {
		switch (fieldNumber) {
		case 1:
			return "Tribe Encampment";
		case 2:
			return "Crater";
		case 3:
			return "Mountain";
		case 4:
			return "Cold Desert";
		case 5:
			return "Black Cave";
		case 6:
			return "The Werewall";
		case 7:
			return "Mountain village";
		case 8:
			return "South Citadel";
		case 9:
			return "Palace gates";
		case 10:
			return "Tower";
		case 11:
			return "Castle";
		case 12:
			return "Walled city";
		case 13:
			return "Monastery";
		case 14:
			return "Huts in the mountain";
		case 15:
			return "The pit";
		case 16:
			return "Goldmine";
		case 17:
			return "Caravan";
		case 18:
			return "Second Sail";
		case 19:
			return "Sea Grover";
		case 20:
			return "The Buccaneers";
		case 21:
			return "Privateer armade";
		}

		return null;
	}

	/**
	 * Prints a short text, asking the specified player to type his name.
	 * 
	 * @param playerNo
	 *            The player number to print as part of the message.
	 */
	public static void printNameRequest(int playerNumber) {
		System.out
				.println("Insert name for player " + (playerNumber + 1) + ".");
	}

	public static void printNumberRequest() {
		System.out.println("Select the number of players 1-6:");
	}

	/**
	 * Prints a short text, telling the player who's turn it is, and asking him
	 * to roll.
	 * 
	 * @param name
	 *            The name to print as part of the message.
	 */
	public static void printTurn(String name) {
		System.out.print("\nIt's " + name + "'s turn. Press enter to roll.");
	}

	public static void printFieldName(int fieldNumber) {
		System.out.println("You hit field number " + fieldNumber + ", " + getFieldName(fieldNumber));
	}
	
	/**
	 * Prints the current status of the game. Thats all players score and the
	 * sum of the dice.
	 * 
	 * @param players
	 *            An array of players to get the information from.
	 * @param sum
	 *            The value that was hit with the dice.
	 */
	public static void printStatus(Player[] players) {
		int i;
		System.out.println("The score is now:");

		for (i = 0; i < players.length; i++) {
			System.out.print(players[i].getName() + " = " + players[i].getAccountValue() + "\t");
		}

		System.out.println();
	}

	public static void printBuyOption() {
		System.out.println("This field is ownable but not owned by anyone. Would you like to buy it? (Y/N)");
	}
	
	public static void printTaxOption() {
		System.out.println("You can either pay 4000 or 10% of total assets. Would you like to pay 10% of total assets?");
	}

	/**
	 * Prints the name and score of the winning player.
	 * 
	 * @param name
	 *            The name of the player who should be declared the winner.
	 * @param score
	 *            The score for the winning player.
	 */
	public static void printWinner(String name, int score) {
		System.out.println("Congratulations! " + name + " has won with "
				+ score + " points!\nPress Enter to exit.");
	}

	/**
	 * Prints the name and score of the losing player.
	 * 
	 * @param name
	 *            The name of the player who should be declared the loser.
	 * @param score
	 *            The score for the losing player.
	 */
	public static void printLoser(String name, int score) {
		System.out.println("Sorry! " + name + " you are bankerupt.");
	}

	/**
	 * Reads a line from the console.
	 * 
	 * @param scanner
	 *            The scanner to read from
	 * @return Whatever the user inputs.
	 */
	public static String getUserInput(Scanner scanner) {
		return scanner.nextLine();
	}
}