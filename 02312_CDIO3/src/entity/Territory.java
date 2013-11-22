package entity;

import java.util.Scanner;

public class Territory extends Ownable {
	private int rent;

	public Territory(String name, int rent, int price, Scanner scanner) {
		super(name, price, scanner);
		this.rent = rent;
	}

	public int getRent() {
		return rent;
	}
}
