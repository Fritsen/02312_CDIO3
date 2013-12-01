package testTools;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.Field;
import entity.Player;
import entity.Tax;

public class LaborCampTest {
	private Player player;
	private Field labor200;
	private Field labor0;

	@Before
	public void setUp() throws Exception {
		this.player = new Player(1000, "Anders And");
		this.labor200 = new Tax("Helle +200", 200);
		this.labor0 = new Tax("Helle 0", 0);
	}

	@After
	public void tearDown() throws Exception {
		this.player = new Player(1000, "Anders And");
		// The fields are unaltered
	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);
		Assert.assertNotNull(this.labor200);
		Assert.assertNotNull(this.labor0);
		Assert.assertTrue(this.labor200 instanceof Tax);
		Assert.assertTrue(this.labor0 instanceof Tax);
	}

	@Test
	public void testLandOnField200() {
		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.labor200.landOnField(this.player);
		expected = 1000 - 200;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField200Twice() {

		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.labor200.landOnField(this.player);
		this.labor200.landOnField(this.player);
		expected = 1000 - 200 - 200;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField0() {
		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.labor0.landOnField(this.player);
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
		this.labor0.landOnField(this.player);
		this.labor0.landOnField(this.player);
		expected = 1000;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}
}