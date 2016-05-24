public class PowerBar extends GameObject {
<<<<<<< HEAD
	private static final long serialVersionUID = 104L; //used for Serializable 
=======
	private static final long serialVersionUID = 104L;
>>>>>>> 764e9fca27f15f1c0f35524071ca0843bfff2b56
	private int powerfluc; //the power that fluctuates on every tick
	private int power; // the power that the player chooses using the space bar.
	private boolean power_flag; // Used to determine if powerfluc bar is going up or down, true is up, false is down
	/**
	 * This class is used to determine the power in which our projectiles will be flung.
	 * This will be visually displayed as the power meter inside the arrow.
	 * 
	 * Constructor. By default, fluc is 0, the power starts at negative, and the power is going up and not stopped
	 * @param xPosition
	 * @param yPosition
	 * @param xVelocity
	 * @param yVelocity
	 * @param gameState
	 */
	public PowerBar(double xPosition, double yPosition, double xVelocity,
			double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);

		power = -1;
		powerfluc = 0;
		power_flag = true;
	}

	/**
	 * changes the flags based on the current value of powerfluc
	 * 
	 * @return void
	 */
	public void setPowerFluc(){
		if(power_flag){
			powerfluc+= 2;
			if(powerfluc >= 114){
				power_flag = false;
			}
		}
		else{
			powerfluc-= 2;
			if(powerfluc <= 0){
				power_flag = true;
			}
		}
	}
	/**
	 * updates state by calling setPowerFluc
	 * 
	 * @return void
	 */
	public void updateState(){
		setPowerFluc();
	}
	/**
	 * getter for PowerFluc
	 * @return powerfluc
	 */
	public int getPowerFluc(){
		return powerfluc;
	}
	/**
	 * setter for PowerFluc
	 * @param x the new value of powerfluc
	 */
	public void setPowerFluc(int x){
		powerfluc = x;
	}

	// this is called when the player releases the space bar
	/**
	 * setter for power, set equal to powerfluc
	 * @return void
	 */
	public void setPower(){
		power = powerfluc;
	}
	/**
	 * getter for power
	 * @return power
	 */
	public int getPower(){
		return power;
	}
	/**
	 * setter for stopflag, which is reversed from true to false and vice versa when method is called
	 * @return void
	 */
	/**
	 * sets power, powerfluc, and power_flag to their default values
	 * @return void
	 */
	public void defaultPower(){
		power = -1;
		this.setPowerFluc(0);
		power_flag = true;
	}
<<<<<<< HEAD
	/**
	 * getter for power_flag
	 * @return power_flag
	 */
	public boolean getFlag(){
		return power_flag;
	}
	
=======
	public boolean getFlag(){
		return power_flag;
	}
	/**
	 * 
	 */
>>>>>>> 764e9fca27f15f1c0f35524071ca0843bfff2b56
}