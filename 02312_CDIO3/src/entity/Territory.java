package entity;

import java.util.Scanner;

public class Territory extends Ownable {
	private int rent;

	public Territory(int rent, int price, Scanner scanner) {
		super(price, scanner);
		this.rent = rent;
	}

	public void landOnField(Player player) 
	{
		if (owner == null)
		{
			buyFieldOption(player);
		} 
		
		else
		{
			int rent = getRent();
			player.transferTo(owner, rent);
		}
	}

	public int getRent() {
		return 0;
	}
}
