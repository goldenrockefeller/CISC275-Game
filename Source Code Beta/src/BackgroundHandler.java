import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BackgroundHandler extends Handler {

	Image sand;
	Image water;
		
	BackgroundHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen,gameState);
		try{
			sand = ImageIO.read(new File("img/background/tile_sand_center.png"));//.getScaledInstance(1000, 1000, Image.SCALE_FAST);	
			water = ImageIO.read(new File("img/background/river_revised.jpg"))
					.getScaledInstance(Launcher.frameHeight, Launcher.frameHeight / 10, Image.SCALE_FAST);	
		}
		catch(IOException e)
		{
			
		}
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < Launcher.frameWidth; i += sand.getWidth(null)){
			for(int j = 0; j < Launcher.frameHeight; j+= sand.getWidth(null)){
				g.drawImage(sand, i, j, Color.gray, null);
			}
		}
		
		g.drawImage(water, 0, Launcher.frameHeight / 4, null);
		if (water.getWidth(null) <= Launcher.frameWidth){
			g.drawImage(water, Launcher.frameWidth / 2, Launcher.frameHeight / 4, null);
		}
		
		g.drawImage(water, 0, Launcher.frameHeight / 4 * 3, null);
		if (water.getWidth(null) <= Launcher.frameWidth){
			g.drawImage(water, Launcher.frameWidth / 2, Launcher.frameHeight / 4 * 3, null);
		}
	}

	
}
