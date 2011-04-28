/**
This file is part of Chart Glazer.

Chart Glazer is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Chart Glazer is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Chart Glazer.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.jss.ise.chartglazer.shared;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles the logging APIs for this Chart Glazer application.
 * @author rishabh
 */
public class CGLogger
{
	/**
	 * The FileHandler which connects with /Resources/cglog.trace.
	 */
	private static FileHandler cgLoggerFileHandler;

	/**
	 * The core logger object that is used by the trace function.
	 */
	private static Logger cgLogger;

	/**
	 * In case the logger is not available, the System's error console can use used.
	 */
	 private static boolean useSystemErr;

	 /**
	  * The physical location of the trace file on the system. Defaults to the current directory of execution.
	  */
	 // TODO find a proper place to store this file.
	 private static final String LOG_FILE = new String("chartglazer");

	 /**
	  * Sets up the logging files etc.
	  */
	public static void setupLoggingAPI()
	{
		try
		{
			// setup the trace file.
			cgLoggerFileHandler = new FileHandler(LOG_FILE, 1048576, 1, true);

			// make sure that all trace levels are archived into the file.
			cgLoggerFileHandler.setLevel(Level.ALL);

			// create a new logger
			cgLogger = Logger.getLogger("cgLogger");

			// // attach the Logger object, cgLogger and the FileHandler, cgLoggerFileHandler.
			cgLogger.addHandler(cgLoggerFileHandler);

			// if trace file was set up, then no need to use the System.Err console.
			useSystemErr = false;

			//CGLogger.trace(CGLogger.class.getName() + "Log file successfully set up at " + System.getProperty("user.dir"));
		}
		catch(Exception ioe)
		{
			// use this only in case the logger is not available.
			useSystemErr = true;

			CGLogger.trace(Level.WARNING, CGLogger.class.getName() + ": Cannot create logger because: " + ioe.getMessage() + "\nUsing System.err instead.");
		}
	}

	/**
	 * Internal application method for logging values conveniently.
	 * @param level The trace entry's seriousness.
	 * @param msg The text content that must be logged.
	 */
	public static void trace(Level level, String msg)
	{
		Date logDate = new Date();

		if(useSystemErr == true)
		{
			System.err.println(logDate.toString() + level.toString() + ": " + msg);
		}
		else
		{
			CGLogger.cgLogger.log(level, msg);
		}
	}
	/**
	 * Internal application method for logging values conveniently.
	 * Here if you don't pass the level, it is understood that the level is Level.INFO.
	 * @param msg The text content that must be logged.
	 */
	public static void trace(String msg)
	{
		Date logDate = new Date();

		if(useSystemErr == true)
		{
			System.err.println(logDate.toString() + Level.INFO.toString() + ": " + msg);
		}
		else
		{
			CGLogger.cgLogger.log(Level.INFO, msg);
		}
	}
}

