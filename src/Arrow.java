	public class Arrow extends GameObject {
		private static final long serialVersionUID = 100L;
		/**
		 * The arrow is the object that determines the direction in which our projectile
		 * will be flung.  On the screen, the player will see the arrow rotate back and
		 * forth
		 * 
		 * @param xPosition
		 * @param yPosition
		 * @param xVelocity
		 * @param yVelocity
		 * @param gameState
		 */
		
		private int directfluc = 20; //sets value for the arrow's movement, acts as "position"
		private int direction = -1; //determines direction
		private boolean arrow_flag = true; // Used to determine if arrow is rotating left or right
		private boolean stop_flag; //determines if the arrow is stopped
		
		public Arrow(double xPosition, double yPosition, double xVelocity,
				double yVelocity, GameState gameState) {
			super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		}
		
		/**
		 * sets direction of the arrow's movement based on its position
		 * 
		 * @return void
		 */
		public void setDirectFluc(){
			if (!stop_flag) {
				if(arrow_flag){
					directfluc++;
					if(directfluc >= 160){
						arrow_flag = false;
					}
				}
				else{
					directfluc--;
					if(directfluc <= 20){
						arrow_flag = true;
					}
				}
			}
		}
		/**
		 * updates the state by calling setDirectFluc
		 */
		public void updateState(){
			setDirectFluc();
		}
		
		/**
		 * getter for direction
		 */
		public int getDirection(){
			return direction;
		}
		/**
		 * setter for direction
		 */
		public void setDirection(){
			direction = directfluc;
		}
		/**
		 * getter for direction fluctuation
		 */
		public int getDirectFluc(){
			return directfluc;
		}
		/**
		 * setter for direction fluctuation
		 */
		public void setDirectFluc(int x){
			directfluc = x;
		}
		/**
		 * changes the stop flag from off to on or vice versa
		 */
		public void setStop() {
			stop_flag = !stop_flag;
		}
		
		@Override
		public String toString(){
			String going;
			String stopped;
			if(direction == -1){
				going = "left";
			}
			else going = "right";
			
			if(stop_flag){
				stopped = "stopped";
			}
			else{
				stopped = "moving";
			}
			
			return "The arrow is " + stopped + " going " + going + " at " + directfluc;
		}
	}