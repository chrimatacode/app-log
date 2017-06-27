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

/**
 * This class specifies a given {@link String} message and {@link LogLevel} for
 * a logging message for our application
 * 
 * @author chrimata
 *
 */
public class LogEvent
{
	/**
	 * The Log Message
	 */
	protected String	message	= null;
	
	/**
	 * The {@link LogLevel} of the message
	 */
	protected LogLevel	level	= null;
	
	/**
	 * Default Constructor
	 */
	public LogEvent()
	{
		message = "";
		level = LogLevel.NORMAL;
	}
	
	/**
	 * Constructs a {@link LogEvent} for a given message {@link String} and
	 * {@link LogLevel}
	 * 
	 * @param msg
	 * @param lvl
	 */
	public LogEvent(String msg, LogLevel lvl)
	{
		message = msg;
		level = lvl;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}
	
	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	/**
	 * @return the level
	 */
	public LogLevel getLevel()
	{
		return level;
	}
	
	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(LogLevel level)
	{
		this.level = level;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEvent other = (LogEvent) obj;
		if (level != other.level)
			return false;
		if (message == null)
		{
			if (other.message != null)
				return false;
		}
		else if (!message.equals(other.message))
			return false;
		return true;
	}
	
}
