package graphic.ihm.frame;

import org.newdawn.slick.BasicGame;

import util.constantes.Constantes;

/**
 * Version 1.0, December 2012
 *
 * Copyright (C) 2012 Collonge Florian
 * Dijon France
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
*/

/**
 * Super classe pour les fenetres d'affichage du jeu
 * 
 * @author fcollonge
 *
 */
public abstract class PBFrame extends BasicGame {

	/**
	 * @param title
	 */
	public PBFrame(String title) {
		super(title);
	}
	
	/**
	 * Affichage d'une fenetre avec un titre par defaut
	 */
	public PBFrame(){
		super(Constantes.GAME_TITLE + Constantes.GAME_VERSION);
	}

}
