import java.awt.*;

/**
 * Created by xehoth on 17-1-18.
 */
public class Main {

    public static void main(String[] args) {
        int width = 645;
        int height = 600;
        int x = Toolkit.getDefaultToolkit().getScreenSize().width - width >> 1;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height - height >> 1;
        try {
            new MainFrame(x, y, width, height, "src/BadApple.dat");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

