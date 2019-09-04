import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

public class NME extends Rectangle {

	int dx, dy;
	int type, type2;
	double theta = 0;
	double dtheta = 2 * Math.PI / 90;
	double theta2 = Math.PI;
	double ddtheta = Math.PI / 50;
	Color c;
	Boolean startPath = false;
	int lives = 3;
	Particle[] particle;
	ArrayList<Lasers> Lasers1;
	int counter = 0;

	public NME() {
		Random r = new Random();
		type = 0;
		// type2 = r.nextInt(2);
		this.setSize(40, 40);
		Lasers1 = new ArrayList<Lasers>();

		if (type == 0) {
			c = Color.BLACK;
			int yLoc = r.nextInt(500) + 100;
			this.setLocation(1000, yLoc);
			dx = -7;
		}

	}

	public void reset(Graphics2D win) {
		Random r = new Random();
		int yLoc = r.nextInt(500) + 100;
		this.setLocation(1000, yLoc);
	}

	public void move(Graphics2D win) {
		Random r1 = new Random();
		int random = r1.nextInt(500) + 100;
		if (GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}

		if (startPath == false && this.getX() < 1300 && type == 1) {
			startPath = true;
		}

		else if (startPath == true) {
			Point center = new Point(900, 350);
			int radius = 250;
			this.theta2 -= this.ddtheta;
			int yLoc = (int) (center.y - radius * Math.sin(this.theta2));
			int xLoc = (int) (center.x - radius * Math.cos(this.theta2));
			this.setLocation(xLoc, yLoc);

		}

		this.translate(dx, 0);

		if (type == 0) {
			// win.drawImage(Main.spikes, null, this.x, this.y);
			AffineTransform tran = win.getTransform();
			theta += dtheta;
			win.rotate(theta, this.getCenterX(), this.getCenterY());
			win.setColor(c);
			win.drawImage(SnakeMain.crash.loop(), null, this.x-20, this.y-20);

			win.setTransform(tran);
		}
	}
}
