import java.awt.Color;

public class Tringler
{
	public static int	radius			= 24;
	public static Color	radGreen		= new Color(100, 255, 100);
	public static Color	sicklyGreen		= new Color(100, 255, 0);
	double				x;
	double				y;
	double				chargeTimeLeft;
	double				chargeDelay		= 4;
	double				rotation;
	double				xVel, yVel;
	double				prevDistPow2	= 9999999;					// to know when to stop dashing
	boolean				slowDown		= true;

	public Tringler(double x_, double y_)
	{
		x = x_;
		x = y_;
		chargeTimeLeft = 5;
		rotation = 0;
		xVel = 0;
		yVel = 0;
	}
}
