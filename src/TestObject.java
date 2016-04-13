
public class TestObject extends GameObject {

	public TestObject(double xPosition, double yPosition, double xVelocity, double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void updateState()
	{
		//Do Nothing
	}
	

	@Override
	public ObjectType getObjectType()
	{
		return ObjectType.TEST;
	}
	
	@Override
	public boolean checkObjectType(ObjectType type)
	{
		return getObjectType() == type || super.checkObjectType(type);
	}
	
	@Override
	public String toString() {
		return "TestObject [xPosition=" + xPosition + ", yPosition=" + yPosition + ", xVelocity=" + xVelocity
				+ ", yVelocity=" + yVelocity + ", objState=" + objState + ", objStateTime=" + objStateTime
				+ ", getObjectType()=" + getObjectType() + ", getInstanceID()=" + getInstanceID() + "]";
	}
	
	
	
	

}
