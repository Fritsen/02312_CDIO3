package entity;

import java.util.Scanner;

public class LaborCamp extends Ownable {
	private GameBoard gameBoard;
	private int baseRent;

	public LaborCamp(int baseRent, int price, GameBoard gameBoard, Scanner scanner) {
		super(price, scanner);
		this.gameBoard = gameBoard;
		this.baseRent = baseRent;
	}

	public void landOnField(Player player) {
		if (owner == null) {
			buyFieldOption(player);
		}
		else {
			int rent = getRent();
			player.transferTo(owner, rent);
		}
	}

	public int getRent() {
		return gameBoard.getDieCupSum() * baseRent;
	}
}