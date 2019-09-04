import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;


public class Enemy extends Rectangle {
	
	int dx, dy;
	int type;
	Color col;
	
	double theta = 0;
	double dtheta = 2 * Math.PI / 90;
	
	double theta2 = Math.PI;
	double dtheta2 = Math.PI / 50;
	
	boolean startPath = false;
	
	public Enemy(){
		
		
		Random r1 = new Random ();
		type = r1.nextInt(2);
		
		this.setSize(25,25);
		
		if(type == 0){
		col = Color.MAGENTA;
		int yLoc = r1.nextInt(500) + 100;
		this.setLocation(1000,yLoc);
		dx = 7;
		}
		
		else{
			col = Color.GREEN;
			this.setLocation(1000, this.width);
			dx = 7;
		}
		
		
	}
	
	public void moveAndDraw(Graphics2D win){
		
		if(this.getX() < 0){
			this.setLocation(100, this.y);
		}
		
		if(!startPath && this.getX() < 500 && type == 0){
			startPath = true;
			
			
		} else if (startPath){
			Point center = new Point(600, 350);
			int radius = 200;
			
			this.theta2 += dtheta2;
			
			int yLoc = (int)(center.y + radius * Math.sin(this.theta2));
			int xLoc = (int)(center.x + radius * Math.cos(this.theta2));
			
			this.setLocation(xLoc, yLoc);
		}else{
			this.translate(-dx,0);
		}
			
			
		
		this.translate(-dx, 0);
		
		AffineTransform tran = win.getTransform();
		
		theta += dtheta;
				
		win.rotate(theta, this.getCenterX(), this.getCenterY());
		
		win.setColor(col);
		win.fill(this);
		
		win.setTransform(tran);
		
	}
	
}
