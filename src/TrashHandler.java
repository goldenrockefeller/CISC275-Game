import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TrashHandler extends Handler {

	Image image[] = new Image[3];
	Image check;
	
	TrashHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen, gameState);
		try{
			image[0] = ImageIO.read(new File("img/apple.png")).getScaledInstance(Launcher.WIDTH/50, Launcher.HEIGHT/50, Image.SCALE_FAST);	
			image[1] = ImageIO.read(new File("img/banana.png")).getScaledInstance(Launcher.WIDTH/50, Launcher.HEIGHT/50, Image.SCALE_FAST);
			image[2] = ImageIO.read(new File("img/paper.png")).getScaledInstance(Launcher.WIDTH/50, Launcher.HEIGHT/50, Image.SCALE_FAST);
			Image check = ImageIO.read(new File("img/check.png")).getScaledInstance(Launcher.WIDTH/50, Launcher.HEIGHT/50, Image.SCALE_FAST);
			}
		catch(IOException e)
		{
			
		}
	}

	/**
	 * First draw all trash on the board
	 * Then draw trash currently in transit if visible
	 */
	@Override
	public void paint(Graphics g) {
		for (GameObject gameObject : getGameState().getGameObjectCollection()){
			if (gameObject instanceof Trash)
			{
				g.drawImage( image[gameObject.hashCode()%3],  scaleX(gameObject.getxPosition()), scaleY(gameObject.getyPosition()), new Color(0,0,0,0), null);
		
			}
		}
	}

}
