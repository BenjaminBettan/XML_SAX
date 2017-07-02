package entities.util;
import org.apache.commons.lang3.SystemUtils;
/**
 * Paths in project
 */

public enum PATH_IN_PROJECT 
{
	LOG4J("src\\entities\\util\\log4j\\log4j.properties"),
	DB(System.getProperty("user.dir")+"\\ressources\\dataBase"),
	
	;
	private String path;
	
	PATH_IN_PROJECT(String path_)//constructor
	{
		path = path_;
	}

	public String getPath() {
		
		if (SystemUtils.IS_OS_LINUX) 
		{
			return path.replace("\\", "/");
		}
		else 
		{
			return path;
		}
		
	}
}
