package entity;

public class Refuge extends Field {
	int bonus;
	
	public Refuge(int bonus) {
		this.bonus = bonus;
	}
	
	public void landOnField(Player player) {
		player.addToAccount(bonus);
	}
}
