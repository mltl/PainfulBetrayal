package graphic.ihm.dialog.chargeplay.charge;

import game.context.GameContext;
import game.context.file.FileGameContext;
import graphic.ihm.dialog.PBDialog;

import javax.swing.JOptionPane;

import org.newdawn.slick.util.Log;

import util.constantes.Constantes;
import util.resolver.MessageResolver;
import util.serial.Serialisation;

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
public class ListSavedPlayInGame extends ListSavedPlay {

	public ListSavedPlayInGame(PBDialog parent, boolean modal) {
		super(parent, modal);
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3061760249257640692L;

	@Override
	public void initComponents() {
		super.initComponents();
		MessageResolver msgRes = new MessageResolver();
		charge.setText(msgRes.getValueFromCode("list.saved.play.charge"));
	}
	
//	protected void validActionPerformed(java.awt.event.ActionEvent evt) {        
//		if(selectionne != null){
//	        String text = getTextSelectionne(selectionne);
//	        text = text.replace(HTML, "");
//	        String[] split = text.split(BR);
//	        //je recupere le nom du personnage, qui correcpond au nom du fichier de sauvegarde
//	        String namePerso = "";
//	        for(int i = 0; i < split.length; i++){
//	        	if(split[i].startsWith(FICHIER)){
//	        		namePerso = split[i];
//	        		namePerso = namePerso.replace(FICHIER, "");
//	        	}
//	        }
//	        
//	        Serialisation serial = new Serialisation();
//	        String path = Constantes.PATH_JEU + 
//	        		Constantes.SUB_PATH_SAVE + namePerso + Constantes.FORMAT_SAVE;
//	        Log.debug(path);
//			FileGameContext loadFile = serial.loadFile(path);
//	        GameContext.setInstance(loadFile.getContext());
//	        this.setVisible(false);
//	        parent.setVisible(false);
//		} else {
//			JOptionPane.showMessageDialog(null, "Merci de sélectionner une sauvegarde", 
//	    		      "Info", JOptionPane.INFORMATION_MESSAGE);
//		}
//    }

}
