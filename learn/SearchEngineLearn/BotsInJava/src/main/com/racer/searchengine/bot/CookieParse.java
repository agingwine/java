package com.racer.searchengine.bot;
/**
 * This class is used to parse cookies that are transmitted with the HTTP headers
 * 
 * @author Ren Wanchun
 * @version v1.0
 * @see 
 */

public class CookieParse extends Parse{
	/**
	 * Special version of the parseAttributeValue method
	 */
	public void parseAttributeValue(){
		eatWhiteSpace();
		if(_source.charAt(_idx)=='='){
			_idx++;
			eatWhiteSpace();
			if( (_source.charAt(_idx)) == '\'' ||
				(_source.charAt(_idx)) == '\"'){
				_parseDelim = _source.charAt(_idx);
				_idx++;//ignore the left delim
				while( _source.charAt(_idx)!=_parseDelim ){
					_parseValue+=_source.charAt(_idx);
					_idx++;
				}
				_idx++;//ignore the right delim
			}
			else{
				while(!eof() && (_source.charAt(_idx)!=';') ){
					_parseValue+=_source.charAt(_idx);
					_idx++;
				}
			}
			eatWhiteSpace();
		}
	}

	/**
	 * Called to parse this cookie
	 * @return The return value is unused
	 */

	public boolean get(){
		while(!eof()){
			_parseName = "";
			_parseValue = "";

			parseAttributeName();
			if( _source.charAt(_idx)==';'){
		 		addAttribute();
		 		break;
		 	}
		 	parseAttributeValue();
		 	addAttribute();
		 	eatWhiteSpace();
		 	while(!eof()){
		 		if( _source.charAt(_idx++) == ';')
		 			break;
		 	}
		}
		_idx++;//ignore ';'
		return false;
	}

	/**
	 * Convert this cookie to a string to be sent as an HTTP handler
	 * @return This cookie as a string
	 */
	public String toString(){
		String str;
		str = get(0).getName();
		str+="=";
		str+=get(0).getValue();
		return str;
	}
}