package entity;

public class Territory extends Ownable {
	private int rent;
	
	public Territory(int rent, int price) {
		super(price);
		this.rent = rent;
	}
	
	public void landOnField(Player player) {
		//TODO: Skriv hvad der skal ske...
	}
	
	public int getRent() {
		return 0;
	}
}
