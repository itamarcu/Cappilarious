import java.awt.Color;

public class Colors
{
	public static Color	backgroundColor		= new Color(50, 150, 255);
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
public static int curr=0;
	// public static Color infestation = new Color(0, 100, 0, 250);
	public static void setColors(int skin)
	{
		switch (skin)
		{
		case 0:
			backgroundColor		= new Color(50, 150, 255);
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
		case 1:
			backgroundColor		= new Color(240, 235, 0);
			// player/enemy
			normalColor = new Color(150, 0, 125);
			dashColor = new Color(200, 0, 125);
			normalOutline = new Color(50, 50, 0);
			dashOutline = new Color(100, 50, 0);
			injuredColor = Color.red;
			chokingColor = new Color(100, 0, 100, 150);
			// tringler
			tringlerColor = new Color(50, 0, 0);
			tringlerOutline = new Color(255, 0, 0);
			//wave
			waveColor = new Color(100, 0, 0, 150);
			break;
		}
	}
	public static void nextColor()
	{
		curr=(curr+1)%2;
		Colors.setColors(Colors.curr);
	}
}
