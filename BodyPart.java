import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class BodyPart extends GameObject {

	int speed = 5;
	BodyPart leader;
	int timer = 0, delay = 15;
	boolean chillDude = true;
	int initialDx, initialDy;
	Random rand = new Random();
	int x1 = rand.nextInt(8) + 1;
	int x2 = SnakeMain.bodycounter;
	ArrayList<BodyPart> yay = new ArrayList<>();
	Boolean up;
	Boolean down;
	Boolean left;
	Boolean right;

	public BodyPart(int x, int y) {
		super(x, y, 30, 30, 0, 0, Color.BLUE);
		yay = SnakeMain.body;

	}

	public BodyPart(BodyPart leader) {
		this(leader.x, leader.y);
		this.col = Color.ORANGE;

		this.leader = leader;
		this.dx = 0;
		this.dy = 0;

		this.initialDx = leader.dx;
		this.initialDy = leader.dy;

		right = Head.right;
		left = Head.left;
		down = Head.down;
		up = Head.up;

	}

	public void followTheLeader() {

		if (this.dx != 0) {
			if (this.x == leader.x) {
				this.dx = 0;
				this.dy = leader.dy;
			}
		}

		if (this.dy != 0) {
			if (this.y == leader.y) {
				this.dy = 0;
				this.dx = leader.dx;
			}
		}
	}

	public void moveAndDraw(Graphics2D win) {
		super.moveAndDraw(win);
		// win.drawImage(SnakeMain.onixbodyy.loop(), null, this.x, this.y);

		if (!chillDude) {
			this.followTheLeader();
		}

		if (leader != null) {

			if (SnakeMain.onix == true) {
				if (SnakeMain.bodycounter < 5) {

					if (x2 <= 2) {
						win.drawImage(SnakeMain.onixbody1, null, this.x, this.y);
					}
					if (x2 > 2) {
						win.drawImage(SnakeMain.onixbody2, null, this.x, this.y);
					}
				}

				if (SnakeMain.bodycounter >= 5) {
					if (x1 == 1) {
						win.drawImage(SnakeMain.steelix1, null, this.x - 30, this.y - 30);
					}
					if (x1 == 2) {
						win.drawImage(SnakeMain.steelix2, null, this.x - 30, this.y - 30);
					}
					if (x1 == 3) {
						win.drawImage(SnakeMain.steelix3, null, this.x - 30, this.y - 30);
					}
					if (x1 == 4) {
						win.drawImage(SnakeMain.steelix4, null, this.x - 30, this.y - 30);
					}
					if (x1 == 5) {
						win.drawImage(SnakeMain.steelix5, null, this.x - 30, this.y - 30);
					}
					if (x1 == 6) {
						win.drawImage(SnakeMain.steelix6, null, this.x - 30, this.y - 30);
					}
					if (x1 == 7) {
						win.drawImage(SnakeMain.steelix7, null, this.x - 30, this.y - 30);
					}
					if (x1 == 8) {
						win.drawImage(SnakeMain.steelix8, null, this.x - 30, this.y - 30);
					}

				}
			}

			if (SnakeMain.gyra == true) {
				if (SnakeMain.bodycounter < 5) {
					if (x1 == 1 || x1 == 2 || x1 == 3) {
						win.drawImage(SnakeMain.bubble1, null, this.x, this.y);
					}

					if (x1 == 4 || x1 == 5 || x1 == 6) {
						win.drawImage(SnakeMain.bubble2, null, this.x, this.y);
					}

					if (x1 == 7 || x1 == 8) {
						win.drawImage(SnakeMain.bubble2, null, this.x, this.y);
					}

				}

				if (SnakeMain.bodycounter >= 5) {
					if (this.dy < 0) {
						win.drawImage(SnakeMain.gyrabody3, null, this.x - 20, this.y - 30);
					}
					if (this.dy > 0) {
						win.drawImage(SnakeMain.gyrabody2, null, this.x - 20, this.y - 30);
					}

					if (this.dx < 0) {
						win.drawImage(SnakeMain.gyrabody1, null, this.x - 20, this.y - 30);
					}
					if (this.dx > 0) {
						win.drawImage(SnakeMain.gyrabody4, null, this.x - 20, this.y - 30);
					}
				}
			}

			if (SnakeMain.ray == true) {

				if (x2 == 1) {
					if (this.dy < 0) {
						win.drawImage(SnakeMain.raybody1up, null, this.x - 30, this.y - 10);
					}
					if (this.dy > 0) {
						win.drawImage(SnakeMain.raybody1down, null, this.x - 30, this.y - 53);
					}

					if (this.dx < 0) {
						win.drawImage(SnakeMain.raybody1left, null, this.x - 20, this.y - 40);
					}
					if (this.dx > 0) {
						win.drawImage(SnakeMain.raybody1right, null, this.x - 30, this.y - 40);
					}

				}
				if (x2 > 1) {

					if (this.dy < 0) {
						win.drawImage(SnakeMain.raybody2up, null, this.x - 0, this.y - 0);
					}
					if (this.dy > 0) {
						win.drawImage(SnakeMain.raybody2down, null, this.x - 10, this.y - 0);
					}

					if (this.dx < 0) {
						win.drawImage(SnakeMain.raybody2left, null, this.x + 5, this.y - 10);
					}
					if (this.dx > 0) {
						win.drawImage(SnakeMain.raybody2right, null, this.x - 5, this.y - 20);
					}

				}

			}

			if (leader != null && chillDude) {
				if (timer > delay) {
					chillDude = false;

					this.dx = this.initialDx;
					this.dy = this.initialDy;

				} else {
					timer++;
				}

			}

			if (leader != null && chillDude) {
				if (timer > delay) {
					chillDude = false;

					this.dx = this.initialDx;
					this.dy = this.initialDy;

				} else {
					timer++;
				}

			}

			if (leader != null && chillDude) {
				if (timer > delay) {
					chillDude = false;

					this.dx = this.initialDx;
					this.dy = this.initialDy;

				} else {
					timer++;
				}

			}
			if (leader != null && chillDude) {
				if (timer > delay) {
					chillDude = false;

					this.dx = this.initialDx;
					this.dy = this.initialDy;

				} else {
					timer++;
				}

			}
		}

	}
}