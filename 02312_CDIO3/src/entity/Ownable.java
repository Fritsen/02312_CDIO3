package entity;

import java.util.Scanner;

import boundary.TUI;

public abstract class Ownable extends Field {
	protected int price;
	protected Player owner;
	private Scanner scanner;

	public Ownable(String name, int price, Scanner scanner) {
		super(name);
		this.price = price;
		owner = null;
		this.scanner = scanner;
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
	
	public abstract int getRent();

	private void buyFieldOption(Player player) {
		TUI.printBuyOption();
		boolean wantToBuy = TUI.getYesNo(scanner);

		if (wantToBuy) {
			player.addToAccount(-1 * price);
			owner = player;
		}
	}
}