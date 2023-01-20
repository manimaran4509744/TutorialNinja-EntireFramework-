package org.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerClass {

	public static Logger logger = LogManager.getLogger(Logger.class.getName());

	public static void startTestCase(String testCaseName) {
		logger.info(testCaseName + " Has Been Started ");
	}

	public static void endTestCase(String testCaseName) {
		logger.info(testCaseName + " Has Been ended ");
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void fatal(String message) {
		logger.fatal(message);
	}

}
