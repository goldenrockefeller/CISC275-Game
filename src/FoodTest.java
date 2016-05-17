import static org.junit.Assert.*;

import org.junit.Test;

public class FoodTest {

	/**
	 * Ensure that food stops when it is no longer in the bounds of the game
	 * Z value decrement is used but has already been tested @see ProjectileTest
	 */
	@Test
	public void testUpdate() {
		GameState testgame = new GameState();
		Food testfood = new Food (200, 200, 10, 10, testgame);
		testfood.setZ(100);
		
		//Test within bounds
		testfood.updateState();
		assertEquals(10, testfood.getxVelocity(), 0.1);
		assertEquals(10, testfood.getyVelocity(), 0.1);
		
		
		//Test out of x upper bounds
		testfood.setxPosition(5000);
		testfood.updateState();
		assertEquals(0, testfood.getxVelocity(), 0.1);
		assertEquals(0, testfood.getyVelocity(), 0.1);
		
		//Test out of x lower bounds
		testfood.setxPosition(-10);
		testfood.updateState();
		assertEquals(0, testfood.getxVelocity(), 0.1);
		assertEquals(0, testfood.getyVelocity(), 0.1);
		
		/****************************************************/
		
		//Test out of y upper bounds
		testfood.setyPosition(5000);
		testfood.updateState();
		assertEquals(0, testfood.getxVelocity(), 0.1);
		assertEquals(0, testfood.getyVelocity(), 0.1);
				
		//Test out of y lower bounds
		testfood.setyPosition(-10);
		testfood.updateState();
		assertEquals(0, testfood.getxVelocity(), 0.1);
		assertEquals(0, testfood.getyVelocity(), 0.1);
	}

}
