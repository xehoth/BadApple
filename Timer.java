/**
 * 
 * @author xht
 * @since1.0
 */
public class Timer extends Thread {
	public long mills;
	public int nanos;
	public int frame = -1;

	/**
	 * 
	 * @param mills∫¡√Î
	 * @param nanosƒ…√Î
	 */
	public Timer(long mills, int nanos) {
		this.mills = mills;
		this.nanos = nanos;
	}

	@Override
	public void run() {
		for (int i = 0; i < 6568; i++) {
			this.frame++;
			try {
				Thread.sleep(mills, nanos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.exit(0);

	}
}
