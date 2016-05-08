import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static java.lang.System.out;

public class powerbarHandler extends Handler implements ActionListener, KeyListener {

	JButton testButton;
	boolean red = true;
	int  length=32;
	boolean direction = true;
	public powerbarHandler(GameScreen gameScreen, GameState gameState) {
		
		super(gameScreen,gameState);
		
		//adds a button to game
//		testButton = new JButton("Click me");
//		overallGame.add(testButton,BorderLayout.SOUTH);
//		overallGame.validate();
//		overallGame.repaint();
//		
//		testButton.addActionListener(this);
		gameScreen.addKeyListener(this);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void  paint(Graphics g)
	{
		for (GameObject gameObject : getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof powerbarObject)
			{	
				if (length>=80){
				g.setColor(Color.RED);
				}
				else if (length >=45){
					g.setColor(Color.YELLOW);
				}else {
					g.setColor(Color.GREEN);
				}
				//if (!stopflag)
					powerbar();
				g.fillRect(scaleX(gameObject.getxPosition()),scaleY(gameObject.getyPosition()),length*Launcher.WIDTH/1000,32*Launcher.HEIGHT/1000);
				
			}if (gameObject instanceof powerbarFrame)
			{
				g.setColor(Color.BLACK);
				
				g.fillRect(scaleX(gameObject.getxPosition()),scaleY(gameObject.getyPosition()),105*Launcher.WIDTH/1000,36*Launcher.HEIGHT/1000);
				
			}

		}
	}
	
	private void powerbar(){
		
		if (direction){
			length = getGameState().getShooter().getPowerBar().getPowerFluc();
		}
	}
	
	
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		red = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("pb keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}