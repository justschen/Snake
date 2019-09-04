import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SnakeMain extends GameDriverV4 implements MouseMotionListener{
	public static SnakeMain instance;
	public static Main instance2;

	SoundDriver sounds;
	static int GameState;
	Head head;
	static Color col = Color.GRAY;
	
	static Main main = new Main();
	
	public static BufferedImage deoboss; 
	public static SpriteSheet deosprite;
	public static BufferedImage rayIcon;
	public static SpriteSheet rayray;
	
	Boolean pause;

	Rectangle rect1, rect2, rect3, rect4, rect5, rect6;
	Rectangle bigBlack = new Rectangle(0,0, 1300,1300);

	public static Food food, block;
	Font f1 = new Font("Dialoginput", Font.BOLD, 30);
	Font f2 = new Font("Dialoginput", Font.BOLD, 27);
	Font f3 = new Font("Dialoginput", Font.BOLD, 23);
	Color colorange, colgreen, colred;
	public static ArrayList<BodyPart> body, body1;
	ArrayList<Laser> laser;
	ArrayList<Bomb> bomb;
	// Bomb bomb;
	ArrayList<BodyPart> bodies, bodies2;
	// public static boolean[] Pkeys = new boolean[KeyEvent.KEY_LAST];
	Grid[] grid = new Grid[70000];
	BouncingPower boost;
	Warning flash;
	Boolean bombing;
	int timer1, delay1, timer2, delay2;
	public static Boolean power;

	public static Boolean bodyup, bodydown, bodyleft, bodyright;

	public static BufferedImage foodgeodude, foodmagikarp, foodhorsea, foodgolem;
	public static BufferedImage onixleft, onixright, onixdown, onixup;
	public static SpriteSheet onixsheetleft, onixsheetright, onixsheetdown, onixsheetup;
	public static BufferedImage onixbody1, onixbody2;
	public static SpriteSheet onixbodyy;
	public static BufferedImage steelixup, steelixdown, steelixright, steelixleft;
	public static SpriteSheet steelixsheetup, steelixsheetright, steelixsheetleft, steelixsheetdown;
	public static BufferedImage gyraup, gyraright, gyraleft, gyradown;
	public static BufferedImage gyrabody1, gyrabody2, gyrabody3, gyrabody4;
	public static BufferedImage magikarpup, magikarpdown, magikarpleft, magikarpright;
	public static SpriteSheet magikarpsheetup, magikarpsheetdown, magikarpsheetleft, magikarpsheetright;
	BufferedImage onixfight, steelixfight, magikarpfight, gyrafight, rayfight;
	BufferedImage backgroundtunnel, backgroundocean, backgroundsky;
	public static BufferedImage rayheadleft, rayheadright, rayheaddown, rayheadup, raybody1up, raybody1down,
			raybody1left, raybody1right;
	public static BufferedImage raybody2down, raybody2left, raybody2up, raybody2right;
	public static BufferedImage steelix1, steelix2, steelix3, steelix4, steelix5, steelix6, steelix7, steelix8;
	public static BufferedImage bubble1, bubble2, bubble3;
	BufferedImage onixsprite, magikarpsprite, raysprite, stillonix, stillkarp, stillray;
	SpriteSheet onixspritesheet, magikarpspritesheet, rayspritesheet;
	BufferedImage back;
	BufferedImage one, two, three;
	BufferedImage poke1, poke2, poke3, poke4;
	public static BufferedImage ball;
	public static BufferedImage walkingdown, walkingleft, walkingright, walkingup;
	public static SpriteSheet downsheet, leftsheet, rightsheet, upsheet;
	public static BufferedImage masterball, rarecandy;
	public static BufferedImage crashEnemy, circleEnemy1, circleEnemy2;
	public static SpriteSheet crash, circle1, circle2;
	Boolean start;

	Boolean left, middlel, right, down, up;
	BufferedImage fighting;

	Rectangle r1, r2, r3, hpbar, hp10, hp8, hp6, hp4, hp2;
	int hpscaler;
	int finalhp;
	public static int location = 140;
	int add = 345;

	public static int bodycounter;
	int timer, delay, level;

	public static Boolean gyra, onix, ray;

	Boolean chill;
	SpriteSheet boxflash;
	BufferedImage box;

	BufferedImage upp, downn, leftt, rightt;
	
	public static int xLoc, yLoc;

	Rectangle rectLeft, rectRight;
	Rectangle fromLeft, fromRight, fromTop, fromBot;
	
	int splitTimer;
	
	public SnakeMain() {
		
		rayIcon = this.addImage("rayIcon.png");
		rayray = new SpriteSheet(rayIcon, 11);
		rayray.changeFrameDelayTo(10);
		crashEnemy = this.addImage("sala.png");
		crash = new SpriteSheet(crashEnemy, 25);
		circleEnemy1 = this.addImage("drago.png");
		circle1 = new SpriteSheet(circleEnemy1, 46);
		circleEnemy2 = this.addImage("floaty.png");
		circle2 = new SpriteSheet(circleEnemy2, 30);
		
		poke1 = this.addImage("poke0.png");
		poke2 = this.addImage("poke1.png");
		poke3 = this.addImage("poke2.png");
		poke4 = this.addImage("poke3.png");
		deoboss= this.addImage("deosprite.png");
		deosprite = new SpriteSheet(deoboss, 12);
		deosprite.changeFrameDelayTo(8);
		masterball = this.addImage("master.png");
		rarecandy = this.addImage("rare candy.png");
		upp = this.addImage("walkingup.png");
		downn = this.addImage("walkingdownsprite.png");
		leftt = this.addImage("walkingleftsprite.png");
		rightt = this.addImage("walkingrightsprite.png");

		walkingdown = this.addImage("walkingdown.png");
		downsheet = new SpriteSheet(walkingdown, 4);

		walkingleft = this.addImage("walkingleftsprite.png");
		leftsheet = new SpriteSheet(walkingleft, 4);

		walkingright = this.addImage("walkingrightsprite.png");
		rightsheet = new SpriteSheet(walkingright, 4);

		walkingup = this.addImage("walkingupsprite.png");
		upsheet = new SpriteSheet(walkingup, 4);

		r1 = new Rectangle(140, 300, 300, 300);
		r2 = new Rectangle(485, 300, 300, 300);
		r3 = new Rectangle(860, 300, 300, 300);
		box = this.addImage("box.png");
		boxflash = new SpriteSheet(box, 2);
		boxflash.changeFrameDelayTo(9);

		ball = this.addImage("ballsprite.png");

		foodgeodude = this.addImage("geodudefood.png");
		foodhorsea = this.addImage("horseafood.png");
		foodmagikarp = this.addImage("magikarpfood.png");
		foodgolem = this.addImage("golemfood.png");

		onixleft = this.addImage("onixleft.png");
		onixsheetleft = new SpriteSheet(onixleft, 7);
		onixsheetleft.changeFrameDelayTo(10);

		onixright = this.addImage("onixright.png");
		onixsheetright = new SpriteSheet(onixright, 7);
		onixsheetright.changeFrameDelayTo(5);

		onixdown = this.addImage("onixdown.png");
		onixsheetdown = new SpriteSheet(onixdown, 7);
		onixsheetdown.changeFrameDelayTo(5);

		onixup = this.addImage("onixup.png");
		onixsheetup = new SpriteSheet(onixup, 7);
		onixsheetup.changeFrameDelayTo(5);

		onixbody1 = this.addImage("onixbody1.png");
		onixbody2 = this.addImage("onixbody2.png");

		onixfight = this.addImage("onix vs geodude.png");
		steelixfight = this.addImage("onix vs golem.png");
		magikarpfight = this.addImage("magikarp vs horsea.png");
		gyrafight = this.addImage("gyra vs magikarp.png");
		rayfight = this.addImage("ray vs gonzo.png");
		backgroundtunnel = this.addImage("tunnel.png");
		backgroundocean = this.addImage("underwater.jpg");
		backgroundsky = this.addImage("sky.jpg");

		steelixleft = this.addImage("steeelixhead.png");
		steelixsheetleft = new SpriteSheet(steelixleft, 4);
		steelixsheetleft.changeFrameDelayTo(4);

		steelixright = this.addImage("steelixheadriht.png");
		steelixsheetright = new SpriteSheet(steelixright, 4);
		steelixsheetright.changeFrameDelayTo(4);

		steelixup = this.addImage("steelixheadup.png");
		steelixsheetup = new SpriteSheet(steelixup, 4);
		steelixsheetup.changeFrameDelayTo(4);

		steelixdown = this.addImage("steeelixheaddown.png");
		steelixsheetdown = new SpriteSheet(steelixdown, 4);
		steelixsheetdown.changeFrameDelayTo(4);

		steelix1 = this.addImage("steelix1.png");
		steelix2 = this.addImage("steelix2.png");
		steelix3 = this.addImage("steelix3.png");
		steelix4 = this.addImage("steelix4.png");
		steelix5 = this.addImage("steelix5.png");
		steelix6 = this.addImage("steelix6.png");
		steelix7 = this.addImage("steelix7.png");
		steelix8 = this.addImage("steelix8.png");

		magikarpup = this.addImage("magikarpup.png");
		magikarpdown = this.addImage("magikarpdown.png");
		magikarpright = this.addImage("magikarpright.png");
		magikarpleft = this.addImage("magikarpleft.png");

		magikarpsheetup = new SpriteSheet(magikarpup, 8);
		magikarpsheetdown = new SpriteSheet(magikarpdown, 8);
		magikarpsheetleft = new SpriteSheet(magikarpleft, 8);
		magikarpsheetright = new SpriteSheet(magikarpright, 8);
		magikarpsheetup.changeFrameDelayTo(9);
		magikarpsheetdown.changeFrameDelayTo(9);
		magikarpsheetleft.changeFrameDelayTo(9);
		magikarpsheetright.changeFrameDelayTo(9);

		rayheadleft = this.addImage("rayhead1.png");
		rayheadright = this.addImage("rayhead4.png");
		rayheaddown = this.addImage("rayhead2.png");
		rayheadup = this.addImage("rayhead3.png");
		raybody1left = this.addImage("raybody1.png");
		raybody1right = this.addImage("raybody4.png");
		raybody1down = this.addImage("raybody2.png");
		raybody1up = this.addImage("raybody3.png");
		raybody2left = this.addImage("raybodyleft.png");
		raybody2right = this.addImage("raybodyright.png");
		raybody2down = this.addImage("raybodydown.png");
		raybody2up = this.addImage("raybodyup.png");

		gyraleft = this.addImage("gyraheadleft.png");
		gyradown = this.addImage("gyraheaddown.png");
		gyraup = this.addImage("gyraheadup.png");
		gyraright = this.addImage("gyraheadright.png");
		gyrabody1 = this.addImage("gyra1.png");
		gyrabody2 = this.addImage("gyra2.png");
		gyrabody3 = this.addImage("gyra3.png");
		gyrabody4 = this.addImage("gyra4.png");

		bubble1 = this.addImage("bubble1.png");
		bubble2 = this.addImage("bubble2.png");
		bubble3 = this.addImage("bubble3.png");

		onixsprite = this.addImage("onixsprite.png");
		magikarpsprite = this.addImage("magikarpsprite.png");
		raysprite = this.addImage("raysprite.png");
		onixspritesheet = new SpriteSheet(onixsprite, 17);
		onixspritesheet.changeFrameDelayTo(7);
		magikarpspritesheet = new SpriteSheet(magikarpsprite, 8);
		magikarpspritesheet.changeFrameDelayTo(7);
		rayspritesheet = new SpriteSheet(raysprite, 11);
		rayspritesheet.changeFrameDelayTo(7);

		stillonix = this.addImage("oniximage.png");
		stillkarp = this.addImage("magikarpimage.png");
		stillray = this.addImage("rayimage.png");

		back = this.addImage("background.png");

		one = this.addImage("1.png");
		two = this.addImage("2.png");
		three = this.addImage("3.png");

		fighting = this.addImage("fightscene.png");

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				grid[26 * i + j] = new Grid(i * 30, j * 30);
			}
		}

		String[] fileNames = new String[11];
		fileNames[0] = "mainmusic1.wav";

		fileNames[1] = "onixback.wav";

		fileNames[2] = "gyrados.wav";
		fileNames[3] = "rayquaza.wav";

		fileNames[4] = "lose.wav";
		fileNames[5] = "onixvoice.wav";
		fileNames[6] = "gyravoice.wav";
		fileNames[7] = "rayroar.wav";
		fileNames[8] = "painfulscream.wav";
		fileNames[9] = "magikarpsound.wav";
		
		fileNames[10] = "startBattle.wav";

		sounds = new SoundDriver(fileNames);
		// sounds.play(0);

		reset();

	}
	
	public void rectReset() {

		fromTop = new Rectangle(-500,150, 250,250);
		fromBot = new Rectangle(1300,150, 250,250);
		fromLeft = new Rectangle(400,150, 250,250);
		fromRight = new Rectangle(400,150, 250,250);
	}

	public void reset() {
		
		rectReset();
		
		splitTimer = 0;
		
		rect1 = new Rectangle(1300,0, 13000,134);
		rect2 = new Rectangle(-13000,134, 13000,134);
		rect3 = new Rectangle(1300,268, 13000,134);
	
		rect4 = new Rectangle(-13000,800-134, 13000,134);
		rect5 = new Rectangle(1300,800-268, 13000,134);
		rect6 = new Rectangle(-13000,800-3*134, 13000, 134);
		
		rectLeft = new Rectangle(0,0, 650, 800);
		rectRight = new Rectangle(650,0, 650, 800);
		
		pause = false;
		power = false;
		laser = new ArrayList<Laser>();
		bodyleft = false;
		bodyright = false;
		bodyup = false;
		bodydown = true;
		start = false;
		bomb = new ArrayList<Bomb>();
		bombing = false;
		location = 0;
		hpscaler = 190;
		finalhp = 100;
		hpbar = new Rectangle(1010, 630, hpscaler, 30);
		hp10 = new Rectangle(1006, 630, 190, 30);
		hp8 = new Rectangle(1006, 630, 160, 30);
		hp6 = new Rectangle(1006, 630, 130, 30);
		hp4 = new Rectangle(1006, 630, 100, 30);
		hp2 = new Rectangle(1006, 630, 70, 30);
		flash = new Warning();
		left = true;
		middlel = false;
		right = false;
		down = false;
		timer = 0;
		delay = 100;
		food = new Food();
		block = new Food();
		head = new Head();
		body = new ArrayList<BodyPart>();
		body1 = new ArrayList<BodyPart>();
		boost = new BouncingPower();
		GameState = 0;
		bodycounter = 0;
		level = 1;
		chill = false;
		gyra = false;
		ray = false;
		onix = false;
		colorange = new Color(247, 229, 85);
		// colorange = new Color(218, 193, 38);
		colgreen = new Color(105, 232, 155);
		colred = new Color(254, 86, 60);
		timer1 = 100;
		delay1 = 100;
		timer2 = 100;
		delay2 = 100;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("yeey");
		SnakeMain s1 = new SnakeMain();
		instance = new SnakeMain();
		instance.start();
		instance.setBackGroundColor(Color.WHITE);
		instance.setFocusable(true);
		main.addMouseMotionListener(main);
		s1.addMouseMotionListener(s1);
		
		
	}

	public void splashscreen(Graphics2D win) {
		
		//this.mouseMoved(arg0);
		
		timer2++;

		win.drawImage(back, null, 0, 0);
		win.setFont(f1);
		win.setColor(Color.WHITE);
		/*
		 * r1 = new Rectangle(140, 300, 300, 300); r2 = new Rectangle(485, 300, 300,
		 * 300); r3 = new Rectangle(860, 300, 300, 300);
		 */
		if (left == true) {
			win.drawImage(boxflash.loop(), null, 133, 300);
			win.drawImage(onixspritesheet.loop(), null, 140, 300);
		} else if (middlel == true) {
			win.drawImage(boxflash.loop(), null, 485, 300);
			win.drawImage(magikarpspritesheet.loop(), null, 530, 320);
		} else if (right == true) {
			win.drawImage(boxflash.loop(), null, 860, 300);
			win.drawImage(rayspritesheet.loop(), null, 890, 300);

		}

		if (left != true) {
			win.drawImage(stillonix, null, 140, 300);
		}

		if (middlel != true) {
			win.drawImage(stillkarp, null, 530, 320);
		}
		if (right != true) {
			win.drawImage(stillray, null, 890, 300);
		}
		win.drawImage(one, null, 260, 600);
		win.drawImage(two, null, 630, 600);
		win.drawImage(three, null, 1000, 600);

		win.setColor(Color.RED);

		win.drawString("Press <SPACE> for instructions", 360, 700);
		win.drawString("<Justin Chen>", 20, 20);

		
		if (GameDriverV4.Keys[KeyEvent.VK_1]) {
			middlel = false;
			left = true;
			right = false;

		}

		if (GameDriverV4.Keys[KeyEvent.VK_2]) {

			middlel = true;
			left = false;
			right = false;

		}
		if (GameDriverV4.Keys[KeyEvent.VK_3]) {
			middlel = false;
			left = false;
			right = true;
		}
		
		
		if (GameDriverV4.Keys[KeyEvent.VK_ENTER] && left == true) {
			GameState = 1;
			onix = true;
			sounds.stop(0);
			sounds.loop(1);
		}
		if (GameDriverV4.Keys[KeyEvent.VK_ENTER] && middlel == true) {
			GameState = 1;
			gyra = true;
			sounds.stop(0);
			sounds.loop(2);
		}
		if (GameDriverV4.Keys[KeyEvent.VK_ENTER] && right == true) {
			GameState = 1;
			ray = true;
			sounds.stop(0);
			sounds.loop(3);
		}

		if (GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			GameState = 3;
			sounds.play(0);
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);

		}
		win.setColor(Color.RED);

	}

	public void instructions(Graphics2D win) {
		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			reset();
			Main.reset();
	
		}
		win.drawImage(back, null, 0, 0);
		
		win.setFont(f1);
		win.setColor(Color.RED);
		win.drawString("Use <WASD> to move", 500, 300);
		win.setColor(Color.BLACK);
		win.drawString("Collect the Pokemon!", 480, 340);
		win.drawString("Avoid the pokeballs!", 480, 380);
		win.drawString("Collect the Rare Candy for Powerup", 360, 420);
		win.drawString("Press Space to use MasterBall Powerup", 350, 460);
		
		win.setColor(Color.RED);
		win.drawString("USE <ARROWS> To move the enemy", 400, 500);
		win.setColor(Color.BLACK);
		win.drawString("When playing as Gonzo", 480, 540);
		win.drawString("Press <B> for bomb!", 500, 580);
		win.setColor(Color.RED);
		win.drawString("Press <R> to restart/go back!", 390, 640);
	}

	public void maingame(Graphics2D win) {
		win.setFont(f1);

		// LEVEL ONE
		if (onix == true) {
			timer++;

			if (this.getX() % 30 == 0 && this.getY() % 30 == 0) {

				if (GameDriverV4.Keys[KeyEvent.VK_UP]) {
					block.translate(0, -3);
				} else if (GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
					block.translate(0, 3);
				} else if (GameDriverV4.Keys[KeyEvent.VK_LEFT]) {
					block.translate(-3, 0);
				} else if (GameDriverV4.Keys[KeyEvent.VK_RIGHT]) {
					block.translate(3, 0);
				}
			}

			win.drawImage(backgroundtunnel, null, 0, 0);

			if (bodycounter < 5) {
				win.drawImage(onixfight, null, 820, 200);
			}
			if (bodycounter >= 5) {
				win.drawImage(steelixfight, null, 820, 200);
			}

			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					grid[26 * i + j].draw(win);
				}

			}
			if (boost.isalive == true) {
				if (bodycounter > 5) {
					boost.moveAndDraw(win);
				}
			}

			food.moveAndDraw(win);
			block.enemymove(win);

			/*
			 * for (int i = 0; i < bodies.size() * 100; i++) { for (int j = 0; j <
			 * body.size(); j++) { if (i % 5!= 0) { body.get(j).moveAndDraw(win); } } }
			 */

			for (int i = 0; i < body.size(); i++) {
				body.get(i).moveAndDraw(win);

			}

			head.moveAndDraw(win);

			this.eatTheFood(win);

			if (head.intersects(boost)) {
				boost.isalive = false;
				power = true;

			}
			this.checkDeath();

		}

		// LEVEL TWO
		if (gyra == true) {
			timer++;

			if (this.getX() % 30 == 0 && this.getY() % 30 == 0) {

				if (GameDriverV4.Keys[KeyEvent.VK_UP]) {
					block.translate(0, -3);
				} else if (GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
					block.translate(0, 3);
				} else if (GameDriverV4.Keys[KeyEvent.VK_LEFT]) {
					block.translate(-3, 0);
				} else if (GameDriverV4.Keys[KeyEvent.VK_RIGHT]) {
					block.translate(3, 0);
				}
			}

			win.drawImage(backgroundocean, null, 0, 0);

			if (bodycounter < 5) {
				win.drawImage(magikarpfight, null, 820, 200);
			}
			if (bodycounter >= 5) {
				win.drawImage(gyrafight, null, 820, 200);
			}

			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					grid[26 * i + j].draw(win);
				}

			}
			if (boost.isalive == true) {
				if (bodycounter > 5) {
					boost.moveAndDraw(win);
				}
			}

			food.moveAndDraw(win);
			block.enemymove(win);

			/*
			 * for (int i = 0; i < bodies.size() * 100; i++) { for (int j = 0; j <
			 * body.size(); j++) { if (i % 5!= 0) { body.get(j).moveAndDraw(win); } } }
			 */

			for (int i = 0; i < body.size(); i++) {
				body.get(i).moveAndDraw(win);

			}

			head.moveAndDraw(win);

			this.eatTheFood(win);
			if (head.intersects(boost)) {
				boost.isalive = false;
				power = true;

			}
			this.checkDeath();

		}

		// LEVEL THREE
		if (ray == true) {
			
			
			timer++;
			timer1++;
			timer2++;

			win.drawImage(backgroundsky, null, 0, 0);
			win.drawImage(rayfight, null, 820, 200);

			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					grid[26 * i + j].draw(win);
				}

			}
			
			if (GameDriverV4.Keys[KeyEvent.VK_B] && timer1 > delay1) {

				bomb.add(new Bomb((int) food.getX(), (int) food.getY()));
				timer1 = 0;
			}

			
			
			
			
			if (boost.isalive == true) {
				if (bodycounter > 5) {
					boost.moveAndDraw(win);
				}
			}

			food.moveAndDraw(win);
			// block.enemymove(win);

			/*
			 * for (int i = 0; i < bodies.size() * 100; i++) { for (int j = 0; j <
			 * body.size(); j++) { if (i % 5!= 0) { body.get(j).moveAndDraw(win); } } }
			 */

			
			
			if (pause == false) {
			for (int i = 0; i < body.size(); i++) {
				body.get(i).moveAndDraw(win);

			}
			
			head.moveAndDraw(win);
			
			this.eatTheFood(win);

			if (head.intersects(boost)) {
				// sounds.play(4);
				boost.isalive = false;
				power = true;

			}
			this.checkDeath();

			}
			
			if (bomb != null) {
				for (int i = 0; i < bomb.size(); i++) {
					bomb.get(i).dropthebomb(win);
					if (head.intersects(bomb.get(i))) {
						finalhp -= 20;
						bomb.remove(i);
					}

				}
			}

			if (this.getX() % 30 == 0 && this.getY() % 30 == 0) {

				if (!GameDriverV4.Keys[KeyEvent.VK_UP] && !GameDriverV4.Keys[KeyEvent.VK_RIGHT]
						&& !GameDriverV4.Keys[KeyEvent.VK_DOWN] && !GameDriverV4.Keys[KeyEvent.VK_LEFT]) {
					win.drawImage(downn, null, food.x - 20, food.y - 30);
				}
				if (GameDriverV4.Keys[KeyEvent.VK_UP]) {
					win.drawImage(upsheet.loop(), null, food.x - 20, food.y - 30);
					food.translate(0, -5);
					bodyleft = false;
					bodyright = false;
					bodyup = true;
					bodydown = false;
				} else if (GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
					win.drawImage(downsheet.loop(), null, food.x - 20, food.y - 30);
					food.translate(0, 5);
					bodyleft = false;
					bodyright = false;
					bodyup = false;
					bodydown = true;
				} else if (GameDriverV4.Keys[KeyEvent.VK_LEFT]) {
					win.drawImage(leftsheet.loop(), null, food.x - 20, food.y - 30);
					food.translate(-5, 0);
					bodyleft = true;
					bodyright = false;
					bodyup = false;
					bodydown = false;
				} else if (GameDriverV4.Keys[KeyEvent.VK_RIGHT]) {
					win.drawImage(rightsheet.loop(), null, food.x - 20, food.y - 30);
					food.translate(5, 0);
					bodyleft = false;
					bodyright = true;
					bodyup = false;
					bodydown = false;
				}

			}
			
			
		}
		

		// win.drawImage(fighting, null, 900, 590);
		win.setColor(Color.BLACK);
		win.fill(hpbar);

		if (finalhp == 100) {
			win.setColor(colgreen);
			win.fill(hp10);
		}

		if (finalhp == 80) {
			win.setColor(colgreen);
			win.fill(hp8);
		}

		if (finalhp == 60) {
			win.setColor(colgreen);
			win.fill(hp6);
		}

		if (finalhp == 40) {
			win.setColor(colorange);
			win.fill(hp4);
		}

		if (finalhp == 20) {
			win.setColor(colred);
			win.fill(hp2);
		}

		win.drawImage(fighting, null, 900, 590);

		win.setColor(Color.BLACK);
		if (onix == true) {
			if (bodycounter < 5) {
				win.drawString("ONIX", 940, 625);
			}
			if (bodycounter >= 5) {
				win.drawString("STEELIX", 940, 625);
			}
		}
		if (gyra == true) {

			if (bodycounter < 5) {
				win.drawString("MAGIKARP", 940, 625);
			}
			if (bodycounter >= 5) {
				win.drawString("GYRADOS", 940, 625);
			}

		}

		if (ray == true) {
			win.drawString("RAYQUAZA", 940, 625);
		}

		win.setFont(f2);
		win.drawString("" + level, 1163, 627);

		win.setFont(f3);
		win.drawString("" + 100, 1152, 676);
		if (finalhp == 100) {
			win.drawString("" + finalhp, 1095, 676);
		}
		if (finalhp != 100) {
			win.drawString("" + finalhp, 1105, 676);
		}

		if (finalhp <= 0) {
			sounds.stop(0);
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.play(4);
			if (onix == true) {
				sounds.play(5);
			}
			if (gyra == true) {
				if (bodycounter < 5) {
					sounds.play(9);
				}
				if (bodycounter >= 5) {
					sounds.play(6);
				}

			}
			if (ray == true) {
				sounds.play(8);
			}
			GameState = 2;

		}

		if (head.x < -20 || head.x > 760) {
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.play(4);
			if (onix == true) {
				sounds.play(5);
			}
			if (gyra == true) {
				if (bodycounter < 5) {
					sounds.play(9);
				}
				if (bodycounter >= 5) {
					sounds.play(6);
				}

			}
			if (ray == true) {
				sounds.play(8);
			}
			GameState = 2;
		}

		if (head.y < -20 || head.y > 740) {
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.play(4);
			if (onix == true) {
				sounds.play(5);
			}
			if (gyra == true) {
				if (bodycounter < 5) {
					sounds.play(9);
				}
				if (bodycounter >= 5) {
					sounds.play(6);
				}

			}
			if (ray == true) {
				sounds.play(8);
			}
			GameState = 2;
			}
		
			if (GameDriverV4.Keys[KeyEvent.VK_I]) {
				pause = true;
				rectReset();
				Main.stateReset();
				sounds.loop(10);
				sounds.stop(0);
				sounds.stop(1);
				sounds.stop(2);
				sounds.stop(3);
				
			}
		
			
			if (pause == true) {
				win.fill(rect1);
				win.fill(rect2);
				win.fill(rect3);
				win.fill(rect4);
				win.fill(rect5);
				win.fill(rect6);
				rect1.translate(-30, 0);
				rect4.translate(30, 0);
			
				if (rect1.x<0) {
					rect2.translate(30, 0);
					rect5.translate(-30, 0);
				}
				
				if (rect2.x>1300-13000) {
					rect3.translate(-30, 0);
					rect6.translate(30, 0);
				}
				
				if (rect3.x<0)
					GameState = 14;
				
				
			}

			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				reset();
				Main.reset();
				sounds.stop(1);
				sounds.stop(2);
				sounds.stop(3);
				sounds.stop(10);
				sounds.play(0);
				GameState =0;
			}
		
		
		// win.drawImage(rightsheet.loop(),null, 100, 100);
	}
	
	
	
	public void pokemonBattle(Graphics2D win) {
		win.setColor(Color.BLACK);
		win.fill(bigBlack);
		fromBot.translate(-15, 0);
		fromTop.translate(15, 0);
		win.drawImage(poke2, null, fromBot.x, fromBot.y);
		win.drawImage(poke1, null, fromTop.x, fromTop.y);
		
		if(fromBot.x == fromTop.x) {
			GameState = 16;
		}
		
		
	}
	
	
	public void loading(Graphics2D win) {
		win.setColor(Color.BLACK);
		win.fill(bigBlack);
		
		win.drawImage(poke4, null, 400, fromLeft.y);
		win.drawImage(poke3, null, 400, fromRight.y);

		if (GameDriverV4.Keys[KeyEvent.VK_UP]) {
				GameState = 4 ;
				
			}
		if (GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
			GameState = 9;
			
		}
		if (GameDriverV4.Keys[KeyEvent.VK_RIGHT]) {
			GameState = 15;
			
		}
	}

	private void endScreen(Graphics2D win) {
		// TODO Auto-generated method stub
		win.drawImage(back, null, 0, 0);
		
		win.setFont(f1);
		win.setColor(Color.RED);
		win.drawString("CONGRATULATIONS!", 500, 300);
		win.setColor(Color.BLACK);
		win.drawString("You reached LEVEL" + level, 480, 340);
		
		win.setColor(Color.RED);
		win.drawString("Press <R> to restart/go back!", 390, 380);
		
		
		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.stop(4);
			sounds.stop(5);
			sounds.stop(6);
			sounds.stop(7);
			sounds.stop(8);
			sounds.stop(9);
			sounds.stop(10);
			sounds.play(0);
			GameState = 0;
			reset();
			Main.reset();
		}

	}

	public void checkDeath() {

		Point p = new Point((int) head.getCenterX(), (int) head.getCenterY());

		for (int i = 1; i < body.size(); i++) {
			if (body.get(i).contains(p)) {
				sounds.stop(1);
				sounds.stop(2);
				sounds.stop(3);
				sounds.play(4);
				if (onix == true) {
					sounds.play(5);
				}
				if (gyra == true) {
					if (bodycounter < 5) {
						sounds.play(9);
					}
					if (bodycounter >= 5) {
						sounds.play(6);
					}

				}
				if (ray == true) {
					sounds.play(8);
				}
				GameState = 2;
			}
		}
	}

	public void eatTheFood(Graphics2D win) {

		if (head.intersects(food)) {
			if (onix == true) {
				sounds.play(5);
			}
			if (gyra == true) {
				if (bodycounter < 5) {
					sounds.play(9);
				}
				if (bodycounter >= 5) {
					sounds.play(6);
				}

			}
			if (ray == true) {
				sounds.play(7);
			}
			bodycounter++;
			level++;
			food = new Food();

			BodyPart b;

			if (body.size() == 0) {
				b = head;
			} else {
				b = body.get(body.size() - 1);
			}

			body.add(new BodyPart(b));

		}

		if (head.intersects(block)) {
			flash.drawrect(win);
			// bodycounter--;
			finalhp -= 20;
			block = new Food();

			BodyPart b;

			if (body.size() == 0) {
				b = head;
			} else {
				b = body.get(body.size() - 1);
			}

			// body.remove(new BodyPart(b));
		}
	}
	
	public void comingstage(Graphics2D win) {
		// TODO Auto-generated method stub
		splitTimer++;
		
		
	
		main.bossbox.movingin(win);

		main.r1.translate(-5, 0);
		main.r2.translate(-5, 0);
		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}

		for (int i = 0; i < main.star.length; i++) {

			main.star[i].moveAndDraw(win);
			
		}

		win.drawImage(main.kabula.loop(), null, (int) main.bossbox.getX() - 20, (int) main.bossbox.getY() - 90);

		main.ship.movement(win, main.ship, main.bossbox, main.pow);
		// ship.shoot(win);
		win.setFont(f1);
		win.setColor(Color.RED);

		if (main.bossbox.getX() < 675) {
			GameState = 5;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(10);
			sounds.loop(0);
			reset();
			Main.reset();
		}
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " +  main.score, 10, 50);

		main.ship.fillhp(win);
		
		win.setColor(Color.BLACK);
		win.fill(rectLeft);
		win.fill(rectRight);
		

		rectLeft.translate(-20, 0);
		rectRight.translate(20, 0);
		
		
		win.drawImage(poke4, null, fromLeft.x, fromLeft.y);
		win.drawImage(poke3, null, fromRight.x, fromRight.y);
		fromLeft.translate(-20, 0);
		fromRight.translate(20, 0);
	}
	
	public void bossstage(Graphics2D win) {
		// TODO Auto-generated method stub
		timer++;

		main.r1.translate(-5, 0);
		main.r2.translate(-5, 0);
		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}

		for (int i = 0; i < main.star.length; i++) {
			main.star[i].moveAndDraw(win);
			;
		}

		//main.ship.x = 300;
		//main.ship.y = 400;
		main.ship.movement(win, main.ship, main.bossbox, main.pow);
		main.ship.shoot(win);
		main.bossbox.movement(win, main.ship);

		win.drawImage(main.test.loop(), null, (int) main.bossbox.getX() - 20, (int) main.bossbox.getY() - 90);

		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + main.score, 10, 50);

		if (main.bossbox.lives <= 70) {
			GameState = 6;
		}

		if (main.ship.lives <= 0) {
			sounds.stop(10);
			sounds.play(4);
			sounds.play(7);
			GameState = 2;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(10);
			sounds.loop(0);
			reset();
			Main.reset();
		}
		main.ship.fillhp(win);

	}

	public void spinattack(Graphics2D win) {
		main.timer++;

		main.r1.translate(-5, 0);
		main.r2.translate(-5, 0);
		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}

		for (int i = 0; i < main.star.length; i++) {
			main.star[i].moveAndDraw(win);
			

		}

		main.ship.movement(win, main.ship, main.bossbox,main.pow);
		main.ship.shoot(win);

		if (main.bossbox.lives > 40) {
			main.bossbox.spinningattack(win, main.ship);
		}

		if (main.bossbox.lives <= 40 && main.bossbox.getX() < 670) {
			main.bossbox.return2(win);
		}

		// bossbox.returnto(win);
		else if (main.bossbox.getX() >= 670 && main.bossbox.lives <= 40 && main.bossbox.lives > 0) {
			main.bossbox.draw(win);
			main.bossbox.movement(win, main.ship);
		}

		if (main.bossbox.lives <= 0) {
			GameState = 7;
		}

		if (main.bossbox.lives > 40) {
			win.drawImage(main.spinattack.loop(), null, (int) main.bossbox.getX() - 20, (int) main.bossbox.getY() - 90);
		}

		else if (main.bossbox.lives > 0) {
			win.drawImage(main.open.loop(), null, (int) main.bossbox.getX() - 20, (int) main.bossbox.getY() - 90);
		}

		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + main.score, 10, 50);

		if (main.ship.lives <= 0) {
			sounds.stop(7);
		
			GameState = 15;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(10);
			sounds.loop(0);
			reset();
			Main.reset();
		}
		main.ship.fillhp(win);

	}

	public void bossflashdie(Graphics2D win) {
		main.timers2++;

		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

	
		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}

		for (int i = 0; i < main.star.length; i++) {
			main.star[i].moveAndDraw(win);
			;

		}

		// ship.shoot(win);
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + main.score, 10, 50);

		main.warned.dyingflash(win);
		win.drawImage(main.crash.loop(), null, (int) main.bossbox.getX() - 20, (int) main.bossbox.getY() - 90);
		//win.drawImage(main.sprite[0], null, (int) main.ship.getX(), (int) main.ship.getY());
		win.drawImage(SnakeMain.raybody1right, null, (int)main.ship.getX()-34, (int)main.ship.getY()+15); 
		win.drawImage(SnakeMain.rayheadright,null, (int) main.ship.getX(), (int) main.ship.getY());		

		if (GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
			GameState = 1;
			// warned.drawrect(win);
		}

		if (main.timers2 == main.delays2) {
			GameState = 8;
		}
	}

	public void dyingstage(Graphics2D win) {
		// bossbox.dying(win);

		win.drawImage(main.crash.loop(), null, (int) main.bossbox.getX() - 20, (int) main.bossbox.getY() - 90);

		if (GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
			GameState = 1;
			// warned.drawrect(win);
		}

		main.r1.translate(-5, 0);
		main.r2.translate(-5, 0);
		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}

		for (int i = 0; i < main.star.length; i++) {
			main.star[i].moveAndDraw(win);
			;

		}

		// ship.movement(win, ship, bossbox);
		// ship.shoot(win);
		win.setFont(f1);
		win.setColor(Color.RED);

		main.bossbox.dying(win);

		win.drawImage(main.crash.loop(), null, (int) main.bossbox.getX() - 20, (int) main.bossbox.getY() - 90);
		win.drawImage(SnakeMain.raybody1right, null, (int)main.ship.getX()-34, (int)main.ship.getY()+15); 
		win.drawImage(SnakeMain.rayheadright,null, (int) main.ship.getX(), (int) main.ship.getY());		

		if (main.bossbox.getX() >= 900) {
			main.ship.victory(win);
			// warned.drawrect(win);
		}

		if (main.ship.getX() >= 1500) {
			GameState = 1;
			rectReset();
			
			pause = false;
			sounds.stop(0);
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.stop(4);
			sounds.stop(5);
			sounds.stop(6);
			sounds.stop(7);
			sounds.stop(8);
			sounds.stop(9);
			sounds.stop(10);
			
			sounds.play(3);

		}

		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + main.score, 10, 50);

		main.ship.fillhp(win);
	}

	
	public void comingstage1(Graphics2D win) {
		main.pow.movingin(win);

		main.r1.translate(-5, 0);
		main.r2.translate(-5, 0);
		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}

		for (int i = 0; i < main.star.length; i++) {

			main.star[i].moveAndDraw(win);
			
		}

		win.drawImage(deosprite.loop(), null, (int) main.pow.getX(), (int) main.pow.getY());

		main.ship.movement(win, main.ship, main.bossbox,main.pow);
		main.ship.shoot(win);

		if (main.pow.getX() < 675) {
			GameState = 10;
		}

		main.ship.fillhp(win);
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + main.score, 10, 50);
		
		win.setColor(Color.BLACK);
		win.fill(rectLeft);
		win.fill(rectRight);
		
		
		rectLeft.translate(-20, 0);
		rectRight.translate(20, 0);
		
		win.drawImage(poke4, null, fromLeft.x, fromLeft.y);
		win.drawImage(poke3, null, fromRight.x, fromRight.y);
		fromLeft.translate(-20, 0);
		fromRight.translate(20, 0);
	}

	public void bossstage2(Graphics2D win) {
		timer++;

		main.r1.translate(-5, 0);
		main.r2.translate(-5, 0);
		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}

		for (int i = 0; i < main.star.length; i++) {
			main.star[i].moveAndDraw(win);
			;
		}

		main.ship.movement(win, main.ship, main.bossbox,main.pow);
		main.ship.shoot(win);
		win.setFont(f1);
		win.setColor(Color.RED);

		main.pow.movement(win, main.ship);
		main.pow.shoot(win);

		win.drawImage(deosprite.loop(), null, (int) main.pow.getX(), (int) main.pow.getY());

		if (main.pow.lives <= 70) {
			GameState = 11;
		}

		if (main.ship.lives <= 0) {
			sounds.stop(0);
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.stop(5);
			sounds.stop(6);
			sounds.stop(7);
			sounds.stop(8);
			sounds.stop(9);
			sounds.stop(10);
			sounds.stop(11);
			
			sounds.play(4);
			GameState = 1;
			rectReset();
			pause = false;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(10);
			sounds.loop(0);
			reset();
			Main.reset();
		}

		main.ship.fillhp(win);
		win.setColor(Color.RED);
		win.drawString("Score: " + main.score, 10, 50);

	}

	public void spinattack2(Graphics2D win) {
		timer++;

		main.r1.translate(-5, 0);
		main.r2.translate(-5, 0);
		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}
		for (int i = 0; i < main.star.length; i++) {
			main.star[i].moveAndDraw(win);
			

		}

		main.ship.movement(win, main.ship, main.bossbox,main.pow);
		main.ship.shoot(win);

		if (main.pow.lives > 20) {
			main.pow.spinningattack(win, main.ship);
		}

		if (main.pow.lives <= 20 && main.pow.getX() < 670) {
			main.pow.return2(win);
		}

		else if (main.pow.getX() >= 670 && main.pow.lives <= 40 && main.pow.lives > 0) {
			main.pow.draw(win);
			main.pow.movement(win, main.ship);
		}

		if (main.pow.lives <= 0) {
			sounds.stop(0);
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.stop(4);
			sounds.stop(5);
			sounds.stop(7);
			sounds.stop(8);
			sounds.stop(9);
			sounds.stop(10);
			
			
			sounds.play(7);
			GameState = 12;
		}

		win.drawImage(deosprite.loop(), null, (int) main.pow.getX(), (int) main.pow.getY());

		win.setFont(f1);
		win.setColor(Color.RED);
		win.drawString("Score: " + main.score, 10, 50);

		if (main.ship.lives <= 0) {
			sounds.stop(10);
			sounds.play(4);
			GameState = 2;
		}

		main.ship.fillhp(win);
		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(10);
			sounds.loop(0);
			Main.reset();
		}
	}

	public void dyingstage2(Graphics2D win) {
		main.timers++;

		// bossbox.dying(win);
		// r1.translate(-5, 0);
		// r2.translate(-5, 0);
		
		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}

		for (int i = 0; i < main.star.length; i++) {
			// star[i].moveAndDraw(win);;

		}

		win.drawImage(SnakeMain.raybody1right, null, (int)main.ship.getX()-34, (int)main.ship.getY()+15); 
		win.drawImage(SnakeMain.rayheadright,null, (int) main.ship.getX(), (int) main.ship.getY());		
		win.setFont(f1);
		win.setColor(Color.RED);
		win.drawString("Score: " + main.score, 10, 50);

		main.warned.dyingflash(win);
		win.drawImage(deosprite.loop(), null, (int) main.pow.getX(), (int) main.pow.getY());

		if (main.timers == main.delays) {
			GameState = 13;

		}
		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(10);
			sounds.loop(0);
			Main.reset();
		}
		main.ship.fillhp(win);
		win.drawImage(SnakeMain.raybody1right, null, (int)main.ship.getX()-34, (int)main.ship.getY()+15); 
		win.drawImage(SnakeMain.rayheadright,null, (int) main.ship.getX(), (int) main.ship.getY());		
	}

	public void fallingout1(Graphics2D win) {
		timer++;

		// bossbox.dying(win);
		main.r1.translate(-5, 0);
		main.r2.translate(-5, 0);
		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}

		for (int i = 0; i < main.star.length; i++) {
			main.star[i].moveAndDraw(win);
		
		}

		main.ship.movement(win, main.ship, main.bossbox,main.pow);
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + main.score, 10, 50);

		main.pow.dying(win);

		win.drawImage(deosprite.loop(), null, (int) main.pow.getX(), (int) main.pow.getY());

		if (main.pow.getX() >= 900) {
			sounds.stop(10);
			GameState = 1;
			rectReset();
			sounds.play(3);
			pause = false;
			
			if (main.ship.lives < 75) {
				main.ship.lives += 25;
				main.ship.hpbar += 50;
			}
		}
		main.ship.fillhp(win);
	}
	
	public void mainHorde(Graphics2D win) {
		// TODO Auto-generated method stub

		main.r1.translate(-5, 0);
		main.r2.translate(-5, 0);
		win.drawImage(main.clouds1, null, (int) main.r1.getX(), 0);
		win.drawImage(main.clouds1, null, (int) main.r2.getX(), 0);

		if (main.r1.getX() == -1500) {
			main.r1.setLocation(1500, 0);
		}
		if (main.r2.getX() == -1500) {
			main.r2.setLocation(1500, 0);
		}
		
		for (int i = 0; i < main.star.length; i++) {
			main.star[i].moveAndDraw(win);
		}
		win.setFont(f1);

		main.ship.movement(win, main.ship, main.bossbox, main.pow);
		main.ship.shoot(win);

		 main.eh.moveAndDraw(win, main.ship, null);
		// ship.victory(win);
		if (main.ship.lives <= 0) {
			sounds.stop(10);
			sounds.play(4);
			GameState = 2;
		}


		win.setColor(Color.RED);

		win.drawString("Score: " + main.score, 10, 50);
		main.ship.fillhp(win);

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(10);
			sounds.loop(0);
			main.reset();
			reset();
		}
		
		win.setColor(Color.BLACK);
		win.fill(rectLeft);
		win.fill(rectRight);
		rectLeft.translate(-20, 0);
		rectRight.translate(20, 0);
		win.drawImage(poke4, null, fromLeft.x, fromLeft.y);
		win.drawImage(poke3, null, fromRight.x, fromRight.y);
		fromLeft.translate(-20, 0);
		fromRight.translate(20, 0);
		
		if (main.score >= 200) {
			GameState = 1;
			rectReset();
			sounds.play(3);
			sounds.stop(10);
			pause = false;
			
		}

	}
		
	

	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		if (GameState == 0) {
			this.splashscreen(win);
			
		}

		if (GameState == 1) {
			this.maingame(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
		}

		if (GameState == 2) {
			this.endScreen(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
		}

		if (GameState == 3) {
			this.instructions(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				Main.reset();
			}
		}
		
		if (GameState == 4) {
			this.comingstage(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
		
		}
		
		if (GameState == 5) {
			this.bossstage(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
			
			
		}
		
		if (GameState == 6) {
			this.spinattack(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
			
		}
		
		if (GameState == 7) {
			this.bossflashdie(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
			
		}
		if (GameState == 8) {
			this.dyingstage(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
			
		}
		if (GameState == 9) {
			this.comingstage1(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
			
		}
		if (GameState == 10) {
			this.bossstage2(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				rectReset();
				reset();
				Main.reset();
			}
			
		}
		if (GameState == 11) {
			this.spinattack2(win);
			
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
		}
		if (GameState == 12) {
			this.dyingstage2(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
			
		}
		if (GameState == 13) {
			this.fallingout1(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
		}
		
		
		if (GameState == 14) {
			this.pokemonBattle(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
		}
		if (GameState == 15) {
			this.mainHorde(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
		}
		
		if (GameState == 16) {
			this.loading(win);
			if (GameDriverV4.Keys[KeyEvent.VK_R]) {
				GameState = 0;
				sounds.stop(10);
				sounds.loop(0);
				reset();
				rectReset();
				Main.reset();
			}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		Global.xLoc = arg0.getX();
		Global.yLoc = arg0.getY();
		
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
