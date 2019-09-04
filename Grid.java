import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Grid extends Rectangle {

	public Grid(int x, int y) {
		this.setLocation(x, y);
		this.setSize(30, 30);

	}

	public void draw(Graphics2D win) {
		win.setColor(Color.BLACK);
		win.draw(this);
	}

}
