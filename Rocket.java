import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class Rocket extends Rectangle{
	Color col = Color.GREEN;
	BossClass boss;
	Ship ship;
	Boolean isReleased = false;
	int speed = 7;
	Boolean isalive = true;
	Warning warn = new Warning();
	
	
	public Rocket(BossClass boss, Ship ship) {
		this.boss = boss;
		this.ship = ship;
		this.setSize(100,50);
		this.followBoss();
		
	}
	
	public void followBoss() {
		int xLoc = (int)boss.getCenterX() +50 - this.width/2;
		int yLoc = (int)boss.getCenterY()+50-this.height/2;
		this.setLocation(xLoc, yLoc);
	}
	
	public void rotateit(Graphics2D win) {
		
		
		
		double deltaX = this.getCenterX() - ship.getCenterX();
		double deltaY = this.getCenterY() - ship.getCenterY();
		
		double angle = Math.atan2(deltaY,deltaX);
		
		AffineTransform tran = win.getTransform();
		win.rotate(angle, this.getCenterX(), this.getCenterY());
		win.setColor(col);
		if (isalive) {
			if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
				win.fill(this);
			}
			win.drawImage(Main.rocket.loop(), null, this.x,this.y);
			
		}
		
		win.setTransform(tran);
	}
	
	public void moveAndDraw(Graphics2D win) {
		
		//this.followBoss();
		if (boss.lives!=100 && boss.lives%5 == 0) {
			this.isReleased = true;
		}
			double deltaX = this.getCenterX() - ship.getCenterX();
			double deltaY = this.getCenterY() - ship.getCenterY();
			
			double angle = Math.atan2(deltaY, deltaX);
			int dy  = (int) (-speed*Math.sin(angle));
			int dx = (int) (-speed*Math.cos(angle));
			
			
			if (!this.isReleased) {
				this.followBoss();
				
			}
			
			else {
				this.translate(dx, dy);
		}

		if (this.intersects(ship)) {
			ship.lives-=10;
			ship.hpbar-=20;
			warn.hpflash(win);
			this.isReleased = false;
			int XLoc = (int)boss.getCenterX() +50 - this.width/2;
			int YLoc = (int)boss.getCenterY()+50-this.height/2;
			this.setLocation(XLoc, YLoc);
	}
		this.rotateit(win);
	}
	
	
}
