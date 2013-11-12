package Control;

import java.util.Scanner;

import Boundary.Graphic;
import Boundary.TUI;
import Entity.DieCup;
import Entity.GameBoard;
import Entity.Player;

/**
 * This is controller class in the dice game.
 * 
 * @author DTU 02312 Gruppe 19
 * 
 */
public class Game {
	private final int POINTS_TO_START_WITH = 1000;
	private final int POINTS_TO_WIN = 3000;
	private final int NUMBER_OF_PLAYERS = 2;

	private DieCup dieCup;
	private Scanner scanner;
	private GameBoard gameBoard;
	private Player[] players;

	/**
	 * Game constructor. Creates new instances of the required classes.
	 */
	public Game() {
		int i;

		dieCup = new DieCup();
		scanner = new Scanner(System.in);
		gameBoard = new GameBoard();
		players = new Player[NUMBER_OF_PLAYERS];

		// Make all player-objekts in loop
		for (i = 0; i < NUMBER_OF_PLAYERS; i++) {
			players[i] = new Player(POINTS_TO_START_WITH);
		}

		Graphic.setupFields();
	}

	/**
	 * Start the game.
	 */
	public void startGame() {
		int activePlayer, i, scoreToAdd;
		String userInput;

		TUI.printRules();

		// Ask for all player names and save them in the player objects. Also
		// adds the players to the GUI.
		for (i = 0; i < NUMBER_OF_PLAYERS; i++) {
			TUI.printNameRequest(i);
			players[i].setName(TUI.getUserInput(scanner));
			Graphic.addPlayer(players[i].getName(), players[i].getAccount()
					.getAccountValue());
		}

		// Player 1 always starts. However this would work with Player 2, or
		// even random.
		activePlayer = 0;

		// Start of the actual game. Infinite loop is broken only when someone
		// wins or inputs "q"
		while (true) {
			// Write whos turn it is and wait for input
			TUI.printTurn(players[activePlayer].getName());
			userInput = TUI.getUserInput(scanner);

			// Exit game if user inputs "q"
			if ("q".equals(userInput)) {
				cleanUp();
			}

			// Shake, and add the sum of the dice to the current players score
			dieCup.shakeDieCup();

			// Add points from field
			scoreToAdd = gameBoard.getField(dieCup.getSum()).getFieldScore();
			if(!players[activePlayer].getAccount().addToAccount(scoreToAdd)) {
				loseTasks(activePlayer);
			}

			// Write status/score to both TUI and GUI
			statusTasks(activePlayer);

			// Check if player have won
			if (players[activePlayer].getAccount().getAccountValue() >= POINTS_TO_WIN) {
				winTasks(activePlayer);
			}

			// Switch turn to the next player, unless the current player gets an
			// extra turn
			if (!gameBoard.getField(dieCup.getSum()).getGivesExtraTurn()) {
				activePlayer = getNextPlayer(activePlayer);
			}
		}
	}

	/**
	 * Simple method to get the number of the next player.
	 * 
	 * @param input The number to toggle away from.
	 * @return 2 if 1 is given etc., but gives 1 if the value for number of players is reached.
	 */
	private int getNextPlayer(int input) {
		if (input + 1 >= NUMBER_OF_PLAYERS) {
			return 0;
		}

		return input + 1;
	}

	/**
	 * Writes score and dice values to both GUI and TUI
	 */
	private void statusTasks(int activePlayer) {
		TUI.printStatus(players, dieCup.getSum());
		Graphic.setDice(dieCup.getValueDie1(), dieCup.getValueDie2());
		Graphic.updatePlayers(players);
		Graphic.moveCar(players[activePlayer].getName(), dieCup.getSum());
	}

	/**
	 * Prints the name of the given player, along with a message telling that
	 * he has won the game., then waits for input, to make sure the message
	 * stays on the screen. Ends the program when any input is given.
	 * 
	 * @param activePlayer The number of the player who should be declared the winner.
	 */
	private void winTasks(int activePlayer) {
		TUI.printWinner(players[activePlayer].getName(), players[activePlayer]
				.getAccount().getAccountValue());
		TUI.getUserInput(scanner);
		cleanUp();
	}

	/**
	 * Prints the name of the given player, along with a message telling that
	 * he has lost the game., then waits for input, to make sure the message
	 * stays on the screen. Ends the program when any input is given.
	 * 
	 * @param activePlayer The number of the player who should be declared the loser.
	 */
	private void loseTasks(int activePlayer) {
		TUI.printLoser(players[activePlayer].getName(), players[activePlayer]
				.getAccount().getAccountValue());
		TUI.getUserInput(scanner);
		cleanUp();
	}

	/**
	 * Closes the program and cleans up properly.
	 */
	private void cleanUp() {
		Graphic.close();
		scanner.close();
		System.exit(0);
	}
}