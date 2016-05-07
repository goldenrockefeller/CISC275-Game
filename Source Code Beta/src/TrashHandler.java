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
			image[0] = ImageIO.read(new File("img/apple.png")).getScaledInstance(GameState.frameWidth/30, GameState.frameWidth/30, Image.SCALE_FAST);	
			image[1] = ImageIO.read(new File("img/banana.png")).getScaledInstance(GameState.frameWidth/30, GameState.frameWidth/30, Image.SCALE_FAST);
			image[2] = ImageIO.read(new File("img/paper.png")).getScaledInstance(GameState.frameWidth/30, GameState.frameWidth/30, Image.SCALE_FAST);
			Image check = ImageIO.read(new File("img/check.png")).getScaledInstance(GameState.frameWidth/30, GameState.frameWidth/30, Image.SCALE_FAST);	;
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
		for (Projectile trash : getGameState().getTrashCollection())
		{
			if (trash.isVisible) {
				g.drawImage( image[trash.trashFlag], (int)trash.xPosition, (int)trash.yPosition, new Color(0,0,0,0), null);
			}
		}
		
		if (getGameState().getProjectile() instanceof Trash) {
			Trash t = (Trash) getGameState().getProjectile();
			{
				if (t.isVisible) {
					t.trashFlag  = t.trashFlag % 3;
					g.drawImage( image[t.trashFlag], (int)t.xPosition, (int)t.yPosition, new Color(0,0,0,0), null);
				}
				
			}
		}
		
	}

}
