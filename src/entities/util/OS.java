package entities.util;

import org.apache.commons.lang3.SystemUtils;

public enum OS {
	get_;
	
	
	OS()//constructor
	{
	}

	public String OsParsor() {
		
		if (SystemUtils.IS_OS_LINUX) 
		{
			return "/";
		}
		else 
		{
			return "\\";
		}
		
	}
	
	public String getCariageReturnForFile() {
		
		if (SystemUtils.IS_OS_LINUX) 
		{
			return "\n";
		}
		else 
		{
			return "\r\n";
		}
		
	}
	
}
