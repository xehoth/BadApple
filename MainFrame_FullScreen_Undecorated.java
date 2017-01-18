import javax.swing.JFrame;

/**
 * 
 * @author xht
 * @since1.0
 */

public class MainFrame_FullScreen_Undecorated extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7045996733298048169L;
	public final int WIDTH = 1024;
	public final int HEIGHT = 768;

	public MainFrame_FullScreen_Undecorated() {
		setBounds(0, 0, WIDTH, HEIGHT);
		setResizable(false);
		setUndecorated(true);
		setLayout(null);
		setAlwaysOnTop(true);
	}
}
