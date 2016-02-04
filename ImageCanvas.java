
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

@SuppressWarnings("serial")
public class ImageCanvas extends Canvas {
  
  private BufferedImage img;
  
  public ImageCanvas(String filename) {
    try {
      img = ImageIO.read(new File(filename));
    } catch (IOException e) {
      System.out.println("problem loading image");
    }
  }
  
  public void paint(Graphics g) {

    g.drawImage(img, 0, 0, null);

  }
  
  public Dimension getPreferredSize() {
    if (img == null) {
      return new Dimension(100, 100);
    }
    else {
      return new Dimension(img.getWidth(null), img.getHeight(null));
    }
  }
  
  public void swapPixels() {
	  Pixel p;
	  int r, g, b;
	  Color newColor;
	  for (int y=0; y<this.getHeight(); y++) {
		  for (int x=0; x<this.getWidth(); y++) {
			  p = this.getPixel(x, y);
			  r = p.getRed();
			  g = p.getGreen();
			  b = p.getBlue();
			  newColor = new Color(g, b, r);
			  p.setColor(newColor);
		  }
	  }
  }

private Pixel getPixel(int x, int y) {
	return new Pixel(img, x, y);
}
}
  
