import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EndScreenHandler extends Handler implements KeyListener{

	//serial version for Serializable
	private static final long serialVersionUID = 1L;
	/**
	 * these are all values from the game that will be display on this screen
	 */
	Image image;
	String scoreblue;
	String scoremitten;
	String scoretrash;
	String scoretrashmissed;
	String feedback;
	//the shooter-handler to be associated with this endscreen
	ShooterHandler shooterHandler;
	boolean ended = false; //this bool is used to let this handler know when the game is over
	/**
	 * Constructor. Should throw exception if image cannot be read.
	 * @param gameScreen
	 * @param gameState
	 * @param shooterHandler
	 */
	EndScreenHandler(GameScreen gameScreen, GameState gameState, ShooterHandler shooterHandler) {
		super(gameScreen, gameState);
		
		try{
			image = ImageIO.read(new File("img/endscreen.png")).getScaledInstance(GameScreen.WIDTH, GameScreen.HEIGHT, Image.SCALE_FAST);
		}
		catch(IOException e)
		{
			System.out.println("End screen image cannot be found.");
		}
		gameScreen.addKeyListener(this);
	}

	/**
	 * sets class attributes based on parameters' tostring methods. Display message is different if player "wins"
	 * @param blueCount sets scoreblue
	 * @param mittenCount sets scoremitten
	 * @param trashfield sets scoretrash
	 * @param trashcan sets scoretrashmissed
	 */
	public void setScores(int blueCount, int mittenCount, int trashfield, int trashcan) {
		scoreblue = Integer.toString(blueCount);
		scoremitten = Integer.toString(mittenCount);
		scoretrash = Integer.toString(trashfield);
		scoretrashmissed = Integer.toString(trashcan);
			
		feedback = "Better Luck Next Time!";

		if (getGameState().iswin)
		{
			feedback = "Good Job";
		}
		/*
		if (blueCount < mittenCount && trashcan > trashfield)
			feedback = "Great Job!";
		else if (blueCount > mittenCount && trashcan > trashfield)
			feedback = "Amazing!";
		else if (blueCount > mittenCount || trashcan < trashfield)
			feedback = "Good Work!";
		else
			feedback = "Better Luck Next Time!";
		*/
			
	}
	/**
	 * paints the images on screen, specifically the end screen itself and the text that goes over it
	 *@param g, graphics used
	 */
	
	@Override
	public void paint(Graphics g) {
		
		
		if (getGameState().isend || getGameState().iswin) {
			g.drawImage(image, 0, 0, new Color(0,0,0,0), null);
			setScores(getGameState().blueCount, getGameState().mittenCount, getGameState().trashCount, getGameState().trashMissed);
			Font f = new Font("serif", Font.PLAIN, scaleX(50));
			g.setFont(f);
			g.setColor(Color.white);
			g.drawString(feedback,  (int)(GameScreen.WIDTH / 2. - feedback.length() * 20.), (int)((100)*GameScreen.HEIGHT / 1000.));
			g.drawString(scoreblue, (int)((200)*GameScreen.WIDTH / 1000.), (int)((500)*GameScreen.HEIGHT / 1000.));
			g.drawString(scoremitten, (int)((700)*GameScreen.WIDTH / 1000.), (int)((500)*GameScreen.HEIGHT / 1000.));
			g.drawString(scoretrash, (int)((200)*GameScreen.WIDTH / 1000.), (int)((800)*GameScreen.HEIGHT / 1000.));
			g.drawString(scoretrashmissed, (int)((700)*GameScreen.WIDTH / 1000.), (int)((800) *GameScreen.HEIGHT / 1000.));
		}
	}

	/**
	 * key event for pressing a key. At this point in the game, pressing a key at the endgame screen restarts the game
	 * @KeyEvent arg0
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			if (getGameState().isend || getGameState().iswin)
			{
				gameState.startover = true;
			}
		}
	}

	/**
	 * stub key event for releasing a key
	 * @param @KeyEvent arg0
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * stub key event for typing a key
	 * @param KeyEvent arg0
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}