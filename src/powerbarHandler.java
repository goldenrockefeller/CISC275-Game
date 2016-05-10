import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static java.lang.System.out;

public class powerbarHandler extends Handler implements ActionListener, KeyListener {

	
	JButton testButton;
	boolean red = true;
	int  length=32;
	boolean direction = true;
	powerbarObject powerBar;
	powerbarFrame powerBarFrame;
	Shooter gameShooter;
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
		this.powerBarFrame = new powerbarFrame(Launcher.WIDTH/5 -2, Launcher.HEIGHT - 220 - 2, 0, 0, gameState);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void  paint(Graphics g)
	{


		g.setColor(Color.BLACK);
		
		g.fillRect((int)powerBarFrame.getxPosition(),(int)powerBarFrame.getyPosition(),105*Launcher.WIDTH/1000,36*Launcher.HEIGHT/1000);
		
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
			

		g.fillRect((int)gameShooter.getPowerBar().getxPosition(),(int)gameShooter.getPowerBar().getyPosition(),length*Launcher.WIDTH/1000,32*Launcher.HEIGHT/1000);


		
	}
	
	private void powerbar(){
		
		if (direction){
			length = gameShooter.getPowerBar().getPowerFluc();
		}
	}
	
	
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		red = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("pb keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the direction
	 */
	public boolean isDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	/**
	 * @return the powerBar
	 */
	public powerbarObject getPowerBar() {
		return powerBar;
	}

	/**
	 * @param powerBar the powerBar to set
	 */
	public void setPowerBar(powerbarObject powerBar) {
		this.powerBar = powerBar;
	}

	/**
	 * @return the powerBarFrame
	 */
	public powerbarFrame getPowerBarFrame() {
		return powerBarFrame;
	}

	/**
	 * @param powerBarFrame the powerBarFrame to set
	 */
	public void setPowerBarFrame(powerbarFrame powerBarFrame) {
		this.powerBarFrame = powerBarFrame;
	}

	/**
	 * @return the gameShooter
	 */
	public Shooter getGameShooter() {
		return gameShooter;
	}

	/**
	 * @param gameShooter the gameShooter to set
	 */
	public void setGameShooter(Shooter gameShooter) {
		this.gameShooter = gameShooter;
	}
	

}