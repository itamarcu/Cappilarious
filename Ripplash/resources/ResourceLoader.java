import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ResourceLoader
{
	static ResourceLoader rl = new ResourceLoader();

	public static BufferedImage getBufferedImage(String fileName)
	{
		BufferedImage b = null;
		try
		{
			b = ImageIO.read(rl.getClass().getResource("images/" + fileName));
			// For example, if this method is called with "sprites/player_3.png" as input, it will return the file called "player_3.png" located in the "sprites" directory in the "images" directory.
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);
		}
		return b;
	}
}
