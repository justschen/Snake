import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Main extends GameDriverV4 implements MouseMotionListener{

	public static Main instance;
	public static BufferedImage spikes, spinspin, openimage, crashimage, waddlebossimage, gothit, warningimage, canon;
	public static SpriteSheet spikesheet, waddlesheet, spinattack, waddleboss, rocket, shocker;
	public static SpriteSheet topshot, botshot, midshot, open, crash, warning, big, gethit;
	public static BufferedImage waddleshot, rocketshot, frames, kabulaicon, waddleicon, kirbyicon;
	public static BufferedImage kabulaname, waddlename, kirbyname, shockerimage, shockbeam;
	public static Ship ship = new Ship();

	int dx = 50, dy = 50;
	static int timer;
	static int delay;
	static int timer2;
	static int timers;
	static int delays;
	static int timers2;
	static int delays2;
	public static int score;
	int angle = 0;
	static int GameState;
	static int timerss;
	static int delayss;
	static int kirby;
	static int kirby1;

	double theta = 0;
	double dtheta = 2 * Math.PI / 10;

	static Warning warned;

	Lasers[] pew = new Lasers[3];
	Lasers[] pewpew = new Lasers[3];

	Stars[] star = new Stars[60];
	Particle[] particle;

	static BufferedImage[] sprite = new BufferedImage[3];
	static BossClass bossbox;
	static BossDee pow;
	static Color col = new Color(157, 172, 234);

	Boolean reset = false, spin = true;

	BufferedImage flyingin, clouds1, logos;
	BufferedImage testing = this.addImage("kabulabig.png");
	BufferedImage kabulacoming = this.addImage("kabula 2.png");
	BufferedImage cloud = this.addImage("clouds.png");
	BufferedImage cloudflip = this.addImage("cloudflip.png");
	BufferedImage toptop, botbot, midmid, waddle;

	SpriteSheet test, kabula, fly, sides, dededefly;

	Lasers hp;

	polypower polygon;

	Rectangle tester = new Rectangle(400, 400, 100, 100);
	Rectangle r1, r2;
	static Rectangle r3;
	static Rectangle r4;

	Font f1 = new Font("Comic Sans MS", Font.BOLD, 50);

	static NMEhandler eh;
	static NMEhandler yeet;

	static NME l;
	static NME2 a;
	static NME3 b;

	static Boolean movement;

	static SoundDriver sounds;

	Rectangle rect = new Rectangle(100, 100, 664, 250);

	SpriteSheet runnable;
	BufferedImage image, dedede;

	public static int livesx;

	static Boolean up;

	Rectangle hpbar;

	static int timerssss;
	static int delaywin;

	BufferedImage ye0, ye1, ye2, ye3, ye4, warpup, warpdown, backgrounds;
	SpriteSheet back, mad, g;
	BufferedImage in1, in2, in3, in4, in5, in6, in7, goback, sadkirby, madde, gg;

	public Main() {
		// Lasers1 = new ArrayList<Lasers>();
		kabulaicon = this.addImage("icon0.png");
		kirbyicon = this.addImage("icon1.png");
		waddleicon = this.addImage("icon2.png");
		kabulaname = this.addImage("names1.png");
		kirbyname = this.addImage("names1.png");
		waddlename = this.addImage("names2.png");
		shockbeam = this.addImage("shockbeam.png");
		dedede = this.addImage("dedede.png");
		dededefly = new SpriteSheet(dedede, 2);
		dededefly.changeFrameDelayTo(4);
		shockerimage = this.addImage("shocker.png");
		shocker = new SpriteSheet(shockerimage, 6);
		shocker.changeFrameDelayTo(10);

		madde = this.addImage("madde.png");
		gg = this.addImage("gg.png");
		mad = new SpriteSheet(madde, 2);
		g = new SpriteSheet(gg, 13);
		mad.changeFrameDelayTo(7);
		g.changeFrameDelayTo(5);

		backgrounds = this.addImage("background.png");
		back = new SpriteSheet(backgrounds, 4);
		back.changeFrameDelayTo(5);

		ye0 = this.addImage("ye0.png");
		ye1 = this.addImage("ye1.png");
		ye2 = this.addImage("ye2.png");
		ye3 = this.addImage("ye3.png");
		ye4 = this.addImage("ye4.png");
		warpup = this.addImage("sprite_1.png");
		warpdown = this.addImage("sprite_0.png");

		in1 = this.addImage("r.png");
		in2 = this.addImage("c.png");
		in3 = this.addImage("toobad.png");
		in4 = this.addImage("airship.png");
		in5 = this.addImage("defeat.png");
		in6 = this.addImage("minions.png");
		in7 = this.addImage("king.png");

		rocketshot = this.addImage("rocket.png");
		rocket = new SpriteSheet(rocketshot, 2);
		rocket.changeFrameDelayTo(10);
		waddleshot = this.addImage("shoot.png");
		gothit = this.addImage("gethit.png");
		gethit = new SpriteSheet(gothit, 3);

		image = this.addImage("testtt.png");
		runnable = new SpriteSheet(image, 107);
		runnable.changeFrameDelayTo(4);
		frames = this.addImage("tester.png");
		big = new SpriteSheet(frames, 164);
		big.changeFrameDelayTo(2);
		canon = this.addImage("Cannon.png");
		warningimage = this.addImage("warning.png");
		warning = new SpriteSheet(warningimage, 3);
		warning.changeFrameDelayTo(20);
		crashimage = this.addImage("dying.png");
		crash = new SpriteSheet(crashimage, 7);
		waddlebossimage = this.addImage("waddleboss.png");
		waddleboss = new SpriteSheet(waddlebossimage, 22);
		waddleboss.changeFrameDelayTo(5);
		openimage = this.addImage("Opening.png");
		open = new SpriteSheet(openimage, 16);
		spinspin = this.addImage("spinattack!.png");
		spinattack = new SpriteSheet(spinspin, 16);

		flyingin = this.addImage("flyy.png");
		spikes = this.addImage("spike!.png");
		toptop = this.addImage("sides.png");
		topshot = new SpriteSheet(toptop, 6);
		topshot.changeFrameDelayTo(5);
		botbot = this.addImage("otherside.png");
		botshot = new SpriteSheet(botbot, 6);
		botshot.changeFrameDelayTo(5);
		midmid = this.addImage("midshot.png");
		midshot = new SpriteSheet(midmid, 4);
		waddle = this.addImage("waddledee.png");
		waddlesheet = new SpriteSheet(waddle, 22);
		waddlesheet.changeFrameDelayTo(10);
		sprite[0] = this.addImage("normal.png");
		sprite[1] = this.addImage("up.png");
		sprite[2] = this.addImage("down.png");
		clouds1 = this.addImage("clouds1.png");

		test = new SpriteSheet(testing, 35);
		test.changeFrameDelayTo(2);
		kabula = new SpriteSheet(kabulacoming, 4);
		kabula.changeFrameDelayTo(2);
		fly = new SpriteSheet(flyingin, 2);
		fly.changeFrameDelayTo(10);
		spikesheet = new SpriteSheet(spikes, 5);
		spikesheet.changeFrameDelayTo(11);
		
		r1 = new Rectangle(0, 1, 0, 80);
		r2 = new Rectangle(1500, 1, 0, 80);

		sadkirby = this.addImage("sad.png");
		goback = this.addImage("rback.png");

		spikes = this.addImage("spike!.png");
		logos = this.addImage("log.png");

		String[] fileNames = new String[14];
		fileNames[0] = "victory!.wav";
		fileNames[1] = "attack.wav";
		fileNames[2] = "hpup.wav";
		fileNames[3] = "airship.wav";
		fileNames[4] = "shoot.wav";
		fileNames[5] = "greengreens.wav";
		fileNames[6] = "gourmet.wav";
		fileNames[7] = "halberd.wav";
		fileNames[8] = "warning.wav";
		fileNames[9] = "gethit.wav";
		fileNames[10] = "boop.wav";
		fileNames[11] = "loselife.wav";
		fileNames[12] = "springbreeze.wav";
		fileNames[13] = "dededetheme.wav";
		// fileNames[14] = "starsrewritten.wav";

		sounds = new SoundDriver(fileNames);
	//	sounds.loop(5);

		for (int i = 0; i < star.length; i++) {
			star[i] = new Stars();
		}

		reset();
		resetpoly();
	}
	
	
	public static void stateReset() {
		timerssss = 0;
		delaywin = 430;
		bossbox = new BossClass();
		bossbox.rocket = new Rocket(bossbox, ship);
		r3 = new Rectangle(-120, 10, 0, 300);
		r4 = new Rectangle(0, 320, 10, 10);
		pow = new BossDee();
		eh = new NMEhandler();
		yeet = new NMEhandler();
		warned = new Warning();
		// ship = new Ship();
		l = new NME();
		a = new NME2();
		b = new NME3();
		livesx = 300;
		// hpbar = new Rectangle(10, 720, livesx, 30);
		timer = 0;
		delay = 200;
		timer2 = 0;
		timers = 0;
		delays = 70;
		timers2 = 0;
		delays2 = 70;
		ship.setLocation(20, 30);
		GameState = 0;
		timerss = 0;
		delayss = 150;
		up = true;
		kirby = 4;
		kirby1 = 4;
		movement = true;
	}

	public static void reset() {
		timerssss = 0;
		delaywin = 430;
		bossbox = new BossClass();
		bossbox.rocket = new Rocket(bossbox, ship);
		r3 = new Rectangle(-120, 10, 0, 300);
		r4 = new Rectangle(0, 320, 10, 10);
		pow = new BossDee();
		eh = new NMEhandler();
		yeet = new NMEhandler();
		warned = new Warning();
		// ship = new Ship();
		l = new NME();
		a = new NME2();
		b = new NME3();
		score = 0;
		livesx = 300;
		// hpbar = new Rectangle(10, 720, livesx, 30);
		timer = 0;
		delay = 200;
		timer2 = 0;
		timers = 0;
		delays = 70;
		timers2 = 0;
		delays2 = 70;
		ship.lives = 100;
		ship.hpbar = 300;
		ship.setLocation(20, 30);
		GameState = 0;
		timerss = 0;
		delayss = 150;
		up = true;
		kirby = 4;
		kirby1 = 4;
		movement = true;

	}

	public void resetpoly() {
		polygon = new polypower();
	}

	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		instance = new Main();
		instance.start();
		instance.setBackGroundColor(col);
		instance.setFocusable(true);
	}
	*/

	public void splashsplash(Graphics2D win) {
		int splashtimer = 0, delaytimer = 1;
		splashtimer++;

		win.setFont(f1);
		win.setColor(Color.WHITE);
		win.fill(rect);

		r1.translate(-5, 0);
		r2.translate(-5, 0);

		if (movement == false) {
			r3.translate(5, kirby);
		}
		win.drawImage(clouds1, null, (int) r1.getX(), 80-30);
		win.drawImage(clouds1, null, (int) r2.getX(), 80-30);
		win.drawImage(fly.loop(), null, (int) r3.getX(), (int) r3.getY());

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		if (r3.getX() == 100 || r3.getX() == 200 || r3.getX() == 300 || r3.getX() == 400 || r3.getX() == 500) {
			kirby *= -1;
		}

		r4.translate(10, 0);

		if (movement) {
			AffineTransform tran = win.getTransform();
			theta += dtheta;
			win.rotate(theta, r4.getCenterX(), r4.getCenterY());
			win.drawImage(logos, null, (int) r4.getX(), (int) r4.getY());
			win.setTransform(tran);
		}

		if (r4.getX() == 300) {
			movement = false;
		}

		if (movement == false) {
			win.drawImage(logos, null, 300, 305);
			// kirby1 = 0;
		}

		win.drawImage(ye1, null, 110, 600);
		win.drawImage(ye4, null, 110, 500);

		if (up == true) {
			win.drawImage(warpup, null, 320, 490);
		} else if (up != true) {
			win.drawImage(warpdown, null, 230, 590);
		}

		if (GameDriverV4.Keys[KeyEvent.VK_UP]) {
			up = true;
		} else if (GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
			up = false;
		}

		if (up == true && GameDriverV4.Keys[KeyEvent.VK_ENTER]) {
			GameState = 1;
			sounds.loop(3);
			sounds.stop(5);
		}

		if (up == false && GameDriverV4.Keys[KeyEvent.VK_ENTER]) {
			GameState = 19;
			sounds.stop(5);
			sounds.loop(12);
		}
		win.setColor(Color.YELLOW);
		polygon.moveAndDraw(win);
		if (GameDriverV4.Keys[KeyEvent.VK_I]) {
			sounds.stop(5);
			sounds.play(0);
			GameState = 17;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_U]) {
			sounds.stop(5);
			sounds.play(11);
			sounds.loop(13);
			GameState = 18;
		}

	}

	public void maingame(Graphics2D win) {
		// TODO Auto-generated method stub

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80-50);
		win.drawImage(clouds1, null, (int) r2.getX(), 80-50);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80-50);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80-50);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);
		}
		win.setFont(f1);

		ship.movement(win, ship, bossbox, pow);
		ship.shoot(win);

		eh.moveAndDraw(win, ship, null);
		// ship.victory(win);
		if (ship.lives <= 0) {
			sounds.stop(3);
			sounds.play(11);
			GameState = 15;
		}

		if (score >= 500 || GameDriverV4.Keys[KeyEvent.VK_O]) {
			GameState = 2;
			sounds.stop(3);
			sounds.loop(8);

		}

		if (GameDriverV4.Keys[KeyEvent.VK_P]) {
			GameState = 8;
			sounds.stop(3);
			sounds.loop(8);

		}

		win.setColor(Color.RED);

		win.drawString("Score: " + score, 10, 50);
		ship.fillhp(win);

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(3);
			sounds.loop(5);
			reset();
		}

	}

	public void warningstage(Graphics2D win) {

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80-50);
		win.drawImage(clouds1, null, (int) r2.getX(), 80-50);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80-50);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80-50);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);

		}

		ship.movement(win, ship, bossbox,pow);
		ship.fillhp(win);
		win.setFont(f1);

		win.setColor(Color.RED);

		timer++;
		warned.drawrect(win);

		win.drawImage(warning.loop(), null, 200, 300);

		if (timer == delay) {
			GameState = 3;
			sounds.stop(8);
			sounds.loop(6);

		}
		win.drawString("Score: " + score, 10, 50);

	}

	public void comingstage1(Graphics2D win) {
		pow.movingin(win);

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80-50);
		win.drawImage(clouds1, null, (int) r2.getX(), 80-50);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80-50);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80-50);
		}

		for (int i = 0; i < star.length; i++) {

			star[i].moveAndDraw(win);
			;
		}

		win.drawImage(waddleboss.loop(), null, (int) pow.getX(), (int) pow.getY());

		ship.movement(win, ship, bossbox,pow);
		ship.shoot(win);

		if (pow.getX() < 675) {
			GameState = 4;
		}

		ship.fillhp(win);
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

	}

	public void bossstage2(Graphics2D win) {
		timer++;

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80-50);
		win.drawImage(clouds1, null, (int) r2.getX(), 80-50);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80-50);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80-50);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);
			;
		}

		ship.movement(win, ship, bossbox,pow);
		ship.shoot(win);
		win.setFont(f1);
		win.setColor(Color.RED);

		pow.movement(win, ship);

		win.drawImage(waddleboss.loop(), null, (int) pow.getX(), (int) pow.getY());

		if (pow.lives <= 70) {
			GameState = 5;
		}

		if (ship.lives <= 0) {
			sounds.stop(6);
			sounds.play(11);
			GameState = 15;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(6);
			sounds.loop(5);
			reset();
		}

		ship.fillhp(win);
		win.setColor(Color.RED);
		win.drawString("Score: " + score, 10, 50);

	}

	public void spinattack2(Graphics2D win) {
		timer++;

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);
			;

		}

		ship.movement(win, ship, bossbox,pow);
		ship.shoot(win);

		if (pow.lives > 40) {
			pow.spinningattack(win, ship);
		}

		if (pow.lives <= 40 && pow.getX() < 670) {
			pow.return2(win);
		}

		else if (pow.getX() >= 670 && pow.lives <= 40 && pow.lives > 0) {
			pow.draw(win);
			pow.movement(win, ship);
		}

		if (pow.lives <= 0) {
			sounds.stop(6);
			sounds.play(9);
			GameState = 6;
		}

		win.drawImage(waddleboss.loop(), null, (int) pow.getX(), (int) pow.getY());

		win.setFont(f1);
		win.setColor(Color.RED);
		win.drawString("Score: " + score, 10, 50);

		if (ship.lives <= 0) {
			sounds.stop(6);
			sounds.play(11);
			GameState = 15;
		}

		ship.fillhp(win);
		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(6);
			sounds.loop(5);
			reset();
		}
	}

	public void dyingstage2(Graphics2D win) {
		timers++;

		// bossbox.dying(win);
		// r1.translate(-5, 0);
		// r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			// star[i].moveAndDraw(win);;

		}

		win.drawImage(sprite[0], null, (int) ship.getX(), (int) ship.getY());
		win.setFont(f1);
		win.setColor(Color.RED);
		win.drawString("Score: " + score, 10, 50);

		warned.dyingflash(win);
		win.drawImage(waddleboss.loop(), null, (int) pow.getX(), (int) pow.getY());

		if (timers == delays) {
			GameState = 7;

		}
		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(6);
			sounds.loop(5);
			reset();
		}
		ship.fillhp(win);
		win.drawImage(sprite[0], null, (int) ship.getX(), (int) ship.getY());

	}

	public void fallingout1(Graphics2D win) {
		timer++;

		// bossbox.dying(win);
		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);
			;

		}

		ship.movement(win, ship, bossbox,pow);
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

		pow.dying(win);

		win.drawImage(waddleboss.loop(), null, (int) pow.getX(), (int) pow.getY());

		if (pow.getX() >= 900) {
			GameState = 14;
			sounds.play(2);
			if (ship.lives < 75) {
				ship.lives += 25;
				ship.hpbar += 50;
			}

			sounds.stop(6);
			sounds.loop(3);
		}
		ship.fillhp(win);

	}

	public void warningstage2(Graphics2D win) {

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);

		}

		ship.movement(win, ship, bossbox,pow);
		win.setColor(Color.RED);

		timer2++;
		warned.drawrect(win);

		win.drawImage(warning.loop(), null, 200, 300);

		if (timer2 == delay) {
			GameState = 9;
			sounds.stop(8);
			sounds.loop(7);

		}

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(6);
			sounds.loop(5);
			reset();
		}
		win.drawString("Score: " + score, 10, 50);
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

	}

	public void comingstage(Graphics2D win) {
		// TODO Auto-generated method stub

		bossbox.movingin(win);

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {

			star[i].moveAndDraw(win);
			;
		}

		win.drawImage(kabula.loop(), null, (int) bossbox.getX() - 20, (int) bossbox.getY() - 90);

		ship.movement(win, ship, bossbox,pow);
		// ship.shoot(win);
		win.setFont(f1);
		win.setColor(Color.RED);

		if (bossbox.getX() < 675) {
			GameState = 10;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(6);
			sounds.loop(5);
			reset();
		}
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

		ship.fillhp(win);

	}

	public void bossstage(Graphics2D win) {
		// TODO Auto-generated method stub
		timer++;

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);
			;
		}

		ship.movement(win, ship, bossbox,pow);
		ship.shoot(win);
		bossbox.movement(win, ship);

		win.drawImage(test.loop(), null, (int) bossbox.getX() - 20, (int) bossbox.getY() - 90);

		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

		if (bossbox.lives <= 70) {
			GameState = 11;
		}

		if (ship.lives <= 0) {
			sounds.stop(7);
			sounds.play(11);
			GameState = 15;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(7);
			sounds.loop(5);
			reset();
		}
		ship.fillhp(win);

	}

	public void spinattack(Graphics2D win) {
		timer++;

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);
			;

		}

		ship.movement(win, ship, bossbox,pow);
		ship.shoot(win);

		if (bossbox.lives > 40) {
			bossbox.spinningattack(win, ship);
		}

		if (bossbox.lives <= 40 && bossbox.getX() < 670) {
			bossbox.return2(win);
		}

		// bossbox.returnto(win);
		else if (bossbox.getX() >= 670 && bossbox.lives <= 40 && bossbox.lives > 0) {
			bossbox.draw(win);
			bossbox.movement(win, ship);
		}

		if (bossbox.lives <= 0) {
			sounds.play(9);
			GameState = 12;
		}

		if (bossbox.lives > 40) {
			win.drawImage(spinattack.loop(), null, (int) bossbox.getX() - 20, (int) bossbox.getY() - 90);
		}

		else if (bossbox.lives > 0) {
			win.drawImage(open.loop(), null, (int) bossbox.getX() - 20, (int) bossbox.getY() - 90);
		}

		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

		if (ship.lives <= 0) {
			sounds.stop(7);
			sounds.play(11);
			GameState = 15;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(7);
			sounds.loop(5);
			reset();
		}
		ship.fillhp(win);

	}

	public void bossflashdie(Graphics2D win) {
		timers2++;

		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);
			;

		}

		// ship.shoot(win);
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

		warned.dyingflash(win);
		win.drawImage(crash.loop(), null, (int) bossbox.getX() - 20, (int) bossbox.getY() - 90);
		win.drawImage(sprite[0], null, (int) ship.getX(), (int) ship.getY());

		if (GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
			GameState = 1;
			// warned.drawrect(win);
		}

		if (timers2 == delays2) {
			GameState = 13;
		}
	}

	public void dyingstage(Graphics2D win) {
		// bossbox.dying(win);

		win.drawImage(crash.loop(), null, (int) bossbox.getX() - 20, (int) bossbox.getY() - 90);

		if (GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
			GameState = 1;
			// warned.drawrect(win);
		}

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);
			;

		}

		// ship.movement(win, ship, bossbox);
		// ship.shoot(win);
		win.setFont(f1);
		win.setColor(Color.RED);

		bossbox.dying(win);

		win.drawImage(crash.loop(), null, (int) bossbox.getX() - 20, (int) bossbox.getY() - 90);
		win.drawImage(sprite[0], null, (int) ship.getX(), (int) ship.getY());

		if (bossbox.getX() >= 900) {
			ship.victory(win);
			// warned.drawrect(win);
		}

		if (ship.getX() >= 1500) {
			GameState = 17;
			sounds.stop(7);
			sounds.play(0);

		}

		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

		ship.fillhp(win);
	}

	public void main2(Graphics2D win) {

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);

		}
		win.setFont(f1);

		if (ship.lives <= 0) {
			sounds.stop(3);
			sounds.play(11);
			GameState = 15;

		}

		yeet.attack2(win, ship, null);
		ship.movement(win, ship, bossbox,pow);
		ship.shoot(win);

		if (score == 1500 || GameDriverV4.Keys[KeyEvent.VK_O]) {

			GameState = 8;
			sounds.stop(3);
			sounds.loop(8);
		}

		// win.drawString("HP");

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(3);
			sounds.loop(5);
			reset();
		}
		ship.fillhp(win);

		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

	}

	public void playerdeath1(Graphics2D win) {
		timers++;
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			// star[i].moveAndDraw(win);;

		}

		ship.dying(win);
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

		//

		// pow.dying(win);

		// win.drawImage(waddleboss.loop(), null, (int)pow.getX(),(int)pow.getY());

		warned.dyingflash(win);

		timerss++;
		if (timerss == delayss) {
			sounds.loop(13);
			GameState = 16;

		}

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(0);
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.stop(4);
			sounds.stop(6);
			sounds.loop(5);
			sounds.stop(7);
			sounds.stop(8);
			sounds.stop(9);
			sounds.stop(10);
			sounds.stop(11);
			sounds.stop(12);
			sounds.stop(13);

			reset();
		}

	}

	public void playerdeath2(Graphics2D win) {
		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		for (int i = 0; i < star.length; i++) {
			star[i].moveAndDraw(win);
			;

		}

		ship.dying(win);
		// ship.shoot(win);

		//

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(0);
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.stop(4);
			sounds.stop(6);
			sounds.loop(5);
			sounds.stop(7);
			sounds.stop(8);
			sounds.stop(9);
			sounds.stop(10);
			sounds.stop(11);
			sounds.stop(12);
			sounds.stop(13);
			reset();
		}

		if (ship.getX() <= -30) {
			GameState = 18;
		}

		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("Score: " + score, 10, 50);

	}

	public void tryagain(Graphics2D win) {
		win.drawImage(in3, null, 220, 20);
		win.drawImage(in1, null, 220, 70);
		win.setColor(Color.RED);
		win.drawImage(g.loop(), null, 0, 200);
		win.drawImage(sadkirby, null, 700, 400);
		win.setFont(f1);
		win.drawString("SCORE:" + score, 390, 170);

		polygon.moveAndDraw(win);

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(0);
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.stop(4);
			sounds.stop(6);
			sounds.loop(5);
			sounds.stop(7);
			sounds.stop(8);
			sounds.stop(9);
			sounds.stop(10);
			sounds.stop(11);
			sounds.stop(12);
			sounds.stop(13);
			reset();
		}

	}

	public void instructionspage(Graphics2D win) {

		r1.translate(-5, 0);
		r2.translate(-5, 0);
		win.drawImage(clouds1, null, (int) r1.getX(), 80);
		win.drawImage(clouds1, null, (int) r2.getX(), 80);

		if (r1.getX() == -1450) {
			r1.setLocation(1550, 80);
		}
		if (r2.getX() == -1450) {
			r2.setLocation(1550, 80);
		}

		win.drawImage(in7, null, 30, 90 - 40);
		win.drawImage(in6, null, -40, 150 - 40);
		win.drawImage(in5, null, 420, 250 - 70);
		win.drawImage(in4, null, 330, 320 - 70);
		win.drawImage(ye0, null, -90, 390);
		win.drawImage(ye2, null, 300, 490);
		win.drawImage(ye3, null, 20, 590);
		win.drawImage(goback, null, 300, 680);
		win.drawImage(fly.loop(), null, 100, 200);
		win.drawImage(dededefly.loop(), null, 720, 290);

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			sounds.stop(12);
			sounds.play(5);
			GameState = 0;
		}

	}

	public void congrats(Graphics2D win) {

		timerssss++;
		// win.drawImage(runnable.loop(), null, 100,100);

		win.drawImage(back.loop(), null, 0, 200);
		win.drawImage(runnable.loop(), null, 350, 510);
		win.drawImage(mad.loop(), null, 270, 530);
		win.drawImage(in2, null, 220, 20);
		win.drawImage(in1, null, 220, 70);
		win.setColor(Color.RED);
		win.setFont(f1);
		win.drawString("SCORE:" + score, 370, 170);

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			GameState = 0;
			sounds.stop(0);
			sounds.stop(1);
			sounds.stop(2);
			sounds.stop(3);
			sounds.stop(4);
			sounds.stop(6);
			sounds.loop(5);
			sounds.stop(7);
			sounds.stop(8);
			sounds.stop(9);
			sounds.stop(10);
			sounds.stop(11);
			sounds.stop(12);
			sounds.stop(13);
			reset();
		}

		// if (timerssss == delaywin) {
		// GameState = 18;

	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		if (GameState == 0) {
			this.splashsplash(win);
		}
		if (GameState == 1) {
			this.maingame(win);
		}

		if (GameState == 2) {
			this.warningstage(win);
		}
		if (GameState == 3) {

			this.comingstage1(win);
		}
		if (GameState == 4) {
			this.bossstage2(win);
		}
		if (GameState == 5) {
			this.spinattack2(win);
		}

		if (GameState == 6) {
			this.dyingstage2(win);
		}

		if (GameState == 7) {
			this.fallingout1(win);
		}

		if (GameState == 8) {
			this.warningstage2(win);
		}

		if (GameState == 9) {
			this.comingstage(win);
		}

		if (GameState == 10) {
			this.bossstage(win);
		}

		if (GameState == 11) {
			this.spinattack(win);
		}

		if (GameState == 12) {
			this.bossflashdie(win);
		}

		if (GameState == 13) {
			this.dyingstage(win);
		}
		if (GameState == 14) {
			this.main2(win);
		}

		if (GameState == 15) {
			this.playerdeath1(win);
		}
		if (GameState == 16) {
			this.playerdeath2(win);
		}
		if (GameState == 17) {
			this.congrats(win);
		}

		if (GameState == 18) {
			this.tryagain(win);
		}

		if (GameState == 19) {
			this.instructionspage(win);
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}
}
