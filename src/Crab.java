import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Crab extends GameObject {


	Crab(double xPosition, double yPositionition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPositionition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}

	public void updateState() {
		if (xPosition > GameState.frameWidth)
		{
			xVelocity = - Math.abs(xVelocity);
		}
		if (xPosition < 0)
		{
			xVelocity = Math.abs(xVelocity);
		}
		if (yPosition > GameState.crabLowerBound)
		{
			yVelocity = - Math.abs(yVelocity);
		}
		if (yPosition < GameState.crabUpperBound) 
		{
			yVelocity = Math.abs(yVelocity);
		}
	}

}
