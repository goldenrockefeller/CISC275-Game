
public class Food extends Projectile{

	Food(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}

	
	public void updateState() {
		if (xPosition > GameState.frameWidth)
		{
			stopped = true;
		}
		if (xPosition < 0)
		{
			stopped = true;
		}
		if (yPosition > GameState.frameHeight)
		{
			stopped = true;
		}
		if (yPosition < 0) 
		{
			stopped = true;
		}
	}
	
}
