
public class Food extends Projectile{


	final static int width = GameState.frameWidth/25;
	final static int height = GameState.frameHeight/25;


	Food(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}
	
	public void updateState() {
		super.updateState();
		if (xPosition <= 0 || xPosition >= gameState.frameWidth) {
			setVelocity(0,0);
		}
		if (yPosition <= 0 || yPosition >= gameState.frameHeight) {
			setVelocity(0,0);
		}
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
}
