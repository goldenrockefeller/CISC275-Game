//TODO add todos
//TODO create tests
//TODO add function comments and javadoc
//TODO add a button to the frame

import java.lang.*;

public class Launcher {


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameState gameState = new GameState();
		OverallGame overallGame = new OverallGame(gameState);
		Launcher.setupGameState(gameState);
		Launcher.setupOverallGame(overallGame);
		
		//TODO correct while loop goes here
		while (true)
		{
			overallGame.update();
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
		gameState.add( (GameObject)( new MittenCrab(500,500,0,0,gameState) ) );
		gameState.add( (GameObject)( new BlueCrab(76,32,0,0,gameState) ) );
	}
	
	public static void setupOverallGame (OverallGame overallGame)
	{
		//Construct and add Handlers here
		overallGame.add ( (Handler) (new MittenCrabHandler(overallGame) ) );
		overallGame.add ( (Handler) (new BlueCrabHandler(overallGame) ) );
	}
	
	public static void setupGameStateFromFile (GameState gameState)
	{
		//Construct and add Objects here
	}
	

}