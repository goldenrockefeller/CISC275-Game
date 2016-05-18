import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScoreBarHandler extends Handler {
	int BlueCarbScore = gameState.getBlueCount();
	int TrashScore = gameState.getTrashCount();

	int red;
	int green;
	int blue;
	int b = -2;
	int prescoreA = 250;
	int prescoreB = 250;
	int countB = 0;
	int countA = 0;
	int temp;
	int missreduce;

	int missreducetemp;
	int win;
	int lose;
	int mittencrabcount;
	int mittencrabdisplaycount;
	int bluecrabcount;

	int bluecrabdisplaycount;
	int trashmisscount;
	int trashmissdisplaycount;
	int trashincount;
	int trashindisplaycount;

	ScoreBarHandler(GameScreen gameScreen, GameState gameState) {
		super(gameScreen, gameState);

	}

	/**
	 * Draw food in transit if visible If it hits a crab, it will disappear and
	 * replicate the crab
	 */
	@Override
	public void paint(Graphics g) {
		// System.out.println("blue"+gameState.getBlueCount());
		// System.out.println("trash"+gameState.getTrashCount());
		// System.out.println("bluedisplay"+BlueCarbScore);
		// System.out.println("miss"+gameState.gettrashMissed());
		// change();
		for (GameObject gameObject : getGameState().getGameObjectCollection()) {

			if (gameObject instanceof ScoreBar) {
				///////////////////////////// background
				g.setColor(Color.RED);
				g.setFont(new Font("Tahoma", Font.BOLD, 16));
				g.drawString("BlueCarb", (int) gameObject.getxPosition() - 260, (int) gameObject.getyPosition() - 11);
				g.drawString("Trash", (int) gameObject.getxPosition() + 230, (int) gameObject.getyPosition() - 11);
				g.setColor(Color.BLACK);
				g.fillRect((int) gameObject.getxPosition() - 292, (int) gameObject.getyPosition() - 2,
						250 + 250 + 43 + 40, 35);
				g.setColor(Color.BLACK);
				g.drawRect((int) gameObject.getxPosition() - 292, (int) gameObject.getyPosition() - 2,
						250 + 250 + 43 + 40, 35);

				/////////////////////////////////////

				// left side score bar.

				g.setColor(Color.RED);
				MissReduce();

				temp = ReduceL(250 - gameState.getMittenCount() * 10) - missreduce;
				lose = 250 - gameState.getMittenCount() * 10 + gameState.getBlueCount() * 20 - missreduce;
				g.fillRect((int) gameObject.getxPosition() - 290 + 250 - temp, (int) gameObject.getyPosition(), temp,
						32);
				warning(lose);
				g.setColor(new Color(red, green, blue));

				g.fillRect((int) gameObject.getxPosition() - 290 + gameState.getMittenCount() * 10 + missreduce
						- gameState.getBlueCount() * 20, (int) gameObject.getyPosition(), lose, 32);

				// right side score bar.
				g.setColor(Color.RED);
				g.fillRect((int) gameObject.getxPosition() + 40, (int) gameObject.getyPosition(),
						ReduceR(250 - gameState.getTrashCount() * 30), 32);

				g.setColor(Color.YELLOW);
				win = 250 - gameState.getTrashCount() * 30;
				g.fillRect((int) gameObject.getxPosition() + 40, (int) gameObject.getyPosition(), win, 32);// gameState.getBlueCount()*10,
																											// 32);

				/////////////////////////////////// K.O.
				g.setColor(Color.BLACK);
				g.fillRect((int) gameObject.getxPosition() - 40, (int) gameObject.getyPosition() - 25, 80, 80);
				g.setColor(Color.WHITE);
				g.draw3DRect((int) gameObject.getxPosition() - 40, (int) gameObject.getyPosition() - 25, 80, 80, true);
				g.setFont(new Font("Tahoma", Font.BOLD, 32));
				g.setColor(Color.RED);
				g.drawString("K.O.", (int) gameObject.getxPosition() - 30, (int) gameObject.getyPosition() + 25);
				/////////////////////////////////
				g.setColor(Color.RED);
				g.setFont(new Font("Tahoma", Font.BOLD, 24));
				if (gameState.getMittenCount() > mittencrabcount) {
					mittencrabcount = gameState.getMittenCount();
					mittencrabdisplaycount = 100;
				} else if (mittencrabdisplaycount > 0) {
					mittencrabdisplaycount--;
					if (trashmissdisplaycount == 0 && bluecrabdisplaycount == 0 && trashindisplaycount == 0) {
						g.drawString("Don't feed the Mitten Crabs. They're an invasive species!", (int) gameObject.getxPosition() + 230,
								(int) gameObject.getyPosition() + 60);
					}
				}

				if (gameState.getBlueCount() > bluecrabcount) {
					bluecrabcount = gameState.getBlueCount();
					bluecrabdisplaycount = 100;
				} else if (bluecrabdisplaycount > 0) {
					bluecrabdisplaycount--;
					if (trashmissdisplaycount == 0 && mittencrabdisplaycount == 0 && trashindisplaycount == 0) {
						g.drawString("You Fed A Blue Claw Crab. Great Job!", (int) gameObject.getxPosition() - 260,
								(int) gameObject.getyPosition() + 60);
					}
				}
				if (gameState.gettrashMissed() > trashmisscount) {
					trashmisscount = gameState.gettrashMissed();
					trashmissdisplaycount = 200;
				} else if (trashmissdisplaycount > 0) {
					trashmissdisplaycount--;
					if (bluecrabdisplaycount == 0 && mittencrabdisplaycount == 0 && trashindisplaycount == 0) {
						g.drawString("Throw Trash In The Trash Can!", (int) gameObject.getxPosition() - 330,
								(int) gameObject.getyPosition() + 75);
					}
				}
				if (gameState.getTrashCount() > trashincount) {
					trashincount = gameState.getTrashCount();
					trashindisplaycount = 100;
				} else if (trashindisplaycount > 0) {
					trashindisplaycount--;
					if (bluecrabdisplaycount == 0 && mittencrabdisplaycount == 0 && trashmissdisplaycount == 0) {
						g.drawString("Nice Shot!", (int) gameObject.getxPosition() + 240,
								(int) gameObject.getyPosition() + 90);
					}
				}

				///////////////////////////////////

			}
		}
		if (win <= 0) {
			gameState.setiswin(true);
			gameState.setisend(true);
		}
		if (lose <= 0) {
			gameState.setisend(true);
			gameState.setiswin(false);
		}
	}

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

	public void MissReduce() {
		int number = 50;
		missreducetemp = missreducetemp + gameState.gettrashMissed();

		if (missreducetemp > number) {
			missreducetemp = 0;
			missreduce++;

		}

	}
}
