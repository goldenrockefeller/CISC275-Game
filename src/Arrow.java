	public class Arrow extends GameObject {
		private int directfluc = 20;
		private int direction = -1;
		private boolean arrow_flag = true; // Used to determine if arrow is rotating left or right
		private boolean stop_flag;
		
		public Arrow(double xPosition, double yPosition, double xVelocity,
				double yVelocity, GameState gameState) {
			super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		}
		
		/**
		 * sets direction of the arrow's movement based on its position
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
		/**
		 * restores default values to Arrow
		 */
		public void defaultDirection(){
			//direction = -1;
			//this.setDirectFluc(0);
			//arrow_flag = true;
		}
	}