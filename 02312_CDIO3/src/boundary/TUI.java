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
	private Scanner scanner;
	
	/**
	 * Constructor to open a scanner for console input.
	 */
	public TUI() {
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Prints game rules.
	 */
	public void printRules() {
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

	/**
	 * Gets an integer from 1-6. Keeps asking until valid input is given.
	 * 
	 * @param scanner An open scanner to read from.
	 * @return An integer from 1-6.
	 */
	public int getNumberOfPlayers() {
		int numberOfPlayers = 0;

		// Get the number of players from console. Keep trying until input is
		// valid
		while (numberOfPlayers == 0) {
			printNumberRequest();
			try {
				numberOfPlayers = new Integer(getUserInput());
				if (numberOfPlayers < 0 || numberOfPlayers > 6) {
					numberOfPlayers = 0;
				}
			} catch (Exception e) {
				numberOfPlayers = 0;
			}
		}

		return numberOfPlayers;
	}

	/**
	 * Method that takes input from console and translates it to boolean yes/no.
	 * Supports both upper and lower case.
	 * Keeps asking until valid input is given (Y/y or N/n).
	 * 
	 * @param scanner A scanner to use for reading from console.
	 * @return True if Y/y is written, False if N/n.
	 */
	public boolean getYesNo() {
		String input;
		
		while(true) {
			input = getUserInput();
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
	 * Prints a short text, asking the specified player to type his name.
	 * 
	 * @param playerNo The player number to print as part of the message.
	 */
	public void printNameRequest(int playerNumber) {
		System.out
				.println("Insert name for player " + (playerNumber + 1) + ".");
	}

	/**
	 * Prints a short text, asking the user to type the number of players. 
	 */
	public void printNumberRequest() {
		System.out.println("Select the number of players 1-6:");
	}

	/**
	 * Prints a short text, telling the player who's turn it is, and asking him
	 * to roll.
	 * 
	 * @param name The name to print as part of the message.
	 */
	public void printTurn(String name) {
		System.out.print("\nIt's " + name + "'s turn. Press enter to roll.");
	}

	/**
	 * Print info about a field.
	 * 
	 * @param fieldNumber The field number used as part of the printed text
	 * @param fieldName The field name used as part of the printed text
	 */
	public void printFieldName(int fieldNumber, String fieldName) {
		System.out.println("You hit field number " + fieldNumber + ", " + fieldName);
	}
	
	/**
	 * Prints the current status of the game. Thats all players name and score.
	 * 
	 * @param players An array of players to get the information from.
	 */
	public void printStatus(Player[] players) {
		int i;
		System.out.println("The score is now:");

		for (i = 0; i < players.length; i++) {
			System.out.print(players[i].getName() + " = " + players[i].getAccountValue() + "\t");
		}

		System.out.println();
	}

	/**
	 * Prints a message in the console, giving the player an option to buy af field.
	 * 
	 * @param name The name of the field.
	 * @param price The price of the field.
	 */
	public void printBuyOption(String name, int price) {
		System.out.println("Would you like to buy " + name + " for " + price + "? (Y/N)");
	}

	/**
	 * Prints the name and score of the winning player.
	 * 
	 * @param name The name of the player who should be declared the winner.
	 * @param score The score for the winning player.
	 */
	public void printWinner(String name, int score) {
		System.out.println("Congratulations! " + name + " has won with "
				+ score + " points!\nPress Enter to exit.");
	}

	/**
	 * Prints the name and score of a player that is bankrupt.
	 * 
	 * @param name The name of the player who should be declared bankrupt.
	 * @param score The score for the losing player.
	 */
	public void printLoser(String name, int score) {
		System.out.println("Sorry! " + name + " you are bankrupt.");
	}

	/**
	 * Reads a line from the console.
	 * 
	 * @param scanner The scanner to read from
	 * @return Whatever the user inputs.
	 */
	public String getUserInput() {
		return scanner.nextLine();
	}
	
	/**
	 * Close the scanner
	 */
	public void close() {
		scanner.close();
	}
}