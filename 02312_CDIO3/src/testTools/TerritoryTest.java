package testTools;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.Field;
import entity.Player;
import entity.Territory;

public class TerritoryTest {
	private Player player;
	private Field ter200;
	private Field ter0;
	private Field terNeg200;

	@Before
	public void setUp() throws Exception {
		this.player = new Player(1000, "Anders And");
		this.ter200 = new Territory("Helle +200", 200, 200);
		this.ter0 = new Territory("Helle 0", 0, 0);
		this.terNeg200 = new Territory("Helle -200", -200, -200);
	}

	@After
	public void tearDown() throws Exception {
		this.player = new Player(1000, "Anders And");
		// The fields are unaltered
	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);
		Assert.assertNotNull(this.ter200);
		Assert.assertNotNull(this.ter0);
		Assert.assertNotNull(this.terNeg200);
		Assert.assertTrue(this.ter200 instanceof Territory);
		Assert.assertTrue(this.ter0 instanceof Territory);
		Assert.assertTrue(this.terNeg200 instanceof Territory);
	}

	@Test
	public void testLandOnField200() {
		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.ter200.landOnField(this.player);
		expected = 1000 + 200;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField200Twice() {

		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.ter200.landOnField(this.player);
		this.ter200.landOnField(this.player);
		expected = 1000 + 200 + 200;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField0() {
		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.ter0.landOnField(this.player);
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
		this.ter0.landOnField(this.player);
		this.ter0.landOnField(this.player);
		expected = 1000;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}

	// @Test
	// public void testLandOnFieldNeg200() {
	// int expected = 1000;
	// int actual = this.player.getAccountValue();
	// Assert.assertEquals(expected, actual);
	//
	// // Perform the action to be tested
	// this.refugeNeg200.landOnField(this.player);
	//
	// // It is not possible to deposit a negative amount
	// expected = 1000;
	// actual = this.player.getAccountValue();
	// Assert.assertEquals(expected, actual);
	// }
}