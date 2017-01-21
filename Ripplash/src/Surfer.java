
public class Surfer
{
	public int				radius			= 18;	// for drawing only
	public double			maxSpeedPow2;
	public static double	acceleration	= 1000;
	double					x;
	double					y;
	int						lastWaveIndex;
	double					xVel, yVel;
	boolean					shielded		= false;
	double					underwaterTimer	= -3;	// to give time when they spawn

	public Surfer(double x_, double y_, double maxSpeed)
	{
		lastWaveIndex = -1;
		x = x_;
		y = y_;
		xVel = 0;
		yVel = 0;
		maxSpeedPow2 = maxSpeed * maxSpeed;
	}

}
