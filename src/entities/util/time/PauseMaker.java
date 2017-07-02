package entities.util.time;



import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * Object that makes pause 
 */

public class PauseMaker {
	
	private static Logger logger = Logger.getLogger(PauseMaker.class);
	
	private PauseMaker(){}
	
	/**
	 * Make a pause
	 * @param duration integer -> value of pause
	 * @param TIME_UNIT_ The time unit
	 */
	
	public static void make(int duration,TimeUnit TimeUnit){
		
		if (duration > 0 ) 
		{
			
			try 
			{
				Thread.sleep(TimeUnit.toMillis(duration));
			} 
			catch (InterruptedException e) 
			{
				logger.warn(e.getMessage());
				Thread.currentThread().interrupt();
			}
			
		}
		
		
	}
}
