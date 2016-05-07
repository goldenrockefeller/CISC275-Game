
public class Projectile extends GameObject {

	
	int xEnd;
	int yEnd;
	boolean isVisible = true;
	boolean stopped = false;
	int foodFlag = 0;
	int trashFlag = 0;
	
	Projectile(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateState() {
		
	}

	public void setEnd(int j) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkCollision() {
		// TODO Auto-generated method stub
		return false;
	}

}
