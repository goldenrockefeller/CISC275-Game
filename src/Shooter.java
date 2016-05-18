
public class Shooter {	
	private boolean arrow_or_pb_flag; // tells us if we need to set the arrow or power bar
	//arrow and powerbar to be associated with this shooters
	private Arrow game_arrow;
	private PowerBar game_powerbar;
	
	/**
	 * Constructor including default values being drawn
	 * @param game
	 */
	public Shooter(GameState game){
		arrow_or_pb_flag = true;
		//game_arrow = new Arrow(GameState.frameWidth / 2 - 50, GameState.frameHeight - 330, 0, 0, game);
		game_arrow = new Arrow(GameScreen.WIDTH / 2 - ShooterHandler.arrowWidth / 2, GameScreen.HEIGHT - GameScreen.HEIGHT / 4, 0, 0, game);
		game_powerbar = new PowerBar(GameScreen.WIDTH/5, GameScreen.HEIGHT - 220, 0, 0, game);
	}
	/**
	 * getter for Arrow
	 * @return game_arrow
	 */
	public Arrow getArrow(){
		return game_arrow;
	}
	/**
	 * getter for the power bar
	 * @return game_powerbar
	 */
	public PowerBar getPowerBar(){
		return game_powerbar;
	}
	/**
	 * getter for the shooter's flag
	 * @return arrow_or_pb_flag
	 */
	public boolean getFlag(){
		return arrow_or_pb_flag;
	}
	/**
	 * flips the flag's current value
	 */
	public void changeFlag(){
		if(arrow_or_pb_flag){
			arrow_or_pb_flag = false;
		}
		else{
			arrow_or_pb_flag = true;
		}
		return;
	}
	/**
	 * sets default value to the arrow and power bar
	 */
	public void setDefault(){
		game_arrow.defaultDirection();
		game_powerbar.defaultPower();
		return;
	}
	/**
	 * calls the arrow and power bar's updateState methods
	 */
	public void update() {
		game_arrow.updateState();
		game_powerbar.updateState();
	}	
	
	
}