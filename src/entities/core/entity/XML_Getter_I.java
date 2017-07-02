package entities.core.entity;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface XML_Getter_I {
	
	public void persist(XMLEntity curFather)throws IOException;
	public XMLEntity getEntity(long l);
	public void deleteSerial(long l) throws FileNotFoundException, IOException;
	public void update(XMLEntity xMLEntity);
	public String showXml();
	
}
