package entities.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import entities.core.entity.XMLEntity;
import entities.core.entity.XML_Getter;
import entities.core.entity.XML_Getter_I;
import entities.util.HashMapSingleton;

public class MyHandler extends DefaultHandler {

	private int level = 0;
	private long id = 0;
	private String data = null;
	private Map<String, String> currentAttributes = null;
	private List <XMLEntity> listOfFather= new ArrayList<>();
	private XML_Getter_I x = XML_Getter.getInstance();

	@Override
	public void startElement(String uri, String localName, String tagName, Attributes attributes) throws SAXException {
		
		
		//because we don't want to create an instance of HashMap, there's a clear in it
		currentAttributes = HashMapSingleton.get();

		for (int i=0; i < attributes.getLength(); i++) 
		{
			currentAttributes.put(attributes.getQName(i), attributes.getValue(i));
		}
		
		XMLEntity e = new XMLEntity(id, tagName, currentAttributes, level);
		
		
		
		if ( id != 0 ) 
		{
			
			XMLEntity e2 = listOfFather.get(listOfFather.size() - 1);//take the father
			
			e.setIsChildOf(e2.getId());//update current tag
			
			e2.setIsFatherOf(id);//update father
			
			x.update(e2);//clean serial instance (undo persist) then persist again -> it's an update !
			
		}
		
		listOfFather.add(e);
		
		try 
		{
			x.persist(e);
		} 
		catch (IOException e_) 
		{
			e_.printStackTrace();
		}
		

		level++;
		id++;
		currentAttributes = null;
	}

	@Override
	public void characters(char[] caracteres, int debut, int longueur) {
		data = new String(caracteres, debut, longueur).trim();

		if ( data != null && ! data.equals("") ) 
		{
			XMLEntity e = listOfFather.get(listOfFather.size() - 1);
			e.setData(data);
			x.update(e);
		}
		
		data  = null;
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		level--;
		listOfFather.remove(listOfFather.size() - 1);//remove last father
	}


	public long getId() {
		return id;
	}

}