package entity;

import java.util.Scanner;

public class LaborCamp extends Ownable {
	private int baseRent;

	private GameBoard gameBoard;

	public LaborCamp(int baseRent, int price, Scanner scanner) {
		super(price, scanner);
		this.baseRent = baseRent;
	}

	public void landOnField(Player player) {
		if (owner == null) {
			buyFieldOption(player);
		} else {
			int baseRent = getRent();
			player.transferTo(owner, baseRent);
		}

	}

	public int getRent() {
		baseRent = gameBoard.calcRentLabor(baseRent) * 100;
		return baseRent;
	}

	public Player getOwner() {
		return owner;
	}
}