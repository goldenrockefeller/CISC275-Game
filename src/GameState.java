import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.*;

public class GameState {
	/**
	 * Gamestate is the main class for our model.  All of our gameobjects are combined
	 * here to form the current gamestate.
	 */
	
	int score; //player's score
	int trashCount; //amount of trash on screen
	int mittenCount; //amount of mitten crabs on screen
	int blueCount; // amount of blue crabs on screen
	int trashMissed;
	int totalTrash;
	boolean isend;
	boolean iswin;
	//Shooter gameShooter;
	//TO DO need to have this in Launcher
	
	//frame size of overall game
	final static int frameWidth = 1000;
    final static int frameHeight = 1000;
    //linked list for all the game objects in play
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
			 //not a gameObject, so I didn't use updateState
		settrashMissed();
	}
	/**
	 * add to namesake value based on parameter
	 * @param value to be added
	 */
	public void addtotalTrash(int a){
		totalTrash=totalTrash+a;
	}
	public void addtrashMissed(int a){
		trashMissed=trashMissed+a;
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
	/**
	 * removes the game object and sets it to null
	 * @param gameObject to be removed
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
	/**
	 * getter for Score
	 * @return the player's Score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * setter for Score
	 * @param score the player's score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * getter for Trashcount
	 * @return trashCount
	 */
	public int getTrashCount() {
		return trashCount;
	}
	/**
	 * setter for Trashcount
	 * @param trashCount
	 */
	public void setTrashCount(int trashCount) {
		this.trashCount = trashCount;
	}
	/**
	 * getter for Trashcount
	 * @return trashCount
	 */
	public int gettotalTrash() {
		return totalTrash;
	}
	/**
	 * setter for totalTrash
	 * @param totalTrash
	 */
	public void settotalTrash(int totalTrash) {
		this.totalTrash = totalTrash;
	}
	/**
	 * getter for MittenCount
	 * @return mittenCount
	 */
	public int getMittenCount() {
		return mittenCount;
	}
	/**
	 * setter for MittenCount
	 * @param mittenCount
	 */
	public void setMittenCount(int mittenCount) {
		this.mittenCount = mittenCount;
	}
	/**
	 * getter for BlueCount
	 * @return blueCount
	 */
	public int getBlueCount() {
		return blueCount;
	}
	/**
	 * setter for number of  trash on ground
	 * @param settrashMissd
	 */
	public void settrashMissed(){
		trashMissed=0;
		for (GameObject gameObject : new ArrayList<GameObject>(getGameObjectCollection()))
		{
			if (gameObject instanceof Trash)
			{	
				Projectile proj = (Projectile)gameObject;
				if (proj.getZ() == 0)
				{
					trashMissed++;
				}
				
			}
	
		}
	}
	/**
	 * getter for number of trash on ground
	 * @return settrashMissd
	 */
	public int gettrashMissed(){

		return trashMissed;
	}
	/**
	 * setter for BlueCount
	 * @param blueCount
	 */
	public void setBlueCount(int blueCount) {
		this.blueCount = blueCount;
	}
	/**
	 * getter for gameObjectCollection
	 * @return gameObjectCollection
	 */
	public Collection<GameObject> getGameObjectCollection() {
		return gameObjectCollection;
	}
	public void setiswin(boolean a){
		iswin=a;
	}
	public void setisend(boolean a){
		isend=a;
	}
	/*
	public Collection<Projectile> getTrashCollection() {
		return trashCollection;
	}*/
	/*
	public void loadProjectile(Shooter gameShooter) {

		
		
	}
	*/
	/**
	 * tostring for the Game state
	 */
	@Override
	public String toString() {
		return "\nGameState [score=" + score + ", trashCount=" + trashCount + ", mittenCount=" + mittenCount
				+ ", blueCount=" + blueCount + ", gameObjectCollection=" + gameObjectCollection + "]";
	}
}
