import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * 
 * @author xht
 * @since1.0
 */

public class MusicPlayer extends Thread {
	public AudioClip clip = null;

	/**
	 * 
	 * @param pathnameÂ·¾¶Ãû
	 */
	public MusicPlayer(String pathname) {
		try {
			File musicFile = new File(pathname);
			URI uri = musicFile.toURI();
			URL url;
			url = uri.toURL();
			clip = Applet.newAudioClip(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		clip.play();
	}
}
