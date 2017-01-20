import java.awt.Color;

public class Wave {
	double cx, cy;
	double r1, r2;
	boolean infested;
	double plagueStart;
	double plagueEnd;
	double width;
	double speed;
	public static Color purple = new Color(196, 0, 255, 80);
	public static Color infestation = new Color(0, 100, 0, 250);
	public static int maxR1 = 1000;
	public static double intesificationRate = 0.1;
	Color color;
	public Wave(double originX, double originY, double _speed, double _width, Color _color) {
		infested=false;
		cx = originX;
		cy = originY;
		speed = _speed;
		r1 = -_width;
		width = _width;
		color = _color;
		r2 = 0;
	}

	public void update(double dt) {
		r1 += speed * dt;
		r2 += speed * dt;
	}
	
public void infest (double angle)
{
	infested=true;
	plagueStart=angle;
	plagueEnd=angle;
}

public void intensify (double dt)
{
	plagueEnd+=Wave.intesificationRate*dt;
}

public double [] intersectionAngles(Wave w)
{
	double [] results = new double [2];
	double d = Math.sqrt(Math.pow(w.cx-cx,2)+Math.pow(w.cy-cy, 2));
	double avgRad1=(w.r2+w.r1)/2;
	double avgRad2=(r1+r2)/2;
	if (d>avgRad1+avgRad2)
		results=new double[]{-1,-1};
	else if (d<Math.abs(avgRad1-avgRad2))
		results=new double[]{-1,-1};
	else if (d==0 && avgRad1==avgRad2)
		results=new double[]{-1,-1};
	else {

		double a = (Math.pow(avgRad1, 2) - Math.pow(avgRad2, 2) + Math.pow(d,  2) ) / (2*d);
		double h = Math.pow(avgRad1, 2) -Math.pow(a, 2);
		double x1= h + (cy-w.cy)/d;
		double x2= h-(cy-w.cy)/d;
		double y1= h-(cx-w.cx)/d;
		double y2= h+(cx-w.cx)/d;
		double ang1=Math.atan2(cy-y1, cx-x1);
		double ang2=Math.atan2(cy-y2, cx-x2);
		results = new double[]{ang1,ang2};
	}
	return results;
}

	public boolean contains(double x, double y) {
		double dist = Math.pow(x - cx, 2) + Math.pow(y - cy, 2);
		return dist >= Math.pow(r1, 2) && dist <= Math.pow(r2, 2);
	}
}
