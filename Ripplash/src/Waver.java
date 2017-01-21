public class Waver {
	double x, y;
	double speed;
	double waveWidth;
	double freq;
	double timeLeft;

	public Waver(double centerX, double centerY, double _speed, double _waveWidth, double _freq) {
		x = centerX;
		y = centerY;
		speed = _speed;
		waveWidth = _waveWidth;
		freq = _freq;
		timeLeft = 0; //is good

	}
	public Waver(double centerX, double centerY, double _speed, double _waveWidth, double _freq, double delay) {
	this(centerX, centerY, _speed, _waveWidth,_freq);
	timeLeft=delay;
	}

	public Wave generateWave() {
		timeLeft = freq;
		Wave w = new Wave(x, y, speed, waveWidth);
		return w;
	}

	public void update(double dt) {
		timeLeft -= dt;
	}
}
