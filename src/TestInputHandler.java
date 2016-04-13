
import java.awt.Graphics;
import java.awt.Color;
import static java.lang.System.out;

public class TestInputHandler extends InputHandler {

	public TestInputHandler(OverallGame overallGame) {
		super(overallGame);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void  paint(Graphics g)
	{
		for (GameObject gameObject : getOverallGame().getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof TestObject)
			{
				if (gameObject.getObjectState()  == 0)
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
		out.println("This was not supposed to happen");
	}

}
