package Managers;

import DataProvider.ConfigFileReader;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	//private as it does not allow others to instantiate FileReaderManger instances
	private FileReaderManager() {}
	
	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}
	
	public ConfigFileReader getConfigReader() {
		if(configFileReader == null) {
			return new ConfigFileReader();
		}else {
			return configFileReader;
		}
	}
}
