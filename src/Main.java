import java.awt.Font;

import javax.swing.JTextArea;

public class Main extends MainFrame_FullScreen_Undecorated {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8033096121154907457L;
	public String[] instr = new String[6568];

	public Main() {
		JTextArea are = new JTextArea();
		are.setBounds(0, 0, 1024, 768);
		are.setFont(new Font("Lucida Console",Font.PLAIN, 21));
		add(are);
		instr = new Tools().ReadText("src/badapple.txt");
		setVisible(true);
		MusicPlayer m = new MusicPlayer("src/badapple.wav");
		Timer timer = new Timer(32,555555);
		timer.start();
		m.start();
		while (true) {
			are.setText(instr[timer.frame]);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
