package entity;

public class Territory extends Ownable {
	private int rent;
	
	public Territory(String name, int number, int rent, int price) {
		this.name = name;
		this.number = number;
		this.rent = rent;
		this.price = price;
	}
	
	public void landOnField(Player player) {
		
	}
	
	public int getRent() {
		return 0;
	}
}
