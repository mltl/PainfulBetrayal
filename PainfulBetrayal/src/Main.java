import game.context.GameContext;
import graphic.ihm.dialog.mainmenu.MainMenu;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.newdawn.slick.util.Log;

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
public class Main {

	/**
	 * @param args
	 */
	public static void main(String args[]){
//		Serialisation serial = new Serialisation();
		//on recupere le contexte du jeu
		GameContext context = GameContext.getInstance();
		//on set le nom de la map
		context.setMapName("Map1.tmx");

		// on cree les caracteristiques et la liste des sorts du personnage
		Map<String, Integer> caracteristiques = new HashMap<String, Integer>();

		//on cree et set les caracteristiques et liste de skills
		caracteristiques.put("dexterite", 9);
		caracteristiques.put("force", 8);
		caracteristiques.put("endurance", 7);
		caracteristiques.put("vitesse", 6);
		caracteristiques.put("comprehension", 5);
		caracteristiques.put("autorite", 4);
		caracteristiques.put("agilite", 3);
		caracteristiques.put("defense", 2);


//		Personne personne = new Personne();

//		personne.setCaracteristique(caracteristiques);
//		personne.setName("mLtL");
//		personne.setLvl(12);
//		personne.setLocalisation("Si possible chez moi");
//		personne.setRace(ENUM_RACE.NAIN);
//		context.setPersonnage(personne);

//		try {
//			serial.saveGameContext(context);
//		} catch (IOException e) {
//			Log.error(e.getMessage());
//		}
//		GameContext game2 = serial.loadGameContext();
        
		try {
			//on set le meme look and feel que le systeme
			UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			Log.error(e.getMessage());
		} catch (InstantiationException e) {
			Log.error(e.getMessage());
		} catch (IllegalAccessException e) {
			Log.error(e.getMessage());
		} catch (UnsupportedLookAndFeelException e) {
			Log.error(e.getMessage());
		}
		MainMenu mainMenu = new MainMenu(null, false);
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		mainMenu.setLocation((int)(tailleEcran.getWidth()/2 - mainMenu.getWidth()/2), (int)(tailleEcran.getHeight()/2 - mainMenu.getHeight()/2));
		mainMenu.setVisible(true);
		
	}

}
