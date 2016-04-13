import java.lang.*;

public class GameObject {
	double xPosition;
	double yPosition;
	double xVelocity;
	double yVelocity;
	GameState gameState;
	int objState = 0;
	int objStateTime = 0;
	
	GameObject(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState)
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.gameState = gameState;
	}
	
	public void selfDestruct()
	{
		gameState.remove(this);
	}
	
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
	
	
	public double magnitude(double x, double y)
	{
		return Math.sqrt(x*x + y*y);
	}
	
	public double getSpeed()
	{
		return magnitude(xVelocity,yVelocity);
	}
	
	public void translatePosition(double x, double y)
	{
		xPosition += x;
		yPosition += y;
	}
	
	
	// Do not override, this will handle position update
	// for every subclass of GameObject
	public void updatePosition()
	{
		xPosition += xVelocity;
		yPosition += yVelocity;
	}
	
	public void updateState()
	{
	}
	
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

	public int getObjState() {
		return objState;
	}

	public void setObjState(int objState) {
		this.objState = objState;
	}

	public int getObjStateTime() {
		return objStateTime;
	}

	public void setObjStateTime(int objStateTime) {
		this.objStateTime = objStateTime;
	}

	public GameState getGameState() {
		return gameState;
	}
	
	public boolean checkObjectType(ObjectType type)
	{
		return false;
	}
	
	public ObjectType getObjectType()
	{
		return ObjectType.GAMEOBJECT;
	}
	
	public int getInstanceID()
	{
		return 0;
	}


	
	public void setVelocity(double x, double y)
	{
		xVelocity = x;
		yVelocity = y;
	}
	
	
	public void addVeloction(double x, double y)
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

	@Override
	public String toString() {
		return "GameObject [xPosition=" + xPosition + ", yPosition=" + yPosition + ", xVelocity=" + xVelocity
				+ ", yVelocity=" + yVelocity + ", gameState=" + gameState + ", objState=" + objState + ", objStateTime="
				+ objStateTime + ", getObjectType()=" + getObjectType() + ", getInstanceID()=" + getInstanceID() + "]";
	}

}
