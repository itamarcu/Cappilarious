import java.awt.Color;

public class LifeRing
{
public static Color dead = new Color (255, 0, 0);
public static Color healthy = new Color (255, 255, 255);

double life;
double maxLife;

public LifeRing (double _life)
{
	maxLife=_life;
	life=_life;
}
public Color getColor ()
{
	double red = healthy.getRed()*(life/maxLife)+dead.getRed()*((maxLife-life)/maxLife);
	double green = healthy.getGreen()*(life/maxLife)+dead.getGreen()*((maxLife-life)/maxLife);
	double blue = healthy.getBlue()*(life/maxLife)+dead.getBlue()*((maxLife-life)/maxLife);
	return new Color((int)red,(int) green,(int) blue);
}
public double getAngle ()
{
	return life/maxLife*Math.PI*2;
}

}
