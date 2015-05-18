package com.racer.searchengine.bot;
import java.io.*;
import java.util.*;

/**
 * The Log class is used to write out log information
 * 
 * @author Ren Wanchun
 * @version v1.0
 */

public class Log{
	/**
	 * Display the greatest amount of log information
	 * All info packages will be displayed.
	 */
	public final static int LOG_LEVEL_DUMP = 1;

	/**
	 * Display enough information so that the operation
	 * of the program could be traced.
	 */
	public final static int LOG_LEVEL_TRACE = 2;

	/**
	 * Display normal information of logging
	 */
	public final static int LOG_LEVEL_NORMAL = 3;

	/**
	 * Display error information
	 */
	public final static int LOG_LEVEL_ERROR = 4;

	/**
	 * Display nothing
	 */
	public final static int LOG_LEVEL_NONE = 5;

	/**
	 * Logging to the console?
	 */
	protected static boolean _log2console = true;

	/**
	 * Logging to a file?
	 */
	protected static boolean _log2file = false;

	/**
	 * The path of the log file
	 */
	protected static String _path = "." + File.pathSeparator + "log.txt";

	/**
	 * What level to log to.
	 */
	protected static int _level = LOG_LEVEL_NONE;

	/**
	 * Construct the Log object
	 */
	public Log(){}

	/**
	 * Set the Logging level
	 * @param level The logging level
	 */
	public static void setLevel(int level){
		if( level==LOG_LEVEL_NONE||
			level==LOG_LEVEL_ERROR||
			level==LOG_LEVEL_NORMAL||
			level==LOG_LEVEL_TRACE||
			level==LOG_LEVEL_DUMP)
			_level=level;
		else
			_level=LOG_LEVEL_NORMAL;
	}

	/**
	 * Set the path of log file
	 * @param path The path of log file
	 */
	public static void setPath(String path){
		_path =  path;
	}

	/**
	 * Determines if file logging is enabled
	 * @param b
	 */
	public static void setLog2File(boolean b){
		_log2file=b;
	}

	/**
	 * Detrermines if console logging is enabled
	 * @param b
	 */
	public static void setLog2Console(boolean b){
		_log2console = b;
	}

	/**
	 * Get the current logging level
	 * @return The current logging level
	 */
	public static int getLevel(){
		return _level;
	}

	

	/**
	 * Get the log file path
	 * @return The log file path
	 */
	public static String getPath(){
		return _path;
	}

	/**
	 * Get if file logging is enabled.
	 * @return True if file logging is enabled, otherwise false.
	 */
	public static boolean getLog2File(){
		return _log2file;
	}

	/**
	 * Get if console logging is enabled.
	 * @return True if console logging is enabled, otherwise false.
	 */
	public static boolean getLog2Console(){
		return _log2console;
	}

	/**
	 * Log an exception
	 * @param event The text to describe this log event
	 * @param e The exception
	 */
	public static void logException(String event,Exception e){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(bos);
		e.printStackTrace(ps);
		ps.close();
		log(LOG_LEVEL_ERROR,event + e +":" +bos);
		try{
			bos.close();
		}
		catch(IOException f){

		}
	}

	/**
	 * Used to actually log an event.
	 * @param level The logging level of this event
	 * @param event The text to be logged
	 */
	synchronized public static void log(int level,String event){
		if(level == LOG_LEVEL_NONE)
			return;
		if(level < _level)
			return;
		Date dt = new Date();
		String log = "[" + dt.toString() +"] [";

		switch(level){
			case LOG_LEVEL_NONE:log+="NONE?";break;
			case LOG_LEVEL_ERROR:log+="ERROR";break;
			case LOG_LEVEL_NORMAL:log+="NORMAL";break;
			case LOG_LEVEL_TRACE:log+="TRACE";break;
			case LOG_LEVEL_DUMP:log+="DUMP";break;
		}

		log+="] [" + Thread.currentThread().getName() + "] "+event;

		if(_log2console)
			System.out.println(log);
		if(_log2file){
			try{
				FileOutputStream fos = new FileOutputStream(_path,true);
				PrintStream ps = new PrintStream(fos);
				ps.println(log);
				ps.close();
				fos.close();
			}
			catch(IOException e){
				
			}
		}
	}
}