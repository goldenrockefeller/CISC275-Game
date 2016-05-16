public class PowerBar extends GameObject {
		private int powerfluc; //the power that fluctuates on every tick
		private int power; // the power that the player chooses using the space bar.
		private boolean power_flag; // Used to determine if powerfluc bar is going up or down
		private boolean stop_flag; //used to stop the bar
		/**
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
			stop_flag = false;
		}

	/**
	 * changes the flags based on the current value of powerfluc
	 */
		public void setPowerFluc(){
			if (!stop_flag) {
				if(power_flag){
					powerfluc++;
					if(powerfluc >= 100){
						power_flag = false;
					}
				}
				else{
					powerfluc--;
					if(powerfluc <= 0){
						power_flag = true;
					}
				}
			}
		}
		/**
		 * updates state by calling setPowerFluc
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
		 */
		public void setStop() {
			stop_flag = !stop_flag;
		}
		/**
		 * sets power, powerfluc, and power_flag to their default values
		 */
		public void defaultPower(){
			power = -1;
			this.setPowerFluc(0);
			power_flag = true;
		}
	}