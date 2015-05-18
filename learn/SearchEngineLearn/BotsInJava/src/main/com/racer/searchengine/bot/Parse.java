/**
 * The Parse class is the low-level text parsing class 
 * that all othher parsing classes are based on.
 *
 * @author Ren Wanchun
 * @version v1.0
 * @see 
 */
package com.racer.searchengine.bot;

class Parse extends AttributeList{
	/**
	 * The source text which need to be parsed
	 */
	protected StringBuffer _source;
	/**
	 * The index number that the source text has been read 
	 */
	protected int _idx;

	/**
	 * The delimeter parsed from the source text.
	 */
	protected char _parseDelim;

	/**
	 * The name parsed from the source text.
	 */
	protected String _parseName;

	/**
	 * The value parsed from the source text
	 */
	protected String _parseValue;

	/**
	 * The HTML tag string
	 */
	protected String _tag;

	/**
	 * IF a character is a whitespace(\t, \n or \r)
	 *@return The character is a whitespace, return True. Otherwise, return False.
	 */
	public static boolean isWhiteSpace(char ch){
		return ("\t\r\n".indexOf(ch) != -1);
	}

	/**
	 * This method ignore the whitespace before a concrete character and move forward the 
	 * index in the source text.
	 */
	public void eatWhiteSpace(){
		while( !eof()){
			if( !isWhiteSpace(_source.charAt(_idx)))
				return;
			_idx++;
		}
	}

	/**
	 * This method allows you to determine if the reading charactor is at the end of the source text
	 * @return True to read to the end of the source text, otherwise False.
	 */
	public boolean eof(){
		return (_idx > _source.length());
	}

	/**
	 * This method parse the name of an attribute from the source text
	 */
	public void parseAttributeName(){
		eatWhiteSpace();
		if( (_source.charAt(_idx) == '\'') ||  (_source.charAt(_idx) == '\"')){
			_parseDelim = _source.charAt(_idx);
			_idx++;//ignore the left delimiter
			while( _source.charAt(_idx) != _parseDelim){
				_parseName += _source.charAt(_idx);
				_idx++;
			}
			_idx++;//ignore the right delimiter
		}
		else{
			while(!eof()){
				if( isWhiteSpace(_source.charAt(_idx)) || 
					(_source.charAt(_idx) == '=') || 
					(_source.charAt(_idx) == '>'))
					break;
				_parseName += _source.charAt(_idx);
				_idx++;
			}
		}
		eatWhiteSpace();
	}

	/**
	 * This method parse the value of an attribute from the source text
	 */
	public void parseAttributeValue(){
		if( _parseDelim != 0)
			return;
		if( _source.charAt(_idx) == '='){
			_idx++;
			eatWhiteSpace();
			if( (_source.charAt(_idx) == '\'') || 
				(_source.charAt(_idx) == '\"') ){
				_parseDelim = _source.charAt(_idx);
				_idx++;//ignore the left delimiter
				while( _source.charAt(_idx)!=_parseDelim ){
					_parseValue+=_source.charAt(_idx);
					_idx++;
				}
				_idx++;//ignore the right delimiter
			}
			else{
				while( !eof() && 
					!isWhiteSpace(_source.charAt(_idx))&&
					(_source.charAt(_idx)!='>') ){
					_parseValue+=_source.charAt(_idx);
					_idx++;
				}
			}
			eatWhiteSpace();
		}

	}

	/**
	 * This method add an Attribute to the attributeList 
	 */
	void addAttribute(){
		Attribute a = new Attribute(_parseName,_parseValue,_parseDelim);
		add(a);
	}

	/**
	 * Get the name parsed from the source text
	 * @return the name parsed from the source text
	 */
	String getParseName(){
		return _parseName;
	}

	/**
	 * Get the value parsed from the source text
	 * @return the value parsed from the source text
	 */
	String getParseValue(){
		return _parseValue;
	}

	/**
	 * Get the delimiter parsed from the source text
	 * @return the delimiter parsed from the source text
	 */
	char getParseDelim(){
		return _parseDelim;
	}

	/**
	 * Set the parsed name
	 * @param name The parsed name
	 */
	void setParseName(String name){
		_parseName=name;
	}

	/**
	 * Set the parsed value
	 * @param value The parsed value
	 */
	void setParseValue(String value){
		_parseValue=value;
	}

	/**
	 * Set the parsed delimiter
	 * @param name The parsed delimiter
	 */
	void setParseName(char delim){
		_parseDelim=delim;
	}

	/**
	 * Set the source text
	 * @param str The source text
	 */
	public void setSource(String str){
		this._source = new StringBuffer(str);
	} 

	/**
	 * 
	 */
}