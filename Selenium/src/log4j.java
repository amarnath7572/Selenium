import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;

public class log4j {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("log4j.configurationFile", "./path_to_the_log4j2_config_file/log4j2.xml");
		Logger log = LogManager.getLogger(log4j.class.getName());
		
		log.debug("Debugging");
		log.error("logging error");
		log.info("info message");
		log.fatal("fatal error");
	}

}
