import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import java.awt.event.*;
import javax.swing.*;

public class GameScreen extends JPanel{
	
	/**
	 * this class puts the game's handlers in a collection to help implement them.
	 * This acts as the main class for our view.
	 */
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) screenSize.getWidth();
	public static final int HEIGHT = (int) screenSize.getHeight();
    private Collection<Handler> handlerCollection;
    private static final long serialVersionUID = 1L;
    /*
     * ImageBank contains a set of Sprite Set
     * SpriteSets contains a list of all Image Sets for a GameObject
     * Image Sets contains a list of Images for an animation of a GameObject
     *
     */
    /**
     * by default, Opaque and Focusable are true and Background should be gray
     */
    public GameScreen()
    {
    	super();
    	this.setBackground(Color.GRAY);
    	this.setOpaque(true);
    	this.setFocusable(true);
		this.handlerCollection = new LinkedList<Handler>();
    }
    
	/**
	 * adds Handler to the collection
	 * @param handler
	 */
	public void add(Handler handler)
	{
		handlerCollection.add(handler);
	}
	
	/*
	 * What to do while in the start screen
	 */
	/**
	 * paints the handlers in the collection
	 * @param g the graphics used
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (Handler handler : handlerCollection )
		{
			handler.paint(g);
		}		
	}
	/**
	 * a getter for the handler collection
	 * @return the collection of handlers
	 */
	public Collection<Handler> getHandlerCollection() {
		return handlerCollection;
	}

	/**
	 * @param handlerCollection the handlerCollection to set
	 */
	public void setHandlerCollection(Collection<Handler> handlerCollection) {
		this.handlerCollection = handlerCollection;
	}
	
}
