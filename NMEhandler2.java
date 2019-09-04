import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class NMEhandler2{
	NME[] zoo = new NME[40];
	NME2[] zoo2 = new NME2[6];
	Particle[] particle = new Particle[20];
	int position = 0;
	int position2 = 0;
	Boolean bosss = false;
	
	public NMEhandler2(){
		
	}

	public void moveAndDraw(Graphics2D win, Ship ship, BossClass boss) {
	
		
		if (Math.random()>0.98) {
			
			zoo[position] = new NME();
			position++;
			position%=zoo.length;
			
		}
		
		//ZOO
		for (int i =0; i < zoo.length; i++) {
			NME e = zoo[i];
			for(int j = 0; j < particle.length; j++) {
				
				//particle[j] = new Particle(e.x, e.y);
			
		}
			
			if (e!=null) {
				if (bosss==false) {
				e.move(win);
				}
			
			if (e.intersects(ship)) {
				ship.lives--;
				zoo[i] = null;
			
			}  
				
			for (int j = 0; j < ship.Lasers1.size(); j++) {
					Lasers bullet = ship.Lasers1.get(j);
					
					if (bullet!=null && i>=0 && zoo[i]!=null) {
						if (bullet.intersects(e)){
							zoo[i]=null;
							ship.Lasers1.remove(j);
							i--;
							j--;
							//this.createParticles();
							//this.drawParticles(win);
					}
						
												
				}
			}
			
			for (int j = 0; j < ship.Lasers2.size(); j++) {
				Lasers bullet = ship.Lasers2.get(j);
				
				if (bullet!=null && i>=0 && zoo[i]!=null) {
					if (bullet.intersects(e)){
						zoo[i]=null;
						ship.Lasers2.remove(j);
						i--;
						j--;
					//	this.createParticles();
				}
					
			}
		}
			
			for (int j = 0; j < ship.Lasers3.size(); j++) {
				Lasers bullet = ship.Lasers3.get(j);
				
				if (bullet!=null && i>=0 && zoo[i]!=null) {
					if (bullet.intersects(e)){
						zoo[i]=null;
						ship.Lasers3.remove(j);
						i--;
						j--;
						//this.createParticles();
					
					}
					}
				}
			}
		}	
		
		
		
		//ZOO2
		
		if (Math.random()>0.98) {
			
			zoo2[position2] = new NME2();
			position2++;
			position2%=zoo2.length;
			
		}
		
		
		for (int i =0; i < zoo2.length; i++) {
			NME2 e = zoo2[i];
			for(int j = 0; j < particle.length; j++) {
				
				//particle[j] = new Particle(e.x, e.y);
			
		}
			
			if (e!=null) {
				if (bosss==false) {
				e.move(win, ship);
				}
			
			if (e.intersects(ship)) {
				ship.lives--;
				zoo2[i] = null;
			
			}  
				
			for (int j = 0; j < ship.Lasers1.size(); j++) {
					Lasers bullet = ship.Lasers1.get(j);
					
					if (bullet!=null && i>=0 && zoo[i]!=null) {
						if (bullet.intersects(e)){
							zoo2[i]=null;
							ship.Lasers1.remove(j);
							i--;
							j--;
							//this.createParticles();
							//this.drawParticles(win);
					}
						
												
				}
			}
			
			for (int j = 0; j < ship.Lasers2.size(); j++) {
				Lasers bullet = ship.Lasers2.get(j);
				
				if (bullet!=null && i>=0 && zoo2[i]!=null) {
					if (bullet.intersects(e)){
						zoo2[i]=null;
						ship.Lasers2.remove(j);
						i--;
						j--;
					//	this.createParticles();
				}
					
			}
		}
			
			for (int j = 0; j < ship.Lasers3.size(); j++) {
				Lasers bullet = ship.Lasers3.get(j);
				
				if (bullet!=null && i>=0 && zoo2[i]!=null) {
					if (bullet.intersects(e)){
						zoo2[i]=null;
						ship.Lasers3.remove(j);
						i--;
						j--;
						//this.createParticles();
					
					}
					}
				}
			}
		}		
		
	}		
}

	
	
	

