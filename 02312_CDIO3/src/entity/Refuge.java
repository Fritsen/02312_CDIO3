package entity;

public class Refuge extends Field {
	int bonus;
	
	public Refuge(String name, int bonus) {
		super(name);
		this.bonus = bonus;
	}
	
	public void landOnField(Player player) {
		player.addToAccount(bonus);
	}
}
