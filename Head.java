import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Head extends BodyPart implements Action {

	public static Boolean up, down, left, right;
	ArrayList<Laser> laser;
	int timer2, delay2, timer, delay;
	Boolean timers;

	public Head() {
		super(300, 300);
		dx = speed;
		up = false;
		left = true;
		down = false;
		right = false;
		laser = new ArrayList<Laser>();
		timer2 = 200;
		delay2 = 200;
		timer = 0;
		delay = 70;
		timers = false;

	}

	public void moveAndDraw(Graphics2D win) {
		timer2++;

		super.moveAndDraw(win);

		if (this.getX() % 30 == 0 && this.getY() % 30 == 0) {

			if (up) {
				dx = 0;
				dy = speed;

			}
			if (down) {
				dx = 0;
				dy = -speed;
			}
			if (left) {
				dx = speed;
				dy = 0;
			}
			if (right) {
				dx = -speed;
				dy = 0;
			}

		}

		if (GameDriverV4.Keys[KeyEvent.VK_W] && !down) {
			down = true;
			up = false;
			left = false;
			right = false;
		} else if (GameDriverV4.Keys[KeyEvent.VK_S] && !up) {
			down = false;
			up = true;
			left = false;
			right = false;
		} else if (GameDriverV4.Keys[KeyEvent.VK_A] && !right) {
			down = false;
			up = false;
			left = false;
			right = true;
		} else if (GameDriverV4.Keys[KeyEvent.VK_D] && !left) {
			down = false;
			up = false;
			left = true;
			right = false;
		}

		if (SnakeMain.gyra == true) {
			if (SnakeMain.bodycounter < 5) {
				if (up) {
					win.drawImage(SnakeMain.magikarpsheetdown.loop(), null, this.x - 30, this.y - 50);
				}
				if (down) {
					win.drawImage(SnakeMain.magikarpsheetup.loop(), null, this.x - 25, this.y);
				}
				if (left) {
					win.drawImage(SnakeMain.magikarpsheetright.loop(), null, this.x - 45, this.y - 35);
				}
				if (right) {
					win.drawImage(SnakeMain.magikarpsheetleft.loop(), null, this.x, this.y - 40);
				}
			}

			if (SnakeMain.bodycounter >= 5) {
				if (up) {
					win.drawImage(SnakeMain.gyradown, null, this.x - 50, this.y - 25);
				}
				if (down) {
					win.drawImage(SnakeMain.gyraup, null, this.x - 5, this.y - 15);
				}
				if (left) {
					win.drawImage(SnakeMain.gyraright, null, this.x - 30, this.y - 50);
				}
				if (right) {
					win.drawImage(SnakeMain.gyraleft, null, this.x - 30, this.y - 50);
				}
			}

		}
		if (SnakeMain.onix == true) {
			if (SnakeMain.bodycounter < 5) {
				if (up) {
					win.drawImage(SnakeMain.onixsheetdown.loop(), null, this.x, this.y - 14);
				}
				if (down) {
					win.drawImage(SnakeMain.onixsheetup.loop(), null, this.x - 25, this.y - 15);
				}
				if (left) {
					win.drawImage(SnakeMain.onixsheetright.loop(), null, this.x - 10, this.y - 25);
				}
				if (right) {
					win.drawImage(SnakeMain.onixsheetleft.loop(), null, this.x - 20, this.y - 25);
				}
			}

			if (SnakeMain.bodycounter >= 5) {
				if (up) {
					win.drawImage(SnakeMain.steelixsheetdown.loop(), null, this.x - 20, this.y - 10);

				}
				if (down) {
					win.drawImage(SnakeMain.steelixsheetup.loop(), null, this.x - 15, this.y - 15);
				}
				if (left) {
					win.drawImage(SnakeMain.steelixsheetright.loop(), null, this.x - 10, this.y - 20);
				}
				if (right) {
					win.drawImage(SnakeMain.steelixsheetleft.loop(), null, this.x - 25, this.y - 20);
				}
			}

		}
		if (SnakeMain.ray == true) {

			if (up) {
				win.drawImage(SnakeMain.rayheaddown, null, this.x - 53, this.y - 45);
			}
			if (down) {
				win.drawImage(SnakeMain.rayheadup, null, this.x - 5, this.y - 14);
			}
			if (left) {
				win.drawImage(SnakeMain.rayheadright, null, this.x - 30, this.y - 60);
			}
			if (right) {
				win.drawImage(SnakeMain.rayheadleft, null, this.x - 20, this.y - 60);
			}
		}

		if (timers == true) {
			timer++;
		}

		if (SnakeMain.power == true) {

			if (GameDriverV4.Keys[KeyEvent.VK_SPACE] && timer2 > delay2) {

				laser.add(new Laser((int) this.getX(), (int) this.getY()));
				timer2 = 0;
				timers = true;

			}

			if (laser != null) {
				for (int i = 0; i < laser.size(); i++) {
					laser.get(i).shoot(win);
					System.out.println(laser.get(i));

					if (SnakeMain.food.intersects(laser.get(i))) {
						// finalhp -= 20;
						laser.remove(i);
						timers = false;
						timer = 0;
						SnakeMain.food = new Food();

					}

					if (timer >= delay) {
						laser.remove(i);
						timers = false;
						timer = 0;

					}

				}
			}

		}
	}

}
