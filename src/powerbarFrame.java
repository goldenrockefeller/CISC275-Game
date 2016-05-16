
public class powerbarFrame extends GameObject {
	/**
	 * Constructor
	 * @param xPosition
	 * @param yPosition
	 * @param xVelocity
	 * @param yVelocity
	 * @param gameState
	 */
	public powerbarFrame(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}

	/**
	 * updates State using the setObjectState method and a for loop
	 */
	@Override
	public void updateState()
	{
		setObjectState(0);
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
			
		}
	}
	
	

}
