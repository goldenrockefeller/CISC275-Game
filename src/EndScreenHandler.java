import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EndScreenHandler extends Handler {

	
	private static final long serialVersionUID = 1L;
	Image image;
	String scoreblue;
	String scoremitten;
	String scoretrash;
	String scoretrashmissed;
	String feedback;
	boolean ended = false;
	
	EndScreenHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen, gameState);
		
		try{
			image = ImageIO.read(new File("img/endscreen.png")).getScaledInstance(GameScreen.WIDTH, GameScreen.HEIGHT, Image.SCALE_FAST);
		}
		catch(IOException e)
		{
			System.out.println("End screen image cannot be found.");
		}
	}

	
	public void setScores(int blueCount, int mittenCount, int trashfield, int trashcan) {
		scoreblue = Integer.toString(blueCount);
		scoremitten = Integer.toString(mittenCount);
		scoretrash = Integer.toString(trashfield);
		scoretrashmissed = Integer.toString(trashcan);
		if (blueCount < mittenCount && trashcan > trashfield)
			feedback = "Great Job!";
		else if (blueCount > mittenCount && trashcan > trashfield)
			feedback = "Amazing!";
		else if (blueCount > mittenCount || trashcan < trashfield)
			feedback = "Good Work!";
		else
			feedback = "Better Luck Next Time!";
			
	}

	@Override
	public void paint(Graphics g) {
		
		
		if (getGameState().isend || getGameState().iswin) {
			g.drawImage(image, 0, 0, new Color(0,0,0,0), null);
			setScores(getGameState().blueCount, getGameState().mittenCount, getGameState().trashCount, getGameState().trashMissed);
			Font f = new Font("serif", Font.PLAIN, scaleX(50));
			g.setFont(f);
			g.setColor(Color.white);
			g.drawString(feedback,  250 *GameScreen.WIDTH / 1000, (100)*GameScreen.HEIGHT / 1000);
			g.drawString(scoreblue, (200)*GameScreen.WIDTH / 1000, (500)*GameScreen.HEIGHT / 1000);
			g.drawString(scoremitten, (700)*GameScreen.WIDTH / 1000, (500)*GameScreen.HEIGHT / 1000);
			g.drawString(scoretrash, (200)*GameScreen.WIDTH / 1000, (800)*GameScreen.HEIGHT / 1000);
			g.drawString(scoretrashmissed, (700)*GameScreen.WIDTH / 1000, (800) *GameScreen.HEIGHT / 1000);
		}
	}
	
	
}
