import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
	
public class ShooterHandler extends Handler implements KeyListener {
	public static final int arrowWidth = 230;
	public static final int arrowHeight = 249;
	//starting x and y values for projectile
	
	public static final int projectileStartingX = 490;
	public static final int projectileStartingY = 860;
	//x and y values for speed
	double xSpeed; 
	double ySpeed;
	int degrees;
	int power;
	int randProj;	
	int delay = 0;
	Food tempf;
	Trash tempt;
	
	//projectile, arrow's image, powerbar's image, and shooter to be associated with this handler
	
	Projectile projectile;
	BufferedImage arrow_image;
	Shooter gameShooter;
	
	boolean firstclick; // This ignores the first space click.  We do this because the first
						 // space click removes the start screen
	/**
	 * Constructor. Should throw exception if images cannot be read
	 * @param gameScreen
	 * @param gameState
	 * @param gameShooter
	 */
	ShooterHandler(GameScreen gameScreen,GameState gameState, Shooter gameShooter) {
		super(gameScreen,gameState);
		// TODO Auto-generated constructor stub
		try{
			arrow_image = ImageIO.read(new File("img/colored_arrow.png"));
		}
		catch(IOException e)
		{
			System.out.println("Arrow Image not found");
		}
		gameScreen.addKeyListener(this);
		projectile = generateProjectile();
		this.gameShooter = gameShooter;
		firstclick = true;
	}
	
	/**
	 * This function takes the current power in the power bar and will create a 
	 * new arrow reflecting the current power and direction
	 */
	private BufferedImage colorArrow(BufferedImage img, int curr_power){
		int width = img.getWidth();
		int height = img.getHeight();
		
		// Clone the arrow Image
		BufferedImage new_img = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
	    Graphics g = new_img.getGraphics();
	    g.drawImage(img, 0, 0, null);
	    g.dispose();
		 
	    // Change the arrow image based on current power
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				final int color = img.getRGB(x, y);
				final int red = (color & 0x00ff0000) >> 16;
				final int green = (color & 0x0000ff00) >> 8;
				final int blue = color & 0x000000ff;

				if(y < 122 - curr_power && !(red == 0 && green == 0 && blue == 0) && 
						!(red == 255 && green == 255 && blue == 255)){
					new_img.setRGB(x, y, 0xffffffff);
				}
			}
		}
		return new_img;
	}

	/**
	 * paints image on screen
	 * @param g, graphics used
	 */
	public void paint(Graphics g) {
		gameShooter.update();
		//GameState game = getGameState();
		
		PowerBar pb = gameShooter.getPowerBar();
		Arrow a = gameShooter.getArrow();
		
		// Create new arrow based off powerbar
		
		BufferedImage new_arrow = colorArrow(arrow_image, pb.getPowerFluc());
		
		// ROTATE ARROW 
        
		double rotation_needed = Math.toRadians(90 - a.getDirectFluc());
		double locationX = (double) arrowWidth / 2;
		double locationY = (double) arrowHeight / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotation_needed, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		
		BufferedImage new_image = op.filter(new_arrow, null);
		
		g.drawImage(new_image, (int)a.getxPosition(), (int)a.getyPosition(), new Color(0, 0, 0, 0), null);
		
		//Generate new projectile only when the current projectile has stopped
		if (projectile.getGameState() != getGameState() ||
				(projectile.getSpeed() == 0 &&
			!(projectile.getxPosition() == projectileStartingX &&
			projectile.getyPosition() == projectileStartingY)))
		{
			if (projectile instanceof Trash)
			{
				if (projectile.getSpeed() == 0){
					gameState.addMessage("T");
				}
			}
			projectile = generateProjectile();
		}
		
	}

	/**
	 * Fetch angle and power of shot
	 * Use trig functions to set xSpeed and ySpeed
	 * If power is less than half, trash will not make it to trash, leaves it on board (does not affect food)
	 * If trash, add to trash collection. Need to keep track of those that are still on the board
	 * Rest arrow movement
	 * @param gameShooter
	 */
	public void calculateTrajectory(Shooter gameShooter) {
		degrees = gameShooter.getArrow().getDirection();
		power = gameShooter.getPowerBar().getPower();
		
		xSpeed = 7.2 * (Math.cos(Math.toRadians(degrees)));
		ySpeed = - 7.2 *(Math.sin(Math.toRadians(degrees)));
		
		projectile.setVelocity(xSpeed, ySpeed);
		int timeOfFlight = power ;
		projectile.setZ(Math.max(30,timeOfFlight));
		/*
		
		if (projectile instanceof Trash && power < 50) {
			projectile.setEnd((int) (400 + Math.random()*200));
		}
		*/
		
		/*if (projectile instanceof Trash) {
			gameState.addTrash(projectile);
		}*/
		
		gameShooter.getArrow().setStop();
	}
	/**
	 * key event for key typed
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	/**
	 * key event for key pressed, which ensures firstclick is set to false
	 * then sets direction, flags, and values according to the circumstance of the click
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(firstclick == true){
			firstclick = false;
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			// Do not control shooter when the projectile is in motion

			System.out.println(projectile);
			if ((projectile.getxPosition() == projectileStartingX && projectile.getyPosition() == projectileStartingY))
			{
				
				if(gameShooter.getFlag()){
					gameShooter.getArrow().setDirection();
					gameShooter.getArrow().setStop();
					gameShooter.changeFlag();

				}
				else{
					gameShooter.getPowerBar().setPower();
					System.out.print("Fired at: " + gameShooter.getPowerBar().getPower() + " power ");
					System.out.println("in direction " + gameShooter.getArrow().getDirection() + "!");

					calculateTrajectory(gameShooter);

					gameShooter.changeFlag();
					gameShooter.setDefault();
				}
			}
		}
	}
	/**
	 * generates a new projectile based on a random number generator to determine type
	 * @return a new projectile
	 */
	public Projectile generateProjectile()
	{
		Projectile proj;
		if (Math.random() < .5) {
			proj = new Food(projectileStartingX,projectileStartingY,0,0,gameState);
		}
		else {
			proj = new Trash(projectileStartingX,projectileStartingY,0,0,gameState);
		}
		gameState.add(proj);
		return proj;
	}
	/**
	 * key event for key being released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}
}