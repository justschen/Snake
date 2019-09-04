import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class BouncingPower extends Rectangle {

	int dx, dy;
	Color col = Color.BLACK;
	Boolean isalive;
	int xx;
	Random rand;

	public BouncingPower() {
		this.setSize(20, 20);
		//xx = rand.nextInt(500);
		this.setLocation(300, 0);
		isalive = true;
		dx = 7;
		dy = 7;
	}

	public void moveAndDraw(Graphics2D win) {
		win.setColor(col);
		win.drawImage(SnakeMain.rarecandy, null, this.x,this.y);
		this.translate(dx, dy);

		if (this.getX() < 0 || this.getX() > 760) {

			dx *= -1;

		}
		if (this.getY() < 0 || this.getY() > 750) {

			dy *= -1;

		}

	}

}
