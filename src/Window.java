import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private BufferStrategy strategy;
	private Player p;
	private Map map;
	
	private int width;
	private int height;
	
	public Window(int x, int y) {
		setLayout(null);
		width = x;
		height = y;
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Dots and Boxes");
		
		Toolkit tk = Toolkit.getDefaultToolkit();

		Dimension screenDim = tk.getScreenSize();

		int xPos = (screenDim.width / 2) - (this.getWidth() / 2);
		int yPos = (screenDim.height / 2) - (this.getHeight() / 2);
		
		setLocation(xPos, yPos);
		setIgnoreRepaint(true);
		setVisible(true);
		
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		
		addKeyListener(new PlayerKeyListener());
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void draw() {
		Graphics g = strategy.getDrawGraphics();
		map.update(g);
		//draw stuff
		g.dispose();
		strategy.show();
	}
	
	private class PlayerKeyListener implements KeyListener {

		public void keyPressed(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				break;
			case KeyEvent.VK_DOWN:
				break;
			case KeyEvent.VK_LEFT:
				if (p.getX() >= 10) {
					p.setX(p.getX() - 10);
				}
				System.out.println("left");
				break;
			case KeyEvent.VK_RIGHT:
				if (p.getX()+p.getImg().getImg().getWidth() <= (width - 10)) {
					p.setX(p.getX() + 10);
				}
				System.out.println(p.getX() + "right");
				// handle right
				break;
			}
		}

		public void keyReleased(KeyEvent arg0) {

		}

		public void keyTyped(KeyEvent arg0) {

		}
	}
}
