package entities.util;

import org.apache.commons.lang3.SystemUtils;

public class MyLongToString {
	public static String convertLong(long l){
		
		String prefix;
		
		if (SystemUtils.IS_OS_LINUX) 
		{
			prefix = new String("/");
		}
		else 
		{
			prefix = new String("\\");
		}
		
		StringBuilder sb = new StringBuilder();
		String s = Long.toString(l);
				
		for (char ch: s.toCharArray()) //for each char in string
		{
			sb.append(prefix + ch);
		}
		
		sb.append(prefix + "id");
		
		return sb.toString();
	}
}
