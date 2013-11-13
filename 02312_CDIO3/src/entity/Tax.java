package entity;

public class Tax extends Field{
	private int taxAmount;
	private int taxRate;
	
	public Tax(int taxAmount, int taxRate) {
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
	}
	
	public void landOnField(Player player) {
		//TODO: Skriv hvad der skal ske...
	}
}
