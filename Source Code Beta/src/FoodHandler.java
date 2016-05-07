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
			image[0] = ImageIO.read(new File("img/algae_good.png")).getScaledInstance(GameState.frameWidth/25, GameState.frameWidth/25, Image.SCALE_FAST);	
			image[1] = ImageIO.read(new File("img/algae_medium.png")).getScaledInstance(GameState.frameWidth/25, GameState.frameWidth/25, Image.SCALE_FAST);	
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
		if (getGameState().getProjectile() instanceof Food) {
			Food t = (Food) getGameState().getProjectile();
			{
				if (t.isVisible) {
					t.foodFlag = t.foodFlag % 2;
					g.drawImage( image[1], (int)t.xPosition, (int)t.yPosition, new Color(0,0,0,0), null);
				}
				
			}
		}
	}

}
