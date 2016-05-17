import static org.junit.Assert.*;

import org.junit.Test;

public class TrashTest {

	/**
	 * Make sure position comparison for the collision check of trash with trash can works
	 * Should work for range of values in hitbox
	 */
	@Test
	public void testCollision() {
		GameState testgame = new GameState();
		Trash testtrash = new Trash(200, 200, 10, 10, testgame);
		Trash testtrash1 = new Trash(150, 150, 10, 10, testgame);
		Trash testtrash2 = new Trash(50, 100, 10, 10, testgame);
		trashcanObject testcan = new trashcanObject(500,120,0,0,testgame);
		testgame.add(testtrash);
		testgame.add(testtrash1);
		testgame.add(testtrash2);
		testgame.add(testcan);
		
		//At start, only 3 trash objects
		assertEquals(3, getTrashCount(testgame));
		
		//Currently, they are not colliding, so this should change nothing
		testtrash.updateState();
		testtrash1.updateState();
		testtrash2.updateState();
		assertEquals(3, getTrashCount(testgame));
		
		//Move first trash object into range
		testtrash.setxPosition(500);
		testtrash.setyPosition(120);
		
		//Collision should cause one trash to be removed, leaving only 2
		testtrash.updateState();
		testtrash1.updateState();
		testtrash2.updateState();
		assertEquals(2, getTrashCount(testgame));
		
		//Move second trash object into range
		testtrash1.setxPosition(510);
		testtrash1.setyPosition(125);
				
		//Collision should cause one trash to be removed, leaving only 1
		testtrash1.updateState();
		testtrash2.updateState();
		assertEquals(1, getTrashCount(testgame));
		
		//Move final trash object into range
		testtrash2.setxPosition(510);
		testtrash2.setyPosition(125);
						
		//Collision should cause one trash to be removed, leaving none
		testtrash2.updateState();
		assertEquals(0, getTrashCount(testgame));
	}
	
	/**
	 * Helper function to get count of trash in game collection
	 * Trash objects are removed if the collide with trash.
	 * This helps to test collision method
	 * @param test
	 * @return count number of food objects
	 */
	public int getTrashCount(GameState test) {
		int count = 0;
		for (GameObject find : test.getGameObjectCollection()) {
			if (find instanceof Trash) {
				count++;
			}
		}
		return count;
		
	}

}
