import static org.junit.Assert.*;
import org.junit.Test;


public class ArrowTest {

	@Test
	public void test() {
		GameState myGame = new GameState();
		Arrow myArrow = new Arrow(0, 0, 0, 0, myGame);
		
		assertEquals(myArrow.getDirectFluc(), 20);
		
		myArrow.updateState();
		
		assertEquals(myArrow.getDirectFluc(), 21);
		myArrow.setDirection();
		assertEquals(myArrow.getDirection(), 21);
		
		myArrow.setDirectFluc(160);
		myArrow.updateState();
		
		assertEquals(myArrow.getDirectFluc(), 161);
		myArrow.updateState();
		assertEquals(myArrow.getDirectFluc(), 160);
		myArrow.setDirection();
		assertEquals(myArrow.getDirection(), 160);
		
		myArrow.setDirectFluc(1);
		myArrow.updateState();
		
		assertEquals(myArrow.getDirectFluc(), 0);
		myArrow.updateState();
		assertEquals(myArrow.getDirectFluc(), 1);
		myArrow.setDirection();
		assertEquals(myArrow.getDirection(), 1);
	}

}