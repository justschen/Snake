import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Stars extends Rectangle{

	int width, height = width;
	int x,y;
	public int starsdx;
	int delay = 120, timer = delay;
	Color col;
	Random rand;
	int c;
	
	public Stars() {
		rand = new Random();
		width = rand.nextInt(10)+1;
		x = rand.nextInt(1000) + rand.nextInt(900);
		y = rand.nextInt(830); 
		starsdx = rand.nextInt(50)+1;
		c = rand.nextInt(155)+100;
		this.setLocation(x,y);
		this.setSize(width, width);
		col = new Color (c,c,c);	
		
	}
	
	public void moveAndDraw(Graphics2D win) {
		
		if (timer<delay) {
			starsdx = 2*rand.nextInt(50)+1;
			timer++;	
		}
		
		else {
			starsdx = rand.nextInt(50)+1;
		}
		
		if(GameDriverV4.Keys[KeyEvent.VK_V]) {
				timer = 0;
			
		}
		
		
		if (this.getMinX() <= 0) {
			this.setLocation(x,y);
		}
		
		this.translate (-starsdx,0);
		win.setColor(col);
		win.fill(this);
	}

	
}
