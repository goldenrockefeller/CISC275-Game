
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static java.lang.System.out;

public class TestInputHandler extends InputHandler implements ActionListener {

	JButton testButton;
	boolean red = true;
	
	public TestInputHandler(OverallGame overallGame) {
		
		super(overallGame);
		testButton = new JButton("Click me");
		overallGame.add(testButton,BorderLayout.SOUTH);
		overallGame.validate();
		overallGame.repaint();
		

		testButton.addActionListener(this);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void  paint(Graphics g)
	{
		for (GameObject gameObject : getOverallGame().getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof TestObject)
			{
				if (red)
				{
					g.setColor(Color.RED);
				}
				else
				{
					g.setColor(Color.BLUE);
				}
				g.fillOval((int)gameObject.getxPosition(),(int)gameObject.getyPosition(),32,32);
			}
		}
	}
	
	public void update()
	{
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		red = !red;
	}

}
