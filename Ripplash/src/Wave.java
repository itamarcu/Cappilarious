import java.awt.Color;

public class Wave
{
	double					cx, cy;
	double					r1, r2;
	boolean					infested;
	double					plagueStart;
	double					plagueEnd;
	double					width;
	double					speed;
	public static Color		purple				= new Color(0, 50, 50, 150);
	public static Color		infestation			= new Color(0, 100, 0, 250);
	public double			maxR1				= 1400;
	public static double	intesificationRate	= 0.1;
	Color					color;
	boolean					surfable			= true;
	boolean damaging =false;

	public Wave(double originX, double originY, double _speed, double _width, Color _color)
	{
		infested = false;
		cx = originX;
		cy = originY;
		speed = _speed;
		r1 = -_width;
		width = _width;
		color = _color;
		r2 = 0;
	}

	/**
	 * not surfable!
	 */
	public Wave(double originX, double originY, double _speed, double _width, Color _color, double maxRadius)
	{
		this(originX, originY, _speed, _width, _color);
		maxR1 = maxRadius;
		surfable = false;
	}
	public Wave(double originX, double originY, double _speed, double _width, Color _color, double maxRadius, boolean _damaging)
	{
		this(originX, originY, _speed, _width, _color, maxRadius);
		surfable = false;
		damaging=_damaging;
	}

	public void update(double dt)
	{
		r1 += speed * dt;
		r2 += speed * dt;
	}

	public void infest(double angle)
	{
		infested = true;
		plagueStart = angle;
		plagueEnd = angle;
	}

	public void intensify(double dt)
	{
		plagueEnd += Wave.intesificationRate * dt;
	}

	public double[] intersectionAngles(Wave w)
	{
		double[] results = new double[2];
		double d = Math.sqrt(Math.pow(w.cx - cx, 2) + Math.pow(w.cy - cy, 2));
		double avgRad1 = (w.r2 + w.r1) / 2;
		double avgRad2 = (r1 + r2) / 2;
		if (d > avgRad1 + avgRad2)
			return new double[]
			{ -1, -1 };
		else if (d < Math.abs(avgRad1 - avgRad2))
			return new double[]
			{ -1, -1 };
		else if (d == 0)
			return new double[]
			{ -1, -1 };

		double a = (Math.pow(avgRad1, 2) - Math.pow(avgRad2, 2) + Math.pow(d, 2)) / (2 * d);
		double h = Math.sqrt(Math.pow(avgRad1, 2) - Math.pow(a, 2));
		double x1 = w.cx + (cx - w.cx) * (a / h) + h * (cy - w.cy) / d;
		double x2 = w.cx + (cx - w.cx) * (a / h) - h * (cy - w.cy) / d;
		double y1 = w.cy + (cy - w.cy) * (a / h) - h * (cx - w.cx) / d;
		double y2 = w.cy + (cy - w.cy) * (a / h) + h * (cx - w.cx) / d;
		double ang1 = Math.atan2(cy - y1, cx - x1) + 2 * Math.PI;
		double ang2 = Math.atan2(cy - y2, cx - x2) + 2 * Math.PI;
		results = new double[]
		{ ang1, ang2 };
		// System.out.println("cx="+cx+", cy="+cy+", w.cx="+w.cx+", w.c="+w.cy+", r="+avgRad2+", w.r="+avgRad1);
		// System.out.println("d="+d+", a="+a+", h="+h+", x1="+x1+", y1="+y1+", x2="+x2+", y2="+y2+"");
		// System.out.println(results[0]+ " " +results[1]);
		// System.out.println();
		return results;
	}

	public double[][] intersectionPoints(Wave w)
	{
		double[][] results = new double[2][2];
		double d = Math.sqrt(Math.pow(w.cx - cx, 2) + Math.pow(w.cy - cy, 2));
		double avgRad1 = (w.r2 + w.r1) / 2;
		double avgRad2 = (r1 + r2) / 2;
		if (d > avgRad1 + avgRad2)
			return null;
		else if (d < Math.abs(avgRad1 - avgRad2))
			return null;
		else if (d == 0)
			return null;

		double a = (Math.pow(avgRad1, 2) - Math.pow(avgRad2, 2) + Math.pow(d, 2)) / (2 * d);
		double h = Math.pow(avgRad1, 2) - Math.pow(a, 2);
		double x1 = h + (cy - w.cy) / d;
		double x2 = h - (cy - w.cy) / d;
		double y1 = h - (cx - w.cx) / d;
		double y2 = h + (cx - w.cx) / d;
		results = new double[][]
		{
				{ x1, y1 },
				{ x2, y2 } };
		return results;
	}

	public boolean inInfectionRange(double ang)
	{
		return angleDiff(plagueStart, ang) > 0 && angleDiff(ang, plagueEnd) > 0;
	}

	public double angleDiff(double an1, double an2)
	{
		int a = (int) (an1 / Math.PI * 180);
		int b = (int) (an2 / Math.PI * 180);
		int d = Math.abs(a - b) % 360;
		double r = d > 180 ? 360 - d : d;

		// calculate sign
		int sign = (a - b >= 0 && a - b <= 180) || (a - b <= -180 && a - b >= -360) ? 1 : -1;
		r *= sign;
		return (r * Math.PI / 180);
	}

	public boolean contains(double x, double y)
	{
		double dist = Math.pow(x - cx, 2) + Math.pow(y - cy, 2);
		return dist >= Math.pow(r1, 2) && dist <= Math.pow(r2, 2);
	}

	public boolean contains(Surfer s)
	{
		double dist = Math.pow(s.x - cx, 2) + Math.pow(s.y - cy, 2);
		return dist >= Math.pow(r1+s.radius, 2) && dist <= Math.pow(r2-s.radius, 2);
	}
}
