import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.*;

public class GameState {
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) screenSize.getWidth();
	public static final int HEIGHT = (int) screenSize.getHeight();
	
	int score;
	int trashCount;
	int mittenCount;
	int blueCount;
	Shooter gameShooter;
	//TO DO need to have this in Launcher
	final static int frameWidth = 1000;
    final static int frameHeight = 1000;
	Collection<GameObject> gameObjectCollection = new LinkedList<GameObject>();
	//Collection<Projectile> trashCollection = new LinkedList<Projectile>();
	/*Other group's method of making screen size changeable
	 * final Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	 double frameWidth = screensize.getWidth();
	 double frameHeight = screensize.getHeight(); 
	 double xScale= frameWidth/1366;
	 double yScale= frameHeight/768;
	 these numbers are MY resolution. Can be easily changed to match any real, possible resolution
	 */
	
	/**
	 * Iterate through game objects and update position for each one based on velocity
	 * Iterate once again and update state (view)
	 * After updates, check for any collisions, add crabs accordingly
	 * Use buffer value (@see buffm buffb) to ensure only one crab is replicated per projectile
	 * Prioritize blue crab
	 * Finally, update gameShooter
	 * 
	 */
	public void update()
	{
		for (GameObject gameObject : gameObjectCollection)
		{
			gameObject.updatePosition();
		}
		for (GameObject gameObject : new ArrayList<GameObject>(gameObjectCollection))
		{
			gameObject.updateState();
		}
			gameShooter.update(); //not a gameObject, so I didn't use updateState
	}
	public void addToScore(int value)
	{
		this.score += value;
	}
	public void addToTrashCount(int value)
	{
		this.trashCount += value;
	}
	public void addToMittenCount(int value)
	{
		this.mittenCount += value;
	}
	public void addToBlueCount(int value)
	{
		this.blueCount += value;
	}
	public void add(GameObject gameObject)
	{
		this.gameObjectCollection.add(gameObject);
	}
	/*
	public void addTrash(Projectile projectile)
	{
		this.trashCollection.add(projectile);
	}
	*/
	public void remove(GameObject gameObject)
	{
		this.gameObjectCollection.remove(gameObject);
	}
	/*
	public void removeTrash(Trash trash)
	{
		this.trashCollection.remove(trash);
	}
	*/
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTrashCount() {
		return trashCount;
	}
	public void setTrashCount(int trashCount) {
		this.trashCount = trashCount;
	}
	public int getMittenCount() {
		return mittenCount;
	}
	public void setMittenCount(int mittenCount) {
		this.mittenCount = mittenCount;
	}
	public int getBlueCount() {
		return blueCount;
	}
	public void setBlueCount(int blueCount) {
		this.blueCount = blueCount;
	}
	public Collection<GameObject> getGameObjectCollection() {
		return gameObjectCollection;
	}
	/*
	public Collection<Projectile> getTrashCollection() {
		return trashCollection;
	}*/
	public Shooter getShooter(){
		return gameShooter;
	}
	public void setShooter(Shooter newShooter){
		gameShooter = newShooter;
	}
	/*
	public void loadProjectile(Shooter gameShooter) {

		
		
	}
	*/
	@Override
	public String toString() {
		return "\nGameState [score=" + score + ", trashCount=" + trashCount + ", mittenCount=" + mittenCount
				+ ", blueCount=" + blueCount + ", gameObjectCollection=" + gameObjectCollection + "]";
	}
	

}
