import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BossClass extends Rectangle{
	
	
	int movex = 675+400, movey = 400;
	static int xx = 675;
	int dx = 12, dy = 11;
	public Rectangle hitbox;
	int lives = 100;
	int hpbar = 300;
	Rectangle hp;
	public Rocket rocket;
	int attackx = 5, attacky=5;
	Boolean returnto = false;
	Boolean spinattack = false;
	ArrayList<Lasers>Lasers1, Lasers2,Lasers3;
	
	Warning warn = new Warning();

	
	public BossClass() {
		Lasers1 = new ArrayList<Lasers>();
		Lasers2 = new ArrayList<Lasers>();
		Lasers3 = new ArrayList<Lasers>();
		
		this.setSize(200,170);
		this.setLocation(movex,movey);
		hitbox = new Rectangle(movex,movey,170,140);
		
		//rocket = new Rocket(ship);
	}

	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		win.setColor(Color.WHITE);
		win.fillRect(606+160, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(610+160, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(610+160,670,hpbar-100, 30+20);
		win.setColor(Color.BLACK);
		
		win.drawImage(Main.kabulaicon, null, 610, 620);
		
		//warn.bossflash(win);
		
		if(win!=null) {
		win.setColor(Color.BLACK);
		rocket.moveAndDraw(win);
		//this.shoot2(win);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		}
	}
	
	public void return2(Graphics2D win) {
		this.translate(10, 0);
		hitbox.translate(10, 0);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		win.setColor(Color.WHITE);
		win.fillRect(606+160, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(610+160, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(610+160,670,hpbar-100, 30+20);
		win.setColor(Color.BLACK);
		
		win.drawImage(Main.kabulaicon, null, 610, 620);
		//warn.bossflash(win);
	}
	
	public void movingin(Graphics2D win) {
		this.translate(-2, -1);
		hitbox.translate(-2, -1);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		
	}
	
	public void dying(Graphics2D win) {
		this.translate(1, 2);
	}
	
	
	public void spinningattack(Graphics2D win, Ship ship) {
		win.setColor(Color.WHITE);
		win.fillRect(606+160, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(610+160, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(610+160,670,hpbar-100, 30+20);
		win.setColor(Color.BLACK);
		
		win.drawImage(Main.kabulaicon, null, 610, 620);
		
		//warn.bossflash(win);
		
		this.translate(-dx, dy);
		hitbox.translate(-dx, dy);
		//this.shoot(win);
		
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		
		if (this.intersects(ship)) {
			ship.lives--;
			ship.hpbar-=2;
			warn.hpflash(win);
		}
		
		if (this.getX() < 0) {
			dx*=-1;
			
		}
		
		if (this.getY() > 550) {
			dy*=-1;
		}
		
		if (this.getY() < 10) {
			dy*=-1;
		}
		
		if (this.getX() >670) {
			dx*=-1;
		}
		
		for (int j = 0; j < ship.Lasers1.size(); j++) {
			Lasers bullet = ship.Lasers1.get(j);
			
			if (bullet!=null) {
				if (bullet.intersects(this)){
					ship.Lasers1.remove(j);
					Main.sounds.play(1);
					j--;
					lives--;
					hpbar-=2;
					warn.bossflash(win);
		}			
	}
}
for (int j = 0; j < ship.Lasers2.size(); j++) {
	Lasers bullet = ship.Lasers2.get(j);
	
	if (bullet!=null) {
		if (bullet.intersects(this)){
			Main.sounds.play(1);
			ship.Lasers2.remove(j);
			j--;
			lives--;
			hpbar-=2;
			warn.bossflash(win);
}			
}
}
for (int j = 0; j < ship.Lasers3.size(); j++) {
	Lasers bullet = ship.Lasers3.get(j);
	
	if (bullet!=null) {
		if (bullet.intersects(this)){
			Main.sounds.play(1);
			ship.Lasers3.remove(j);
			j--;
			lives--;
			hpbar-=2;
			warn.bossflash(win);
}			
}
}
		
	}  
		
	
	
	public void returnto(Graphics2D win) {
		this.setLocation(movex,movey);
		hitbox = new Rectangle(movex+60,movey+100,170,140);
		win.setColor(Color.WHITE);
		win.fillRect(606+160, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(610+160, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(610+160,670,hpbar-100, 30+20);
		win.setColor(Color.BLACK);
		
		win.drawImage(Main.kabulaicon, null, 610, 620);
	//	warn.bossflash(win);
		
	}
	
	public void movement(Graphics2D win, Ship ship) {
		win.setColor(Color.WHITE);
		win.fillRect(606+160, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(610+160, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(610+160,670,hpbar-100, 30+20);
		win.setColor(Color.BLACK);
		
		win.drawImage(Main.kabulaicon, null, 610, 620);
		//warn.bossflash(win);
		this.translate(0, dy);
		hitbox.translate(0, dy);
		this.shoot(win);
		//rocket.moveAndDraw(win);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		
		
		if (this.getY() > 550) {
			dy*=-1;
		}
		
		if (this.getY() < 10) {
			dy*=-1;
		}
		
		
		
		if (this.intersects(ship)) {
			ship.lives--;
			ship.hpbar-=2;
			warn.hpflash(win);
		}  
		
		for (int j = 0; j < ship.Lasers1.size(); j++) {
					Lasers bullet = ship.Lasers1.get(j);
					
					if (bullet!=null) {
						if (bullet.intersects(this)){
							ship.Lasers1.remove(j);
							Main.sounds.play(1);
							j--;
							lives--;
							hpbar-=2;
							warn.bossflash(win);
				}			
			}
		}
		for (int j = 0; j < ship.Lasers2.size(); j++) {
			Lasers bullet = ship.Lasers2.get(j);
			
			if (bullet!=null) {
				if (bullet.intersects(this)){
					Main.sounds.play(1);
					ship.Lasers2.remove(j);
					j--;
					lives--;
					hpbar-=2;
					warn.bossflash(win);
		}			
	}
}
		for (int j = 0; j < ship.Lasers3.size(); j++) {
			Lasers bullet = ship.Lasers3.get(j);
			
			if (bullet!=null) {
				if (bullet.intersects(this)){
					ship.Lasers3.remove(j);
					Main.sounds.play(1);
					j--;
					lives--;
					hpbar-=2;
					warn.bossflash(win);
		}			
	}
}	
	}
	public int counter2 = 0;
	
	public void shoot(Graphics2D win) {
		counter2++;
		counter2%=30;
		
		if (counter2==0) {
			Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers1.add(laze1);
		}
		
		for (Lasers l1 : Lasers1) {
			l1.moveAndDrawboss3(win);
		}
		
		
		if (counter2==0) {
			Lasers laze2 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers2.add(laze2);
		}
		
		for (Lasers l2 : Lasers2) {
			l2.movetopboss3(win);
			
		}
		
		
		if (counter2==0) {
			Lasers laze3 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers3.add(laze3);
		}
		
		for (Lasers l3 : Lasers3) {
			l3.movebotboss3(win);
		}
		
		for (int i = 0; i < Lasers1.size(); i++) {
			Lasers bullet = Lasers1.get(i);
			if (bullet.getX() < 0) {
				Lasers1.remove(i);
				i--;
			}
		}		
	

	
	for (int j = 0; j < Lasers2.size(); j++) {
		Lasers bullet = Lasers2.get(j);
		if (bullet.getX() < 0) {
			Lasers2.remove(j);
			
			j--;
		}
	
		
	}		
	
	for (int k = 0;k < Lasers3.size(); k++) {
		Lasers bullet = Lasers3.get(k);
			if (bullet.getX() <0) {
				Lasers3.remove(k);
				k--;
	}

	
}		
	}
	
	public void shoot2(Graphics2D win) {
		counter2++;
		counter2%=30;
		
		if (counter2==0) {
			Lasers laze1 = new Lasers((int)this.getMaxX(), (int)this.getCenterY());
			Lasers1.add(laze1);
		}
		
		for (Lasers l1 : Lasers1) {
			l1.moveAndDrawboss3(win);
		}
		
		
		if (counter2==0) {
			Lasers laze2 = new Lasers((int)this.getMaxX(), (int)this.getCenterY());
			Lasers2.add(laze2);
		}
		
		for (Lasers l2 : Lasers2) {
			l2.movetopboss3(win);
			
		}
		
		
		if (counter2==0) {
			Lasers laze3 = new Lasers((int)this.getMaxX(), (int)this.getCenterY());
			Lasers3.add(laze3);
		}
		
		for (Lasers l3 : Lasers3) {
			l3.movebotboss3(win);
		}
		
		for (int i = 0; i < Lasers1.size(); i++) {
			Lasers bullet = Lasers1.get(i);
			if (bullet.getX() < 0) {
				Lasers1.remove(i);
				i--;
			}
		}		
	

	
	for (int j = 0; j < Lasers2.size(); j++) {
		Lasers bullet = Lasers2.get(j);
		if (bullet.getX() < 0) {
			Lasers2.remove(j);
			
			j--;
		}
	
		
	}		
	
	for (int k = 0;k < Lasers3.size(); k++) {
		Lasers bullet = Lasers3.get(k);
			if (bullet.getX() <0) {
				Lasers3.remove(k);
				k--;
	}

	
}		
	}
	
}
		
		
	
	

	
	

