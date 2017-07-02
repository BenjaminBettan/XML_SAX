package entities.util.log4j;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

import entities.util.time.TimeFormat;


public class MyPatternLayout extends PatternLayout {

	/**
	 * Define what's the first line of the csv log (column names -> header)
	 */
	@Override
	public String getHeader() {
		return "Time;Level;Package.Class;Message;ThreadName;\n";
	}

	/**
	 * Define what do you want in csv file (datas) / log it to database too
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String format(LoggingEvent event){
		
		try 
		{//try catch because of depreciated code

			String myLog = TimeFormat.get(event.timeStamp).replace(";", "") + ";" 
					+ event.level.toString().replace(";", "")         + ";" 
					+ event.categoryName.replace(";", "")             + ";" 
					+ event.getMessage().toString().replace(";", "")  + ";"
					+ event.getThreadName()                           + ";\n";

			return myLog;	

		} 
		catch (Exception e) 
		{
			throw new RuntimeException("Log4j had an error : " + e.getMessage());	
		}

	}

}
