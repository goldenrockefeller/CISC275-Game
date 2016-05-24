
public class Food extends Projectile{
	private static final long serialVersionUID = 102L;
	
	//size values for this object
	final static int width = GameState.frameWidth/35;
	final static int height = GameState.frameHeight/35;

/**
 * constructor for food
 * @param xPosition
 * @param yPosition
 * @param xVelocity
 * @param yVelocity
 * @param gameState
 */
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
<<<<<<< HEAD
	/**
	 * stub method. Can be called but does nothing.
	 */
=======
	
>>>>>>> 764e9fca27f15f1c0f35524071ca0843bfff2b56
	public void sendMessage(){
		//Do nothing
	}
	
	/** Z's getter
	 * @return the z
	 */
	public int getZ() {
		return z;
	}

	/**Z's setter
	 * @param z the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**Width's getter
	 * @return the width
	 */
	public static int getWidth() {
		return width;
	}

	/**Height's getter
	 * @return the height
	 */
	public static int getHeight() {
		return height;
	}

}
