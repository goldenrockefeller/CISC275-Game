import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class StartScreen implements KeyListener {

	Image start;
	
	StartScreen(){

		try{
			start = ImageIO.read(new File("img/startscreen.png"));
		}
		catch(IOException e){
			System.out.println("startscreen did not load properly");
		}
	}

	public void paint(Graphics g) {
		g.drawImage(start, GameState.WIDTH / 4, GameState.HEIGHT / 4, new Color(0, 0, 0, 0), null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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