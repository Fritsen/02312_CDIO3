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
    private boolean isOnBuyableField;
    private int location;

    /**
     * Constructor that initiates name to empty and account to an initial score.
     */
    public Player(int initialScore, String name) {
        this.name = name;
        account = new Account(initialScore);
        isBankrupt = false;
        isOnBuyableField = false;
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

    /**
     * Method to set the bankrupt status, which is used to determine if a player is still in the game.
     */
    public void setBankrupt() {
    	isBankrupt = true;
    }

    /**
     * Method to get the bankrupt status, which is used to determine if a player is still in the game.
     *
     * @return True if player is bankrupt, otherwise false.
     */
    public boolean isBankrupt() {
    	return isBankrupt;
    }

    /**
     * Method to set the boolean for whether the player is on a field that can be bought.
     *
     * @param isOnBuyableField What the value should be set to.
     */
    public void setIsOnBuyableField(boolean isOnBuyableField) {
    	this.isOnBuyableField = isOnBuyableField;
    }

    /**
     * Method to get the boolean for whether the player is on a field that can be bought.
     *
     * @return True if player is on a field that can be bought, otherwise false.
     */
    public boolean isOnBuyableField() {
    	return isOnBuyableField;
    }

    /**
     * Method to set the players current location (field number).
     *
     * @param location The location to set the player to.
     */
    public void setLocation(int location) {
    	this.location = location;
    }

    /**
     * Method to get the players current location (field number).
     *
     * @return The players current location.
     */
    public int getLocation() {
    	return location;
    }

    /**
     * Method to move a player forward on the board.
     * Takes the players current location and adds a given number of fields.
     *
     * @param fields The number of fields to move forward.
     */
    public void moveFieldsForward(int fields) {
    	location = location + fields;
    	if(location > 21) {
    		location = location - 21;
    	}
    }

    /**
     * Method to get a players account value.
     *
     * @return The players current account value.
     */
    public int getAccountValue() {
    	return account.getAccountValue();
    }

    /**
     * Method to add to a players account value.
     * Takes what the player has in the account and adds a given number.
     *
     * @param amount Amount to add to the account.
     */
    public void addToAccount(int amount) {
    	boolean succes = account.addToAccount(amount);

    	if(!succes) {
    		isBankrupt = true;
    		account.setAccountValue(0);
    	}
    }

    /**
     * Method to transfer "money" from one player to another.
     * Also checks if the player has enough money for the transfer, and sets player to bankrupt if not.
     *
     * @param player Player to transfer to.
     * @param amount Amunt to transfer.
     */
    public void transferTo(Player player, int amount) {
    	boolean succes = account.addToAccount(-1*amount);

    	if(succes) {
    		player.addToAccount(amount);
    	}
    	else {
    		player.addToAccount(account.getAccountValue());
    		account.setAccountValue(0);
    		isBankrupt = true;
    	}
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