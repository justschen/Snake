import java.awt.Graphics2D;

public class EnemyHandler {

	Enemy[] zoo = new Enemy[50];
	int position = 0;
	
	public EnemyHandler(){
		
	}
	
	public void moveAndDraw(Graphics2D win, Ship s1){
		
		
		if(Math.random() > 0.99){
			zoo[position] = new Enemy();
			position++;
			position %= zoo.length;
		}
		
		for(int i = 0; i < zoo.length; i ++){
			Enemy e = zoo[i];
			
			if(e != null){
			
			e.moveAndDraw(win);
			
			if(e.intersects(s1)){
				s1.lives--;
				zoo[i] = null;
			}
			
			}
		}
		
	}
}


