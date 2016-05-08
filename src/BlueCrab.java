import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BlueCrab extends Crab {

	BlueCrab(double xPosition, double yPositionition, double xVelocity, double yVelocity, GameState gameState){
		super(xPosition, yPositionition, xVelocity, yVelocity, gameState);
	
	}

	@Override
	public void crabClone() {
		getGameState().add( new BlueCrab(getxPosition(),getyPosition(),-getxVelocity(), -getyVelocity(),gameState));
	}
	
	

	

}
