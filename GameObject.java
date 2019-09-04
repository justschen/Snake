import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameObject extends Rectangle {

	Color col;
	int dx, dy;

	public GameObject(int x, int y, int width, int height, int dx, int dy, Color col) {
		super(x, y, width, height);
		this.col = col;
		this.dx = dx;
		this.dy = dy;
	}

	public void moveAndDraw(Graphics2D win) {
		// TODO Auto-generated method stub

		this.translate(dx, dy);
		win.setColor(col);
		// win.fill(this);
	}

}
