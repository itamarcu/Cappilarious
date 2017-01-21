import java.awt.Color;

public class Colors
{
	// player/enemy
	public static Color	normalColor		= new Color(200, 225, 255);
	public static Color	dashColor		= new Color(200, 225, 255);
	public static Color	normalOutline	= new Color(150, 0, 50);
	public static Color	dashOutline		= new Color(225, 100, 255);
	public static Color	injuredColor	= Color.red;
	public static Color	chokingColor	= Color.white;
	// tringler
	public static Color	tringlerColor	= new Color(255, 255, 255);
	public static Color	tringlerOutline	= new Color(0, 0, 0);
	// waves
	public static Color	waveColor		= new Color(0, 50, 50, 150);

	// public static Color infestation = new Color(0, 100, 0, 250);
	public void setColors(int skin)
	{
		switch (skin)
		{
		case 0:
			// player/enemy
			normalColor = new Color(200, 225, 255);
			dashColor = new Color(200, 225, 255);
			normalOutline = new Color(150, 0, 50);
			dashOutline = new Color(225, 100, 255);
			injuredColor = Color.red;
			chokingColor = Color.white;
			// tringler
			tringlerColor = new Color(255, 255, 255);
			tringlerOutline = new Color(0, 0, 0);
			//wave
			waveColor = new Color(0, 50, 50, 150);
			break;
		}
	}
}
