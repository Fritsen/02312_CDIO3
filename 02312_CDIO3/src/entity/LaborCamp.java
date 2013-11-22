package entity;

import java.util.Scanner;

public class LaborCamp extends Ownable {
	private int baseRent;

	private GameBoard gameBoard;

	public LaborCamp(int baseRent, int price, Scanner scanner, GameBoard gameBoard) {
		super(price, scanner);
		this.baseRent = baseRent;
		this.gameBoard = gameBoard;
	}

	public void landOnField(Player player) {
		if (owner == null) {
			buyFieldOption(player);
		} else {
			int rent = getRent();
			player.transferTo(owner, rent);
		}

	}

	public int getRent() {
		return gameBoard.calcRentLabor() * baseRent;
	}
}