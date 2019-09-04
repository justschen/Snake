import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ship extends Rectangle{

	public int hp = 100, lives = 100;
	public static int dx = 15, dy = 15;
	BufferedImage Normal, Up, Down;
	ArrayList<Lasers> Lasers1, Lasers2, Lasers3;
	public Rectangle hitbox;
	Boolean forward = false;
	int dxx = 10, dyy = 4;
	Boolean forye = false;
	public int hpbar = 200;
	Rectangle hpbars;
	Warning warn = new Warning();
	ArrayList<particles>part;  
	int timer;
	int counters;
	ParticleHandler pH;

	public Ship() {
		Lasers1 = new ArrayList<Lasers>();
		Lasers2 = new ArrayList<Lasers>();
		Lasers3 = new ArrayList<Lasers>();
		part = new ArrayList<particles>();
		this.setSize(69, 65);
		this.setLocation(100,100);
		timer = 10;
		counters = 0;
		pH = new ParticleHandler();
		//hitbox.x = Global.xLoc;
		//hitbox.y = Global.yLoc;
		
		//this.setLocation(SnakeMain.xLoc,SnakeMain.yLoc);
		hitbox = new Rectangle(69,65,this.x,this.y);
	}
	
	public void movement(Graphics2D win, Ship ship, BossClass boss, BossDee boss1) {
		timer++;
		
		pH.moveAndDraw(win);
	
		/*
		for (particles parts2 : part) {
			parts2.moveAndDraw(win);
		}
		
		for (int j = 0; j < part.size(); j+=2) {
			particles exhaust = part.get(j);
			if (exhaust.getX() < -10) {
				part.remove(j);
				j--;
			}
		
			
		}		
		
		*/
		//this.setLocation(Global.xLoc, Global.yLoc);
		win.setColor(Color.WHITE);
		win.fillRect(6+110, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(10+110, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(10+110,670,hpbar-100, 30+20);
		win.setColor(Color.BLACK);
		
		//win.drawImage(Main.kirbyicon, null, -35, 620);
		//win.drawImage(Main.kirbyname, null, 40, 620);
		win.drawImage(SnakeMain.rayray.loop(), null, 10, 620);
		
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		
		if 	(GameDriverV4.Keys[KeyEvent.VK_S] && this.getY() < 680) {
			this.translate(0, dy);
			hitbox.translate(0, dy);
		}
		
		if 	(GameDriverV4.Keys[KeyEvent.VK_W] && this.getY() > 5) {
			this.translate(0, -dy);
			hitbox.translate(0, -dy);
			}
		 
		if (GameDriverV4.Keys[KeyEvent.VK_A] && this.getX() > 0) {
			this.translate(-dx, 0);
			hitbox.translate(-dx, 0);
		}
		
		 if (GameDriverV4.Keys[KeyEvent.VK_D] && this.getX() < 870) {
			this.translate(dx,0);
			hitbox.translate(dx, 0);
			}
		 
		 /*
		 if (GameDriverV4.Keys[KeyEvent.VK_S]) {
				
				win.drawImage(Main.sprite[2],null, (int)this.getX(), (int)this.getY());
				
			}
			
		 else if (GameDriverV4.Keys[KeyEvent.VK_W]) {
				
				win.drawImage(Main.sprite[1],null, (int)this.getX(), (int)this.getY());
				}
			 
		 else if (GameDriverV4.Keys[KeyEvent.VK_A]) {
			
				 win.drawImage(Main.sprite[0],null, (int)this.getX(), (int)this.getY());
			}
			
		 else if (GameDriverV4.Keys[KeyEvent.VK_D]) {
				
				 win.drawImage(Main.sprite[0],null, (int)this.getX(), (int)this.getY());
				}
		 */
		    
		//hitbox.setLocation(Global.xLoc, Global.yLoc);
		//this.setLocation(Global.xLoc, Global.yLoc);
		
		 for (particles parts1 : part) {
				parts1.moveAndDraw(win);
				counters++;
				
			}
		 if (counters%2==0) {
			particles part1 = new particles((int)this.getX()-40, (int)this.getY()+36);
			part.add(part1);
			
			particles part2 = new particles((int)this.getX()-40, (int)this.getY()+36);
			part.add(part2);
		 }
		 if (counters%2!=0) {
				particles part1 = new particles((int)this.getX()-40, (int)this.getY()+30);
				part.add(part1);
				
				particles part2 = new particles((int)this.getX()-40, (int)this.getY()+30);
				part.add(part2);
			 }
			
			
			for (int j = 0; j < part.size(); j+=1) {
				particles exhaust = part.get(j);
				if (exhaust.getX() < -10) {
					part.remove(j);
					j--;
				}
			
				
			}		
			
		win.drawImage(SnakeMain.raybody1right, null, this.x-34, this.y+15); 
		win.drawImage(SnakeMain.rayheadright,null, this.x, this.y);
		
		 
			for (int j = 0; j < boss.Lasers1.size(); j++) {
				Lasers bullet = boss.Lasers1.get(j);
				
				if (bullet!=null) {
					if (bullet.intersects(this)){
						boss.Lasers1.remove(j);
						j--;
						hpbar-=4;
						lives-=2;
						warn.hpflash(win);
			}			
		}
	}
	for (int j = 0; j < boss.Lasers2.size(); j+=2) {
		Lasers bullet = boss.Lasers2.get(j);
		
		if (bullet!=null) {
			if (bullet.intersects(this)){
				boss.Lasers2.remove(j);
				j--;
				hpbar-=4;
				lives-=2;
				warn.hpflash(win);
	}			
	}
	}
	
	for (int j = 0; j < boss.Lasers3.size(); j++) {
		Lasers bullet = boss.Lasers3.get(j);
		
		if (bullet!=null) {
			if (bullet.intersects(this)){
				boss.Lasers3.remove(j);
				j--;
				hpbar-=4;
				lives-=2;
				warn.hpflash(win);
	}			
	}
	}
	
	
	for (int j = 0; j < boss1.Lasers1.size(); j++) {
		Lasers bullet = boss1.Lasers1.get(j);
		
		if (bullet!=null) {
			if (bullet.intersects(this)){
				boss1.Lasers1.remove(j);
				j--;
				hpbar-=4;
				lives-=2;
				warn.hpflash(win);
	}			
}
}
for (int j = 0; j < boss1.Lasers2.size(); j+=2) {
Lasers bullet = boss1.Lasers2.get(j);

if (bullet!=null) {
	if (bullet.intersects(this)){
		boss1.Lasers2.remove(j);
		j--;
		hpbar-=4;
		lives-=2;
		warn.hpflash(win);
}			
}
}

for (int j = 0; j < boss1.Lasers3.size(); j++) {
Lasers bullet = boss1.Lasers3.get(j);

if (bullet!=null) {
	if (bullet.intersects(this)){
		boss1.Lasers3.remove(j);
		j--;
		hpbar-=4;
		lives-=2;
		warn.hpflash(win);
}			
}
}

for (int j = 0; j < boss1.Lasers4.size(); j++) {
	Lasers bullet = boss1.Lasers4.get(j);
	
	if (bullet!=null) {
		if (bullet.intersects(this)){
			boss1.Lasers4.remove(j);
			j--;
			hpbar-=4;
			lives-=2;
			warn.hpflash(win);
}			
}
}
for (int j = 0; j < boss1.Lasers5.size(); j+=2) {
Lasers bullet = boss1.Lasers5.get(j);

if (bullet!=null) {
if (bullet.intersects(this)){
	boss1.Lasers5.remove(j);
	j--;
	hpbar-=4;
	lives-=2;
	warn.hpflash(win);
}			
}
}

for (int j = 0; j < boss1.Lasers11.size(); j++) {
Lasers bullet = boss1.Lasers11.get(j);

if (bullet!=null) {
if (bullet.intersects(this)){
	boss1.Lasers11.remove(j);
	j--;
	hpbar-=4;
	lives-=2;
	warn.hpflash(win);
}			
}
}

for (int j = 0; j < boss1.Lasers22.size(); j++) {
	Lasers bullet = boss1.Lasers22.get(j);
	
	if (bullet!=null) {
		if (bullet.intersects(this)){
			boss1.Lasers22.remove(j);
			j--;
			hpbar-=4;
			lives-=2;
			warn.hpflash(win);
}			
}
}
for (int j = 0; j < boss1.Lasers33.size(); j+=2) {
Lasers bullet = boss1.Lasers33.get(j);

if (bullet!=null) {
if (bullet.intersects(this)){
	boss1.Lasers33.remove(j);
	j--;
	hpbar-=4;
	lives-=2;
	warn.hpflash(win);
}			
}
}

for (int j = 0; j < boss1.Lasers44.size(); j++) {
Lasers bullet = boss1.Lasers44.get(j);

if (bullet!=null) {
if (bullet.intersects(this)){
	boss1.Lasers44.remove(j);
	j--;
	hpbar-=4;
	lives-=2;
	warn.hpflash(win);
}			
}
}

for (int j = 0; j < boss1.Lasers55.size(); j++) {
	Lasers bullet = boss1.Lasers55.get(j);
	
	if (bullet!=null) {
		if (bullet.intersects(this)){
			boss1.Lasers55.remove(j);
			j--;
			hpbar-=4;
			lives-=2;
			warn.hpflash(win);
}			
}
}
for (int j = 0; j < boss1.Lasers6.size(); j+=2) {
Lasers bullet = boss1.Lasers6.get(j);

if (bullet!=null) {
if (bullet.intersects(this)){
	boss1.Lasers6.remove(j);
	j--;
	hpbar-=4;
	lives-=2;
	warn.hpflash(win);
}			
}
}

for (int j = 0; j < boss1.Lasers7.size(); j++) {
Lasers bullet = boss1.Lasers7.get(j);

if (bullet!=null) {
if (bullet.intersects(this)){
	boss1.Lasers7.remove(j);
	j--;
	hpbar-=4;
	lives-=2;
	warn.hpflash(win);
}			
}
}

for (int j = 0; j < boss1.Lasers66.size(); j++) {
	Lasers bullet = boss1.Lasers66.get(j);
	
	if (bullet!=null) {
		if (bullet.intersects(this)){
			boss1.Lasers66.remove(j);
			j--;
			hpbar-=4;
			lives-=2;
			warn.hpflash(win);
}			
}
}
for (int j = 0; j < boss1.Lasers77.size(); j+=2) {
Lasers bullet = boss1.Lasers77.get(j);

if (bullet!=null) {
if (bullet.intersects(this)){
	boss1.Lasers77.remove(j);
	j--;
	hpbar-=4;
	lives-=2;
	warn.hpflash(win);
}			
}
}


	
	
		
		}
	
	public void filling (Graphics2D win) {
		
		//win.fill(this);
	}
	
	public int counter = 0;
	
	public void shoot(Graphics2D win) {
		
		counter++;
		counter%=15;
	
		
		if (counter==0) {
			Lasers laze1 = new Lasers((int)this.getMaxX(), (int)this.getCenterY());
			Lasers1.add(laze1);
			Main.sounds.play(10);
		
		}
		
		for (Lasers l1 : Lasers1) {
			l1.moveAndDraw(win);
			Main.sounds.play(10);
		
		}
		
		
		if (counter==0) {
			Lasers laze2 = new Lasers((int)this.getMaxX(), (int)this.getCenterY());
			Lasers2.add(laze2);
			Main.sounds.play(10);
			
		}
		
		for (Lasers l2 : Lasers2) {
			l2.movetop(win);
			Main.sounds.play(10);
			
		}
		
		
		if (counter==0) {
			Lasers laze3 = new Lasers((int)this.getMaxX(), (int)this.getCenterY());
			Lasers3.add(laze3);
			Main.sounds.play(10);
			
		}
		
		for (Lasers l3 : Lasers3) {
			l3.movebot(win);
			Main.sounds.play(10);
		}
		
		for (int i = 0; i < Lasers1.size(); i++) {
			Lasers bullet = Lasers1.get(i);
			if (bullet.getX() > 920) {
				Lasers1.remove(i);
				
				i--;
			}
		}		
		
	
		
		for (int j = 0; j < Lasers2.size(); j++) {
			Lasers bullet = Lasers2.get(j);
			if (bullet.getX() > this.getX()+400) {
				Lasers2.remove(j);
				
				j--;
			}
		
			
		}		
		
		for (int k = 0;k < Lasers3.size(); k++) {
			Lasers bullet = Lasers3.get(k);
				if (bullet.getX() > this.getX()+400) {
					Lasers3.remove(k);
					k--;
		}
	}		
		
		
		
	
		}
	
	public void dying(Graphics2D win) {
		this.translate(-2, 1);
		win.drawImage(SnakeMain.raybody1right, null, this.x-34, this.y+15); 
		win.drawImage(SnakeMain.rayheadright,null, this.x, this.y);
		
		
	}
	
	public void victory(Graphics2D win) {
		
		particles part1 = new particles((int)this.getX()+40, (int)this.getY()+30);
		part.add(part1);
		particles part2 = new particles((int)this.getX()+40, (int)this.getY()+30);
		part.add(part2);
		
		for (particles parts1 : part) {
			parts1.moveAndDraw(win);
		}
		
		for (int j = 0; j < part.size(); j++) {
			particles exhaust = part.get(j);
			if (exhaust.getX() < -10) {
				part.remove(j);
				j--;
			}
		
			
		}		
		
		for (particles parts2 : part) {
			parts2.moveAndDraw(win);
		}
		
		for (int j = 0; j < part.size(); j++) {
			particles exhaust = part.get(j);
			if (exhaust.getX() < -10) {
				part.remove(j);
				j--;
			}
		
			
		}		
		this.translate(dxx, -dyy);
		win.setColor(Color.WHITE);
		win.fillRect(6+110, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(10+110, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(10+110,670,hpbar-100, 30+20);
		win.setColor(Color.BLACK);
		//win.drawImage(Main.kirbyicon, null, -35, 620);
		win.drawImage(SnakeMain.rayray.loop(), null, 10, 620);
		
		
		win.drawImage(SnakeMain.raybody1right, null, this.x-34, this.y+15); 
		win.drawImage(SnakeMain.rayheadright,null, this.x, this.y);
		
	
	
}
	
	public void fillhp(Graphics2D win) {
		win.setColor(Color.BLACK);
		//win.fill(hpbars);
	}
}
	
