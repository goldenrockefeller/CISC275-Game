import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class StartDisplayHandler extends Handler implements KeyListener {

	Image startdisplay;
	boolean active; // tells us if the start screen is needed or not
	
	StartDisplayHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen, gameState);
		try{
			startdisplay = ImageIO.read(new File("img/startscreen.png"));
		}
		catch (IOException e){
			System.out.println("startscreen.png not found");
		}
		active = true;
	}

	@Override
	public void paint(Graphics g) {
		if(active){
			for (GameObject gameObject : getGameState().getGameObjectCollection())
			{
				if (gameObject instanceof StartDisplay)
				{
					g.drawImage(startdisplay, (int) gameObject.getxPosition(), (int) gameObject.getyPosition(), new Color(0,0,0,0), null);
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(active){
			if(e.getKeyCode() == KeyEvent.VK_SPACE){
				for (GameObject gameObject : getGameState().getGameObjectCollection())
				{
					if (gameObject instanceof StartDisplay)
					{
						getGameState().remove(gameObject);
						active = false;
						System.out.println("dooooone");
					}
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
