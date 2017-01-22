import java.awt.image.BufferedImage;

public class Resources {

	static BufferedImage darkEdges;
	static BufferedImage redEdges;
	public static void initialize() {
		darkEdges = ResourceLoader.getBufferedImage("black edges.png");
		redEdges = ResourceLoader.getBufferedImage("red edges.png");
	}
}
