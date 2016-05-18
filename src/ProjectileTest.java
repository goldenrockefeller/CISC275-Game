
import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectileTest {

	@Test
	public void testZ() {
		GameState testgame = new GameState();
		Food testfood = new Food(500, 500, 0, 0, testgame);
		Trash testtrash = new Trash(600, 600, 0, 0, testgame);
		
		//Test getter and setter
		testfood.setZ(5);
		assertEquals(5, testfood.getZ());
		testfood.setZ(3);
		assertEquals(3, testfood.getZ());
		testtrash.setZ(1);
		assertEquals(1, testtrash.getZ());
		testtrash.setZ(4);
		assertEquals(4, testtrash.getZ());
		
	}
	
	@Test
	public void testUpdate() {
		GameState testgame = new GameState();
		Food testfood = new Food(500, 500, 1, 1, testgame);
		Trash testtrash = new Trash(600, 600, 1, 1, testgame);
		
		testfood.setZ(10);
		testtrash.setZ(7);
		
		//This should only decrement z or changes velocity
		for (int i = 0; i < 7; i++) {
			testfood.updateState();
			testtrash.updateState();
		}
		//After 7 calls, z-value for trash should be 0, so its velocity should be 0
		assertEquals(0, testtrash.getZ());
		assertEquals(0, testtrash.getxVelocity(), 0.1);
		assertEquals(0, testtrash.getyVelocity(), 0.1);
		//Food z-value should be 3, still moving
		assertEquals(3, testfood.getZ());
		assertEquals(1, testfood.getxVelocity(), 0.1);
		assertEquals(1, testfood.getyVelocity(), 0.1);
		
		for (int i = 0; i < 3; i++) {
			testfood.updateState();
			testtrash.updateState();
		}
		//Updating 3 more times should make food z-vlue 0, speed also 0
		assertEquals(0, testfood.getZ());
		assertEquals(0, testfood.getxVelocity(), 0.1);
		assertEquals(0, testfood.getyVelocity(), 0.1);
		
	}

}
