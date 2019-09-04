import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake extends Rectangle{

	int x = 20, y = 20;
	int dx = 15, dy = 15;
	ArrayList<Rectangle>rect;
	Rectangle body;
	
	public Snake() {
		this.setSize(50,50);
		this.setLocation(x,y);
		rect = new ArrayList<Rectangle>();
		body = new Rectangle(50,50,x+52,y);
	}
	
	public void movement (Graphics2D win) {
	
	//	rect.add(body);
		
		win.setColor(Color.YELLOW);
		win.fill(this);
		
		this.translate(dx, dy);
		
		if 	(GameDriverV4.Keys[KeyEvent.VK_S] && this.getY() < 680) {
			
			if (dx>0) {
			dx*=-1;
			dy=0;
		}
	}
		
		else if (GameDriverV4.Keys[KeyEvent.VK_W] && this.getY() > 5) {
		
			
			}
		 
		else if (GameDriverV4.Keys[KeyEvent.VK_A] && this.getX() > 0) {
			this.translate(-dx, 0);
			
		}
		
		else if (GameDriverV4.Keys[KeyEvent.VK_D] && this.getX() < 870) {
			this.translate(dx,0);
			
			}
		 
	}
	
	
}
