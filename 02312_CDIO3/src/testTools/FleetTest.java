package testTools;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.Field;
import entity.Fleet;
import entity.GameBoard;
import entity.Player;

public class FleetTest {
	private Player player;
	private Field fleet200;
	private Field fleet0;
	private GameBoard gameboard;

	@Before
	public void setUp() throws Exception {
		this.gameboard.setOwner(player);
		this.player = new Player(1000, "Anders And");
		this.fleet200 = new Fleet("Helle +200", 200, gameboard);
		this.fleet0 = new Fleet("Helle 0", 0, gameboard);
	}

	@After
	public void tearDown() throws Exception {
		this.player = new Player(1000, "Anders And");
		// The fields are unaltered
	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);
		Assert.assertNotNull(this.fleet200);
		Assert.assertNotNull(this.fleet0);
		Assert.assertTrue(this.fleet200 instanceof Fleet);
		Assert.assertTrue(this.fleet0 instanceof Fleet);
	}

	@Test
	public void testLandOnField200() {
		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.fleet200.landOnField(this.player);
		expected = 1000;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField200Twice() {

		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.fleet200.landOnField(this.player);
		this.fleet200.landOnField(this.player);
		expected = 1000;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField0() {
		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.fleet0.landOnField(this.player);
		expected = 1000;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField0Twice() {
		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.fleet0.landOnField(this.player);
		this.fleet0.landOnField(this.player);
		expected = 1000;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}
}