package entity;

import java.util.Scanner;

public class LaborCamp extends Ownable {
	private final int[] LABOR_CAMP_FIELDS = { 14, 15 };
	
	private GameBoard gameBoard;
	private int baseRent;

	public LaborCamp(String name, int baseRent, int price, GameBoard gameBoard, Scanner scanner) {
		super(name, price, scanner);
		this.gameBoard = gameBoard;
		this.baseRent = baseRent;
	}

	public int getRent() {
		gameBoard.shakeDieCup();
		return baseRent * gameBoard.getDieCupSum() * getLaborCampsOwned();
	}
	
	public int getLaborCampsOwned() {
		int i, numberOfLaborCampsOwned = 0;

		for (i = 0; i < LABOR_CAMP_FIELDS.length; i++) {
			if (owner == gameBoard.getOwner(LABOR_CAMP_FIELDS[i])) {
				numberOfLaborCampsOwned++;
			}
		}
		
		return numberOfLaborCampsOwned;
	}
}