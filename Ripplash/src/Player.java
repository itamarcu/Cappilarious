public class Player extends Surfer
{
	int						ripple				= 0;
	public static double	maxUnderwater		= 2;
	double					injureFlash			= 1;
	LifeRing				life				= new LifeRing(100);
	double					cantControlTimeLeft	= 0;
	public static double	dashSpeedPow2		= 1600000;

	public Player(int x_, int y_, double maxSpeed)
	{
		super(x_, y_, maxSpeed);
		underwaterTimer = 0;
		radius = 12;
	}

	public void damage(double d)
	{
		if (injureFlash > 0.5)
		{
			injureFlash = 0;
			life.life -= d;
			if (life.life < 0)
				life.life = 0;
		}
	}

	public void holdBreath(double dt)
	{
		underwaterTimer += dt;
		if (underwaterTimer >= Player.maxUnderwater)
		{
			this.damage(5);
			underwaterTimer = maxUnderwater;
		}
	}
}
