package entity;

public class LaborCamp extends Ownable {
	private int baseRent;
	
	public LaborCamp(int baseRent, int price) {
		this.baseRent = baseRent;
		this.price = price;
	}
	
	public void landOnField(Player player) {
		//TODO: Skriv hvad der skal ske...
	}
	
	public int getRent() {
		return 0;
	}
}
