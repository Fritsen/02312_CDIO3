package control;

import java.util.Scanner;

import entity.DieCup;
import entity.GameBoard;
import entity.Player;

import boundary.Graphic;
import boundary.TUI;


/**
 * This is controller class in the dice game.
 * 
 * @author DTU 02312 Gruppe 19
 * 
 */
public class Game {
	private final int POINTS_TO_START_WITH = 30000;

	private DieCup dieCup;
	private Scanner scanner;
	private GameBoard gameBoard;
	private Player[] players;
	
	private int numberOfPlayers;

	/**
	 * Game constructor. Creates new instances of the required classes.
	 */
	public Game() {
		dieCup = new DieCup();
		scanner = new Scanner(System.in);
		gameBoard = new GameBoard();

		Graphic.setupFields();
	}

	/**
	 * Start the game.
	 */
	public void startGame() {
		int activePlayer, i;
		String userInput;
		numberOfPlayers = 0;
		
		TUI.printRules();
		
		// Get the number of players from console. Keep trying until input is valid
		while(numberOfPlayers == 0) {
			TUI.printNumberRequest();
			try {
				numberOfPlayers = new Integer(TUI.getUserInput(scanner));
				if(numberOfPlayers < 0 || numberOfPlayers > 6) {
					numberOfPlayers = 0;
				}
			}
			catch(Exception e) {
				numberOfPlayers = 0;
			}
		}
		
		//Make array of players according to number of players
		players = new Player[numberOfPlayers];

		// Make all player-objekts in loop
		for (i = 0; i < numberOfPlayers; i++) {
			players[i] = new Player(POINTS_TO_START_WITH);
		}

		// Ask for all player names and save them in the player objects. Also
		// adds the players to the GUI.
		for (i = 0; i < numberOfPlayers; i++) {
			TUI.printNameRequest(i);
			players[i].setName(TUI.getUserInput(scanner));
			Graphic.addPlayer(players[i].getName(), players[i].getAccount()
					.getAccountValue());
		}

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
			gameBoard.getField(1).landOnField(players[activePlayer]);
			if(players[activePlayer].isBankrupt()) {
				loseTasks(activePlayer);
			}

			// Write status/score to both TUI and GUI
			statusTasks(activePlayer);

			// Switch turn to the next player
			activePlayer = getNextPlayer(activePlayer);
		}
	}

	/**
	 * Simple method to get the number of the next player.
	 * 
	 * @param input The number to toggle away from.
	 * @return 2 if 1 is given etc., but gives 1 if the value for number of players is reached.
	 */
	private int getNextPlayer(int input) {
		if (input + 1 >= numberOfPlayers) {
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
		TUI.printWinner(players[activePlayer].getName(), players[activePlayer].getAccount().getAccountValue());
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
		TUI.printLoser(players[activePlayer].getName(), players[activePlayer].getAccount().getAccountValue());

		if(countPlayersLeft() == 1) {
			winTasks(getLastPlayerLeft());
		}
		
		TUI.getUserInput(scanner);
	}
	
	private int countPlayersLeft() {
		int i, playersLeft = 0;
		
		for(i = 0; i < numberOfPlayers; i++) {
			if(!players[i].isBankrupt()) {
				playersLeft++;
			}
		}
		
		return playersLeft;
	}
	
	private int getLastPlayerLeft() {
		int i;
		
		for(i = 0; i < numberOfPlayers; i++) {
			if(!players[i].isBankrupt()) {
				return i;
			}
		}
		
		return 0;
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