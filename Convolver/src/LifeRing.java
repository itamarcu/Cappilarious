import java.awt.Color;

public class LifeRing
{
	public static Color	dead	= new Color(255, 0, 0);
	public static Color	healthy	= new Color(255, 255, 255);

	double				life;
	double				maxLife;
	double				rotation;

	public LifeRing(double _life)
	{
		maxLife = _life;
		life = _life;
		rotation = 0;
	}

	public void rotate(double dt)
	{
		rotation += dt * (600 - 500 * (life / maxLife));
		if (rotation > 360)
			rotation -= 360;
	}

	public Color getColor()
	{
		/*
		 * double red = healthy.getRed()*(life/maxLife)+dead.getRed()*((maxLife-life)/maxLife); double green = healthy.getGreen()*(life/maxLife)+dead.getGreen()*((maxLife-life)/maxLife); double blue =
		 * healthy.getBlue()*(life/maxLife)+dead.getBlue()*((maxLife-life)/maxLife);
		 */
		double red = 255;
		double green = life > 50 ? 255 : 0;
		double blue = life > 50 ? 255 : 0;
		return new Color((int) red, (int) green, (int) blue);
	}

	public double getAngle()
	{
		return life / maxLife * Math.PI * 2;
	}

}
