
public class Shooter {	
	private static final long serialVersionUID = 106L;//used for Serializable
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
		game_arrow = new Arrow(GameScreen.WIDTH / 2.0 - ShooterHandler.arrowWidth / 2.0, ((.75)*GameScreen.HEIGHT ), 0, 0, game);
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
	 * getter for the shooter's flag. If the flag is true, the shooter
	 * is using the arrow.  If the flag is false, the shooter is using
	 * the powerbar.
	 * 
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
	 * sets default value to the power bar.  This activates once a projectile is
	 * fired.
	 */
	public void setDefault(){
		game_powerbar.defaultPower();
		return;
	}
	/**
	 * calls the arrow and power bar's updateState methods. This is
	 * called every tick
	 */
	public void update() {
		game_arrow.updateState();
		game_powerbar.updateState();
	}	
	
	
}