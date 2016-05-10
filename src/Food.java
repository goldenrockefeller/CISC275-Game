
public class Food extends Projectile{
	
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

	/**
	 * @return the width
	 */
	public static int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public static int getHeight() {
		return height;
	}

	final static int width = GameState.frameWidth/50;
	final static int height = GameState.frameHeight/50;


	Food(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}
	/**
	 * resets velocity values to 0,0 if it leaves the game's frame dimensions
	 */
	public void updateState() {
		super.updateState();
		if (xPosition <= 0 || xPosition >= gameState.frameWidth) {
			setVelocity(0,0);
		}
		if (yPosition <= 0 || yPosition >= gameState.frameHeight) {
			setVelocity(0,0);
		}
	}

}
