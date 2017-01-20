import java.awt.Color;

public class Waver {
	double cx, cy;
	double speed;
	double waveWidth;
	double freq;
	double timeSinceLastWave;
	Color color;
	
	
	public Waver (double centerX, double centerY, double _speed, double _waveWidth, double _freq, Color _color)
	{
		cx=centerX;
		cy=centerY;
		speed=_speed;
		waveWidth=_waveWidth;
		freq=_freq;
		color=_color;
		timeSinceLastWave=0;
	}
	public Wave generateWave ()
	{
		timeSinceLastWave=0;
		Wave w= new Wave (cx, cy, speed, waveWidth, color);
		return w;
	}
}
