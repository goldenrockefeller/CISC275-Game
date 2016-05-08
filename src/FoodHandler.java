import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FoodHandler extends Handler{

	Image image;
	
	FoodHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen, gameState);
		try{
			image = ImageIO.read(new File("img/Coin1.png")).getScaledInstance(Launcher.WIDTH/50, Launcher.HEIGHT/50, Image.SCALE_FAST);	
		}
		catch(IOException e)
		{
			
		}
	}

	
	/**
	 * Draw food in transit if visible
	 * If it hits a crab, it will disappear and replicate the crab
	 */
	@Override
	public void paint(Graphics g) {
		for (GameObject gameObject : getGameState().getGameObjectCollection()) {
			if (gameObject instanceof Food)
			{
				g.drawImage( image, scaleX(gameObject.getxPosition()), scaleY(gameObject.getyPosition()), new Color(0,0,0,0), null);
			}
		}
	}

}
