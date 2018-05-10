package euroStar.MasterFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
	public static Properties frameworkProperties = null;

	public static String getValueForTheKeywordFromConfigFile(String getData) throws Exception {
		
		String desiredValue = null;
		
		try {
			frameworkProperties = new Properties();
			InputStream inputStream = new FileInputStream("src/test/resources/Configuration/config.properties");

			frameworkProperties.load(inputStream);

			desiredValue = frameworkProperties.getProperty(getData);
		} catch (Exception ex) {
			throw new RuntimeException("Failed to initialize/load .property file: " + ex.getMessage());
		}
		return desiredValue;

	}
}
