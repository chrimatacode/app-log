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
 * @author chrimata
 *
 */
public class Start
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ConsoleLogger cl = new ConsoleLogger();
		
		AppLog.getInstance().addObserver(cl);
		
		AppLog.getInstance().log("Hi!");
		
		cl.setErrorOn(false);
		cl.setDebugOn(false);
		
		AppLog log = AppLog.getInstance();
		
		log.logDbg("Oops here's some helpful info");
		
		log.logErr("AHHHHH!!!! It's on FIRE");
		
		try
		{
			throw new Exception("DSFDFSDFSFSD");
		}
		catch (Exception e)
		{
			log.logException(e);
		}
	}
	
}
