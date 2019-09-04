import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Warning extends Rectangle{

	int timer = 0, delay = 100;
	Rectangle redbox;
	int colorchanger = 0;
	Boolean red = true;
	//Color col;
	
	
	public Warning() {
		
		//col = new Color(colorchanger, 120, 120);
		
	}
	
	public void drawrect(Graphics2D win) {
		this.setSize(1300,900);
		this.setLocation(0,0);
		if (red == true) {
			colorchanger+=10; 
		 
		}
		
		else {
			colorchanger-=10;
		}
		
		
		
		if (colorchanger%200 == 0) {
			red = !red;
		}
		
		int alpha = 127;
		Color col = new Color(255, colorchanger,colorchanger, alpha);
		
		win.setColor(col);
		win.fill(this);
	}
	
	public void dyingflash(Graphics2D win) {
		this.setSize(2000,2000);
		this.setLocation(0,0);
		if (red == true) {
			colorchanger+=20; 
		 
		}
		
		else {
			colorchanger-=20;
		}
		
		
		
		if (colorchanger%200 == 0) {
			red = !red;
		}
		
		int alpha = 127;
		Color col = new Color(255, colorchanger,colorchanger, alpha);
		
		win.setColor(col);
		win.fill(this);
	}
	
	
	public void hpflash(Graphics2D win) {
		this.setSize(300-100,30+20);
		this.setLocation(10+110,670);

		if (red == true) {
			colorchanger+=20; 
		 
		}
		
		else {
			colorchanger-=20;
		}
		
	
		if (colorchanger%200 == 0) {
			red = !red;
		}
		
		int alpha = 127;
		Color col = new Color(255, colorchanger,colorchanger, alpha);
		
		win.setColor(col);
		win.fill(this);
	}
	
	public void bossflash(Graphics2D win) {
		this.setSize(300-100,30+20);
		this.setLocation(610+160,670);

		if (red == true) {
			colorchanger+=20; 
		 
		}
		
		else {
			colorchanger-=20;
		}
		
	
		if (colorchanger%200 == 0) {
			red = !red;
		}
		
		int alpha = 127;
		Color col = new Color(255, colorchanger,colorchanger, alpha);
		
		win.setColor(col);
		win.fill(this);
	}

	
	
	
}
