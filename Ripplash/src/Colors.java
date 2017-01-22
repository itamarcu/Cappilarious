import java.awt.Color;

public class Colors
{
	public static Color	backgroundColor;
	// player
	public static Color	normalColor;
	public static Color	dashColor;
	public static Color	normalOutline;
	public static Color	dashOutline;
	public static Color	injuredColor;
	public static Color	chokingColor;
	// enemy surfer
	public static Color	enemyColor;
	public static Color	enemyOutline;
	// tringler
	public static Color	tringlerColor;
	public static Color	tringlerOutline;
	// waves
	public static Color	waveColor;
	public static int	curr	= -1; //to start at 1

	// public static Color infestation = new Color(0, 100, 0, 250);
	public static void setColors(int skin)
	{
		switch (skin)
		{
		case 0:
			backgroundColor = new Color(50, 150, 255);
			// player
			normalColor = new Color(100, 255, 0);
			dashColor = new Color(100, 255, 0);
			normalOutline = new Color(150, 0, 50);
			dashOutline = new Color(225, 100, 255);
			injuredColor = Color.red;
			chokingColor = Color.white;
			// enemy
			enemyColor = new Color(200, 225, 255);
			enemyOutline = new Color(150, 0, 50);
			// tringler
			tringlerColor = new Color(255, 255, 255);
			tringlerOutline = new Color(0, 0, 0);
			// wave
			waveColor = new Color(0, 50, 50, 150);
			break;
		case 1:
			backgroundColor = new Color(50, 15, 0);
			// player/enemy
			normalColor = new Color(255, 20, 0);
			dashColor = new Color(255, 0, 0);
			normalOutline = new Color(255, 255, 100);
			dashOutline = new Color(255, 255, 50);
			injuredColor = Color.red;
			chokingColor = new Color(100, 0, 100, 150);
			// enemy
			enemyColor = new Color(255, 20, 0);
			enemyOutline = new Color(255, 255, 100);
			// tringler
			tringlerColor = new Color(255, 200, 0);
			tringlerOutline = new Color(255, 0, 0);
			// wave
			waveColor = new Color(255, 30, 0, 150);
			break;
		case 2:
			backgroundColor = new Color(255, 235, 235);
			// player/enemy
			normalColor = new Color(50, 0, 0);
			dashColor = new Color(255, 200, 200);
			normalOutline = new Color(255, 200, 200);
			dashOutline = new Color(50, 0, 0);
			injuredColor = Color.red;
			chokingColor = new Color(100, 0, 100, 150);
			// enemy
			enemyColor = new Color(50, 0, 0);
			enemyOutline = new Color(255, 200, 200);
			// tringler
			tringlerColor = new Color(255, 200, 200);
			tringlerOutline = new Color(255, 0, 0);
			// wave
			waveColor = new Color(255, 100, 100, 150);
			break;
		case 3:
			backgroundColor = new Color(255, 255, 255);
			// player/enemy
			normalColor = new Color(255, 0, 0);
			dashColor = new Color(200, 235, 255);
			normalOutline = new Color(0, 0, 0);
			dashOutline = new Color(255, 255, 255);
			injuredColor = Color.red;
			chokingColor = new Color(100, 0, 100, 150);
			// enemy
			enemyColor = new Color(255, 255, 255);
			enemyOutline = new Color(0, 0, 0);
			// tringler
			tringlerColor = new Color(0, 0, 0);
			tringlerOutline = new Color(255, 255, 255);
			// wave
			waveColor = new Color(0, 0, 0, 255);
			break;
		case 4:
			backgroundColor = new Color(0, 0, 0);
			// player/enemy
			normalColor = new Color(100, 255, 0);
			dashColor = new Color(100, 255, 0);
			normalOutline = new Color(0, 0, 0);
			dashOutline = new Color(255, 255, 255);
			injuredColor = new Color(0, 150, 0);
			chokingColor = new Color(50, 100, 50);
			// enemy
			enemyColor = new Color(100, 255, 0);
			enemyOutline = new Color(0, 0, 0);
			// tringler
			tringlerColor = new Color(50, 150, 0);
			tringlerOutline = new Color(100, 255, 0);
			// wave
			waveColor = new Color(50, 200, 20, 150);
			break;
		default:
			break;
		}
	}

	public static void nextColor()
	{
		curr = (curr + 1) % 5;
		Colors.setColors(Colors.curr);
	}

	public static Color opacitate(Color color, int a)
	{
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int) (a));
	}
}
