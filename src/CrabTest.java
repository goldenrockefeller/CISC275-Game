<<<<<<< HEAD


import static org.junit.Assert.*;

import org.junit.Test;

public class CrabTest {
	
	/**
	 * Initiate two crabs with arbitrary position and speed
	 * Assert there is no change if there is no change in position
	 * Assert that velocity sign is switched if out of bounds
	 * 
	 * Create food objects and test collisions using position values
	 * Use helper functions getCrabCount and getFoodCount to 
	 * ensure proper removal of food and cloning of crabs
	 */
	@Test
	public void testUpdateState() {
		
		GameState testgame = new GameState();
		
		Crab testblue = new BlueCrab(500, 500, 3, 1, testgame);
		Crab testmitten = new MittenCrab(500, 500, 6, 2, testgame);
		testgame.add(testblue);;
		testgame.add(testmitten);
		assertEquals(2, getCrabCount(testgame));
		assertEquals(3.0, testblue.getxVelocity(), 0.1);
		assertEquals(6.0, testmitten.getxVelocity(), 0.1);
		assertEquals(1.0, testblue.getyVelocity(), 0.1);
		assertEquals(2.0, testmitten.getyVelocity(), 0.1);
		
		//Change nothing
		testblue.updateState();
		testmitten.updateState();
		assertEquals(3.0, testblue.getxVelocity(), 0.1);
		assertEquals(6.0, testmitten.getxVelocity(), 0.1);
		assertEquals(1.0, testblue.getyVelocity(), 0.1);
		assertEquals(2.0, testmitten.getyVelocity(), 0.1);
		
		//Change xPosition
		testblue.setxPosition(-10);
		testmitten.setxPosition(1500);
		testblue.updateState();
		testmitten.updateState();
		assertEquals(3.0, testblue.getxVelocity(), 0.1);
		assertEquals(-6.0, testmitten.getxVelocity(), 0.1);
		assertEquals(1.0, testblue.getyVelocity(), 0.1);
		assertEquals(2.0, testmitten.getyVelocity(), 0.1);
		
		//Change y Position
		testblue.setyPosition(800);
		testmitten.setyPosition(100);
		testblue.updateState();
		testmitten.updateState();
		assertEquals(3.0, testblue.getxVelocity(), 0.1);
		assertEquals(-6.0, testmitten.getxVelocity(), 0.1);
		assertEquals(-1.0, testblue.getyVelocity(), 0.1);
		assertEquals(2.0, testmitten.getyVelocity(), 0.1);
		
		//Collision checking is part of updateState, tested here
		//First reset position values for crab
		testblue.setxPosition(500);
		testblue.setyPosition(500);
		testmitten.setxPosition(500);
		testmitten.setyPosition(500);
		testgame.add(new Food(400, 400, 0, 0, testgame));
		assertEquals(1, getFoodCount(testgame));
		assertEquals(2, getCrabCount(testgame));
		
		//There should be no collision, so food and crab count remain the same
		testblue.updateState();
		testmitten.updateState();
		assertEquals(1, getFoodCount(testgame));
		assertEquals(2, getCrabCount(testgame));
	
		//Add food that should collide with crab
		testgame.add(new Food(500, 500, 0, 0, testgame));
		assertEquals(2, getFoodCount(testgame));
		assertEquals(2, getCrabCount(testgame));
		
		//Collision should happen, so there is one less food and one more crab
		testblue.updateState();
		testmitten.updateState();
		assertEquals(1, getFoodCount(testgame));
		assertEquals(3, getCrabCount(testgame));
		
		//Test again, this time crabs should not be cloned since the food particle is not in range
		testblue.updateState();
		testmitten.updateState();
		assertEquals(1, getFoodCount(testgame));
		assertEquals(3, getCrabCount(testgame));
		
		//Add food that should collide with crab, different position, same hitbox
		testgame.add(new Food(550, 550, 0, 0, testgame));
		assertEquals(2, getFoodCount(testgame));
		assertEquals(3, getCrabCount(testgame));
				
		//Collision should happen, so there is one less food and one more crab
		testblue.updateState();
		testmitten.updateState();
		assertEquals(1, getFoodCount(testgame));
		assertEquals(4, getCrabCount(testgame));
		
		//Test again, this time crabs should not be cloned since the food particle is not in range
		testblue.updateState();
		testmitten.updateState();
		assertEquals(1, getFoodCount(testgame));
		assertEquals(4, getCrabCount(testgame));
	}
	
	/**
	 * Helper function to get count of crabs in game collection
	 * @param test
	 * @return count number of crabs
	 */
	public int getCrabCount(GameState test) {
		int count = 0;
		for (GameObject find : test.getGameObjectCollection()) {
			if (find instanceof Crab) {
				count++;
			}
		}
		return count;
		
	}
	
	/**
	 * Helper function to get count of food in game collection
	 * @param test
	 * @return count number of food objects
	 */
	public int getFoodCount(GameState test) {
		int count = 0;
		for (GameObject find : test.getGameObjectCollection()) {
			if (find instanceof Food) {
				count++;
			}
		}
		return count;
		
	}
}
=======


