import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author xht
 * @since1.0
 */
public class Tools {
	/**
	 * 
	 * @param pathnameÂ·¾¶Ãû
	 * @return String[]
	 */
	public String[] ReadText(String pathname) {
		String[] instr = new String[6568];
		File file = new File(pathname);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 6568; i++) {
				for (int j = 0; j < 35; j++) {
					String str;

					try {
						str = br.readLine();
						sb.append(str + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				instr[i] = sb.toString();
				sb = new StringBuffer("");
			}
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return instr;
	}
}
