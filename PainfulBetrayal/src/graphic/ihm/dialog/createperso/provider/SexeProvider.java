package graphic.ihm.dialog.createperso.provider;

import util.resolver.MessageResolver;
import graphic.ihm.dialog.createperso.DialCreatePerso;

/**
 * Version 1.0, March 2013
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
public class SexeProvider {

	/**
	 * @param code
	 * @return le libelle du sexe 
	 */
	public static String getLabel(Integer code){
		MessageResolver messageResolver = new MessageResolver();
		if(DialCreatePerso.H_SELECTED.equals(code)){
			return messageResolver.getValueFromCode("dial.create.sexe.homme");
		} else if(DialCreatePerso.F_SELECTED.equals(code)){
			return messageResolver.getValueFromCode("dial.create.sexe.femme");
		}
		return "";
	}
	
}
