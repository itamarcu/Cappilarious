import java.awt.Color;

public class Wave {
	double cx, cy;
	double r1, r2;
	double width;
	double speed;
	public static Color purple = new Color(196, 0, 255, 80);
	public static int maxR1 = 1000;
	Color color;

	public Wave(double originX, double originY, double _speed, double _width, Color _color) {
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

	public boolean contains(double x, double y) {
		double dist = Math.pow(x - cx, 2) + Math.pow(y - cy, 2);
		return dist >= Math.pow(r1, 2) && dist <= Math.pow(r2, 2);
	}
}
