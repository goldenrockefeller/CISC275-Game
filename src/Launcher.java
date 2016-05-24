//TODO add todos
//TODO create tests
//TODO add function comments and javadoc
//TODO add a button to the frame

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.lang.*;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Launcher {	
	/**
	 * these values determine the total dimensions of the screen
	 */

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		GameState gameState = new GameState();
		GameScreen gameScreen = new GameScreen();
		JFrame gameWindow = new JFrame("Estuary Slam!");

		Shooter gameShooter = new Shooter(gameState);
		
		Launcher.setupGameWindow(gameWindow,gameScreen);
		Launcher.setupGameState(gameState);
		Launcher.setupGameScreen(gameScreen,gameState,gameShooter);
		
		/*
		JLabel label1 = new JLabel("Tap to start!",
                JLabel.CENTER);
		label1.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 48));
		gameScreen.add(label1);
		*/
		//TODO correct while loop goes here
		/**
		 * gameState should ALWAYS be updating and repainting. Throws exception if Thread.sleep doesn't work
		 */
		while (true)
		{
			while (!gameState.startover)
			{
				gameState.update();
				gameScreen.repaint();
				//System.out.println(gameState);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			gameState = new GameState();
			gameScreen.setHandlerCollection(new LinkedList<Handler>());
			Launcher.setupGameState(gameState);
			Launcher.setupGameScreen(gameScreen,gameState,gameShooter);
		}
		
	}
	/**
	 * sets default values of the game state
	 * @param gameState the instance of game state
	 */
	public static void setupGameState (GameState gameState)
	{
		//Construct and add Objects here
		gameState.add(new MittenCrab(500,500,2,2,gameState));
		gameState.add(new BlueCrab(500,500,2,1,gameState));
		//gameState.add(new TestObject(480,850,0,0,gameState));
		//gameState.add(new mytestObject(32,64,0,0,gameState));
		//gameState.add(new Food(480,700,0,0,gameState));
		gameState.add(new trashcanObject(200,120,0,0,gameState));
		gameState.add(new trashcanObject(500,120,0,0,gameState));
		gameState.add(new trashcanObject(800,120,0,0,gameState));
		//gameState.add(new ScoreBar(850,25,0,0,gameState));
		//gameState.setProjectile(new Food(480,700,0,0,gameState));
		//add(new StartDisplay(GameScreen.WIDTH / 8, GameScreen.HEIGHT / 12, 0, 0, gameState));
		
	}
	/**
	 * sets default values of the game screen
	 * @param gameScreen the game's view
	 * @param gameState the instance of game state
	 * @param gameShooter the game's shooter
	 */
	public static void setupGameScreen (GameScreen gameScreen, GameState gameState, Shooter gameShooter)
	{
		//Construct and add Handlers here
		
		gameScreen.add (new BackgroundHandler(gameScreen,gameState));
		gameScreen.add (new trashcanHandler(gameScreen,gameState));
		gameScreen.add (new MittenCrabHandler(gameScreen,gameState));
		gameScreen.add (new BlueCrabHandler(gameScreen,gameState));
		ShooterHandler sh = new ShooterHandler(gameScreen, gameState,gameShooter);
		gameScreen.add (sh);
		//gameScreen.add (new TestHandler(gameScreen,gameState));
		//gameScreen.add (new mytestHandler(gameScreen,gameState));
		gameScreen.add (new FoodHandler(gameScreen,gameState));
		gameScreen.add (new TrashHandler(gameScreen, gameState));
		gameScreen.add(new ScoreBarHandler(gameScreen, gameState));
		gameScreen.add (new StartDisplayHandler(gameScreen, gameState));
		gameScreen.add(new EndScreenHandler(gameScreen, gameState,sh));
	}
	/**
	 * sets default values of game window
	 * @param gameWindow game window being set
	 * @param gameScreen the game's view
	 */
	public static void setupGameWindow(JFrame gameWindow, GameScreen gameScreen)
	{
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setSize(GameScreen.WIDTH, GameScreen.HEIGHT);
		gameWindow.getContentPane().add(gameScreen);
		gameWindow.setVisible(true);
	}
	/**
	 * allows setup of game state from file, such as Serializable
	 * @param gameState
	 */
	public static void setupGameStateFromFile (GameState gameState)
	{
		//Construct and add Objects here
	}

}
