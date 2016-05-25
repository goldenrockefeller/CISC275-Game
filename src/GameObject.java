
public abstract class GameObject implements java.io.Serializable {
	//the x and y values for the game object's location
	double xPosition;
	double yPosition;
	//the x and y values for the game object's velocity
	double xVelocity;
	double yVelocity;
	//an instance of game state to associate with the object in question
	GameState gameState;
	//a number to associate with the object's state
	protected int objectState = 0;
	//to be used with methods concerning time
	protected double objectStateTime = 0;
	
	/**
	 * Constructor for game objects. These are the model representations for
	 * the objects that will appear on screen.
	 * 
	 * @param xPosition
	 * @param yPosition
	 * @param xVelocity
	 * @param yVelocity
	 * @param gameState
	 */
	GameObject(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState)
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.gameState = gameState;
	}
	/**
	 * an updating method to be implemented by the subclasses
	 */
	abstract public void updateState();
	/**
	 * What the object does when it is removed from the game
	 */
	public void finish()
	{
		//Do nothing
	}
	/**
	 * takes the existing speed and adjusts the velocity's direction based on parameters
	 * @param cosineAngle the angle associated with the x velocity
	 * @param sineAngle the angle associated with the y velocity
	 */
	public void rotateDirection(double cosineAngle, double sineAngle)
	{
		double speed = getSpeed(); //end velocity must have the same end speed
		double bufferXVelocity = xVelocity;
		xVelocity = xVelocity * cosineAngle - yVelocity * sineAngle;
		yVelocity = bufferXVelocity * sineAngle + yVelocity * cosineAngle;
		
		//Correction for any math inaccuracies
		double correction = speed / magnitude(xVelocity,yVelocity);
		xVelocity = xVelocity * correction;
		yVelocity = yVelocity * correction;
		
	}
	/**
	 * 
	 * @param x the x value
	 * @param y the y value
	 * @return the two values squared and then added together
	 */
	public double magnitude(double x, double y)
	{
		return Math.sqrt(x*x + y*y);
	}
	/**
	 * gets speed by calling magnitude for the object's velocities
	 * @return the object's speed
	 */
	public double getSpeed()
	{
		return magnitude(xVelocity,yVelocity);
	}
	/**
	 * increases the object's position based on parameters
	 * @param x to be added to xPosition
	 * @param y to be added to yPosition
	 */
	public void translatePosition(double x, double y)
	{
		xPosition += x;
		yPosition += y;
	}
	
	/**
	 * increases x and y position based on their respective velocities
	 */
	// Do not override, this will handle position update
	// for every subclass of GameObject
	public void updatePosition()
	{
		xPosition += xVelocity;
		yPosition += yVelocity;
	}
	
	/**
	 * getters and setters for this class
	 */
	public double getxPosition() {
		return xPosition;
	}
	

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	public int getObjectState() {
		return objectState;
	}

	public void setObjectState(int objState) {
		this.objectState = objState;
	}

	public double getObjectStateTime() {
		return objectStateTime;
	}

	public void setObjectStateTime(double objectStateTime) {
		this.objectStateTime = objectStateTime;
	}
	


	public GameState getGameState() {
		return gameState;
	}
	

	public void setVelocity(double x, double y)
	{
		xVelocity = x;
		yVelocity = y;
	}
	/**
	 * adds to velocity based on parameters
	 * @param x to be added to xVelocity
	 * @param y to be added to yVelocity
	 */
	public void addVelocity(double x, double y)
	{
		xVelocity += x;
		yVelocity += y;
	}

	public double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}
	

	/**
	 * @param gameState the gameState to set
	 */
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	/**
	 * tostring method for game objects
	 */
	@Override
	public String toString() {
		return "\n" + super.toString() + " GameObject [xPosition=" + xPosition + ", yPosition=" + yPosition + ", xVelocity=" + xVelocity
				+ ", yVelocity=" + yVelocity + ", objectState=" + objectState + ", objectStateTime="
				+ objectStateTime + "]";
	}
   
	
}
