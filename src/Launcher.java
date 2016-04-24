//TODO add todos
//TODO create tests
//TODO add function comments and javadoc
//TODO add a button to the frame

import java.lang.*;

import javax.swing.JFrame;

public class Launcher {
	final static int frameWidth = 1000;
    final static int frameHeight = 1000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameState gameState = new GameState();
		GameScreen gameScreen = new GameScreen();
		JFrame gameWindow = new JFrame("Super Team 6");
		
		
		Launcher.setupGameState(gameState);
		Launcher.setupGameScreen(gameScreen,gameState);
		Launcher.setupGameWindow(gameWindow,gameScreen);
		
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
		gameState.add(new MittenCrab(500,500,0,0,gameState));
		gameState.add(new BlueCrab(76,32,0,0,gameState));
		gameState.add(new TestObject(500,500,0,0,gameState));
		gameState.add(new mytestObject(32,64,0,0,gameState));
		gameState.add(new powerbarFrame(18, 126, 0, 0, gameState));
		gameState.add(new powerbarObject(20,128,0,0,gameState));
		
	}
	
	public static void setupGameScreen (GameScreen gameScreen, GameState gameState)
	{
		//Construct and add Handlers here
		gameScreen.add (new BackgroundHandler(gameScreen,gameState));
		gameScreen.add (new MittenCrabHandler(gameScreen,gameState));
		gameScreen.add (new BlueCrabHandler(gameScreen,gameState));
		gameScreen.add (new TestHandler(gameScreen,gameState));
		gameScreen.add (new mytestHandler(gameScreen,gameState));
		gameScreen.add (new powerbarHandler(gameScreen,gameState));
	}
	
	public static void setupGameWindow(JFrame gameWindow, GameScreen gameScreen)
	{
    	
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setSize(frameWidth, frameHeight);
		gameWindow.getContentPane().add(gameScreen);
		gameWindow.setVisible(true);

	}
	
	public static void setupGameStateFromFile (GameState gameState)
	{
		//Construct and add Objects here
	}
	

}
