package com.racer.searchengine.bot;

/**
 * The Attribute class stores a list of named value pairs.
 * Optionally the values can have delimeters such as ' or ".
 * 
 * @author Ren Wanchun
 * @version v1.0
 * @see AttributeList
 */

public class Attribute implements Cloneable{
	/**
	 * The nama of this attribute
	 */
	private String _name;

	/**
	 * The value of this attribute
	 */
	private String _value;

	/**
	 * The delimiter of the value of this attribute(i.e. " or ');
	 */
	private char _delim;

	/**
	 * Clone this object using the cloneable interface
	 * @return A new object which is a clone of the specified object
	 */
	public Object clone()
	{
		return new Attribute(_name,_value,_delim);
	}

	/**
	 * Construct a new Attribute. The name, value, delim properties can be specified here.
	 * @param name The name of this Attribute
	 * @param value The value of this Attribute
	 * @param delim The delimiter character for the value
	 */
	public Attribute(String name,String value,char delim){
		_name=name;
		_value=value;
		_delim=delim;
	}

	/**
	 * The default constructor. Construct a blank attribute.
	 */
	public Attribute(){
		this("","",(char)0);
	}

	/**
	 * Construct an Attribute without a delimiter.
	 * @param name The name of this Attribute
	 * @param value The value of this Attribute
	 */
	public Attribute(String name,String value){
		this(name,value,(char)0);
	}

	/**
	 * Get the name of this Attribute
	 * @return The name of this Attribute
	 */
	public String getName(){
		return _name;
	}

	/**
	 * Get the value of this Attribute
	 * @return The value of this Attribute
	 */
	public String getValue(){
		return _value;
	}

	/**
	 * Get the delimiter of this Attribute
	 * @return The delimiter of this Attribute
	 */
	public char getDelim(){
		return _delim;
	}

	/**
	 * Set the name of this Attribute
	 * @param name The name of this Attribute
	 */
	public void setName(String name){
		_name=name;
	}

	/**
	 * Set the value of this Attribute
	 * @param value The value of this Attribute
	 */
	public void setValue(String value){
		_value=value;
	}

	/**
	 * Set the delimiter of this Attribute
	 * @param delim The delimiter of this Attribute
	 */
	public void setDelim(char delim){
		_delim=delim;
	}
}
