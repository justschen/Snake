import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bomb extends Rectangle {
	int x, y;

	public Bomb(int xLoc, int yLoc) {
		this.x = xLoc;
		this.y = yLoc;
		this.setLocation(x, y);
		this.setSize(20, 20);

	}

	public void dropthebomb(Graphics2D win) {
		win.setColor(Color.WHITE);
		// win.fill(this);
		win.drawImage(SnakeMain.ball, null, this.x - 7, this.y - 8);
	}

}
