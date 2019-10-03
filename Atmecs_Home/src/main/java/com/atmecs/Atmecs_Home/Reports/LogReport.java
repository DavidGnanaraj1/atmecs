package com.atmecs.Atmecs_Home.Reports;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs_Atmecs_Home.constants.FilePath;

public class LogReport {
	
	Logger logger = null;
	public LogReport() {
		getlogger();
		logger = Logger.getLogger(LogReport.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure(FilePath.LOG4J_FILE);
	}

	public void info(String message) {
		logger.info(message);
	}
}
