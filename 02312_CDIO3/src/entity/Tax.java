package entity;

public class Tax extends Field{
	private int taxAmount;
	private int taxRate;
	private GameBoard gameBoard;
	
	public Tax(String name, int taxAmount) {
		super(name);
		this.taxAmount = taxAmount;
		taxRate = -1;
	}
	
	public Tax(String name, int taxAmount, int taxRate, GameBoard gameBoard) {
		super(name);
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
		this.gameBoard = gameBoard;
	}
	
	public void landOnField(Player player) {
		player.addToAccount(-1*getTax(player));
	}
	
	private int getAssets(Player player) {
		int i, assets = 0;
		
		for(i=1; i<=21; i++) {
			if(gameBoard.getOwner(i) == player) {
				assets = assets + gameBoard.getPrice(i);
			}
		}
		
		return assets + player.getAccountValue();
	}
	
	private int getTax(Player player) {
		if(taxRate != -1)
		{
			int taxFromAssets = getAssets(player) * taxRate / 100;
			if(taxFromAssets < taxAmount) {
				return taxFromAssets;
			}
		}

		return taxAmount;
	}
}
