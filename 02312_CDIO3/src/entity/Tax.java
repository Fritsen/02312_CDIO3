package entity;

import java.util.Scanner;

import boundary.TUI;

public class Tax extends Field{
	private int taxAmount;
	private int taxRate;
	private GameBoard gameBoard;
	private Scanner scanner;
	
	public Tax(int taxAmount) {
		this.taxAmount = taxAmount;
		taxRate = -1;
	}
	
	public Tax(int taxAmount, int taxRate, GameBoard gameBoard, Scanner scanner) {
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
		this.gameBoard = gameBoard;
		this.scanner = scanner;
	}
	
	public void landOnField(Player player) {
		if(taxRate == -1)
		{
			player.addToAccount(-1 * taxAmount);	
		}
		else
		{
			TUI.printTaxOption();
			if(TUI.getYesNo(scanner))
			{
				player.addToAccount(-1 * calculateTax(player));
				System.out.println("Betalte 10%");
			}
			else
			{
				player.addToAccount(-1 * taxAmount);
				System.out.println("Betalte 4000");
			}
		}
	}
	
	private int calculateAssets(Player player) {
		int i, assets = 0;
		
		for(i=1; i<=21; i++) {
			if(gameBoard.getOwner(i) != null && gameBoard.getOwner(i) == player) {
				assets = assets + gameBoard.getPrice(i);
			}
		}
		
		return assets + player.getAccountValue();
	}
	
	private int calculateTax(Player player) {
		return (taxRate * calculateAssets(player)) / 100;
	}
}
