import java.util.ArrayList;

public class Trash extends Projectile{
<<<<<<< HEAD
	private static final long serialVersionUID = 107L; //used for Serializable 
=======
	private static final long serialVersionUID = 107L;
>>>>>>> 764e9fca27f15f1c0f35524071ca0843bfff2b56
	int trashFlag = 0;//amount of trash on screen
	//size values for this object
	public static final int width = GameState.frameWidth/35;
	public static final int height = GameState.frameHeight/35;
	/**
	 * Constructor
	 * @param xPosition
	 * @param yPosition
	 * @param xVelocity
	 * @param yVelocity
	 * @param gameState
	 */
	Trash(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
	}
	/**
	 * setter for yEnd
	 */
	public void setEnd(int y) {
		this.yEnd = y;
	}

	
	/**
	 * Checks if trash collided with trash can.
	 * Also check if end-point is reached based on shooter power
	 * If any of these final destinations are reached, stop movement.
	 * If in trash, don't draw, otherwise show them scattered over the field
	 * @return true if within a certain hitbox, false otherwise.
	 */
	public void updateState() {
		super.updateState();
		/* Commented out to react to the current instances of Trash//Trash 1
		if (Math.abs(xPosition - 150) < 50 && Math.abs(yPosition - 200) < 50) {
			setVelocity(0,0);
			isVisible = false;
		}
		//Trash 2
		else if (Math.abs(xPosition - 500) < 50 && Math.abs(yPosition - 200) < 50) {
			setVelocity(0,0);
			isVisible = false;
		}
		//Trash 3
		else if (Math.abs(xPosition - 800) < 50 && Math.abs(yPosition - 200) < 50) {
			setVelocity(0,0);
			isVisible = false;
		}
		//No trash can/*
		if (yPosition <= yEnd) {
			setVelocity(0,0);
			stopped = true;
		}*/
		if (getGameState() != null){
			for (GameObject gameObject : new ArrayList<GameObject>(getGameState().getGameObjectCollection()))
			{
				if (gameObject instanceof trashcanObject)
				{
					checkCollision((trashcanObject)gameObject);
				}
		
			}
		}

	}
<<<<<<< HEAD
	/**
	 * adds the message "t" to gameState
	 */
=======
	
>>>>>>> 764e9fca27f15f1c0f35524071ca0843bfff2b56
	public void sendMessage()
	{
		getGameState().addMessage("t");
	}
	/**
	 * checks for collision between trash and a trash can
	 * @param trashCan
	 */
	private void checkCollision(trashcanObject trashCan) {

		//Collision boxes overlapping
		if (trashCan.getxPosition()  < this.getxPosition() + width &&
				trashCan.getyPosition() < this.getyPosition() + height &&
				trashCan.getxPosition() + trashCan.width > this.getxPosition() &&
				trashCan.getyPosition() + trashCan.height > this.getyPosition() )
		{
			//Collision Detected
			getGameState().trashCount += 1;
			getGameState().addMessage("t");
			getGameState().remove(this);
		}
	}
	

}
