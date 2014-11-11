package game.context;

import game.livingbeing.personne.Personne;

import java.io.Serializable;

/**
 * Version 1.0, February 2013
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
public class GameContext implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6719490493118662068L;

	/**
	 * Instance du contexte
	 */
	private static GameContext instance;

	/**
	 * Nom de la map
	 */
	private String mapName;
	
	/**
	 * Heros
	 */
	private Personne personnage;
	
	/**
	 * Singleton
	 */
	private GameContext(){
	}
	
	/**
	 * @return the instance
	 */
	public static GameContext getInstance() {
		if(instance == null){
			return new GameContext();
		}
		return instance;
	}
	
	public static void setInstance(GameContext context){
		instance = context;
	}

	/**
	 * @return the mapName
	 */
	public String getMapName() {
		return mapName;
	}

	/**
	 * @param mapName the mapName to set
	 */
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	/**
	 * @return the personnage
	 */
	public Personne getPersonnage() {
		return personnage;
	}

	/**
	 * @param personnage the personnage to set
	 */
	public void setPersonnage(Personne personnage) {
		this.personnage = personnage;
	}

}
