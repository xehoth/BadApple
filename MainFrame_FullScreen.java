import javax.swing.JFrame;

/**
 * 
 * @author xht
 * @since1.0
 */

public class MainFrame_FullScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7237858734352735731L;
	public final int WIDTH = 1024;
	public final int HEIGHT = 768;

	public MainFrame_FullScreen() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, WIDTH, HEIGHT);
		setResizable(false);
		setLayout(null);
		setAlwaysOnTop(true);
	}
}
