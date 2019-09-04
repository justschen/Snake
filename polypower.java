import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class polypower extends Polygon{
	
	int dx, dy;
	int timer, delay;
	
	public polypower() {	
		dx = 7;
		dy = 7;
		timer = 0;
		delay = 600;
		int xpoints[] = {1,3,4,5,7,5,6,4,2,3};
		int ypoints[] = {3,3,1,3,3,4,6,5,6,4};
		for (int i = 0; i <xpoints.length; i++) {
			this.addPoint(10*xpoints[i],10*ypoints[i]);
		}
		
	}	
	
	public void moveAndDraw(Graphics2D win) {
		win.setColor(Color.YELLOW);
		
		this.translate(dx, dy);
		win.fillPolygon(this);
	
		
		if (this.getBounds().getY() >= 730 || this.getBounds().getY() <= 0) {
			dy*=-1;
		}
		
		if (this.getBounds().getX() >= 900 || this.getBounds().getX() <= 0) {
			dx*=-1;
		}
		
		for (int i = 0; i <xpoints.length; i++) {
			
		}
	}
}
