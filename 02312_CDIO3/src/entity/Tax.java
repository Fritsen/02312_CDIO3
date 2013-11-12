package entity;

public class Tax extends Field{
	private int taxAmount;
	private int taxRate;
	
	public Tax(String name, int number, int taxAmount, int taxRate) {
		this.name = name;
		this.number = number;
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
	}
	
	public void landOnField(Player player) {
		
	}
}
