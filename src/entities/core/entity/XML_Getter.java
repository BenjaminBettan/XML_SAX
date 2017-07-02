package entities.core.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.log4j.Logger;

import entities.util.MyFileUtil;
import entities.util.MyLongToString;
import entities.util.PATH_IN_PROJECT;

public class XML_Getter implements XML_Getter_I,Serializable
{
	private static final long serialVersionUID = -1996140893257723324L;
	private static Logger logger = Logger.getLogger(XML_Getter.class);
	
/***
 * next is for singleton
 */
	private XML_Getter() {}
	private static class SingletonHolder { private final static XML_Getter instance = new XML_Getter(); }
	public static XML_Getter getInstance() {  XML_Getter x = SingletonHolder.instance; return x; }
	
	public void persist(XMLEntity e) throws IOException {
		MyFileUtil.makeLastDirectoryIfNotExist(PATH_IN_PROJECT.DB.getPath() + MyLongToString.convertLong(e.getId()));
		
		File f = new File(PATH_IN_PROJECT.DB.getPath() + MyLongToString.convertLong(e.getId()));
		FileOutputStream output = new FileOutputStream(f);
		ObjectOutputStream outputStream = new ObjectOutputStream(output);
		outputStream.writeObject(e);
		output.close();
		outputStream.close();
		
		logger.debug("New serialized object : " + e);
	}
	
	public void update(XMLEntity xMLEntity){
		
		try 
		{
			deleteSerial( xMLEntity.getId() );
			persist(xMLEntity);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public XMLEntity getEntity(long l) 
	{
		
		File f = new File(PATH_IN_PROJECT.DB.getPath() + MyLongToString.convertLong(l));
		XMLEntity x;
		
		try 
		{
			
			FileInputStream inputStream = new FileInputStream(f);
			
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			
			try 
			{
				x = (XMLEntity) objectInputStream.readObject();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
				objectInputStream.close();
				inputStream.close();
				throw new RuntimeException("ClassNotFoundException");
			}

			objectInputStream.close();
			inputStream.close();
			
		} 
		catch (IOException e) 
		{
			logger.warn("Exception while trying to open a file : " + f.getAbsolutePath());
			e.printStackTrace();
			throw new RuntimeException("\n\nException while trying to open a file : " + f.getAbsolutePath()+"\n");
		}


		logger.debug("GetXmlEntity : "+ x);
		return x;
	}

	public void deleteSerial(long l) throws FileNotFoundException, IOException{
		
		File f = new File(PATH_IN_PROJECT.DB.getPath() + MyLongToString.convertLong(l));
		
		if (f.exists()) 
		{
			new FileOutputStream(f).close();	
		}

	}

	@Override
	public String showXml() {
		
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+getEntity(0).showXmlValue();
	}

}

