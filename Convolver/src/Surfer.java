
public class Surfer {
	public static int radius = 10;
	public static double maxSpeedPow2 = 200000;
	public static double acceleration = 1000;
	double x;
	double y;
	int lastWaveIndex;
	double xVel, yVel;
	public Surfer(int x_, int y_)
	{
		lastWaveIndex = -1;
		x = x_;
		y = y_;
		xVel = 0;
		yVel = 0;
	}

}
