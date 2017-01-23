public class Player extends Surfer
{
	int						ripple				= 0;
	public static double	maxUnderwater		= 1.5; //not including dash
	double					injureFlash			= 1;
	LifeRing				life				= new LifeRing(100);
	double					cantControlTimeLeft	= 0;
	public boolean			plunged				= false;
	public static double	dashSpeedPow2		= 1600000;
	public static int normalRadius = 12;
	public static int dashHitRadius = 24;
	int hitRadius;

	public Player(int x_, int y_, double maxSpeed)
	{
		super(x_, y_, maxSpeed);
		underwaterTimer = 0;
		radius = Player.normalRadius;
		hitRadius = radius;
	}

	public boolean damage(double d)
	{
		if (injureFlash > 0.5)
		{
			injureFlash = 0;
			life.life -= d;
			if (life.life < 0)
				life.life = 0;
			return true;
		}
		return false;
	}

	public boolean holdBreath(double dt)
	{
		underwaterTimer += dt;
		if (underwaterTimer >= Player.maxUnderwater)
		{
			underwaterTimer = Player.maxUnderwater;
			return this.damage(5);
		}
		return false;
	}
}
