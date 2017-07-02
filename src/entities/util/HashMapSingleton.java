package entities.util;

import java.util.HashMap;
import java.util.Map;

public class HashMapSingleton {

	private static Map<String, String> myMap = new HashMap<>();
	
	/**
	 * next is for singleton, everything is private exept get method 
	 */
	private HashMapSingleton() {}
	
	private static class SingletonHolder
	{
		private final static HashMapSingleton instance = new HashMapSingleton();
	}
	private static HashMapSingleton getInstance(){
		HashMapSingleton s = SingletonHolder.instance;
		return s;
	}
	
	public static Map<String, String> get() {
		getInstance();
		myMap.clear();
		
		return myMap;
	}

}
