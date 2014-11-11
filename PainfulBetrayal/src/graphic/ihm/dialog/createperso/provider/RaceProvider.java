package graphic.ihm.dialog.createperso.provider;

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
public class RaceProvider {

	public static final String RACE_VIDE = "...";
	
	/**
	 * @return la liste des races
	 */
	public String[] getRaces() {
		String[] races;
		ENUM_RACE[] enumRaces = ENUM_RACE.values();
		races = new String[enumRaces.length + 1];
		races[0] = RACE_VIDE;
		for (int i = 0; i < enumRaces.length; i++) {
			races[i + 1] = enumRaces[i].value;
		}
		return races;
	}

}
