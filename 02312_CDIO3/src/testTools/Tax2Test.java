package testTools;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.Field;
import entity.GameBoard;
import entity.Player;
import entity.Tax;

public class Tax2Test {
	private Player player;
	private Field tax200;
	private Field tax0;
	private Field taxNeg200;
	private GameBoard gameboard;

	@Before
	public void setUp() throws Exception {
		this.player = new Player(1000, "Anders And");
		this.tax200 = new Tax("Helle +200", 200, 10, gameboard);
		this.tax0 = new Tax("Helle 0", 0, 0, gameboard);
		this.taxNeg200 = new Tax("Helle -200", -200, 10, gameboard);
	}

	@After
	public void tearDown() throws Exception {
		this.player = new Player(1000, "Anders And");
		// The fields are unaltered
	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);
		Assert.assertNotNull(this.tax200);
		Assert.assertNotNull(this.tax0);
		Assert.assertNotNull(this.taxNeg200);
		Assert.assertTrue(this.tax200 instanceof Tax);
		Assert.assertTrue(this.tax0 instanceof Tax);
		Assert.assertTrue(this.taxNeg200 instanceof Tax);
	}

	@Test
	public void testLandOnField200() {
		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.tax200.landOnField(this.player);
		expected = 1000 + 100;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField200Twice() {

		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.tax200.landOnField(this.player);
		this.tax200.landOnField(this.player);
		expected = 1000 + 200;
		actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField0() {
		int expected = 1000;
		int actual = this.player.getAccountValue();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.tax0.landOnField(this.player);
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
		this.tax0.landOnField(this.player);
		this.tax0.landOnField(this.player);
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