package entity;

/**
 * Class to create a player. This class can be used for storing a name and account for a player.
 *
 * @author DTU 02312 Gruppe 19
 *
 */
public class Player {
    private String name;
    private Account account;
    private boolean isBankrupt;
    private int location;
    private int lastDieSum;
    
    /**
     * Constructor that initiates name to empty and account to an initial score.
     */
    public Player(int initialScore) {
        name = "";
        account = new Account(initialScore);
        isBankrupt = false;
        location = 1;
    }
    
    /**
     * Saves the given name.
     * 
     * @param input The name to save.
     */
    public void setName(String input) {
        name = input;
    }
    
    /**
     * Gets the name of the player
     * 
     * @return The name of this player.
     */
    public String getName() {
        return name;
    }
    
    public void setBankrupt() {
    	isBankrupt = true;
    }
    
    public boolean isBankrupt() {
    	return isBankrupt;
    }
    
    public void setLocation(int location) {
    	this.location = location;
    }
    
    public int getLocation() {
    	return location;
    }
    
    public void moveFieldsForward(int fields) {
    	location = location + fields;
    	if(location > 21) {
    		location = location - 21;
    	}
    }
    
    public int getAccountValue() {
    	return account.getAccountValue();
    }
    
    public void addToAccount(int amount) {
    	boolean succes;
    	succes = account.addToAccount(amount);
    	
    	if(!succes) {
    		isBankrupt = true;
    	}
    }
    
    public void transferTo(Player player, int amount) {
    	this.addToAccount(-1*amount);
    	player.addToAccount(amount);
    }
    
    public void setLastDieSum(int input) {
    	lastDieSum = input;
    }
    
    public int getLastDieSum() {
    	return lastDieSum;
    }
    
    /**
     * Method that makes a text with the most important values in the class, and some description.
     *
     * @return A coherent string with values of name and account.
     */
    public String toString() {
        return "Name = " + name + ", Account = " + account;
    }
} 