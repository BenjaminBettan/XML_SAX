package m;

import org.apache.log4j.Logger;

public class SubMain extends SubMain_A{
	
	private static Logger logger = Logger.getLogger(SubMain.class);
	
	public void run(String[] args) {
		
		init(args);
		
		executeScenario();
		
	}

	private void executeScenario() {
		
		logger.info("Let's run a scenario !");
		
		for (long i = 0; i < NB_INSTANCE; i++) 
		{
			logger.info( x.getEntity(i));
		}
		
		logger.info( "Print XML : " + x.showXml() );
		
		logger.info("Show me value 5 in xml : "+ x.getEntity(5).showXmlValue());
		
		logger.info( "End of program" );
		
	}
	

}
