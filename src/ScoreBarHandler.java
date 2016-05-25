import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ScoreBarHandler extends Handler {
	/**
	 * Image handling for the scoreboard.
	 */
	int BlueCrabScore = gameState.getBlueCount(); //score based on the amount of blue crabs
	int TrashScore = gameState.getTrashCount(); //score based on trash

	int red; // RGB color for score bar
	int green; // RGB color for score bar
	int blue; // RGB color for score bar
	int b = -2;
	int prescoreA = 250; // the length of the score bar
	int prescoreB = 250;// the length of the score bar
	int countB = 0; //the value for counting right reducing score animation
	int countA = 0; //the value for counting left reducing score animation
	int temp; //temple value for left side score bar for X position and length
	int missreduce; // animation of reducing of score

	int missreducetemp;// temple value store the number of reduce animation
	int win; // check if it is winning
	int lose; // check if it is end of the game

	int bluecrabcount; // the number of blue crab on screen
	int bluecrabdisplaycount; //counting the blue crab display text time
	int mittencrabcount;// the number of mitten crab on screen
	int mittencrabdisplaycount;//counting the mitten crab display text time

	int trashmisscount;// the number of trash missed
	int trashmissdisplaycount;//counting the trash missed display text time
	int trashincount;// the number of trash on screen
	int trashindisplaycount;//counting the trash display text time
	/**
	 * initial the number of object on screen 
	 * 
	 */
	ScoreBarHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen, gameState);
		bluecrabcount = 1;
		mittencrabcount = 1;
		trashmisscount = 0;
		trashincount = 0;

	}

	/**
	 * Draw food in transit if visible If it hits a crab, it will disappear and
	 * replicate the crab
	 */
	@Override
	public void paint(Graphics g) {
		// System.out.println("blue"+gameState.getBlueCount());
		// System.out.println("trash"+gameState.getTrashCount());
		// System.out.println("bluedisplay"+BlueCrabScore);
		// System.out.println("miss"+gameState.gettrashMissed());
		// change();
		///////////////////////////// background
		g.setColor(Color.RED);
		g.setFont(new Font("Tahoma", Font.BOLD,
				(int) (16 * Math.min(GameScreen.WIDTH / 1920.0, (GameScreen.HEIGHT / 1080.0)))));
		g.drawString("Blue Crab", (int) ((950 - 260) * GameScreen.WIDTH / 1920.0),
				(int) ((25 - 11) * GameScreen.HEIGHT / 1080.0));

		g.drawString("Trash", (int) ((950 + 230) * GameScreen.WIDTH / 1920.0),
				(int) ((25 - 11) * GameScreen.HEIGHT / 1080.0));
		g.setColor(Color.BLACK);
		g.fillRect((int) ((950 - 292) * GameScreen.WIDTH / 1920.0), (int) ((25 - 2) * GameScreen.HEIGHT / 1080.0),
				(int) ((250 + 250 + 43 + 40) * GameScreen.WIDTH / 1920.0), (int) (35 * GameScreen.HEIGHT / 1080.0));
		g.setColor(Color.BLACK);
		g.drawRect((int) ((950 - 292) * GameScreen.WIDTH / 1920.0), (int) ((25 - 2) * GameScreen.HEIGHT / 1080.0),
				(int) ((250 + 250 + 43 + 40) * GameScreen.WIDTH / 1920.0), (int) (35 * GameScreen.HEIGHT / 1080.0));

		/////////////////////////////////////

		// left side score bar.

		g.setColor(Color.RED);
		MissReduce();

		temp = ReduceL(250 - gameState.getMittenCount() * 10) - missreduce;
		lose = 250 - gameState.getMittenCount() * 10 + gameState.getBlueCount() * 20 - missreduce;
		g.fillRect((int) ((950 - 290 + 250 - temp) * GameScreen.WIDTH / 1920.0),
				(int) (25 * GameScreen.HEIGHT / 1080.0), (int) ((temp) * GameScreen.WIDTH / 1920.0),
				(int) (32 * GameScreen.HEIGHT / 1080.0));
		warning(lose);
		g.setColor(new Color(red, green, blue));

		g.fillRect(
				(int) ((950 - 290 + gameState.getMittenCount() * 10 + missreduce - gameState.getBlueCount() * 20)
						* GameScreen.WIDTH / 1920.0),
						(int) (25 * GameScreen.HEIGHT / 1080.0), (int) ((lose) * GameScreen.WIDTH / 1920.0),
						(int) (32 * GameScreen.HEIGHT / 1080.0));

		// right side score bar.

		g.setColor(Color.RED);
		g.fillRect((int) ((825 + 40 * GameScreen.WIDTH / 1920.0)), (int) (25 * GameScreen.HEIGHT / 1080.0),
				(int) (ReduceR(250 - gameState.getTrashCount() * 30) * GameScreen.WIDTH / 1920.0),
				(int) (32 * GameScreen.HEIGHT / 1080.0)); // 32);

		g.setColor(Color.YELLOW);
		win = 250 - gameState.getTrashCount() * 30;
		g.fillRect((int) ((950 + 40) * GameScreen.WIDTH / 1920.0), (int) (25 * GameScreen.HEIGHT / 1080.0),
				(int) ((win) * GameScreen.WIDTH / 1920.0), (int) (32 * GameScreen.HEIGHT / 1080.0));// gameState.getBlueCount()*10,

		/////////////////////////////////// K.O.
		g.setColor(Color.BLACK);
		g.fillRect((int) ((950 - 40) * GameScreen.WIDTH / 1920.0), 0, (int) (80 * GameScreen.WIDTH / 1920.0),
				(int) (80 * GameScreen.HEIGHT / 1080.0));
		g.setColor(Color.WHITE);
		g.draw3DRect((int) ((950 - 40) * GameScreen.WIDTH / 1920.0), (int) 0, (int) (80 * GameScreen.WIDTH / 1920.0),
				(int) (80 * GameScreen.HEIGHT / 1080.0), true);
		g.setFont(new Font("Tahoma", Font.BOLD,
				(int) (32 * Math.min(GameScreen.WIDTH / 1920.0, GameScreen.HEIGHT / 1080.0))));
		g.setColor(Color.RED);
		g.drawString("K.O.", (int) ((950 - 30) * GameScreen.WIDTH / 1920.0),
				(int) ((25 + 25) * GameScreen.HEIGHT / 1080.0));
		/////////////////////////////////
		g.setColor(Color.RED);
		g.setFont(new Font("Tahoma", Font.BOLD,
				(int) (24 * Math.min(GameScreen.WIDTH / 1920.0, GameScreen.HEIGHT / 1080.0))));

		if (gameState.getMessages().indexOf('m') >= 0) {
			mittencrabcount += 1;
			mittencrabdisplaycount = 100;
		} else if (mittencrabdisplaycount > 0) {
			mittencrabdisplaycount--;
			if (trashmissdisplaycount == 0 && bluecrabdisplaycount == 0 && trashindisplaycount == 0) {
				g.drawString("Don't feed the Mitten Crabs. They're an invasive species!",
						(int) ((950 + 230) * GameScreen.WIDTH / 1920.0),
						(int) ((25 + 60) * GameScreen.HEIGHT / 1080.0));
			}
		}

		if (gameState.getMessages().indexOf('b') >= 0) {
			bluecrabcount += 1;
			bluecrabdisplaycount = 100;
		} else if (bluecrabdisplaycount > 0) {
			bluecrabdisplaycount--;
			if (trashmissdisplaycount == 0 && mittencrabdisplaycount == 0 && trashindisplaycount == 0) {
				g.drawString("You Fed A Blue Claw Crab. Great Job!", (int) ((950 - 260) * GameScreen.WIDTH / 1920.0),
						(int) ((25 + 60) * GameScreen.HEIGHT / 1080.0));
			}
		}
		if (gameState.getMessages().indexOf('t') >= 0) {
			trashincount += 1;
			trashindisplaycount = 100;
		} else if (trashindisplaycount > 0) {
			trashindisplaycount--;
			if (bluecrabdisplaycount == 0 && mittencrabdisplaycount == 0 && trashmissdisplaycount == 0) {
				g.drawString("Nice Shot!", (int) ((950 + 240) * GameScreen.WIDTH / 1920.0),
						(int) ((25 + 90) * GameScreen.HEIGHT / 1080.0));
			}
		}
		if (gameState.getMessages().indexOf('T') >= 0) {
			trashmisscount += 1;

			trashmissdisplaycount = 100;
		} else if (trashmissdisplaycount > 0) {
			trashmissdisplaycount--;
			if (bluecrabdisplaycount == 0 && mittencrabdisplaycount == 0 && trashindisplaycount == 0) {
				g.drawString("Throw Trash In The Trash Can!", (int) ((950 - 330) * GameScreen.WIDTH / 1920.0),
						(int) ((25 + 75) * GameScreen.HEIGHT / 1080.0));
			}
		}

		/////////////////////////////////// checking if the game ends and wins

		if (win <= 0) {
			gameState.setiswin(true);
			gameState.setisend(true);
		}
		if (lose <= 0) {
			gameState.setisend(true);
			gameState.setiswin(false);
		}
	}
	/**
	 * change colors to alert player the score is low, the game is losing.
	 * @param a
	 */
	public void warning(int a) {

		if (a < 50) {
			red = 255;

			blue = 0;
			if (green <= 10) {
				b = 10;
			} else if (green >= 245) {
				b = -10;
			}
			green = green + b;
		} else {
			red = green = 255;
			blue = 0;
		}

	}
	/**
	 * reduces the score of the right bar
	 * @param a, a value used in determining how much score is reduced
	 * @return
	 */
	public int ReduceR(int a) {
		if (a < prescoreB) {
			countB++;
			if (countB > 20) {
				countB = 0;
				prescoreB--;
			}
			return prescoreB;

		}
		prescoreB = a;
		return 0;
	}
	/**
	 * reduces the score of the LEFT bar
	 * @param a, a value used in determining how much score is reduced
	 * @return
	 */
	public int ReduceL(int a) {
		if (a < prescoreA) {
			countA++;
			if (countA > 20) {
				countA = 0;
				prescoreA--;
			}
			return prescoreA;

		}
		prescoreA = a;
		return prescoreA;
	}
	/**
	 * Showing score reduction for missing
	 */
	public void MissReduce() {
		int number = 200;
		missreducetemp = missreducetemp + gameState.gettrashMissed();

		if (missreducetemp > number) {
			missreducetemp = 0;
			missreduce++;

		}

	}
}

