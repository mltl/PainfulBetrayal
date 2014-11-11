package graphic.ihm.dialog.mainmenu.bo;

import graphic.ihm.dialog.createperso.provider.ENUM_RACE;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import util.constantes.Constantes;
import util.provider.SrcProvider;

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
public class MainMenuBO {

	/**
	 * @param race
	 * @return le label contenant l'overview par rapport a la race du personnage
	 */
	public JLabel getOverviewFromRace(ENUM_RACE race){
		JLabel label = new JLabel();
		SrcProvider src = new SrcProvider();
		Icon icon = new ImageIcon(Constantes.PATH_JEU + "" + src.getCodesLabels("image.ov." + race.value.toLowerCase()));;
		label.setIcon(icon);
		return label;
	}
	
}
