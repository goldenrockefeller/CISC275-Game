import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class GameState implements java.io.Serializable {
	private static final long serialVersionUID = 1L;//used for Serializable
	
	/**
	 * Gamestate is the main class for our model.  All of our gameobjects are combined
	 * here to form the current gamestate.
	 */
	
	int score; //player's score
	int trashCount; //amount of trash on screen
	int mittenCount; //amount of mitten crabs on screen
	int blueCount; // amount of blue crabs on screen
	int trashMissed; //amount of trash that was thrown but didn't get into a can
	int totalTrash; //total trash thrown
	String messages; //used for project information about the game state changes to the world

	boolean isend; //is true if the game is over
	boolean iswin; //is true if the player has "won"
	boolean startover; //is true if the game needs to restart
	//Shooter gameShooter;
	//TO DO need to have this in Launcher
	
	//frame size of overall game
	final static int frameWidth = 1000;
    final static int frameHeight = 1000;
    //linked list for all the game objects in play
	Collection<GameObject> gameObjectCollection;
	
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
	 * Constructor. Sets default value for game stats.
	 */
	public GameState()
	{
		isend = false;
		iswin = false;
		totalTrash = 0;
		trashMissed = 0;
		messages = "";
		blueCount = 0;
		mittenCount = 0;
		trashCount = 0;
		score = 0;
		startover = false;
		gameObjectCollection = new LinkedList<GameObject>();
	}
	
	/**
	 * sets the game state stats to be the same as the initial constructor's
	 */
	public void reset()
	{
		isend = false;
		iswin = false;
		totalTrash = 0;
		trashMissed = 0;
		messages = "";
		blueCount = 0;
		mittenCount = 0;
		trashCount = 0;
		score = 0;
		gameObjectCollection = new LinkedList<GameObject>();
	}
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
		messages = "";
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
	
	public void addMessage(String info)
	{
		messages += info;
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
		gameObject.finish();
		gameObject.setGameState(null);
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
	 * @return the messages
	 */
	public String getMessages() {
		return messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(String messages) {
		this.messages = messages;
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
	
	/**
	 * setter for iswin
	 * @param a the new value of iswin
	 */
	public void setiswin(boolean a){
		iswin=a;
	}

	/**
	 * setter for isend
	 * @param a the new value of isend
	 */
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
	
	
	
	/**
	 * Method to serialize OverallGame, which contains the other games as params
	 * So this output will contain the serialized version of every object
	 * @param obj
	 * @param fileName
	 * @exception Throws an error if file name isn't found
	 * @see java.io.Serializable
	 */
	public static void serialize(Object obj, String fileName) {
		try {
	        FileOutputStream fos = new FileOutputStream(fileName);
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(obj);
	        fos.close();
		}
		catch (IOException e) {
			System.out.println("Read Error: " + e.getMessage());
		}
	}
	
	/**
	 * Method to read a game state from file and instantiate it. The reverse of the serialize function
	 * @param fileName
	 * @returns the deserialized object
	 * @exception Throws an exception if file name isn't found
	 * @exception Throws an exception if the class isn't found
	 */
	public static Object deserialize(String fileName) {
		GameState obj = null ;
		try {	
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			obj = (GameState)ois.readObject();
			ois.close();
		}
		catch(IOException e) {
			System.out.println("Read Error: " + e.getMessage());
		}
		catch (ClassNotFoundException e){
			System.out.println("Read Error: " + e.getMessage());
		}
		return obj;
	}
}
