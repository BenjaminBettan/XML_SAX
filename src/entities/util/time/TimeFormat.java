package entities.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Use to generate timestamp (return String) 
 */

public class TimeFormat {
	
	/**
	 * Current time with this format : yyyy-MM-dd_HH-mm-ss-SSS
	 * @return String -> yyyy-MM-dd_HH-mm-ss-SSS
	 */
	
	public static String getCurrentTime() {
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(new Date(System.currentTimeMillis()));
	}
	
	/**
	 * This format : yyyy-MM-dd_HH-mm-ss-SSS is applicated on your argument (long)
	 * @return String -> yyyy-MM-dd_HH-mm-ss-SSS
	 */
	
	public static String get(long t) {
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(new Date(t));
	}
}
