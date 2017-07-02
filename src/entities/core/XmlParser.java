package entities.core;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/*
 * Uses SAX parser to stream the XML file without loading the whole file in memory
 * and builds a map file
 */

public class XmlParser {
	
	private static Logger logger = Logger.getLogger(XmlParser.class);
	
	private SAXParserFactory factory;
	private SAXParser saxParser;
	private MyHandler myHandler = new MyHandler();

	public void parseWithSaxAndGenerateSerializedXmlEntitiesDatabase(String filePath) {
		
		logger.info("About to parse");
		
		// init SAX parser
		
		try 
		{
			
			factory = SAXParserFactory.newInstance();
			
			saxParser = factory.newSAXParser();

			saxParser.parse(filePath, myHandler);// execute sax parser. Look at the code in handler
			
			logger.info("The XML file has been parsed by SAX. " + myHandler.getId() + " instances to parse");
			
		} 		
		catch (IOException e) 
		{
			logger.warn("Error loading input file");
			throw new RuntimeException(e);
		} 
		catch (SAXException e)
		{
			logger.warn("Error parsing XML file");
			throw new RuntimeException(e);
		} 
		catch (ParserConfigurationException e) 
		{
			logger.warn("Error configuring SAX");
			throw new RuntimeException(e);
		}
		
	}
	

}
