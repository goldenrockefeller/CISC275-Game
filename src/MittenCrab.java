

public class MittenCrab extends Crab {

	MittenCrab(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState){
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void crabClone() {
		getGameState().add( new MittenCrab(getxPosition(),getyPosition(),-getxVelocity(), -getyVelocity(),gameState));
	}
	

}
