import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

public class NME2 extends Rectangle {

	int dx, dy;
	int type, type2;
	double theta = 0;
	double dtheta = 2*Math.PI/90;
	double theta2 = Math.PI;
	double ddtheta = Math.PI/50;
	Color c;
	Boolean startPath = false;
	int lives = 3;
	Particle[] particle;
	static ArrayList<Lasers> Laserz;
	int counter = 0;
	Warning warn;
	
	
	
	public NME2() {
		Random r = new Random();
		warn = new Warning();
		type = 1;
		//type2 = r.nextInt(2);
		this.setSize(40,40);
		Laserz = new ArrayList<Lasers>();
	
		c = Color.MAGENTA;
		int yLoc = r.nextInt(500)+100;
		this.setLocation(1000,yLoc);			
		dx = -4;
		//Lasersz = new ArrayList<Lasers>();
			
	}	
	
	public void reset(Graphics2D win) {
		Random r = new Random();
		int yLoc = r.nextInt(500)+100;
		this.setLocation(1000,yLoc);
	}
	
	public void move(Graphics2D win, Ship ship) {
		Random r1 = new Random();
		int random = r1.nextInt(500)+100;
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		
		if (startPath == false && this.getX() < 1300 && type ==1) {
			startPath = true;
		} 
		
		else if (startPath == true){
			Point center = new Point(1250,350);
			int radius = 250;
			this.theta2 -= this.ddtheta;
			int yLoc = (int) (center.y - radius*Math.sin(this.theta2));
			int xLoc = (int) (center.x -  radius*Math.cos(this.theta2));
			this.setLocation(xLoc, yLoc);
		}
			
		this.translate(dx, 0);
		
		
	
			
			win.drawImage(SnakeMain.circle1.loop(), null, this.x, this.y);
		
		

			counter++;
			counter%=20;
			
			if (counter==0) {
				Lasers laze1 = new Lasers((int)this.getMaxX(), (int)this.getCenterY());
				Laserz.add(laze1);
			}
			
			for (Lasers l1 : Laserz) {
			
				l1.nmegun(win);
			
			}
			
			for (int j = 0; j < Laserz.size(); j++) {
				Lasers bullets = Laserz.get(j);
				
				if (bullets!=null) {
					if (bullets.intersects(ship)){
						Laserz.remove(j);
						j--;
						ship.lives--;
						ship.hpbar-=2;
						warn.hpflash(win);
			}			
		}

		
		}
		
		
	}

	
}
