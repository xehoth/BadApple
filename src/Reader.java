import java.io.*;

/**
 * Created by xehoth on 17-1-18.
 */
class Reader {
    private BufferedReader br;

    Reader(File file) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(file));
    }

    String readLine() throws IOException {
        return br.readLine();
    }

    void close() throws IOException {
        br.close();
        br = null;
    }
}
