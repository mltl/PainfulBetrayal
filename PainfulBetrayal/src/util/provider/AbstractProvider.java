package util.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
public abstract class AbstractProvider {

	/**
	 * Logger
	 */
	private Logger log = Logger.getLogger(AbstractProvider.class.getName());
	
	/**
	 * @param code
	 * @return la valeur correspondant au code
	 */
	public String getCodesLabels(String code){
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
	
	/**
	 * @return la liste des valeurs du provider
	 */
	public Map<String, String> getCodesLabels(){
		InputStream f;
		Properties p = new Properties();
		Map<String, String> codesLabels = new HashMap<String, String>();
		try {
			f = getClass().getClassLoader().getResourceAsStream(getSrc());
			p.load(f);
			for (Entry<Object, Object> entry : p.entrySet()) {
				codesLabels.put((String)entry.getKey(), (String)entry.getValue());
			}
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return codesLabels;
	}
	
	/**
	 * @return le chemin du fichier
	 */
	public abstract String getSrc();
	
}
