import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BackgroundHandler extends Handler {
	//these images are the parts of the background itself
	Image sand;
	Image water;
	Image sky;
	/**
	 * constructor, should load background images or throw exception
	 * @param gameScreen, the game's View
	 * @param gameState, the instance of the game's state
	 */
	BackgroundHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen,gameState);
		try{
			sand = ImageIO.read(new File("img/background/tile_sand_center.png"));//.getScaledInstance(1000, 1000, Image.SCALE_FAST);	
			water = ImageIO.read(new File("img/background/river_revised.jpg"))
					.getScaledInstance(GameScreen.WIDTH, GameScreen.HEIGHT / 10, Image.SCALE_FAST);
			sky = ImageIO.read(new File("img/background/sky_tile.png"))
					.getScaledInstance(GameScreen.WIDTH / 10, GameScreen.HEIGHT / 10, Image.SCALE_FAST);
		}
		catch(IOException e)
		{
			System.out.println("Background failed to load.");
		}
	}
	/**
	 * draws the specified images. Should be two water sections, one sand section, and a skybox
	 * @param g, graphics used.
	 */
	public void paint(Graphics g) {
		for(int i = 0; i < GameScreen.WIDTH; i += sand.getWidth(null)){
			for(int j = 0; j < GameScreen.HEIGHT; j+= sand.getWidth(null)){
				g.drawImage(sand, i, j, Color.gray, null);
			}
		}
		
		for(int i = 0; i < GameScreen.WIDTH; i+= sky.getWidth(null)){
			g.drawImage(sky, i, 0, Color.gray, null);
		}
		
		g.drawImage(water, 0, GameScreen.HEIGHT / 4, null);
		if (water.getWidth(null) <= GameScreen.WIDTH){
			g.drawImage(water, GameScreen.WIDTH / 2, GameScreen.HEIGHT / 4, null);
		}
		
		g.drawImage(water, 0, GameScreen.HEIGHT / 4 * 3, null);
		if (water.getWidth(null) <= GameScreen.WIDTH){
			g.drawImage(water, GameScreen.WIDTH / 2, GameScreen.HEIGHT / 4 * 3, null);
		}
	}

	
}
