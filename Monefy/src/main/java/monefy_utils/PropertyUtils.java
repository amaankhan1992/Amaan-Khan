package monefy_utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class will contain methods to read configuration from property file
 * 
 * @author amaankhan
 */
public class PropertyUtils {

	private static PropertyUtils INSTANCE = null;
	private final Properties props = new Properties();
	private static Logger log = LogManager.getLogger(PropertyUtils.class);
	
	private PropertyUtils() {
		this.loadProperties("configuration.properties");
		this.props.putAll(System.getProperties());
		
		
	}

	private static PropertyUtils getInstance() {
		if (PropertyUtils.INSTANCE == null) {
			PropertyUtils.INSTANCE = new PropertyUtils();
		}
		return PropertyUtils.INSTANCE;
	}

	/**
	 * This method will read property for given key
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(final String key) {
		return PropertyUtils.getInstance().props.getProperty(key);
	}

	/**
	 * This method will return value for any given property
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static int getIntegerProperty(String key, int defaultValue) {
		int integerValue=0;
		final String value=PropertyUtils.getInstance().props.getProperty(key);
		if(value==null)
		{
			return defaultValue;
		}
		integerValue=Integer.parseInt(value);
		return integerValue;
	}

	public static String getProperty(final String key, final String defaultValue) {
		return PropertyUtils.getInstance().props.getProperty(key, defaultValue);
	}

	/**
	 * This method loads propeties file in Properties object
	 * 
	 * @param path
	 */
	private void loadProperties(final String path) {

		InputStream inputStream = null;
		log.info("Loading properties from "+path);
		try {
			inputStream = ClassLoader.getSystemResourceAsStream(path);
			log.info(inputStream);
			if (inputStream != null) {
				this.props.load(inputStream);
				log.info("File loaded from : "+ inputStream);
			} else {
				throw new UnableToLoadPropertiesException("Property file - " + path + "not found in classpath");
			}
		} catch (final Exception e) {
			e.printStackTrace();
			log.error("Found exception " +e);
		} finally {
			try {
				inputStream.close();
				log.info("CLosing file" + inputStream );
			} catch (final IOException e) {
				e.printStackTrace();
				log.error("IOException Occured "+e);
			}
		}

		return;

	}

	/**
	 * 
	 * @return Properties
	 */
	public static Properties getProps() {
		return PropertyUtils.getInstance().props;
	}

	class UnableToLoadPropertiesException extends RuntimeException {

		UnableToLoadPropertiesException(final String s) {
			super(s);
		}

		public UnableToLoadPropertiesException(final String string, final Exception ex) {
			super(string, ex);
			log.info("Exception occured in loading properties file : " +ex);
		}

	}
}
