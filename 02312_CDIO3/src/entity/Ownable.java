package entity;

public abstract class Ownable extends Field {
	protected int price;
	protected Player owner;

	public Ownable(String name, int price) {
		super(name);
		this.price = price;
		owner = null;
	}
	
	public void landOnField(Player player) {
		if (owner == null) {
			buyFieldOption(player);
		}
		else if(owner != player) {
			int rent = getRent();
			player.transferTo(owner, rent);
		}
	}
	
	public abstract int getRent();

	private void buyFieldOption(Player player) {
		player.setIsOnBuyableField(true);
	}
}