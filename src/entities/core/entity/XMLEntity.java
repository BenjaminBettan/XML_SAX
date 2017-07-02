package entities.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author benjamin
 * Entity to persist
 */
public class XMLEntity implements Serializable {

	private static final long serialVersionUID = Long.MAX_VALUE - 99;

	private long id = 0L;
	private String tag,header,footer;
	private String data = new String("");
	private List<Long> isFatherOf;
	private long isChildOf = -1;
	private Map<String, String> attributes = null;
	private int level = 0;
	private XML_Getter_I x = XML_Getter.getInstance();
	
	public boolean thisNodeHasNoAttribute() {
		if (attributes==null) {
			return true;
		}
		return attributes.isEmpty();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	public boolean isLeaf() {
		return isFatherOf == null || isFatherOf.size() == 0;
	}

	public long getIsChildOf() {
		return isChildOf;
	}

	public void setIsChildOf(long isChildOf) {
		this.isChildOf = isChildOf;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
	public List<Long> getIsFatherOf() {
		return isFatherOf;
	}

	public void setIsFatherOf(long id2) {
		if (isFatherOf==null) 
		{
			isFatherOf = new ArrayList<>();
		}
		this.isFatherOf.add(id2);
	}

	public XMLEntity(long id2, String currentTag, Map<String, String> currentAttributes, int level2) {
		this.id = id2;
		this.tag = currentTag;
		this.attributes = currentAttributes;
		this.level = level2;
		
		if (attributes==null || attributes.size()==0) 
		{
			this.header=new String("<"+currentTag+">");
		}
		else 
		{
			this.header=new String("<"+currentTag+" "+attributes.toString().substring(1, attributes.toString().length()-1).replace("=", "=\"").replace(",", "\"") + "\">");
		}
		
		this.footer=new String("</"+currentTag+">");
		
	}

	@Override
	public String toString() {
		return "XMLEntity [id=" + id + ", level=" + level + ", tag=" + tag + ", data=" + data +  ", leaf="
				+ isLeaf() + ", isChildOf=" + isChildOf + ", attributes=" + attributes 
				+ ", isFatherOf=" + isFatherOf +"]";
	}
	
	public String showXmlValue() {
		return header + data + getSonTags() +footer;
	}

	private String getSonTags() {
		
		String s = new String("");
		
		if (isFatherOf!=null) 
		{
			for (Long l : isFatherOf) 
			{
				s += x.getEntity(l).showXmlValue();
			}	
		}
		
		return s;
	}

}

