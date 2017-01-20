import java.awt.Color;

public class Waver {
	double x, y;
	double speed;
	double waveWidth;
	double freq;
	double timeLeft;
	Color color;

	public Waver(double centerX, double centerY, double _speed, double _waveWidth, double _freq, Color _color) {

		x = centerX;
		y = centerY;
		speed = _speed;
		waveWidth = _waveWidth;
		freq = _freq;
		color = _color;
		timeLeft = freq;

		x = centerX;
		y = centerY;
		speed = _speed;
		waveWidth = _waveWidth;
		freq = _freq;
		color = _color;
		timeLeft = freq;

	}

	public Wave generateWave() {
		timeLeft = freq;
		Wave w = new Wave(x, y, speed, waveWidth, color);
		return w;
	}

	public void update(double dt) {
		timeLeft -= dt;
	}
}
