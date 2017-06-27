/**
 * Copyright (c) 2017 chrimata
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.chrimata.code;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * Logging singleton to use as a convenient logging mechanism in our application
 * 
 * @author chrimata
 *
 */
public class AppLog extends Observable
{
	/**
	 * The only instance of the singleton
	 */
	private static AppLog		singleton		= null;
	
	/**
	 * The {@link List} of all {@link Observer}s watching for {@link LogEvent}s
	 * from this {@link AppLog} object
	 */
	protected List<Observer>	observerList	= new Vector<Observer>();
	
	private AppLog()
	{
		// private constructor so that no one can create an instance of this
		// object but us
	}
	
	/**
	 * This method returns the one and only instance of this {@link AppLog}
	 * singleton
	 * 
	 * @return
	 */
	public synchronized static AppLog getInstance()
	{
		if (singleton == null)
		{
			singleton = new AppLog();
			
			return singleton;
		}
		
		return singleton;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observable#addObserver(java.util.Observer)
	 */
	@Override
	public void addObserver(Observer obs)
	{
		super.addObserver(obs);
		
		observerList.add(obs);
	}
	
	/**
	 * Gets the {@link List} of all objects which are currently watching for
	 * {@link LogEvent}s
	 * 
	 * @return
	 */
	public List<Observer> getObservers()
	{
		return observerList;
	}
	
	/**
	 * Dispatches a normal log message to all of the observers
	 * 
	 * @param msg
	 */
	public void log(String msg)
	{
		LogEvent evt = new LogEvent(msg, LogLevel.NORMAL);
		setChanged();
		notifyObservers(evt);
	}
	
	/**
	 * Dispatches a normal log message to all of the observers, formatted
	 * according to {@link String#format(String, Object...)} conventions
	 * 
	 * @param msg
	 */
	public void log(String msg, Object... args)
	{
		log(String.format(msg, args));
	}
	
	/**
	 * Dispatches a debug log message to all of the observers
	 * 
	 * @param msg
	 */
	public void logDbg(String msg)
	{
		LogEvent evt = new LogEvent(msg, LogLevel.DEBUG);
		setChanged();
		notifyObservers(evt);
	}
	
	/**
	 * Dispatches a debug log message to all of the observers, formatted
	 * according to {@link String#format(String, Object...)} conventions
	 * 
	 * @param msg
	 */
	public void logDbg(String msg, Object... args)
	{
		log(String.format(msg, args));
	}
	
	/**
	 * Dispatches an error log message to all of the observers
	 * 
	 * @param msg
	 */
	public void logErr(String msg)
	{
		LogEvent evt = new LogEvent(msg, LogLevel.ERROR);
		setChanged();
		notifyObservers(evt);
	}
	
	/**
	 * Dispatches an error log message to all of the observers, formatted
	 * according to {@link String#format(String, Object...)} conventions
	 * 
	 * @param msg
	 */
	public void logErr(String msg, Object... args)
	{
		log(String.format(msg, args));
	}
	
	/**
	 * Logs an {@link Exception} to the Error log, including both the message
	 * and the Stack Trace
	 * 
	 * @param e
	 */
	public void logException(Exception e)
	{
		logErr(e.getMessage());
		
		for (StackTraceElement ele : e.getStackTrace())
		{
			logErr(ele.toString());
		}
	}
	
}
