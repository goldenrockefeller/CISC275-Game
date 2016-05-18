import static org.junit.Assert.*;

import org.junit.Test;


public class ShooterTest {

	@Test
	public void test() {
		GameState mygame = new GameState();
		Shooter myshooter = new Shooter(mygame);
		
		
		assertEquals(myshooter.getFlag(), true);
		myshooter.changeFlag();
		assertEquals(myshooter.getFlag(), false);
		myshooter.changeFlag();
		assertEquals(myshooter.getFlag(), true);
			
	}

}
