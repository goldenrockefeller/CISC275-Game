import java.awt.Graphics;
import java.util.Random;
public class ProjectileHandler extends Handler {
	//the projectile being handled
	public static Projectile projectile;
	/**
	 * Constructor
	 * @param gameScreen
	 * @param gameState
	 */
	public ProjectileHandler(GameScreen gameScreen, GameState gameState)
	{
		super(gameScreen, gameState);
	}
	/**
	 * paints projectile on screen
	 * @param g, graphics used
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

	}
	/**
	 * generates a new projectile. Type is based on a Random number generator
	 */
	public void generateProjectile()
	{
		if (Math.random() < .5) {
			projectile = new Food(480,700,0,0,gameState);
		}
		else {
			projectile = new Trash(480,700,0,0,gameState);
		}
		gameState.add(projectile);
	}

}
