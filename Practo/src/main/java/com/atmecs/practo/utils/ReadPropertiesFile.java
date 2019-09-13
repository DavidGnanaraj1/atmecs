package com.atmecs.practo.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	static File file;
	static FileReader filereader;
	static Properties prop;

	public Properties loadProperty(String path) throws IOException {
		prop = new Properties();
		file = new File(path);
		filereader = new FileReader(file);
		prop.load(filereader);
		return prop;

	}

	public String getData(String data) throws IOException {
		String datav = prop.getProperty(data);
		return datav;
	}
}
