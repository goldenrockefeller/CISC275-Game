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
	public static final int arrowWidth = 50;
	public static final int arrowHeight = 140;
	int degrees;
	int xSpeed;
	int ySpeed;
	
	BufferedImage arrow_image;
	Image powerbar_image;
	
	ShooterHandler(GameScreen gameScreen,GameState gameState) {
		super(gameScreen,gameState);
		// TODO Auto-generated constructor stub
		try{
			arrow_image = ImageIO.read(new File("img/arrow.png"));
			powerbar_image = ImageIO.read(new File("img/powerbar.png"));
		}
		catch(IOException e)
		{
			System.out.println("Arrow Image not found");
		}
		gameScreen.addKeyListener(this);
	}

	public void paint(Graphics g) {
		GameState game = getGameState();
		Shooter gameShooter = getGameState().getShooter();
		
		PowerBar pb = gameShooter.getPowerBar();
		Arrow a = gameShooter.getArrow();
		
		// rotate arrow - NEEDS TESTING -----------------------------------------------------
		double rotation_needed = 260;
		double locationX = (double) arrowWidth / 2;
		double locationY = (double) arrowHeight / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotation_needed, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		
		BufferedImage temp = op.createCompatibleDestImage(arrow_image, null);
		temp = op.filter(temp, null);
		arrow_image = temp;
		
		g.drawImage(arrow_image, (int)a.xPosition, (int)a.yPosition, Color.gray, null);
		
		g.drawImage(powerbar_image, (int)pb.xPosition, (int)pb.yPosition, new Color(0, 0, 0, 0), null);
	}
	
	public void calculateTrajectory(Shooter gameShooter) {
		degrees = gameShooter.getArrow().getDirection();
		xSpeed = (int) Math.toDegrees(Math.cos(degrees))/10;
		ySpeed = -5;
		System.out.println("xSpeed is " + xSpeed + " ySpeed is " + ySpeed);
		gameState.add(new TestObject(480,700,xSpeed,ySpeed,gameState));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if("Space" == KeyEvent.getKeyText(e.getKeyCode())){
			Shooter gameShooter = getGameState().getShooter();
			if(gameShooter.getFlag()){
				gameShooter.getArrow().setDirection();
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

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
