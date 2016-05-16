import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class StartDisplayHandler extends Handler implements KeyListener {

	Image startdisplay; //image to be used for the start screen
	boolean active; // tells us if the start screen is needed or not
	/**
	 * consctuctor for the start display. Throws exception if images can't be read
	 * @param gameScreen
	 * @param gameState
	 */
	StartDisplayHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen, gameState);
		try{
			startdisplay = ImageIO.read(new File("img/startscreen.png"));
		}
		catch (IOException e){
			System.out.println("startscreen.png not found");
		}
		gameScreen.addKeyListener(this);
		active = true;
	}
	/**
	 * paints graphics on screen
	 * @param g, graphics used
	 */
	@Override
	public void paint(Graphics g) {
		if(active){
			for (GameObject gameObject : getGameState().getGameObjectCollection())
			{
				if (gameObject instanceof StartDisplay)
				{
					if(active){
						g.drawImage(startdisplay, (int) gameObject.getxPosition(), (int) gameObject.getyPosition(), new Color(0,0,0,0), null);
					}
				}
			}
		}
	}
	/**
	 * blank key event for typing keys
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}
	/**
	 * key event for pressing a key. Ends start display if it is active
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(active){
			if(e.getKeyCode() == KeyEvent.VK_SPACE){
				System.out.println("hello");
				for (GameObject gameObject : getGameState().getGameObjectCollection())
				{
					if (gameObject instanceof StartDisplay)
					{
						getGameState().remove(gameObject);
						active = false;
					}
				}
			}
		}
	}
	/**
	 * blank key event for releasing key
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
