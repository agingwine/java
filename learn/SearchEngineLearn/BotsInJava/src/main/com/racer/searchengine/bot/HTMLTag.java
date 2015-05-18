package com.racer.searchengine.bot;

/**
 * The HTMLTag class is used to store an HTML Tag. This include 
 * the tag name and any attributes.
 * 
 * @author Ren Wanchun
 * @version v1.0
 */

public class HTMLTag extends AttributeList implements Cloneable{
	/**
	 * The name of the tag
	 */
	protected String _name;

	/**
	 * Clone a object 
	 * @return New Object
	 */
	public Object clone(){
		int i;
		AttributeList rtn = new AttributeList();
		for(i=0;i<_vec.size();i++){
			rtn.add( (Attribute)get(i).clone());
		}
		rtn.setName(_name);
		return rtn;
	}

	/**
	 * Set the name of tag
	 * @param s Tag name
	 */
	public void setName(String s){
		_name=s;
	}

	/**
	 * Get the tag name
	 */
	public String getName(){
		return _name;
	}

	/**
	 * Get an attribute value of this tag.
	 * @param name The attribute's name.
	 */
	public String getAttributeValue(String name){
		Attribute a = get(name);
		if(a==null)
			return null;
		return a.getValue();
	}
}
