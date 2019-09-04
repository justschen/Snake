import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Food extends GameObject {

	Random random;
	int foodlocx, foodlocy, newx, newy;

	public Food() {
		super(0, 0, 20, 20, 0, 0, Color.WHITE);
		Random rand = new Random();
		int xLoc = rand.nextInt(24) * 30 + 7;
		int yLoc = rand.nextInt(23) * 30 + 7;

		this.setLocation(xLoc, yLoc);
	}

	public void moveAndDraw(Graphics2D win) {

		if (SnakeMain.onix == true) {
			if (SnakeMain.bodycounter < 5) {
				win.drawImage(SnakeMain.foodgeodude, null, this.x - 20, this.y - 20);
			}
			if (SnakeMain.bodycounter >= 5) {
				win.drawImage(SnakeMain.foodgolem, null, this.x - 20, this.y - 10);
			}
		}

		if (SnakeMain.gyra == true) {
			if (SnakeMain.bodycounter < 5) {
				win.drawImage(SnakeMain.foodhorsea, null, this.x - 15, this.y - 15);
			}
			if (SnakeMain.bodycounter >= 5) {
				win.drawImage(SnakeMain.foodmagikarp, null, this.x - 12, this.y - 15);
			}

		}

		if (SnakeMain.ray == true) {
			win.fill(this);
		}
	}

	public void enemymove(Graphics2D win) {

		win.drawImage(SnakeMain.ball, null, this.x - 7, this.y - 8);
		win.setColor(Color.WHITE);
		// win.fill(this);
	}

}
