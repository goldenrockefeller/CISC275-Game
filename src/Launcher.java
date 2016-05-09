//TODO add todos
//TODO create tests
//TODO add function comments and javadoc
//TODO add a button to the frame

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Launcher {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameState gameState = new GameState();
		GameScreen gameScreen = new GameScreen();
		JFrame gameWindow = new JFrame("Estuary Slam!");
		
		Launcher.setupGameState(gameState);
		Launcher.setupGameScreen(gameScreen,gameState);
		Launcher.setupGameWindow(gameWindow,gameScreen);

		/*
		JLabel label1 = new JLabel("Tap to start!",
                JLabel.CENTER);
		label1.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 48));
		gameScreen.add(label1);
		*/
		//TODO correct while loop goes here
		
		
		while (true)
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
		
	}
	
	public static void setupGameState (GameState gameState)
	{
		//Construct and add Objects here
		gameState.add(new MittenCrab(500,500,2,1,gameState));
		gameState.add(new BlueCrab(500,500,3,1,gameState));
		//gameState.add(new TestObject(480,850,0,0,gameState));
		//gameState.add(new mytestObject(32,64,0,0,gameState));
		gameState.add(new powerbarFrame(GameState.WIDTH / 5, (GameState.HEIGHT - 50 - 2), 0, 0, gameState));
		gameState.add(new powerbarObject(GameState.WIDTH / 5, GameState.HEIGHT - 50, 0, 0, gameState));
		//gameState.add(new Food(480,700,0,0,gameState));
		gameState.add(new trashcanObject(200,120,0,0,gameState));
		gameState.add(new trashcanObject(500,120,0,0,gameState));
		gameState.add(new trashcanObject(800,120,0,0,gameState));
		//gameState.setProjectile(new Food(480,700,0,0,gameState));
		gameState.setShooter(new Shooter(gameState));
	}
	
	public static void setupGameScreen (GameScreen gameScreen, GameState gameState)
	{
		//Construct and add Handlers here
		gameScreen.add (new BackgroundHandler(gameScreen,gameState));
		gameScreen.add (new trashcanHandler(gameScreen,gameState));
		gameScreen.add (new MittenCrabHandler(gameScreen,gameState));
		gameScreen.add (new BlueCrabHandler(gameScreen,gameState));
		gameScreen.add (new ShooterHandler(gameScreen, gameState));
		gameScreen.add (new TestHandler(gameScreen,gameState));
		//gameScreen.add (new mytestHandler(gameScreen,gameState));
		gameScreen.add (new powerbarHandler(gameScreen,gameState));
		gameScreen.add (new FoodHandler(gameScreen,gameState));
		gameScreen.add (new TrashHandler(gameScreen, gameState));
		
	}
	
	public static void setupGameWindow(JFrame gameWindow, GameScreen gameScreen)
	{
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setSize(GameState.WIDTH, GameState.HEIGHT);
		gameWindow.getContentPane().add(gameScreen);
		gameWindow.setVisible(true);
	}
	
	public static void setupGameStateFromFile (GameState gameState)
	{
		//Construct and add Objects here
	}
	

}
