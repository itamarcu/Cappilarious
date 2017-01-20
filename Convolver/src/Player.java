
public class Player extends Surfer
{
	public Player(int x_, int y_, double maxSpeed)
	{
		super(x_, y_, maxSpeed);
	}

	int ripple = 0;
	LifeRing life = new LifeRing(100);
	double underwaterTimer =0;
	public static int maxUnderwater =20;
	public void damage (double d)
	{
		life.life-=d;
	}
	
	public void holdBreath (double dt)
	{
		underwaterTimer+=dt;
		if (underwaterTimer>=Player.maxUnderwater)
			this.damage(20*dt);
	}
}
