import java.awt.Color;

public class Wave {
double cx, cy;
double r1, r2;
double width;
double speed;
Color color;
public static Color pink, red;

public Wave (double originX, double originY, double _speed, double _width, Color _color)
{
	cx=originX;
	cy=originY;
	speed=_speed;
	r1=-_width;
	width=_width;
	r2=0;
	color=_color;
}

public void update (double dt)
{
	r1+=speed*dt;
	r2+=speed*dt;
	}
public boolean contains (double x, double y)
{
	double dist=Math.pow(x-cx, 2);
	return dist>=Math.pow(r1, 2)&&dist<=Math.pow(r2, 2);
}
}

