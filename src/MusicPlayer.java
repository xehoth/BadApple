import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xehoth on 17-1-18.
 */
public class MusicPlayer extends Thread {

    private File file;

    MusicPlayer(String path) {
        file = new File(path);
    }

    @Override
    public void run() {
        try {
            URL url = file.toURL();
            AudioClip clip = Applet.newAudioClip(url);
            clip.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
