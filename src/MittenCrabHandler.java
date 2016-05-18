import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MittenCrabHandler extends Handler {
	Image image[] = new Image[3];//this creature uses 3 images and keeps them in an array
	int crabFlag = 0; //number of this type of crab
	/**
	 * constructor, should load mitten crab's files or throw an exception
	 * @param gameScreen
	 * @param gameState
	 */
	MittenCrabHandler(GameScreen gameScreen,GameState gameState) {
		super(gameScreen,gameState);
		try{
			image[0] = ImageIO.read(new File("img/mittencrab/mittencrab_0.png")).getScaledInstance(GameScreen.WIDTH/15, GameScreen.HEIGHT/15, Image.SCALE_FAST);
			image[1] = ImageIO.read(new File("img/mittencrab/mittencrab_1.png")).getScaledInstance(GameScreen.WIDTH/15, GameScreen.HEIGHT/15, Image.SCALE_FAST);
			image[2] = ImageIO.read(new File("img/mittencrab/mittencrab_2.png")).getScaledInstance(GameScreen.WIDTH/15, GameScreen.HEIGHT/15, Image.SCALE_FAST);
		}
		catch(IOException e)
		{
			
		}
		// TODO Auto-generated constructor stub
	}
	/**
	 * paints graphics of mitten crab on screen
	 * @param g, graphics used
	 */
	public void paint(Graphics g) {
		crabFlag++;
		crabFlag = crabFlag % 3;
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof MittenCrab)
			{
				g.drawImage(image[crabFlag], scaleX(gameObject.getxPosition()), scaleY(gameObject.getyPosition()), new Color(0,0,0,0), null);
			}
		}
	}
}
