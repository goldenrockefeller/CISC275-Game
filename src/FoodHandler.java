import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FoodHandler extends Handler{

	Image image[] = new Image[2];
	
	FoodHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen, gameState);
		try{
			image[0] = ImageIO.read(new File("img/algae_good.png")).getScaledInstance(Launcher.WIDTH/25, Launcher.HEIGHT/25, Image.SCALE_FAST);	
			image[1] = ImageIO.read(new File("img/algae_medium.png")).getScaledInstance(Launcher.WIDTH/25, Launcher.HEIGHT/25, Image.SCALE_FAST);
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
				//Use .hashCode() to assign each Food Item a random image for easy maintainability
				g.drawImage( image[gameObject.hashCode()%2], scaleX(gameObject.getxPosition()), scaleY(gameObject.getyPosition()), new Color(0,0,0,0), null);
			}
		}
	}

}
