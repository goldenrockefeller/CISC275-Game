
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.*;

public class ViewHandler {

	private OverallGame overallGame;
	ArrayList<ArrayList<BufferedImage>> spriteCollection;
	
	ViewHandler(OverallGame overallGame)
	{
		this.overallGame = overallGame;
		this.spriteCollection = new ArrayList<ArrayList<BufferedImage>>();
	}
	
	public void selfDestruct()
	{
		overallGame.remove(this);
	}
	
	public void paint(Graphics g)
	{
		
	}
	public void loadAnimationFromFile(String fileName,int subImageWidth, int subImageHeight)
	{
		//TODO
		//This function should add an arraylist<BufferedImage> to spriteCollection
	}
	public void loadAnimationFromMultipleFiles(String[] fileNames)
	{
		//TODO
		//This function should add an arraylist<BufferedImage> to spriteCollection
	}
	public void drawFrame(Graphics g, int x, int y, int animationIndex, int frameIndex)
	{
		g.drawImage((Image)spriteCollection.get(animationIndex).get(frameIndex),x,y,null);
	}

	public OverallGame getOverallGame() {
		return overallGame;
	}

	public ArrayList<ArrayList<BufferedImage>> getSpriteCollection() {
		return spriteCollection;
	}
	

}
