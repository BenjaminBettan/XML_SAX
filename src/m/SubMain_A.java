package m;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import entities.core.XmlParser;
import entities.core.entity.XML_Getter;
import entities.core.entity.XML_Getter_I;
import entities.util.PATH_IN_PROJECT;
import entities.util.time.PauseMaker;

public abstract class SubMain_A {
	
	private static Logger logger = Logger.getLogger(SubMain_A.class);
	protected static final int NB_INSTANCE = 7;
	
	private File f = new File(PATH_IN_PROJECT.DB.getPath());
	private String filePath = null;
	protected XML_Getter_I x = XML_Getter.getInstance();
	
	protected void init(String[] args) {
		
		logger.info("Start init");
		
		testArgs(args);
		
		clear();
		
		new XmlParser().parseWithSaxAndGenerateSerializedXmlEntitiesDatabase(filePath);
		
		System.gc();
		
		logger.info("End of init");
		
	}
	
	private void testArgs(String[] args) {
		
		if(args.length > 0)
		{
			filePath = args[0];
		}
		else 
		{
			logger.warn("Input file is required.");
			throw new RuntimeException("\n\nInput Filename is required -> Argument is missing in run configuration\n");
		}
		
		logger.info("XMLFILE to load : " + filePath);
		
	}

	private void clear() {
		
		logger.info("Clear database (serialized xml entities) -> delete directory ressources\\database then create it again");
		
		try 
		{
			FileUtils.deleteDirectory(f);//ressources/database
			
			while(f.exists())
			{
				PauseMaker.make(300, TimeUnit.MILLISECONDS);
			}
			
			f.mkdir();
			
		} 
		catch (IOException e) 
		{
			logger.warn("Issue during database removal" + e.getMessage());
		}
		
	}
	
}
