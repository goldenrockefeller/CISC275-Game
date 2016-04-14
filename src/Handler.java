
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.lang.*;

import javax.imageio.ImageIO;

public class Handler {

	private OverallGame overallGame;

	Handler(OverallGame overallGame)
	{
		this.overallGame = overallGame;
	}
	
	public void paint(Graphics g)
	{
		
	}

	public OverallGame getOverallGame() {
		return overallGame;
	}



}
