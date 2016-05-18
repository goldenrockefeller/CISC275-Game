import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static java.lang.System.out;

public class powerbarHandler extends Handler implements ActionListener, KeyListener {

	
	JButton testButton; 
	boolean red = true; //boolean to see color
	int  length=32; //the length of the bar
	boolean direction = true; //direction the bar is moving
	powerbarObject powerBar; //the bar itself
	powerbarFrame powerBarFrame; //the frame around the bar
	Shooter gameShooter; //the shooters associated with this power bar
	/**
	 * Constructor
	 * @param gameScreen
	 * @param gameState
	 * @param gameShooter
	 */
	public powerbarHandler(GameScreen gameScreen, GameState gameState, Shooter gameShooter) {
		
		super(gameScreen,gameState);
		
		//adds a button to game
//		testButton = new JButton("Click me");
//		overallGame.add(testButton,BorderLayout.SOUTH);
//		overallGame.validate();
//		overallGame.repaint();
//		
//		testButton.addActionListener(this);
		gameScreen.addKeyListener(this);
		this.gameShooter = gameShooter;
		this.powerBarFrame = new powerbarFrame(GameScreen.WIDTH/5 -2, GameScreen.HEIGHT - 220 - 2, 0, 0, gameState);
		// TODO Auto-generated constructor stub
	}
	/**
	 * paints graphics on screen
	 * @param g, graphics used
	 */
	@Override
	public void  paint(Graphics g)
	{


		g.setColor(Color.BLACK);
		
		g.fillRect((int)powerBarFrame.getxPosition(),(int)powerBarFrame.getyPosition(),105*GameScreen.WIDTH/1000,36*GameScreen.HEIGHT/1000);
		
		if (length>=80){
		g.setColor(Color.RED);
		}
		else if (length >=45){
			g.setColor(Color.YELLOW);
		}else {
			g.setColor(Color.GREEN);
		}
		//if (!stopflag)
			powerbar();
			

		g.fillRect((int)gameShooter.getPowerBar().getxPosition(),(int)gameShooter.getPowerBar().getyPosition(),length*GameScreen.WIDTH/1000,32*GameScreen.HEIGHT/1000);


		
	}
	/**
	 * sets length based on the bar's PowerFluc value
	 */
	private void powerbar(){
		
		if (direction){
			length = gameShooter.getPowerBar().getPowerFluc();
		}
	}
	
	/**
	 * key event for typing
	 */
	public void keyTyped(KeyEvent e) {
	}
	/**
	 * key event for key pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		red = true;
	}
	/**
	 * key event for key released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("pb keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
	}
	/**
	 * key event for generic action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/** getter for length
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**setter for length
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/** getter for direction
	 * @return the direction
	 */
	public boolean isDirection() {
		return direction;
	}

	/** setter for direction
	 * @param direction the direction to set
	 */
	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	/** getter for powerbar
	 * @return the powerBar
	 */
	public powerbarObject getPowerBar() {
		return powerBar;
	}

	/** setter for power bar
	 * @param powerBar the powerBar to set
	 */
	public void setPowerBar(powerbarObject powerBar) {
		this.powerBar = powerBar;
	}

	/**getter for power bar frame
	 * @return the powerBarFrame
	 */
	public powerbarFrame getPowerBarFrame() {
		return powerBarFrame;
	}

	/**setter for the power bar frame
	 * @param powerBarFrame the powerBarFrame to set
	 */
	public void setPowerBarFrame(powerbarFrame powerBarFrame) {
		this.powerBarFrame = powerBarFrame;
	}

	/** getter for game shooter
	 * @return the gameShooter
	 */
	public Shooter getGameShooter() {
		return gameShooter;
	}

	/** setter for game shooter
	 * @param gameShooter the gameShooter to set
	 */
	public void setGameShooter(Shooter gameShooter) {
		this.gameShooter = gameShooter;
	}
	

}