import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

class Main extends JFrame implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener,
		ComponentListener, WindowFocusListener {
	// Constants
	final double TAU = 2 * Math.PI;

	// Variables
	boolean leftMousePressed = false;
	boolean leftPressed, rightPressed, upPressed, downPressed;
	Point camera; // Marks the CENTER of the screen to be drawn, not the top
					// left point

	double timeThatPassed;

	List<Wave> waves;
	List<Waver> wavers;

	// Stuff that should not be touched
	private static final long serialVersionUID = 1;
	int frameHeight, frameWidth;
	PointerInfo pin; // Don't use this
	Point incorrectMousePoint = new Point(); // Don't use that
	int mx = 0; // Mouse X coordinate relative to FRAME
	int my = 0; // Mouse Y coordinate relative to FRAME
	int bufferWidth; // ignore
	int bufferHeight; // ignore
	Image bufferImage; // ignore, unless you want to do stuff with this
	Graphics bufferGraphics; // ignore

	// This is where the magic happens
	void gameFrame(double deltaTime) {
		timeThatPassed += deltaTime;
		for (int i = 0; i < waves.size(); i++) {
			Wave w = waves.get(i);
			w.update(deltaTime);
		}
		for (int i = 0; i < wavers.size(); i++) {
			Waver wr = wavers.get(i);
			wr.update(deltaTime);
			if (wr.timeLeft <= 0)
			{
				waves.add(wr.generateWave());
			}
		}
	}

	// This is what you use to call draw methods or to just draw. Is called in
	// the repaint() method which is called after every frame.
	void paintBuffer(final Graphics g) {
		Graphics2D buffer = (Graphics2D) g;

		// Move "camera" to position
		AffineTransform original = buffer.getTransform();
		buffer.translate(0.5 * frameWidth, 0.5 * frameHeight);
		buffer.translate(-camera.x, -camera.y);

		// Draw stuff

		buffer.drawOval(-20, -20, 40, 40);
		// Waves
		for (Wave w : waves) {
			// Draw outlines
			buffer.setStroke(new BasicStroke(2));
			buffer.setColor(Wave.pink);
			buffer.drawOval((int) (w.cx - w.r2), (int) (w.cy - w.r2), (int) (2 * w.r2), (int) (2 * w.r2));
			buffer.drawOval((int) (w.cx - w.r1), (int) (w.cy - w.r1), (int) (2 * w.r1), (int) (2 * w.r1));
		}

		// Wavers
		for (Waver wr : wavers) {
			// Draw plus sign
			buffer.setStroke(new BasicStroke(2));
			buffer.setColor(Color.red);
			buffer.drawLine((int)(wr.x),(int)(wr.y-20),(int)(wr.x),(int)(wr.y+20));
			buffer.drawLine((int)(wr.x-20),(int)(wr.y),(int)(wr.x+20),(int)(wr.y));
		}

		// Move camera back
		buffer.setTransform(original);

		// More example code
		buffer.drawImage(Resources.exampleImage, -55, -55, null);
		buffer.rotate(-TAU / 4, frameWidth - 90, frameHeight * 4 / 5 + 300 / 2);
		buffer.drawImage(Resources.exampleImage2, frameWidth - 45, frameHeight * 4 / 5 + 300 / 2, null);
		buffer.rotate(TAU / 4, frameWidth - 90, frameHeight * 4 / 5 + 300 / 2);
	}

	// Setup of everything! Put stuff in here, not in Main()!
	void restart() {
		camera = new Point(0, 0);
		leftMousePressed = false;
		leftPressed = false;
		rightPressed = false;
		upPressed = false;
		downPressed = false;
		Resources.initialize();

		waves = new ArrayList<Wave>();
		wavers = new ArrayList<Waver>();

		wavers.add(new Waver(300, 150, 120, 120, 1.0, Wave.pink));
		wavers.add(new Waver(-300, -350, 120, 120, 1.0, Wave.pink));
		wavers.add(new Waver(100, 550, 120, 120, 1.0, Wave.pink));
	}

	// Is called when you start to press a key, and then keeps being called
	// until you stop pressing the key
	public void keyPressed(final KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_R:// Restart
			restart();
			break;
		case KeyEvent.VK_ESCAPE:// Exit
			exitGame();
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			leftPressed = true;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			rightPressed = true;
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			upPressed = true;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			downPressed = true;
			break;
		default:
			// another key was pressed; do nothing.
			break;
		}
	}

	// Is called when you stop pressing a key
	public void keyReleased(final KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			leftPressed = false;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			rightPressed = false;
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			upPressed = false;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			downPressed = false;
			break;
		default:
			// another key was released; do nothing.
			break;
		}
	}

	// Start of the program. Set-up stuff happens in restart(), NOT in here!
	public Main() {
		setSize(640, 640); // will be the size if window stops being maximized
		setResizable(true);
		setFocusTraversalKeysEnabled(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				exitGame();
			}
		});

		frameWidth = (int) this.getBounds().getWidth();
		frameHeight = (int) this.getBounds().getHeight();

		setVisible(true);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		addComponentListener(this);
		addWindowFocusListener(this);
		addMouseWheelListener(this);
	}

	// Just don't change the main() method
	public static void main(String[] args) {
		Main main = new Main();
		main.restart();
		main.mainLoop();
	}

	// Main loop. You probably shouldn't change the code here.
	void mainLoop() {
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

		// keep looping until the game ends
		while (true) {
			// work out how long its been since the last update
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);

			// update the game logic
			gameFrame(delta / TARGET_FPS);

			// draw everyting
			repaint();

			try {
				Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			;
		}
	}

	// When you exit the game
	void exitGame() {
		System.exit(0);
	}

	// IGNORE
	private void adjustbuffer() {
		// getting image size
		bufferWidth = getSize().width;
		bufferHeight = getSize().height;

		// clean buffered image
		if (bufferGraphics != null) {
			bufferGraphics.dispose();
			bufferGraphics = null;
		}
		if (bufferImage != null) {
			bufferImage.flush();
			bufferImage = null;
		}
		System.gc(); // Garbage cleaner

		// create the new image with the size of the panel
		bufferImage = createImage(bufferWidth, bufferHeight);
		bufferGraphics = bufferImage.getGraphics();
	}

	// IGNORE
	public void update(final Graphics g) {
		paint(g);
	}

	// IGNORE
	public void paint(final Graphics g) {
		// Resetting the buffered Image
		if (bufferWidth != getSize().width || bufferHeight != getSize().height || bufferImage == null
				|| bufferGraphics == null)
			adjustbuffer();

		if (bufferGraphics != null) {
			// this clears the offscreen image, not the onscreen one
			bufferGraphics.clearRect(0, 0, bufferWidth, bufferHeight);

			// calls the paintbuffer method with buffergraphics
			paintBuffer(bufferGraphics);

			// painting the buffered image on to the visible frame
			g.drawImage(bufferImage, 0, 0, this);
		}
	}

	// IGNORE
	public void keyTyped(final KeyEvent e) {

	}

	// IGNORE
	public void mouseDragged(final MouseEvent me) {
		// Getting mouse info
		pin = MouseInfo.getPointerInfo();
		incorrectMousePoint = pin.getLocation();
		mx = (int) (incorrectMousePoint.getX() - this.getX());
		my = (int) (incorrectMousePoint.getY() - this.getY());
	}

	// IGNORE
	public void mouseClicked(final MouseEvent me) {
	}

	// IGNORE
	public void mouseEntered(final MouseEvent me) {
	}

	// IGNORE
	public void componentHidden(ComponentEvent arg0) {

	}

	// When the window is resized by the user
	public void componentResized(ComponentEvent e) {
		frameWidth = (int) this.getBounds().getWidth();
		frameHeight = (int) this.getBounds().getHeight();
	}

	// IGNORE
	public void componentMoved(ComponentEvent arg0) {

	}

	// IGNORE
	public void componentShown(ComponentEvent arg0) {

	}

	// IGNORE
	public void mouseExited(final MouseEvent me) {

	}

	// Mouse position changed
	public void mouseMoved(final MouseEvent me) {
		// Getting mouse info
		pin = MouseInfo.getPointerInfo();
		incorrectMousePoint = pin.getLocation();
		mx = (int) (incorrectMousePoint.getX() - this.getX());
		my = (int) (incorrectMousePoint.getY() - this.getY());
	}

	// Mouse was pressed
	public void mousePressed(final MouseEvent me) {
		// BUTTON1 = left click
		// BUTTON2 = mid click (scroll wheel click),
		// BUTTON3 = right click
		// This will only trigger when you press the mouse, and only once.
		// Unlike the keys it won't repeatedly "click" the mouse again
		if (me.getButton() == MouseEvent.BUTTON1) // Left Click
		{
			leftMousePressed = true;
		}
	}

	// Mouse was unpressed
	public void mouseReleased(final MouseEvent me) {
		if (me.getButton() == MouseEvent.BUTTON1) // Left Click
		{
			leftMousePressed = false;
		}
	}

	// Window gained focus
	public void windowGainedFocus(WindowEvent arg0) {

	}

	// Window lost focus
	public void windowLostFocus(WindowEvent arg0) {

	}

	// Mouse was scrolled up/down
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		@SuppressWarnings("unused")
		boolean direction = arg0.getWheelRotation() == 1 ? true : false;
	}

}
