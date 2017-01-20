import java.awt.Color;

public class Wave {
double cx, cy;
double r1, r2;
double speed;
Color color;
public static Color pink, red;

public Wave (double originX, double originY, double speed, double width, Color color)
{
	cx=originX;
	cy=originY;
	this.speed=speed;
	this.r1=-width;
	this.r2=0;
	this.color=color;
}

public void update (double dt)
{
	r1+=speed*dt;
	r2+=speed*dt;
	}
}

