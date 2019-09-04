import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Laser extends Rectangle {

	int x, y;
	int dx, dy;
	public static Boolean alive;
	Boolean left, right, up, down;

	public Laser(int xLoc, int yLoc) {
		
		dx = 5;
		dy = 5;
		this.x = xLoc;
		this.y = yLoc;
		this.setLocation(x, y);
		this.setSize(30,30);
		alive = true;
	}

	public void shoot(Graphics2D win) {
		
		this.translate(dx, dy);
		
		if (Head.up == true) {
			dy=10;
			dx=0;
		}
		
		else if (Head.down == true) {
			dy=-10;
			dx=0;
		}
		
		else if (Head.left == true) {
			dx=10;
			dy=0;
		}
		
		else if (Head.right == true) {
			dx=-10;
			dy=0;
		}
			win.setColor(Color.WHITE);
			win.drawImage(SnakeMain.masterball, null, (int) this.getX(), (int)this.getY());
	}
}
