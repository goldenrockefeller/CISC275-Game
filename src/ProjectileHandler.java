import java.awt.Graphics;
import java.util.Random;
public class ProjectileHandler extends Handler {
	
	public static Projectile projectile;
	
	public ProjectileHandler(GameScreen gameScreen, GameState gameState)
	{
		super(gameScreen, gameState);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

	}
	
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
