
public class trashcanObject extends GameObject {

	//size values for this object
	public final static int width = GameState.frameWidth / 25;
	public final static int height = GameState.frameHeight / 25;
	


	/**
	 * Constructor
	 * @param xPosition
	 * @param yPosition
	 * @param xVelocity
	 * @param yVelocity
	 * @param gameState
	 */
	public trashcanObject(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}

	/**
	 * blank update State implementation
	 */
	@Override
	public void updateState()
	{
		
	}
	
	
	



}
