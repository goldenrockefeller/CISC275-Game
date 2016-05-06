import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class BlueCrabHandler extends Handler{

	Image image[] = new Image[3];
	int crabFlag = 0;
	
	BlueCrabHandler(GameScreen gameScreen,GameState gameState) {
		super(gameScreen,gameState);
		try{
			image[0] = ImageIO.read(new File("img/blueclaw/bluecrab_0.png")).getScaledInstance(100, 100, Image.SCALE_FAST);
			image[1] = ImageIO.read(new File("img/blueclaw/bluecrab_1.png")).getScaledInstance(100, 100, Image.SCALE_FAST);
			image[2] = ImageIO.read(new File("img/blueclaw/bluecrab_2.png")).getScaledInstance(100, 100, Image.SCALE_FAST);
		}
		catch(IOException e)
		{
			System.out.println("Blue Crab image cannot be found.");
		}
		// TODO Auto-generated constructor stub
	}

	/**
	 * draws the blue crab in place
	 * @param graphics g, graphic being used
	 */
	public void paint(Graphics g) {
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof BlueCrab)
			{
				crabFlag++;
				crabFlag = crabFlag % 3;
				//System.out.println(crabFlag);
				g.drawImage(image[crabFlag], (int)gameObject.xPosition, (int)gameObject.yPosition, new Color(0,0,0,0), null);
			}
		}
	}

}
