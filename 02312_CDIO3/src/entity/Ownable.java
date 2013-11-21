package entity;

import java.util.Scanner;

import boundary.TUI;

public abstract class Ownable extends Field {
	protected int price;
	protected Player owner;
	private Scanner scanner;

	public Ownable(int price, Scanner scanner) {
		this.price = price;
		owner = null;
		this.scanner = scanner;
	}

	protected void buyFieldOption(Player player) {
		TUI.printBuyOption();
		boolean wantToBuy = TUI.getYesNo(scanner);

		if (wantToBuy) {
			player.addToAccount(-1 * price);
			owner = player;
		}
	}

	public abstract int getRent();
}