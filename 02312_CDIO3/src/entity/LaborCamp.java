package entity;

public class LaborCamp extends Ownable {
	private int baseRent;
	
	public LaborCamp(String name, int number, int baseRent, int price) {
		this.name = name;
		this.number = number;
		this.baseRent = baseRent;
		this.price = price;
	}
	
	public void landOnField(Player player) {
		
	}
	
	public int getRent() {
		return 0;
	}
}
