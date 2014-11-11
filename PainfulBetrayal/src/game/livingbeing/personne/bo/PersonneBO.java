package game.livingbeing.personne.bo;

import graphic.ihm.dialog.createperso.provider.ENUM_RACE;

import java.util.LinkedHashMap;
import java.util.Map;

import util.constantes.Constantes;

/**
 * Version 0, March 2013
 *
 * Copyright (C) 2512 Collonge Florian
 * Dijon France
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
*/

/**
 * @author fcollonge
 *
 */
public class PersonneBO {

	/**
	 * Charge les attributs de base du perso suivant la race
	 */
	public Map<String, Integer> chargeCaracteristicsPerso(ENUM_RACE race){
		Map<String, Integer> attributs = new LinkedHashMap<String, Integer>();
		attributs.put(Constantes.AGILITY, 5);
		attributs.put(Constantes.AUTHORITY, 5);
		attributs.put(Constantes.COURAGE, 5);
		attributs.put(Constantes.DEXTERITY, 5);
		attributs.put(Constantes.DIVERSIFICATION, 5);
		attributs.put(Constantes.INTELLIGENCE, 5);
		attributs.put(Constantes.PRECISION, 5);
		attributs.put(Constantes.SPEED, 5);
		attributs.put(Constantes.STAMINA, 5);
		attributs.put(Constantes.STEALTH, 5);
		attributs.put(Constantes.STRENGTH, 5);
		attributs.put(Constantes.TRADE, 5);
		attributs.put(Constantes.UNDERSTANDING, 5);
		attributs.put(Constantes.VERSATILITY, 5);
		switch(race){
		case AGYLIS :
			attributs.put(Constantes.AGILITY, 7);
			attributs.put(Constantes.STEALTH, 7);
			attributs.put(Constantes.INTELLIGENCE, 7);
			attributs.put(Constantes.VERSATILITY, 3);
			attributs.put(Constantes.TRADE, 3);
			attributs.put(Constantes.STRENGTH, 3);
			break;
		case ELFE :
			attributs.put(Constantes.INTELLIGENCE, 7);
			attributs.put(Constantes.SPEED, 7);
			attributs.put(Constantes.UNDERSTANDING, 7);
			attributs.put(Constantes.STAMINA, 3);
			attributs.put(Constantes.STRENGTH, 3);
			attributs.put(Constantes.VERSATILITY, 3);
			break;
		case GOBELIN :
			attributs.put(Constantes.TRADE, 7);
			attributs.put(Constantes.VERSATILITY, 7);
			attributs.put(Constantes.DIVERSIFICATION, 7);
			attributs.put(Constantes.STRENGTH, 3);
			attributs.put(Constantes.STAMINA, 3);
			attributs.put(Constantes.COURAGE, 3);
			break;
		case HUMAIN :
			attributs.put(Constantes.DEXTERITY, 7);
			attributs.put(Constantes.PRECISION, 7);
			attributs.put(Constantes.VERSATILITY, 7);
			attributs.put(Constantes.STAMINA, 3);
			attributs.put(Constantes.INTELLIGENCE, 3);
			attributs.put(Constantes.AUTHORITY, 3);
			break;
		case MORN :
			attributs.put(Constantes.STRENGTH, 7);
			attributs.put(Constantes.DEXTERITY, 7);
			attributs.put(Constantes.COURAGE, 7);
			attributs.put(Constantes.SPEED, 3);
			attributs.put(Constantes.INTELLIGENCE, 3);
			attributs.put(Constantes.UNDERSTANDING, 3);
			break;
		case NAIN :
			attributs.put(Constantes.STRENGTH, 7);
			attributs.put(Constantes.DEXTERITY, 7);
			attributs.put(Constantes.AUTHORITY, 7);
			attributs.put(Constantes.PRECISION, 3);
			attributs.put(Constantes.SPEED, 3);
			attributs.put(Constantes.STEALTH, 3);
			break;
		}
		return attributs;
	}
	
}
