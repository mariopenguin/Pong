import java.awt.*;

public class Ball
{
	public static final int TIME = 1;

	private int x, y;
	private int dx, dy;
	private Color color;
	private int speed;
	private int speedUpDelay = 25;
	private int delay = 0;

	public Ball(Color c, int x, int y)
	{
		color = c;
		this.x = x;
		this.y = y;
		dx = (Math.random() < .9)?1:-1;
		dy = (Math.random() < .5)?1:-1;
		speed = 4;
	}

	public void move()
	{
		delay = (delay+1)%speedUpDelay;
		if(delay == 0)
			speed++;
		x+=(int)(getUnitDX()*speed);
		y+=(int)(getUnitDY()*speed);
	}

	public Point getLocation()
	{
		return new Point(x,y);
	}

	private double getUnitDX()
	{
		return ((double)dx/(double)(Math.sqrt(dx*dx + dy*dy)));
	}

	private double getUnitDY()
	{
		return ((double)dy/(double)(Math.sqrt(dx*dx + dy*dy)));
	}

	public void bounceSide()
	{
		dx = -dx;
		dy = (int)(Math.random()*8)-4;
		move();
		move();
	}

	public void bounceTop()
	{
		dy = -dy;
		move();
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x- TIME, y- TIME, TIME *2, TIME *2);
	}
}