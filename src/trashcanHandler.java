
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
			image  = ImageIO.read(new File("img/TrashCan/trashcan_open.png")).getScaledInstance(GameState.WIDTH/25, GameState.HEIGHT/25, Image.SCALE_FAST);	
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
				g.drawImage( image, scaleX(gameObject.getxPosition()), scaleY(gameObject.getyPosition()), new Color(0,0,0,0), null);
			}
		}
	}
}
