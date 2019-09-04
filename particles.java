import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class particles extends Rectangle {
	
	
	
	double gravity;
	double dx;
	double dy;
	int timer = 0;
	int delay = 10;
	Random r1 = new Random();
	double dtheta = Math.PI/75;
	double theta;
	Random rand;
	double dblX;
	double dblY;

	public particles(int x, int y) {
		rand = new Random();
		gravity = 0;
		this.setSize(7,7);
		this.setLocation(x,y);
		//dx = -20;
		//dy = 0;
		//dx = 10*(r1.nextDouble() - 2);
		//dy = 0;
		
	}
	
	public void moveAndDraw(Graphics2D win) {
		win.drawImage(SnakeMain.raybody2left, null, this.x, this.y);
		
		dx = -15;
		dy = 0;
		this.translate((int)dx,  (int)dy);
		win.setColor(Color.GREEN);
		//win.fill(this);
		
	}
	
	public void circle(Graphics2D win) {
		win.setColor(Color.RED);
		if (timer > delay) {
			timer = 0;
		}
		if (timer == 0) {
			for (int i = 0; i <40; i++) {
				double pdx = (3*Math.sin((i*Math.PI/18)+theta));
				double pdy = (3*Math.cos((i*Math.PI/18)+theta));
				x+=pdx;
				y+=pdy;
				this.setLocation((int)x, (int)y);
				
			}
			theta+=dtheta;
		}
		timer++;
		win.fill(this);
	}
}

