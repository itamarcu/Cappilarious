import java.awt.Color;

public class TringlerDeath
{
	double		pos;
	double[]	xPoints1;
	double[]	xPoints2;
	double[]	yPoints1;
	double[]	yPoints2;
	double		separationSpeed;
	double		separationAngle;
	double	initialXVel;
	double initialYVel;

	/**
	 * 
	 * @param t
	 *            former tringler
	 * @param dcx
	 *            death cause x
	 * @param dcy
	 *            death cause y
	 */
	public TringlerDeath(Tringler t, double dcx, double dcy)
	{
		separationAngle = Math.atan2(dcy - t.y, dcx - t.x);
		xPoints1 = new double[3];
		yPoints1 = new double[3];
		xPoints2 = new double[3];
		yPoints2 = new double[3];
		// first corpse
		xPoints1[0] = (t.x + Tringler.radius * Math.cos(separationAngle));
		yPoints1[0] = (t.y + Tringler.radius * Math.sin(separationAngle));
		xPoints1[1] = (t.x - Tringler.radius * Math.cos(separationAngle) / 2);
		yPoints1[1] = (t.y - Tringler.radius * Math.sin(separationAngle) / 2);
		xPoints1[2] = t.x + Tringler.radius * Math.cos(t.rotation + Math.PI / 3 * 2);
		yPoints1[2] = t.y + Tringler.radius * Math.sin(t.rotation + Math.PI / 3 * 2);
		// second corpse
		xPoints2[0] = (t.x + Tringler.radius * Math.cos(separationAngle));
		yPoints2[0] = (t.y + Tringler.radius * Math.sin(separationAngle));
		xPoints2[1] = (t.x - Tringler.radius * Math.cos(separationAngle) / 2);
		yPoints2[1] = (t.y - Tringler.radius * Math.sin(separationAngle) / 2);
		xPoints2[2] = t.x + Tringler.radius * Math.cos(t.rotation - Math.PI / 3 * 2);
		yPoints2[2] = t.y + Tringler.radius * Math.sin(t.rotation - Math.PI / 3 * 2);
		pos = 0.5;
		separationSpeed = 30;
		separationAngle += Math.PI / 2;
		 initialXVel =t.xVel;
		 initialYVel =t.yVel;
	}

	public void update(double dt)
	{
		for (int i = 0; i < 3; i++)
		{
			xPoints1[i] += (initialXVel+separationSpeed * Math.cos(separationAngle)) * dt;
			yPoints1[i] += (initialYVel+separationSpeed * Math.sin(separationAngle)) * dt;
			xPoints2[i] -= (-initialXVel+separationSpeed * Math.cos(separationAngle)) * dt;
			yPoints2[i] -= (-initialYVel+separationSpeed * Math.sin(separationAngle)) * dt;
		}
		pos -= dt;
	}

	public static int[] getPaintablePoints(double[] arr)
	{
		int[] intArray = new int[arr.length];
		for (int i = 0; i < intArray.length; ++i)
			intArray[i] = (int) arr[i];
		return intArray;
	}
	public Color opacitate (Color color)
	{
		return new Color (color.getRed(), color.getGreen(), color.getBlue(), (int)(pos/0.5*255));
	}
}
