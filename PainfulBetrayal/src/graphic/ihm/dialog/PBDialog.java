package graphic.ihm.dialog;

import java.awt.Frame;

import javax.swing.JDialog;

import util.constantes.Constantes;

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
public abstract class PBDialog extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 278062416577244637L;
	
	/**
	 * @param parent
	 * @param modal
	 */
	public PBDialog(Frame parent, Boolean modal){
		super(parent, modal);
        this.setTitle(Constantes.GAME_TITLE + Constantes.GAME_VERSION);
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public abstract void initComponents();
	
}
