
public class Trash extends Projectile{

	int yEnd;
	
	Trash(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
	}
	
	public void setEnd(int y) {
		this.yEnd = y;
	}

	
	/**
	 * Checks if trash collided with trash can.
	 * Also check if end-point is reached based on shooter power
	 * If any of these final destinations are reached, stop movement.
	 * If in trash, don't draw, otherwise show them scattered over the field
	 * @return true if within a certain hitbox, false otherwise.
	 */
	public void updateState() {
		//No trash can
		if (yPosition <= yEnd) {
			setVelocity(0,0);
			stopped = true;
		}
	}
	

}
