import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Crab extends GameObject {
	
	final static int crabUpperBound = 2*GameState.frameHeight/6;
	final static int crabLowerBound = GameState.frameHeight-GameState.frameHeight/3;

	Crab(double xPosition, double yPositionition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPositionition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}

	public void updateState() {
		if (xPosition > GameState.frameWidth-100)
		{
			xVelocity = - Math.abs(xVelocity);
		}
		if (xPosition < 0)
		{
			xVelocity = Math.abs(xVelocity);
		}
		if (yPosition > crabLowerBound)
		{
			yVelocity = - Math.abs(yVelocity);
		}
		if (yPosition < crabUpperBound) 
		{
			yVelocity = Math.abs(yVelocity);
		}
	}
	
	/**
	 * Checks if crab collided with projectile.
	 * @return 
	 * @return true if within a certain hitbox, false otherwise.
	 */
	public boolean checkCollision() {
			if (getGameState().projectile instanceof Food && Math.abs(this.xPosition - getGameState().projectile.xPosition) < GameState.frameWidth/20 && Math.abs(this.yPosition - getGameState().projectile.yPosition) < GameState.frameHeight/20) {
				System.out.println("Collision!");
				getGameState().projectile.isVisible = false;
				return true;
			}
		return false;
	}

}
