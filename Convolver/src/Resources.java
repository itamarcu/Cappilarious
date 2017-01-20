import java.awt.image.BufferedImage;

public class Resources
{
	public static BufferedImage exampleImage;
	public static BufferedImage exampleImage2;

	public static void initialize()
	{
		exampleImage = ResourceLoader.getBufferedImage("example.png");
		exampleImage2 = ResourceLoader.getBufferedImage("example folder/example2.png");
	}
}
