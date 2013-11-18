package entity;

import java.util.Scanner;

public class Fleet extends Ownable {
	private final int[] FLEET_FIELDS = {18, 19, 20, 21};
	
	private final int RENT_1 = 500;
	private final int RENT_2 = 1000;
	private final int RENT_3 = 2000;
	private final int RENT_4 = 4000;
	
	private GameBoard gameBoard;
	
	public Fleet(int price, GameBoard gameBoard, Scanner scanner) {
		super(price, scanner);
		this.gameBoard = gameBoard;
	}
	
	public void landOnField(Player player) {
		if(owner == null) {
			buyFieldOption(player);
		}
		else {
			int rent = getRent();
			player.transferTo(owner, rent);
		}
	}
	
	public int getRent() {
		int i, numberOfFleetsOwned = 0;
		
		for(i=0; i<4; i++) {
			if(owner == gameBoard.getOwner(FLEET_FIELDS[i])) {
				numberOfFleetsOwned++;
			}
		}
		
		switch(numberOfFleetsOwned) {
			case 1:
				return RENT_1;
			case 2:
				return RENT_2;
			case 3:
				return RENT_3;
			case 4:
				return RENT_4;
			default:
				return 0;
		}
	}
	
	public Player getOwner() {
		return owner;
	}
}
