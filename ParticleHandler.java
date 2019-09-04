import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class ParticleHandler {

	Ship p;
	
	int delay = 6;
	int timer;
	int RotationTimer;
	int selection;
	
	double dtheta = Math.PI/75;
	double theta;
	Random rand;
	
	//Images
	BufferedImage Fire;
	BufferedImage BFire;
	
	ArrayList<Particle> onScreen = new ArrayList<Particle>();
	ArrayList<Particle> fire = new ArrayList<Particle>();
	
	public ParticleHandler() {
	
		rand = new Random();
	
		
	}
	
	public void moveAndDraw(Graphics2D win) {
		for (int i = 0; i < onScreen.size(); i++) {
			onScreen.get(i).moveAndDraw(win);
			win.drawImage(BFire,  null,  (int)(onScreen.get(i).getX()), (int)(onScreen.get(i).getY()));
			if (onScreen.get(i).getX() > 590 || onScreen.get(i).getX() < 100 || onScreen.get(i).getY() < 0 || onScreen.get(i).getY() > 600) {
				onScreen.remove(i);
				i--;
			}
		}
		for (int i = 0; i < fire.size(); i++) {
			fire.get(i).moveAndDraw(win);
			win.drawImage(Fire,  null,  (int)fire.get(i).getX(), (int)fire.get(i).getY());
			if (fire.get(i).getX() < 100 || fire.get(i).getX() > 576)  {
				fire.get(i).dx*= -1;
			}
			if (fire.get(i).getY() > 600) {
				fire.get(i).dy*= -1;
			}
			if (fire.get(i).getY() < 0) {
				fire.remove(i);
				i--;
			}
			
		}
	}

	public void flame(Graphics2D win, int x, int y) {
		
		for (int i = 0; i < 10; i++) {
			double pdx = (6*(Math.random() - 0.5));
			double pdy = (4*Math.random());
			Particle part = new Particle(x, y, 15, 24, pdy, pdx, Color.RED);
			fire.add(part);
			
		}
		
	}
	public void circle(Graphics2D win, int x, int y) {
			if (timer > delay) {
				timer = 0;
			}			
			if (timer == 0) {
				for (int i = 0; i < 40; i++) {
					double pdx = (3*Math.sin((i*Math.PI/18) + theta));
					double pdy = (3*Math.cos((i*Math.PI/18) + theta));
					Particle part = new Particle(x,y,10,15,pdy,pdx,Color.RED);
					onScreen.add(part);
				}
				theta += dtheta;
			}			
		
		timer++;
		
	}
	
	public void spiral(Graphics2D win, int x, int y) {

		if (timer > 0) {
			timer = 0;
		}
			
		if (timer == 0) {
			for (int i = 0; i < 2; i++) {					
				double pdx = (4*Math.sin((i*Math.PI) + theta));
				double pdy = (4*Math.cos((i*Math.PI) + theta));
				Particle part = new Particle(x,y,10,15,pdy,pdx,Color.RED);
				onScreen.add(part);
			}
			theta += Math.PI/20;
		}			
		timer++;
		
		
	}
	
	public void crossspiral(Graphics2D win, int x, int y) {

			if (timer > 2) {
				timer = 0;
			}
			
			if (timer == 0) {
				for (int i = 0; i < 4; i++) {
					double pdx = (3*Math.sin((i*Math.PI/2) + theta));
					double pdy = (3*Math.cos((i*Math.PI/2) + theta));
					Particle part = new Particle(x,y,10,15,pdy,pdx,Color.RED);
					onScreen.add(part);
				}
				for (int i = 0; i < 4; i++) {
					double pdx = (3*Math.sin((i*Math.PI/2) - theta));
					double pdy = (3*Math.cos((i*Math.PI/2) - theta));
					Particle part = new Particle(x,y,10,15,pdy,pdx,Color.RED);
					onScreen.add(part);
				}
			}		
			theta += Math.PI/75;
		timer++;
	}
	
	public void targetfire(Graphics2D win, int x, int y) {

			double xLoc = (int)(x+30*Math.random());
			double yLoc = (int)(y+30*Math.random());
			
			double deltay = (p.getCenterY() - yLoc);
			double deltax = (p.getCenterX() - xLoc);
			double angle = Math.atan(deltax/deltay);
			
			double pdx = 4*Math.sin(angle);
			double pdy = 4*Math.cos(angle);
			
			Particle part = new Particle((int)xLoc, (int)yLoc, 15, 24, pdy, pdx, Color.RED);
			fire.add(part);
			
		
	}
	
	
}