import static org.junit.Assert.*;

import org.junit.Test;

public class CrabTest {
	
	/**
	 * Initiate two crabs with arbitrary position and speed
	 * Assert there is no change if there is no change in position
	 * Assert that velocity sign is switched if out of bounds
	 * 
	 * Create food objects and test collisions using position values
	 * Use helper functions getCrabCount and getFoodCount to 
	 * ensure proper removal of food and cloning of crabs
	 */
	@Test
	public void testUpdateState() {
		
		GameState testgame = new GameState();
		
		Crab testblue = new BlueCrab(500, 500, 3, 1, testgame);
		Crab testmitten = new MittenCrab(500, 500, 6, 2, testgame);
		testgame.add(testblue);;
		testgame.add(testmitten);
		assertEquals(2, getCrabCount(testgame));
		assertEquals(3.0, testblue.getxVelocity(), 0.1);
		assertEquals(6.0, testmitten.getxVelocity(), 0.1);
		assertEquals(1.0, testblue.getyVelocity(), 0.1);
		assertEquals(2.0, testmitten.getyVelocity(), 0.1);
		
		//Change nothing
		testblue.updateState();
		testmitten.updateState();
		assertEquals(3.0, testblue.getxVelocity(), 0.1);
		assertEquals(6.0, testmitten.getxVelocity(), 0.1);
		assertEquals(1.0, testblue.getyVelocity(), 0.1);
		assertEquals(2.0, testmitten.getyVelocity(), 0.1);
		
		//Change xPosition
		testblue.setxPosition(-10);
		testmitten.setxPosition(1500);
		testblue.updateState();
		testmitten.updateState();
		assertEquals(3.0, testblue.getxVelocity(), 0.1);
		assertEquals(-6.0, testmitten.getxVelocity(), 0.1);
		assertEquals(1.0, testblue.getyVelocity(), 0.1);
		assertEquals(2.0, testmitten.getyVelocity(), 0.1);
		
		//Change y Position
		testblue.setyPosition(800);
		testmitten.setyPosition(100);
		testblue.updateState();
		testmitten.updateState();
		assertEquals(3.0, testblue.getxVelocity(), 0.1);
		assertEquals(-6.0, testmitten.getxVelocity(), 0.1);
		assertEquals(-1.0, testblue.getyVelocity(), 0.1);
		assertEquals(2.0, testmitten.getyVelocity(), 0.1);
		
		//Collision checking is part of updateState, tested here
		//First reset position values for crab
		testblue.setxPosition(500);
		testblue.setyPosition(500);
		testmitten.setxPosition(500);
		testmitten.setyPosition(500);
		testgame.add(new Food(400, 400, 0, 0, testgame));
		assertEquals(1, getFoodCount(testgame));
		assertEquals(2, getCrabCount(testgame));
		
		//There should be no collision, so food and crab count remain the same
		testblue.updateState();
		testmitten.updateState();
		assertEquals(1, getFoodCount(testgame));
		assertEquals(2, getCrabCount(testgame));
	
		//Add food that should collide with crab
		testgame.add(new Food(500, 500, 0, 0, testgame));
		assertEquals(2, getFoodCount(testgame));
		assertEquals(2, getCrabCount(testgame));
		
		//Collision should happen, so there is one less food and one more crab
		testblue.updateState();
		testmitten.updateState();
		assertEquals(1, getFoodCount(testgame));
		assertEquals(3, getCrabCount(testgame));
		
		//Test again, this time crabs should not be cloned since the food particle is not in range
		testblue.updateState();
		testmitten.updateState();
		assertEquals(1, getFoodCount(testgame));
		assertEquals(3, getCrabCount(testgame));
		
		//Add food that should collide with crab, different position, same hitbox
		testgame.add(new Food(550, 550, 0, 0, testgame));
		assertEquals(2, getFoodCount(testgame));
		assertEquals(3, getCrabCount(testgame));
				
		//Collision should happen, so there is one less food and one more crab
		testblue.updateState();
		testmitten.updateState();
		assertEquals(1, getFoodCount(testgame));
		assertEquals(4, getCrabCount(testgame));
		
		//Test again, this time crabs should not be cloned since the food particle is not in range
		testblue.updateState();
		testmitten.updateState();
		assertEquals(1, getFoodCount(testgame));
		assertEquals(4, getCrabCount(testgame));
	}
	
	/**
	 * Helper function to get count of crabs in game collection
	 * @param test
	 * @return count number of crabs
	 */
	public int getCrabCount(GameState test) {
		int count = 0;
		for (GameObject find : test.getGameObjectCollection()) {
			if (find instanceof Crab) {
				count++;
			}
		}
		return count;
		
	}
	
	/**
	 * Helper function to get count of food in game collection
	 * @param test
	 * @return count number of food objects
	 */
	public int getFoodCount(GameState test) {
		int count = 0;
		for (GameObject find : test.getGameObjectCollection()) {
			if (find instanceof Food) {
				count++;
			}
		}
		return count;
		
	}
}
>>>>>>> 764e9fca27f15f1c0f35524071ca0843bfff2b56
