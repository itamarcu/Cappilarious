import java.awt.Color;

public class Waver {
	double cx, cy;
	double speed;
	double waveWidth;
	double freq;
	double timeSinceLastWave;
	Color color;
	
	
	public Waver (double centerX, double centerY, double speed, double waveWidth, double freq, Color color)
	{
		cx=centerX;
		cy=centerY;
		this.speed=speed;
		this.waveWidth=waveWidth;
		this.freq=freq;
		this.color=color;
		timeSinceLastWave=0;
	}
	public Wave generateWave ()
	{
		timeSinceLastWave=0;
		Wave w= new Wave (cx, cy, speed, waveWidth, color);
		return w;
	}
}
