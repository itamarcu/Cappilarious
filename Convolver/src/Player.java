
public class Player {
	public static int radius = 10;
	public static double maxSpeedPow2 = 160000;
	public static double acceleration = 1000;
	double x;
	double y;
	int lastWaveIndex;
	double xVel, yVel;
	public Player(int x_, int y_)
	{
		lastWaveIndex = -1;
		x = x_;
		y = y_;
		xVel = 0;
		yVel = 0;
	}

}
