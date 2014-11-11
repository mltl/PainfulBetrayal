package util.constantes;

import java.awt.Dimension;

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
public class Constantes {

	public static final String VERSION = "v0.1";
	
	/**
	 * Taille de base des boutons
	 */
	public static final Dimension SIZE_BUTTONS = new Dimension(150,20);
	
	/**
	 * Chemin pour le dossier dans Program Files
	 */
	public static final String PATH_JEU = System.getenv("ProgramFiles") + "/A Painful Betrayal";
//	private String pathJeu = System.getProperty("user.dir");
	
	/**
	 * Chemin dans le dossier pour atteindre les sauvegardes
	 */
	public static final String SUB_PATH_SAVE = "/Data/Save/";
	
	/**
	 * Format de sauvegarde des fichiers
	 */
	public static final String FORMAT_SAVE = ".dat";
	
	public static final String LAST_PLAYED = "last";
	
	/**
	 * Titre du jeu
	 */
	public static final String GAME_TITLE = "A Painful Betrayal";
	
	/**
	 * Version du jeu
	 */
	public static final String GAME_VERSION = " 0.1";
	
	/**
	 * Caracteristiques du personnage
	 */
	public static final String STRENGTH = "Force";
	public static final String STAMINA = "Endurance";
	public static final String AGILITY = "Agilité";
	public static final String SPEED = "Vitesse";
	public static final String DEXTERITY = "Dextérité";
	public static final String INTELLIGENCE = "Intelligence";
	public static final String PRECISION = "Précision";
	public static final String STEALTH = "Furtivité";
	public static final String TRADE = "Commerce";
	public static final String VERSATILITY = "Versatilite";
	public static final String AUTHORITY = "Autorité";
	public static final String UNDERSTANDING = "Compréhension";
	public static final String DIVERSIFICATION = "Diversification";
	public static final String COURAGE = "Courage";
	/**
	 * FIN caracteristiques du personnage
	 */
	
	/**
	 * enumeration des differentes directions possibles
	 */
	public enum DIRECTIONS{
		NORTH, SOUTH, EAST, WEST
	}
	
}
