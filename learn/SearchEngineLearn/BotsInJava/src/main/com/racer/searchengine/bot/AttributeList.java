package com.racer.searchengine.bot;

/**
 * The AttributeList class is used to store list of Attribute classes.
 * 
 * @author Ren Wanchun
 * @version v1.0
 */

import java.util.*;

public class AttributeList extends Attribute implements Cloneable{
	/**
	 * An internally used Vector. The vector contains the entire list of attributes.
	 */
	protected Vector<Attribute> _vec;
	/**
	 * Make an exact deeply copy of this object using the cloneable interface
	 * @return A new object that is a clone of the specified object
	 */
	public Object clone(){
		AttributeList rtn = new AttributeList();

		for(int i=0;i<_vec.size();i++)
			rtn.add((Attribute)(get(i).clone()));
		return rtn;
	}

	/**
	 * The default constructor. Construct a empty AttributeList
	 */
	public AttributeList(){
		super("","");
		_vec = new Vector<Attribute>();
	}

	/**
	 * Add the specified attribute to the list of attributes.
	 * @param An attribute to add to this AttributeList 
	 */
	synchronized public void add(Attribute a){
		_vec.addElement(a);
	}

	/**
	 * Locate an Attribute by index number. Index number start at zero.
	 * @param index A zero based index that specified the Attribute to retrieve.
	 * @return The Attribute object that was found. If index number is out of range, return null
	 */
	synchronized public Attribute get(int index){
		if(index>=0&&index<_vec.size())
			return (Attribute)_vec.elementAt(index);
		else 
			return null;
	}

	/**
	 * Locate an Attribute by its name. The search is case-insensitive.
	 * @param index The attribute name to search for
	 * @return The Attribute object that was located. If not found, return null.
	 */
	synchronized public Attribute get(String index){
		for(int i=0;get(i)!=null;i++){
			if(get(i).getName().equalsIgnoreCase(index))
				return get(i);
		}
		return null;
	}


	/**
	 * Clear all attributes from the AttributeList and return it to a empty state
	 */
	synchronized public void clear(){
		_vec.removeAllElements();
	}

	/**
	* Returns true of this AttributeList is empty, with no attributes.
	*
	* @return True if this AttributeList is empty, false otherwise.
	*/
	synchronized public boolean isEmpty()
	{
		return( _vec.size()<=0);
	}

	/**
	* Returns the number of Attributes in this AttributeList.
	*
	* @return The number of Attributes in this AttributeList.
	*/
	synchronized public int length()
	{
		return _vec.size();
	}

	/**
	 * If there is already an attribute with the specified name,
	 * then it will have its value changed to match the specified value.
	 * If there is no Attribute with the specified name, then one will be created.
	 * This method is case-insensitive
	 * @param name The name of the Attribute to edit or create. Case-insensitive.
	 * @param value 
	 */
	synchronized public void set(String name,String value){
		if(name==null)
			return;
		if(value==null)
			value="";
		Attribute a=get(name);
		if(a==null){
			a = new Attribute(name,value);
			add(a);
		}
		else
			a.setValue(value);
	}
}