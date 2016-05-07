import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class trashcanHandler extends Handler {

	Image image;
	
	
	
	trashcanHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen, gameState);
		try{
			image  = ImageIO.read(new File("img/TrashCan/trashcan_open.png")).getScaledInstance(GameState.frameWidth/20, GameState.frameWidth/20, Image.SCALE_FAST);	
		}
		catch(IOException e)
		{
			System.out.println("no image for trash can.");
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void  paint(Graphics g)
	{
		
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof trashcanObject)
			{
				g.drawImage( image, (int)gameObject.xPosition, (int)gameObject.yPosition, new Color(0,0,0,0), null);
			}
		}
	}
}