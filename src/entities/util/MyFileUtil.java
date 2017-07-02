package entities.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class MyFileUtil {
	
	private static Logger logger = Logger.getLogger(MyFileUtil.class);
	
	private MyFileUtil(){}
	
	public static void makeLastDirectoryIfNotExist(String path) {
		
		String p   = path.substring(0, path.lastIndexOf(OS.get_.OsParsor()) + 1);
		
		File f = new File(p);
		
		f.mkdir();
		
		while( ! f.exists())
		{
			try 
			{
				Thread.sleep(100);//wait 100 ms if folder not exist (warning -> could be infinite loop...)
			} 
			catch (InterruptedException e) 
			{
				logger.warn(e.getMessage());
			}
		}
		
	}

	public static String readFile(String path){
		String text = null;
		
		try(FileInputStream inputStream = new FileInputStream(path)) 
		{     
		    text = IOUtils.toString(inputStream,"UTF-8");
		    inputStream.close();
		}
		catch (Exception e) 
		{
			logger.warn("ERROR>Reading this file -> " + path);
		}
		return text;
	}
	
}
