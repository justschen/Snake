import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BossDee extends Rectangle{
	
	
	int movex = 675+700, movey = 400;
	static int xx = 675;
	int dx = 9, dy = 9;
	public Rectangle hitbox;
	int lives = 100;
	int hp = 300;
	Rectangle hpbox;
	public Rocket rocket;
	int attackx = 5, attacky=5;
	
	Boolean returnto = false;
	Boolean spinattack = false;
	Warning warn = new Warning();
	ArrayList<Lasers>Lasers1, Lasers2,Lasers3,Lasers4, Lasers5, Lasers6, Lasers7, Lasers8, Lasers9;
	ArrayList<Lasers>Lasers11, Lasers22,Lasers33,Lasers44, Lasers55, Lasers66, Lasers77, Lasers88, Lasers99;
	ArrayList<particles>part;
	
	ParticleHandler pH;
	
	public BossDee() {
		
		Lasers1 = new ArrayList<Lasers>();
		Lasers2 = new ArrayList<Lasers>();
		Lasers3 = new ArrayList<Lasers>();
		Lasers4 = new ArrayList<Lasers>();
		Lasers5 = new ArrayList<Lasers>();
		Lasers6 = new ArrayList<Lasers>();
		Lasers7= new ArrayList<Lasers>();
		Lasers8 = new ArrayList<Lasers>();
		Lasers9 = new ArrayList<Lasers>();
		Lasers11 = new ArrayList<Lasers>();
		Lasers22 = new ArrayList<Lasers>();
		Lasers33 = new ArrayList<Lasers>();
		Lasers44 = new ArrayList<Lasers>();
		Lasers55 = new ArrayList<Lasers>();
		Lasers66 = new ArrayList<Lasers>();
		Lasers77= new ArrayList<Lasers>();
		Lasers88 = new ArrayList<Lasers>();
		Lasers99 = new ArrayList<Lasers>();
		this.setSize(200,204);
		this.setLocation(movex,movey);
		part = new ArrayList<particles>();
		hitbox = new Rectangle(movex+60,movey+100,170,140);
		pH = new ParticleHandler();
		//rocket = new Rocket(ship);
	}

	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		win.setColor(Color.WHITE);
		win.fillRect(606+160, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(610+160, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(610+160,670,hp-100, 30+20);
		win.setColor(Color.BLACK);
		
		
		//win.drawImage(SnakeMain.deosprite.loop(), null, 600, 620);
		if(win!=null) {
		win.setColor(Color.BLACK);
		
		
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(hitbox);
		}
		
		}
		
		//rocket.moveAndDraw(win);	 
	}
	
	public void return2(Graphics2D win) {
		win.setColor(Color.WHITE);
		win.fillRect(606+160, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(610+160, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(610+160,670,hp-100, 30+20);
		win.setColor(Color.BLACK);
		
		//win.drawImage(SnakeMain.deosprite.loop(), null, 600, 620);
		this.translate(10, 0);
		hitbox.translate(10, 0);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(hitbox);
		}
	}
	
	public void movingin(Graphics2D win) {
		this.translate(-2, -1);
		hitbox.translate(-2, -1);
		
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(hitbox);
		}
		
	}
	
	public void dying(Graphics2D win) {
		this.translate(1, 2);
	}
	
	
	public void spinningattack(Graphics2D win, Ship ship) {
		shoot(win);
		this.translate(-dx, dy);
		hitbox.translate(-dx, dy);
		win.setColor(Color.WHITE);
		win.fillRect(606+160, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(610+160, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(610+160,670,hp-100, 30+20);
		win.setColor(Color.BLACK);
		
		//win.drawImage(SnakeMain.deosprite.loop(), null, 600, 620);
		
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(hitbox);
		}
		
		if (this.intersects(ship)) {
			ship.lives--;
			ship.hpbar-=2;
			warn.hpflash(win);
		}
		
		if (this.getX() < 0) {
			dx*=-1;
			
		}
		
		if (this.getY() > 450) {
			dy*=-1;
		}
		
		if (this.getY() < -10) {
			dy*=-1;
		}
		
		if (this.getX() >670) {
			dx*=-1;
		}
		
		for (int j = 0; j < ship.Lasers1.size(); j++) {
			Lasers bullet = ship.Lasers1.get(j);
			
			if (bullet!=null) {
				if (bullet.intersects(this)){
					Main.sounds.play(1);
					ship.Lasers1.remove(j);
					j--;
					lives--;
					hp-=2;
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
			hp-=2;
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
			hp-=2;
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
		win.fillRect(610+160,670,hp-100, 30+20);
		win.setColor(Color.BLACK);
		
	//	win.drawImage(SnakeMain.deosprite.loop(), null, 600, 620);
		
	}
	
	public void movement(Graphics2D win, Ship ship) {
		this.translate(0, dy);
		hitbox.translate(0, dy);
		win.setColor(Color.WHITE);
		win.fillRect(606+160, 665, 208, 40+20);
		win.setColor(Color.BLACK);
		win.fillRect(610+160, 670, 200, 30+20);
		win.setColor(Color.BLUE);
		win.fillRect(610+160,670,hp-100, 30+20);
		win.setColor(Color.BLACK);
		
	//	win.drawImage(SnakeMain.deosprite.loop(), null, 600, 620);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(hitbox);
		}
		
		
		if (this.getY() > 450) {
			dy*=-1;
		}
		
		if (this.getY() < -10) {
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
							Main.sounds.play(1);
							ship.Lasers1.remove(j);
							j--;
							lives--;
							hp-=2;
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
					hp-=2;
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
					hp-=2;
					warn.bossflash(win);
		}			
	}
}	
		win.setColor(Color.RED);
		pH.circle(win, (int)this.getX(), (int)this.getY());
		
	}
	
	
	public int counter2 = 0;
	
	public void shoot(Graphics2D win) {
		counter2++;
		counter2%=30;
		
		
		//1
		if (counter2==0) {
			Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers1.add(laze1);
		}
		
		for (Lasers l1 : Lasers1) {
			l1.moveAndDrawboss3(win);
		}
		
		//2
		if (counter2==0) {
			Lasers laze2 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers2.add(laze2);
		}
		
		for (Lasers l2 : Lasers2) {
			l2.movetopboss3(win);
			
		}
		
		//3
		if (counter2==0) {
			Lasers laze3 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers3.add(laze3);
		}
		
		for (Lasers l3 : Lasers3) {
			l3.movebotboss3(win);
		}
		//4
		if (counter2==0) {
			Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers4.add(laze1);
		}
		
		for (Lasers l1 : Lasers4) {
			l1.moveAndDrawboss1(win);
		}
		//5
		if (counter2==0) {
			Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers5.add(laze1);
		}
		
		for (Lasers l1 : Lasers5) {
			l1.movetopboss1(win);
		}
		//6
		if (counter2==0) {
			Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers6.add(laze1);
		}
		
		for (Lasers l1 : Lasers6) {
			l1.movebotboss1(win);
		}
		//7
		if (counter2==0) {
			Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers7.add(laze1);
		}
		
		for (Lasers l1 : Lasers7) {
			l1.moveAndDrawboss2(win);
		}
		//8
		if (counter2==0) {
			Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers8.add(laze1);
		}
		
		for (Lasers l1 : Lasers8) {
			l1.movetopboss2(win);
		}
		//9
		
		if (counter2==0) {
			Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
			Lasers9.add(laze1);
		}
		
		for (Lasers l1 : Lasers9) {
			l1.movebotboss2(win);
		}
		
		for (int i = 0; i < Lasers1.size(); i++) {
			Lasers bullet = Lasers1.get(i);
			if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
				Lasers1.remove(i);
				i--;
			}
		}		
	

	
	for (int j = 0; j < Lasers2.size(); j++) {
		Lasers bullet = Lasers2.get(j);
		if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
			Lasers2.remove(j);
			
			j--;
		}
	
		
	}		
	
	for (int k = 0;k < Lasers3.size(); k++) {
		Lasers bullet = Lasers3.get(k);
		if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
				Lasers3.remove(k);
				k--;
	}

			
	
}	
	for (int k = 0;k < Lasers4.size(); k++) {
		Lasers bullet = Lasers4.get(k);
		if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
				Lasers4.remove(k);
				k--;
	}

			
	
}	
	
	for (int k = 0;k < Lasers5.size(); k++) {
		Lasers bullet = Lasers5.get(k);
		if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
				Lasers5.remove(k);
				k--;
	}

			
	
}	
	
	for (int k = 0;k < Lasers6.size(); k++) {
		Lasers bullet = Lasers6.get(k);
		if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
				Lasers6.remove(k);
				k--;
	}

			
	
}	
	
	for (int k = 0;k < Lasers7.size(); k++) {
		Lasers bullet = Lasers7.get(k);
		if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
				Lasers7.remove(k);
				k--;
	}

			
	
}	
	
	for (int k = 0;k < Lasers8.size(); k++) {
		Lasers bullet = Lasers8.get(k);
		if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
				Lasers8.remove(k);
				k--;
	}

			
	
}	
	
	for (int k = 0;k < Lasers9.size(); k++) {
		Lasers bullet = Lasers9.get(k);
			if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
				Lasers9.remove(k);
				k--;
	}

			
	
}	
	if (counter2==0) {
		Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
		Lasers11.add(laze1);
	}
	
	for (Lasers l1 : Lasers11) {
		l1.moveAndDrawboss4(win);
	}
	
	//2
	if (counter2==0) {
		Lasers laze2 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
		Lasers22.add(laze2);
	}
	
	for (Lasers l2 : Lasers22) {
		l2.movetopboss4(win);
		
	}
	
	//3
	if (counter2==0) {
		Lasers laze3 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
		Lasers33.add(laze3);
	}
	
	for (Lasers l3 : Lasers33) {
		l3.movebotboss4(win);
	}
	//4
	if (counter2==0) {
		Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
		Lasers44.add(laze1);
	}
	
	for (Lasers l1 : Lasers4) {
		l1.moveAndDrawboss5(win);
	}
	//5
	if (counter2==0) {
		Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
		Lasers5.add(laze1);
	}
	
	for (Lasers l1 : Lasers5) {
		l1.movetopboss5(win);
	}
	//6
	if (counter2==0) {
		Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
		Lasers66.add(laze1);
	}
	
	for (Lasers l1 : Lasers66) {
		l1.movebotboss5(win);
	}
	//7
	if (counter2==0) {
		Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
		Lasers77.add(laze1);
	}
	
	for (Lasers l1 : Lasers77) {
		l1.moveAndDrawboss6(win);
	}
	//8
	if (counter2==0) {
		Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
		Lasers88.add(laze1);
	}
	
	for (Lasers l1 : Lasers88) {
		l1.movetopboss6(win);
	}
	//9
	
	if (counter2==0) {
		Lasers laze1 = new Lasers((int)this.getMaxX()-180, (int)this.getCenterY()+100);
		Lasers99.add(laze1);
	}
	
	for (Lasers l1 : Lasers99) {
		l1.movebotboss6(win);
	}
	
	for (int i = 0; i < Lasers11.size(); i++) {
		Lasers bullet = Lasers11.get(i);
		if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
			Lasers11.remove(i);
			i--;
		}
	}		



