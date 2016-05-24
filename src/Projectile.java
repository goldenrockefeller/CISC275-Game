import java.util.ArrayList;

public abstract class Projectile extends GameObject {

	//values of the projectile's end point
	int xEnd;
	int yEnd;
	int z =-1; //projectile's z value
	public final static int width = GameState.frameWidth / 25; //projectile's width
	public final static int height = GameState.frameHeight / 25; //projectile's height
	
	boolean isVisible = true; //determines if projectile is visible
	boolean stopped = false; //determines if the projectile is stopped
	/**
	 * Constructor
	 * @param xPosition
	 * @param yPosition
	 * @param xVelocity
	 * @param yVelocity
	 * @param gameState
	 */
	Projectile(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
		this.z = -1;
	}
	/**
	 * updates State by constantly decreasing 0. Velocity is reset to 0 once Z reaches 0.
	 */
	@Override
	public void updateState() {
		if (z > 0)
		{
			z--;
		}
		if (z == 0)
		{
			setVelocity(0,0);
/* i=0;
			for (GameObject gameObject : new ArrayList<GameObject>(this.getGameState().getGameObjectCollection()))
			{
				if (gameObject instanceof Trash)
				{	i++;
					
				}
		
			}*/
			/*
			//getGameState().settrashMissd(i);
			//System.out.println(getGameState().gettrashMissed());
			if (getGameState() != null){
				for (GameObject gameObject : new ArrayList<GameObject>(this.getGameState().getGameObjectCollection()))
				{
					if (gameObject instanceof trashcanObject)
					{
						checkCollision((trashcanObject)gameObject);
						//the function ends here. This object no longer exist
					}
			
				}
			}
			*/
		}
	}
	
	/**
	 * blank sendMessage method
	 */
	abstract public void sendMessage();

	
	/**getter for z
	 * @return the z
	 */
	public int getZ() {
		return z;
	}

	/**setter for z
	 * @param z the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * should check if a projectile has collided with a trash can. Trash that hits a can is added to trashCount and then removed visually from the game
	 * @param trashCan the potentially colliding can
	 */
	private void checkCollision(trashcanObject trashCan) {

		//Collision boxes overlapping
		if (trashCan.getxPosition()  < this.getxPosition() + width &&
				trashCan.getyPosition() < this.getyPosition() + height &&
				trashCan.getxPosition() + trashCan.width > this.getxPosition() &&
				trashCan.getyPosition() + trashCan.height > this.getyPosition() )
		{
			//Collision Detected
			getGameState().addToTrashCount(1);
			
			sendMessage();
//			getGameState().settrashMissd(getGameState().gettotalTrash()-getGameState().getTrashCount());
//			System.out.println("Missed "+getGameState().gettrashMissed()+" total trash "+getGameState().gettotalTrash()+" trash in can "+getGameState().getTrashCount());
			getGameState().remove(this);
			
		}
	}
	
}