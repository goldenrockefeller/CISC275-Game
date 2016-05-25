
public class StartDisplay extends GameObject {
	private static final long serialVersionUID = 57L; // Serial ID

	/**
	 * The game object for the start screen
	 * 
	 * Constructor
	 * @param xPosition
	 * @param yPosition
	 * @param xVelocity
	 * @param yVelocity
	 * @param gameState
	 */
	StartDisplay(double xPosition, double yPosition, double xVelocity,
			double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
	}
	/**
	 * Update State method. Blank.
	 */
	@Override
	public void updateState() {
		
	}

}
