
public class Player extends Surfer
{
	int						ripple			= 0;
	double					life			= 100;
	double					underwaterTimer	= 0;
	public static double	maxUnderwater	= 2;
	double					injureFlash		= 1;

	public Player(int x_, int y_, double maxSpeed)
	{
		super(x_, y_, maxSpeed);
		radius = 12;
	}

	public void damage(double d)
	{
		life -= d;
		if (injureFlash > 0.5)
			injureFlash = 0;
	}

	public void holdBreath(double dt)
	{
		underwaterTimer += dt;
		if (underwaterTimer >= Player.maxUnderwater)
		{
			this.damage(20 * dt);
			underwaterTimer = maxUnderwater;
		}
	}
}
