import java.awt.image.BufferStrategy;
import java.util.*;

public class GameState {
	int score;
	int trashCount;
	int mittenCount;
	int blueCount;
	Shooter gameShooter;
	//TO DO need to have this in Launcher
	final static int frameWidth = 1000;
    final static int frameHeight = 1000;
	Collection<GameObject> gameObjectCollection = new LinkedList<GameObject>();
	Collection<Projectile> trashCollection = new LinkedList<Projectile>();
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
<<<<<<< HEAD
=======
		//If first projectile, or food that has been eaten, or trash that has stopped, load the next projectile
		if (projectile == null || !projectile.isVisible || projectile.stopped) {
			loadProjectile(gameShooter);
		}
		projectile.updatePosition();
		projectile.updateState();
		for (Projectile trash : trashCollection) 
		{
			trash.updatePosition();
			trash.updateState();
		}
>>>>>>> b185d154ef978fd2c23ec9364369c26dd2965d56
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
	public void addTrash(Projectile projectile)
	{
		this.trashCollection.add(projectile);
	}
	public void remove(GameObject gameObject)
	{
		this.gameObjectCollection.remove(gameObject);
	}
	public void removeTrash(Trash trash)
	{
		this.trashCollection.remove(trash);
	}
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
	public Collection<Projectile> getTrashCollection() {
		return trashCollection;
	}
	public Shooter getShooter(){
		return gameShooter;
	}
	public void setShooter(Shooter newShooter){
		gameShooter = newShooter;
	}
	
	public void loadProjectile(Shooter gameShooter) {
		int randProj = (int) (Math.random()*10);
		
		if (randProj < 5) {
			setProjectile(new Food(480,700,0,0,this));
		}
		//A comment
		else {
			setProjectile(new Trash(480,700,0,0,this));
		}
		
		
	}
	
	@Override
	public String toString() {
		return "\nGameState [score=" + score + ", trashCount=" + trashCount + ", mittenCount=" + mittenCount
				+ ", blueCount=" + blueCount + ", gameObjectCollection=" + gameObjectCollection + "]";
	}
	

}
