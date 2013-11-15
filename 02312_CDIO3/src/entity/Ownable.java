package entity;

public abstract class Ownable extends Field {
	protected int price;
	protected Player owner;
	
	public Ownable(int price) {
		this.price = price;
		owner = null;
	}
	
	public void buyFieldOption(Player player) {
		//TODO: Giv mulighed for at købe feltet...
	}
	
	public abstract int getRent();
}
