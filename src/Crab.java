import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public abstract class Crab extends GameObject {
	
	//final static int crabUpperBound = Launcher.HEIGHT / 4;
	final static int crabUpperBound = 250; //Changed by Golden because it is easier and more manageable to only have the view worry about screen placement.
	final static int crabLowerBound = 700; //It also technically violates MVC
	
	final static int height = 100;
	final static int width = 100;

	Crab(double xPosition, double yPositionition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPositionition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}

	public void updateState() {
		if (xPosition + width > GameState.frameWidth)
		{
			xVelocity = - Math.abs(xVelocity);
		}
		if (xPosition < 0)
		{
			xVelocity = Math.abs(xVelocity);
		}
		if (yPosition + height > crabLowerBound)
		{
			yVelocity = - Math.abs(yVelocity);
		}
		if (yPosition < crabUpperBound) 
		{
			yVelocity = Math.abs(yVelocity);
		}
		
		for (GameObject gameObject: new ArrayList<GameObject>(getGameState().getGameObjectCollection()))
		{
			if (gameObject instanceof Food)
			{
				checkCollision((Food)gameObject);
			}
		}
	}
	
	/**
	 * Checks if crab collided with projectile.
	 * @return 
	 * @return true if within a certain hitbox, false otherwise.
	 */
	private void checkCollision(Food food) {
		if (food.getZ() == 0)
		{
			//Collision boxes overlapping
			if (food.getxPosition()  < this.getxPosition() + width &&
					food.getyPosition() < this.getyPosition() + height &&
					food.getxPosition() + Food.width > this.getxPosition() &&
					food.getyPosition() + Food.height > this.getyPosition() )
			{
				//Collision Detection
				getGameState().remove(food);
				this.crabClone();
			}
		}
	}
	
	abstract public void crabClone(); //different from clone

}
