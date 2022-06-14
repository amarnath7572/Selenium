import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		// we should let eclipse know where the properties file is located
		
		FileInputStream fis = new FileInputStream("C:\\Users\\gangigua\\eclipse-workspace1\\Selenium\\src\\commondata.properies");
		// now we need to give the path knowledge to the Properties object
		// to read the properties file load method
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
		
		//you can change the global value at runtime
		prop.setProperty("browser", "Edge");
		System.out.println(prop.getProperty("browser"));
		// this wont update in the properties file
		
		// in order to update the properties file, we need to use FileOutputStream
		FileOutputStream fos = new FileOutputStream("C:\\Users\\gangigua\\eclipse-workspace1\\Selenium\\src\\commondata.properies");
		
		// to update the properties file, store method
		prop.store(fos, null);
		
	}

}
