import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MittenCrabHandler extends Handler {
	Image image[] = new Image[3];
	int crabFlag = 0;
	
	MittenCrabHandler(GameScreen gameScreen,GameState gameState) {
		super(gameScreen,gameState);
		try{
			image[0] = ImageIO.read(new File("img/mittencrab/mittencrab_0.png")).getScaledInstance(100, 100, Image.SCALE_FAST);
			image[1] = ImageIO.read(new File("img/mittencrab/mittencrab_1.png")).getScaledInstance(100, 100, Image.SCALE_FAST);
			image[2] = ImageIO.read(new File("img/mittencrab/mittencrab_2.png")).getScaledInstance(100, 100, Image.SCALE_FAST);
		}
		catch(IOException e)
		{
			
		}
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g) {
		crabFlag++;
		crabFlag = crabFlag % 3;
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof MittenCrab)
			{
				g.drawImage(image[crabFlag], (int)gameObject.xPosition, (int)gameObject.yPosition, new Color(0,0,0,0), null);
			}
		}
	}
}
