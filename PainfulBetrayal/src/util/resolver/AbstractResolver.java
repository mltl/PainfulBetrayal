package util.resolver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Version 1.0, July 2012
 *
 * Copyright (C) 2012 Collonge Florian
 * Dijon France
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
*/

/**
 * @author fcollonge
 *
 */
public abstract class AbstractResolver {
	
	/**
	 * Logger
	 */
	private Logger log = Logger.getLogger(AbstractResolver.class.getName());
	
	/**
	 * @param code
	 * @return la valeur associee au code
	 */
	public String getValueFromCode(String code){
		InputStream f;
		Properties p = new Properties();
		try {
			f = getClass().getClassLoader().getResourceAsStream(getSrc());
			p.load(f);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return p.getProperty(code);
	}

	public abstract String getSrc();
	
}
