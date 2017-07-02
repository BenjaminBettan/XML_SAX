package m;

import org.apache.log4j.PropertyConfigurator;

import entities.util.PATH_IN_PROJECT;

public class M {

	public static void main(String[] args) {
		
		//init log4j
		PropertyConfigurator.configure(PATH_IN_PROJECT.LOG4J.getPath());
		
		new SubMain().run(args);
		
	}
}
