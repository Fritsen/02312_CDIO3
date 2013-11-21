package entity;

import java.util.Scanner;

public class LaborCamp extends Ownable {
	private int baseRent;
<<<<<<< HEAD

	private GameBoard gameBoard;

	public LaborCamp(int baseRent, int price, GameBoard gameBoard) {
		super(price);
=======
	
	public LaborCamp(int baseRent, int price, Scanner scanner) {
		super(price, scanner);
>>>>>>> 36ff0e4aeb37abe209819cce739e758c9d893da8
		this.baseRent = baseRent;
		this.gameBoard = gameBoard;
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
