import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public abstract class Crab extends GameObject {
	
	//final static int crabUpperBound = Launcher.HEIGHT / 4;
	final static int crabUpperBound = 250; //Changed by Golden because it is easier and more manageable to only have the view worry about screen placement.
	final static int crabLowerBound = 700; //It also technically violates MVC
	
	final static int height = GameState.frameHeight/15;
	final static int width = GameState.frameWidth/15;

	Crab(double xPosition, double yPositionition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPositionition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}
	/**
	 * checks the velocity and position of the crab and updates it accordingly based on each other and
	 * the other game objects, such as collisions with walls and projectiles
	 */
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
		
		//Add variation by slightly altering Direction over time.
		double oldspeed = getSpeed();
		addVelocity((Math.random() - .5)/10,(Math.random()-.5)/10);
		double correction = oldspeed / getSpeed();
		setVelocity(getxVelocity()*correction,getyVelocity()*correction);
		
		for (GameObject gameObject: new ArrayList<GameObject>(getGameState().getGameObjectCollection()))
		{
			
			if (gameObject instanceof Food)
			{
				Food food = (Food)gameObject;
				checkCollision(food);
				//TODO package this code as a function
				if (food.getxPosition() < GameState.frameWidth &&
						food.getyPosition() < crabLowerBound &&
						food.getxPosition() + Food.width > 0 &&
						food.getyPosition() + Food.height > crabUpperBound ) //food is in bound to be attractive
				{
					double offsetX = food.getxPosition()+Food.width - this.getxPosition() - Crab.width;
					double offsetY = food.getyPosition() + Food.height - this.getyPosition() - Crab.height;
					double distance = magnitude(offsetX, offsetY);
					if (  distance < 300 && distance > 5)
					{
						//Change Direction and maintain constant speed
						oldspeed = getSpeed();
						addVelocity(offsetX*10/distance/distance,offsetY *10/distance/distance);
						correction = oldspeed / getSpeed();
						setVelocity(getxVelocity()*correction,getyVelocity()*correction);
						
					}
				}
			}
		}
	}
	
	/**
	 * Checks if crab collided with projectile.
	 * @param food, the food pellet colliding with the crab
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
	/**
	 * a crab-copying abstract class that will be implemented in the subclasses
	 */
	abstract public void crabClone(); //different from clone

}
