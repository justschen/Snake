import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Particle extends Rectangle {
	
	double dx;
	double dy;
	double dblX;
	double dblY;
	
	int width;
	int height;
	int fill;
	
	
	Color col;

	public Particle(int x, int y, int width, int height, double dy, double dx, Color col) {
		

		this.dx = dx;
		this.dy = dy;
		this.col = col;
		this.dblX = x;
		this.dblY = y;
		this.width = width;
		this.height = height;
		
		
		this.setSize(width, height);
	}
	
	public void moveAndDraw(Graphics2D win) {
		
		this.dblX += dx;
		this.dblY += dy;
		 
		this.setLocation((int)dblX, (int)dblY);
		
		win.setColor(Color.RED);
			win.fill(this);
			win.fillOval((int)dblX, (int)dblY, this.width, this.height);
			win.setColor(Color.BLACK);
			win.fillOval((int)dblX + 3, (int)dblY + 3, this.width - 6, this.height - 6);
	
		
	}
	
}

