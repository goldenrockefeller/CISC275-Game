import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BlueCrab extends Crab {
	private static final long serialVersionUID = 101L;
/**
 * Constructor for Blue Crab
 */
	BlueCrab(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState){
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
	
	}
	/**
	 * adds a new blue crab to the game
	 */
	@Override
	public void crabClone() {
		getGameState().add( new BlueCrab(getxPosition(),getyPosition(),-getxVelocity(), -getyVelocity(),gameState));
		getGameState().addMessage("b");
	}
	
	

	

}
