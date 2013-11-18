package entity;

import java.util.Scanner;

public class Territory extends Ownable {
	private int rent;
	
	public Territory(int rent, int price, Scanner scanner) {
		super(price, scanner);
		this.rent = rent;
	}
	
	public void landOnField(Player player) {
		//TODO: Skriv hvad der skal ske...
	}
	
	public int getRent() {
		return 0;
	}
}
