import static org.junit.Assert.*;

import org.junit.Test;


public class PowerBarTest {

	@Test
	public void test() {
		GameState myGame = new GameState();
		PowerBar myPower = new PowerBar(myGame.frameWidth / 4, myGame.frameHeight - 100, 0, 0, myGame);
		
		assertEquals(myPower.getPowerFluc(), 0);
		assertEquals(myPower.getFlag(), true);
		
		myPower.updateState();
		
		assertEquals(myPower.getPowerFluc(), 1);
		
		myPower.setPowerFluc(114);
		myPower.updateState();
		
		assertEquals(myPower.getPowerFluc(), 115);
		myPower.updateState();
		assertEquals(myPower.getPowerFluc(), 114);
		assertEquals(myPower.getFlag(), false);
		
		myPower.setPowerFluc(1);
		assertEquals(myPower.getFlag(), false);
		myPower.updateState();
		assertEquals(myPower.getFlag(), true);
		
		assertEquals(myPower.getPowerFluc(), 0);
		assertEquals(myPower.getFlag(), true);
		myPower.updateState();
		assertEquals(myPower.getPowerFluc(), 1);
		assertEquals(myPower.getFlag(), true);
		myPower.setPower();
		assertEquals(myPower.getPower(), 1);
		
		myPower.defaultPower();
		assertEquals(myPower.getPower(), -1);
		assertEquals(myPower.getPowerFluc(), 0);
		assertEquals(myPower.getFlag(), true);
	}
}