for (int j = 0; j < Lasers22.size(); j++) {
	Lasers bullet = Lasers22.get(j);
	if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
		Lasers22.remove(j);
		
		j--;
	}

	
}		

for (int k = 0;k < Lasers33.size(); k++) {
	Lasers bullet = Lasers33.get(k);
	if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
			Lasers33.remove(k);
			k--;
}

		

}	
for (int k = 0;k < Lasers44.size(); k++) {
	Lasers bullet = Lasers44.get(k);
	if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
			Lasers44.remove(k);
			k--;
}

		

}	

for (int k = 0;k < Lasers55.size(); k++) {
	Lasers bullet = Lasers55.get(k);
	if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
			Lasers55.remove(k);
			k--;
}

		

}	

for (int k = 0;k < Lasers66.size(); k++) {
	Lasers bullet = Lasers66.get(k);
	if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
			Lasers66.remove(k);
			k--;
}

		

}	

for (int k = 0;k < Lasers77.size(); k++) {
	Lasers bullet = Lasers77.get(k);
	if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
			Lasers77.remove(k);
			k--;
}

		

}	

for (int k = 0;k < Lasers88.size(); k++) {
	Lasers bullet = Lasers88.get(k);
	if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
			Lasers88.remove(k);
			k--;
}

		

}	

for (int k = 0;k < Lasers99.size(); k++) {
	Lasers bullet = Lasers99.get(k);
		if (bullet.getX() <0 || bullet.getY() >1300 || bullet.getY()<0) {
			Lasers99.remove(k);
			k--;
}

		

}	

	
	
	}
}
		