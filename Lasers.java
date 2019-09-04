import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Lasers extends Rectangle{


	int dx = 30;
	Rectangle HPBAR;
	int livesbar = 100;

	//int delay = 50, timer = 0;
	

	public Lasers(int x, int y) {
		this.setSize(20,20);
		this.setLocation(x, y);
	}
	
	public void moveAndDraw(Graphics2D win) {
		//timer++;
		this.translate(dx, 0);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		//Main.sounds.play(10);
		
		win.drawImage(Main.midshot.loop(), null, this.x, this.y);
		if (this.intersects(new BossClass().hitbox)) {
			new BossClass( ).lives--;
			
		}
	}
	
	public void movebot (Graphics2D win) {
		this.translate(dx, 12);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		//Main.sounds.play(10);
		
		win.drawImage(Main.botshot.loop(), null, this.x, this.y);
		if (this.intersects(new BossClass().hitbox)) {
			new BossClass().lives--;
			
		}
	}
	
	public void movetop(Graphics2D win) {
		this.translate(dx, -12);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		//Main.sounds.play(10);
		win.drawImage(Main.topshot.loop(), null, this.x, this.y);
		if (this.intersects(new BossClass().hitbox)) {
			new BossClass().lives--;
			
		}
	}
	
	public void nmegun(Graphics2D win) {
		this.translate(-10, 0);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		win.drawImage(Main.waddleshot, null, this.x, this.y);
		
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
		}
		
		
	}
	
	public void nme3gun(Graphics2D win) {
		this.translate(-10, 0);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
			win.drawImage(Main.shockbeam, null, this.x, this.y);
		
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
		}
		
	}

	public void movebotboss1 (Graphics2D win) {
		this.translate(-15, 12);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void movetopboss1(Graphics2D win) {
		this.translate(-15, -12);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void moveAndDrawboss1(Graphics2D win) {
		//timer++;
		this.translate(-15, -24);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().lives--;
			
		}
	}
	
	public void movebotboss2 (Graphics2D win) {
		this.translate(-15, 24);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void movetopboss2(Graphics2D win) {
		this.translate(-15, 36);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void moveAndDrawboss2(Graphics2D win) {
		//timer++;
		this.translate(-15, -36);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().lives--;
			
		}
	}
	
	public void movebotboss3 (Graphics2D win) {
		this.translate(-15, 6);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void movetopboss3(Graphics2D win) {
		this.translate(-15, -6);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void moveAndDrawboss3(Graphics2D win) {
		//timer++;
		this.translate(-15, 0);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().lives--;
			
		}
	}
	
	public void movebotboss4 (Graphics2D win) {
		this.translate(15, 12);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void movetopboss4(Graphics2D win) {
		this.translate(15, -12);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void moveAndDrawboss4(Graphics2D win) {
		//timer++;
		this.translate(15, -24);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().lives--;
			
		}
	}
	
	public void movebotboss5 (Graphics2D win) {
		this.translate(15, 24);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void movetopboss5(Graphics2D win) {
		this.translate(15, 36);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void moveAndDrawboss5(Graphics2D win) {
		//timer++;
		this.translate(15, -36);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().lives--;
			
		}
	}
	
	public void movebotboss6 (Graphics2D win) {
		this.translate(15, 6);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void movetopboss6(Graphics2D win) {
		this.translate(15, -6);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().hp--;
			
		}
	}
	
	public void moveAndDrawboss6(Graphics2D win) {
		//timer++;
		this.translate(15, 0);
		win.setColor(Color.RED);
		if 	(GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			win.fill(this);
		}
		
		win.drawImage(Main.canon, null, this.x, this.y);
		if (this.intersects(new Ship().hitbox)) {
			new Ship().lives--;
			
		}
	}
	
}
