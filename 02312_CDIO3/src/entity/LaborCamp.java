package entity;

import java.util.Scanner;

public class LaborCamp extends Ownable {
	private int baseRent;
	
	public LaborCamp(int baseRent, int price, Scanner scanner) {
		super(price, scanner);
		this.baseRent = baseRent;
	}
	
	public void landOnField(Player player) {
		//TODO: Skriv hvad der skal ske...
	}
	
	public int getRent() {
		return 0;
	}
}
