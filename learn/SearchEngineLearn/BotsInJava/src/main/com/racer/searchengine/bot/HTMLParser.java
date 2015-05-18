package com.racer.searchengine.bot;
/**
 * The HTMLParser class is used to parse an HTML page.
 * It's just a utility class, and do NOT store any values.
 * @author Ren Wanchun
 * @version v1.0
 */

public class HTMLParser extends Parse{
	/**
	 * This method return a HTMLTag object that has been parsed
	 * @return The HTMLTag object.
	 */
	public HTMLTag getTag(){
		int i;
		HTMLTag tag = new HTMLTag();
		tag.setName(_tag);
		for(i=0;i<_vec.size();i++)
			tag.add( (Attribute)get(i).clone());
		return tag;
	}

	/**
	 * This method build a HTML tag by the parsed data..
	 * @return The HTML tag string.
	 */
	public String buildTag(){
		String buffer="<";
		buffer+=_tag;
		int i=0;
		while(get(i)!=null){
			buffer+=" ";
			if(get(i).getValue()==null){
				if(get(i).getDelim()!=0)
					buffer+=get(i).getDelim();
				buffer+=get(i).getName();
				if(get(i).getDelim()!=0)
					buffer+=get(i).getDelim();
			}
			else{
				buffer+=get(i).getName();
				if(get(i).getValue()!=null){
					buffer+="=";
					if(get(i).getDelim()!=0)
						buffer+=get(i).getDelim();
					buffer+=get(i).getValue();
					if(get(i).getDelim()!=0)
						buffer+=get(i).getDelim();
				}
			}
			i++;
		}
		buffer+=">";
		return buffer;
	}


	/**
	 * This method parse a HTML tag. 
	 * The tag name stores in _tag
	 * The tag attributes stores in _vec using addAttribute method.
	 */
	protected void parseTag(){
		_idx++;
		_tag="";
		clear();

		//Is it a comment?
		if( (_source.charAt(_idx)=='!') && 
			(_source.charAt(_idx+1)=='-') &&
			(_source.charAt(_idx+2)=='-') ){
			while(!eof()){
				if( (_source.charAt(_idx)=='-') &&
					(_source.charAt(_idx+1)=='-') &&
					(_source.charAt(_idx+2)=='>') )
					break;//end of comment
				if(_source.charAt(_idx)!='\r')
					_tag+=_source.charAt(_idx);
			}
			_tag+="--";
			_idx+=3;
			_parseDelim=0;
			return;
		}

		//Find the tag name
		while(!eof()){
			if(isWhiteSpace(_source.charAt(_idx)) || (_source.charAt(_idx)=='>'))
				break;
			_tag += _source.charAt(_idx);
			_idx++;
		}

		eatWhiteSpace();

		//get the attributes
		while(_source.charAt(_idx)!='>'){
			_parseDelim=0;
			_parseName="";
			_parseValue="";
			parseAttributeName();

			if( _source.charAt(_idx)=='>'){
				addAttribute();
				break;
			}

			//get the value(if any)
			parseAttributeValue();
			addAttribute();
		}
		_idx++;
	}

	/**
	 * This method start parse the source text, and parse a html tag.
	 */
	public char get(){
		if(_source.charAt(_idx)=='<'){
			char ch=Character.toUpperCase(_source.charAt(_idx+1));
			if( (ch>='A' && ch<='Z') || ch=='!'||ch=='/'){
				parseTag();
				return 0;
			}
			else
				return (_source.charAt(_idx++));
		}
		else
			return _source.charAt(_idx++);
	}
}