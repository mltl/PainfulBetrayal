import ihm.FrameInstaller;

import java.awt.Dimension;

/**
 * Version 1.0, February 2013
 *
 * Copyright (C) 2012 Collonge Florian
 * Gemeaux France
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
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		FrameInstaller install = new FrameInstaller();
		install.setSize(new Dimension(450,400));
		install.setLocation(tailleEcran.width/2 - 225, tailleEcran.height/2 - 200);
		install.setVisible(true);
	}

}
