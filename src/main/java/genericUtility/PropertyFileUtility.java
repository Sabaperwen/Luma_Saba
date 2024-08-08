package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fi=new FileInputStream("./src/test/resources/CommonData.Properties");
		Properties property=new Properties();
		property.load(fi);
		String value=property.getProperty(key);
		return value;
	}
}
