
public class Projectile extends GameObject {

	
	int xEnd;
	int yEnd;
	int z;
	

	boolean isVisible = true;
	boolean stopped = false;
	
	Projectile(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}

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

	public void setEnd(int j) {
		// TODO Auto-generated method stub
		
	}

	public Projectile checkCollision() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return the z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * @param z the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}

}
