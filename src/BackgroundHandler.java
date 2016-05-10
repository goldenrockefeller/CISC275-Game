import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BackgroundHandler extends Handler {
	
	Image sand;
	Image water;
	Image sky;
	/**
	 * contructor, should load background images or throw exception
	 * @param gameScreen, the game's View
	 * @param gameState, the instance of the game's state
	 */
	BackgroundHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen,gameState);
		try{
			sand = ImageIO.read(new File("img/background/tile_sand_center.png"));//.getScaledInstance(1000, 1000, Image.SCALE_FAST);	
			water = ImageIO.read(new File("img/background/river_revised.jpg"))
					.getScaledInstance(Launcher.WIDTH, Launcher.HEIGHT / 10, Image.SCALE_FAST);
			sky = ImageIO.read(new File("img/background/sky_tile.png"))
					.getScaledInstance(Launcher.WIDTH / 10, Launcher.HEIGHT / 10, Image.SCALE_FAST);
		}
		catch(IOException e)
		{
			System.out.println("Background failed to load.");
		}
	}
	/**
	 * draws the specified images
	 * @param g, graphics used.
	 */
	public void paint(Graphics g) {
		for(int i = 0; i < Launcher.WIDTH; i += sand.getWidth(null)){
			for(int j = 0; j < Launcher.HEIGHT; j+= sand.getWidth(null)){
				g.drawImage(sand, i, j, Color.gray, null);
			}
		}
		
		for(int i = 0; i < Launcher.WIDTH; i+= sky.getWidth(null)){
			g.drawImage(sky, i, 0, Color.gray, null);
		}
		
		g.drawImage(water, 0, Launcher.HEIGHT / 4, null);
		if (water.getWidth(null) <= Launcher.WIDTH){
			g.drawImage(water, Launcher.WIDTH / 2, Launcher.HEIGHT / 4, null);
		}
		
		g.drawImage(water, 0, Launcher.HEIGHT / 4 * 3, null);
		if (water.getWidth(null) <= Launcher.WIDTH){
			g.drawImage(water, Launcher.WIDTH / 2, Launcher.HEIGHT / 4 * 3, null);
		}
	}

	
}
