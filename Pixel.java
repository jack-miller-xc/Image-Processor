import java.awt.Color;
import java.awt.image.BufferedImage;

public class Pixel {

	private BufferedImage bi;
	private int x;
	private int y;
	private Color c;

	public Pixel(BufferedImage bi, int x, int y) {
		this.bi = bi;
		this.x = x;
		this.y = y;
		int rgb = bi.getRGB(x, y);
		this.c = new Color(rgb);
	}

	public Color getColor() {
		return this.c;
	}

	public int getRed() {
		return this.c.getRed();
	}

	public int getBlue() {
		return this.c.getBlue();
	}

	public int getGreen() {
		return this.c.getGreen();
	}

	public void setColor(Color c) {
		this.c = c;
//		int r = c.getRed();
//		int b = c.getBlue();
//		int g = c.getGreen();
		bi.setRGB(this.x, this.y, this.getRed());
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public void setRed(int r) {
		Color newC = new Color(r, this.getGreen(), this.getBlue());
		this.setColor(newC);
	}
}
