
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.lang.*;

import javax.imageio.ImageIO;

public abstract class Handler {

	GameScreen gameScreen;
	GameState gameState;

	Handler(GameScreen gameScreen, GameState gameState)
	{
		this.gameScreen = gameScreen;
		this.gameState = gameState;
	}
	
	abstract public void paint(Graphics g);

	/**
	 * @return the gameScreen
	 */
	public GameScreen getGameScreen() {
		return gameScreen;
	}

	/**
	 * @return the gameState
	 */
	public GameState getGameState() {
		return gameState;
	}
	/**
	 * scales X based on parameter
	 * @param x the scale value
	 * @return new X value
	 */
	public int scaleX(double x)
	{
		return (int)(x * Launcher.WIDTH / GameState.frameWidth);
	}
	/**
	 * scales Y based on parameter
	 * @param y the scale value
	 * @return the new Y value
	 */
	public int scaleY(double y)
	{
		return (int)(y * Launcher.HEIGHT / GameState.frameHeight);
	}

	
}
