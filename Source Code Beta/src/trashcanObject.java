public class trashcanObject extends GameObject {

	
	
	



	public trashcanObject(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void updateState()
	{
		
	}
	
	/**
	 * Checks if trash collided with trash can.
	 * @return 
	 * @return true if within a certain hitbox, false otherwise.
	 */
	public boolean checkCollision() {
			if (getGameState().projectile instanceof Trash && Math.abs(this.xPosition - getGameState().projectile.xPosition) < GameState.frameWidth/20 && Math.abs(this.yPosition - getGameState().projectile.yPosition) < GameState.frameHeight/20) {
				System.out.println("Trash Collision!");
				getGameState().projectile.isVisible = false;
				return true;
			}
		return false;
	}
	



}