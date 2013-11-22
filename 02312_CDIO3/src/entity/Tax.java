package entity;

import java.util.Scanner;

import boundary.TUI;

public class Tax extends Field{
	private int taxAmount;
	private int taxRate;
	private GameBoard gameBoard;
	
	public Tax(int taxAmount) {
		this.taxAmount = taxAmount;
		taxRate = -1;
	}
	
	public Tax(int taxAmount, int taxRate, GameBoard gameBoard) {
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
		this.gameBoard = gameBoard;
	}
	
	public void landOnField(Player player) {
		if(player.getLocation() == 16)
		{
			player.addToAccount(-2000);	
		}
		
		else if(player.getLocation() == 17)
		{
			//TODO Fix TUI message for Tax
			if(TUI.getYesNo(Scanner) = True)
			{
				player.addToAccount(-4000);
			}
		else
		{
			player.addToAccount(-1*(taxRate/100*calculateAssets(player)));
		}
	}
		
		
}
	
	private int calculateAssets(Player player) {
		int i, assets = 0;
		
		for(i=1; i<=21; i++) {
			Ownable ownableField = gameBoard.getOwnableField(i);
			
			if(ownableField != null && player == ownableField.owner) {
				assets = assets + ownableField.price;
			}
		}
		
		return assets;
	}
}
