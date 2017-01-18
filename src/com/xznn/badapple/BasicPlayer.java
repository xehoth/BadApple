package com.xznn.badapple;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.io.IOException;
import java.io.File;

public class BasicPlayer {

  private AudioInputStream stream = null;
  private AudioFormat format = null;
  private Clip clip = null;
  private SourceDataLine m_line;

  public void play(File fileName,int itemStatus)
  {
    try {
        // From file
        stream = AudioSystem.getAudioInputStream(fileName);

        // At present, ALAW and ULAW encodings must be converted
        // to PCM_SIGNED before it can be played
        format = stream.getFormat();
        if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
            format = new AudioFormat(
              AudioFormat.Encoding.PCM_SIGNED,
              format.getSampleRate(),
              16,
              format.getChannels(),
              format.getChannels() * 2,
              format.getSampleRate(),false);        // big endian
            stream = AudioSystem.getAudioInputStream(format, stream);
        }

        // Create the clip
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, stream.getFormat(), AudioSystem.NOT_SPECIFIED);
        m_line = (SourceDataLine) AudioSystem.getLine(info);
        m_line.open(stream.getFormat(),m_line.getBufferSize());
        m_line.start();

        int numRead = 0;
        byte[] buf = new byte[m_line.getBufferSize()];
        while ((numRead = stream.read(buf, 0, buf.length)) >= 0) {
           int offset = 0;
           while (offset < numRead) {
             offset += m_line.write(buf, offset, numRead-offset);
           }
        }
        m_line.drain();
        m_line.stop();
        m_line.close();
        stream.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    } catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
    }
  }

  public double getDuration()
  {
		System.out.println(getDuration());
		
    return m_line.getBufferSize() /
        (m_line.getFormat().getFrameSize() * m_line.getFormat().getFrameRate());
  }

  public double getDecision()
  {
	  System.out.println(getDecision());
    return m_line.getMicrosecondPosition()/1000.0;
  }
}