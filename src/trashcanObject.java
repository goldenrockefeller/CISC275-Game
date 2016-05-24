
public class trashcanObject extends GameObject {

	private static final long serialVersionUID = 56L; // Serial ID
	
	//size values for this object
	public final static int width = GameState.frameWidth / 10;
	public final static int height = GameState.frameHeight / 10;
	


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
