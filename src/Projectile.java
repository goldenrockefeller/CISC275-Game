
public class Projectile extends GameObject {

	//values of the projectile's end point
	int xEnd;
	int yEnd;
	int z; //projectile's z value
	

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
		}
	}
	/**
	 * setter for end
	 * @param j
	 */
	public void setEnd(int j) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * checks for Collision? Currently disabled
	 * @return
	 */
	public Projectile checkCollision() {
		// TODO Auto-generated method stub
		return null;
	}
	
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

}
