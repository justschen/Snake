import java.awt.image.BufferedImage;

public class SpriteSheet2 {

	
	int width, rows, cols; 
	BufferedImage[] frameArray = new BufferedImage[rows*cols]; 
	int currentFrameCount; 
	int frameDelay; 
	boolean playedOnce = false; 
	boolean isChecking; 
	
	

	public SpriteSheet2(BufferedImage input, int aFrames) { 
		width = aFrames; 
		boolean playedOnce = false; 
		currentFrameCount = 0; 
		frameDelay = 1; 
		isChecking = false; 
		
		for( int i = 0; i < rows; i++ ) {
			for (int j = 0; j < cols; j++) {
			frameArray[(i*cols) + j] = input.getSubimage( i *(input.getWidth()), i*(input.getWidth()/cols) , (input.getWidth()/width), input.getHeight()/rows); 
			}
		}
		
	}
		
			public BufferedImage[] loop() { 
			
			return frameArray;
			
		}
			// loop will return the current frame and then move onto the next one 
			// will need a boolean to make it only loop once so a condition setter 
			// if the loop has played the last frame was played and if so, set playedOnce to true
			// else set it to false
			
			
			public void changeFrameDelayTo(int input) { 
				frameDelay = input;  
			} 
	
	
	

	
	
}


