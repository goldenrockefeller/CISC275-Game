public class ScoreBar extends GameObject{
	private static final long serialVersionUID = 105L; //used for Serializable 
	
	/**
	 * Constructor for the score or "life" bar in the game
	 * @param xPosition
	 * @param yPositionition
	 * @param xVelocity
	 * @param yVelocity
	 * @param gameState
	 */
	ScoreBar(double xPosition, double yPositionition, double xVelocity, double yVelocity, GameState gameState){
		super(xPosition, yPositionition, xVelocity, yVelocity, gameState);
	
	}

	/**
	 * stub updateState method
	 */
	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		
	}
}
