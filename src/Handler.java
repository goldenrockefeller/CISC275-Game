
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.lang.*;

import javax.imageio.ImageIO;

public abstract class Handler {
	//gameScreen and gameState to be associated with this Handler
	GameScreen gameScreen;
	GameState gameState;
	/**
	 * Constructor for Handlers
	 * @param gameScreen
	 * @param gameState
	 */
	Handler(GameScreen gameScreen, GameState gameState)
	{
		this.gameScreen = gameScreen;
		this.gameState = gameState;
	}
	/**
	 * abstract class for painting graphics for use in handlers
	 * @param g
	 */
	abstract public void paint(Graphics g);

	/** getter for gameScreen
	 * @return the gameScreen
	 */
	public GameScreen getGameScreen() {
		return gameScreen;
	}

	/** getter for GameState
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
		return (int)(x * GameScreen.WIDTH / GameState.frameWidth);
	}
	/**
	 * scales Y based on parameter
	 * @param y the scale value
	 * @return the new Y value
	 */
	public int scaleY(double y)
	{
		return (int)(y * GameScreen.HEIGHT / GameState.frameHeight);
	}

	
}
