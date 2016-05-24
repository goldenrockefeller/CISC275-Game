import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScoreBar extends GameObject{
<<<<<<< HEAD
	private static final long serialVersionUID = 105L; //used for Serializable 
	
	/**
	 * Constructor for the score or "life" bar in the game
	 * @param xPosition
	 * @param yPositionition
	 * @param xVelocity
	 * @param yVelocity
	 * @param gameState
	 */
=======
	private static final long serialVersionUID = 105L;

>>>>>>> 764e9fca27f15f1c0f35524071ca0843bfff2b56
	ScoreBar(double xPosition, double yPositionition, double xVelocity, double yVelocity, GameState gameState){
		super(xPosition, yPositionition, xVelocity, yVelocity, gameState);
	
	}
<<<<<<< HEAD
	/**
	 * stub updateState method
	 */
=======
	
>>>>>>> 764e9fca27f15f1c0f35524071ca0843bfff2b56
	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

	
	
	

	

}
