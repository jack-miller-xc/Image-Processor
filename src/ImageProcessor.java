import javax.swing.*;

public class ImageProcessor {

  private JFrame frame;
  private JPanel primary;
  private ImageCanvas canvas;

  public ImageProcessor() {
  }
  
  public void createGUI() {
    this.frame = new JFrame("IP");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.primary = new JPanel();
    canvas = new ImageCanvas("resources/Koala.jpg");
    primary.add(canvas);
    primary.setSize(canvas.getWidth(), canvas.getHeight());
    frame.getContentPane().add(primary);
    frame.pack();
    frame.setVisible(true);    
  }

  public static void main(String[] args) {
    ImageProcessor ip = new ImageProcessor();
    ip.createGUI();
  }
}
