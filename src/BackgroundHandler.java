import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BackgroundHandler extends Handler {

	Image image;
		
	BackgroundHandler(OverallGame overallGame) {
		super(overallGame);
		try{
			image = ImageIO.read(new File("img/bad-background.png"));//.getScaledInstance(1000, 1000, Image.SCALE_FAST);	
		}
		catch(IOException e)
		{
			
		}
	}
	
	public void paint(Graphics g) {
		for (GameObject gameObject : getOverallGame().getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof Background)
			{
				g.drawImage( image, (int)gameObject.xPosition, (int)gameObject.yPosition, Color.gray, null);
			}
		}
	}

	
}
