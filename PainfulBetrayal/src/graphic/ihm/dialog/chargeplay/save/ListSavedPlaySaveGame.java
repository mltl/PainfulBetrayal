package graphic.ihm.dialog.chargeplay.save;

import game.context.GameContext;
import graphic.ihm.dialog.PBDialog;
import graphic.ihm.dialog.chargeplay.AbstractListSavedPlay;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
public class ListSavedPlaySaveGame extends AbstractListSavedPlay {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1241387771208997329L;

	public ListSavedPlaySaveGame(PBDialog parent, boolean modal) {
		super(parent, modal);
	}

	@Override
	public void initComponents() {
		super.initComponents();
    	MessageResolver msgRes = new MessageResolver();
		charge.setText(msgRes.getValueFromCode("list.saved.play.save"));
	}
	
	@Override
	protected void validActionPerformed(ActionEvent evt) {
		if(selectionne != null){
			GameContext context = GameContext.getInstance();
			if(selectionne.getComponentCount() == 1){
				Serialisation serial = new Serialisation();
		        try {
					serial.saveGameContext(context, Constantes.PATH_JEU + 
							Constantes.SUB_PATH_SAVE + context.getPersonnage().getName()
							+ Constantes.FORMAT_SAVE);
				} catch (IOException e) {
					Log.error(e.getMessage());
				}
			}
	        String text = getTextSelectionne(selectionne);
	        text = text.replace(HTML, "");
	        String[] split = text.split(BR);
	        //je recupere le nom du personnage, qui correcpond au nom du fichier de sauvegarde
	        String namePerso = split[0];
	        Serialisation serial = new Serialisation();
	        try {
				serial.saveGameContext(context, Constantes.PATH_JEU + 
						Constantes.SUB_PATH_SAVE + namePerso + Constantes.FORMAT_SAVE);
			} catch (IOException e) {
				Log.error(e.getMessage());
			}
	        this.setVisible(false);
	        parent.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Merci de sélectionner une sauvegarde", 
	    		      "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	protected void selectPlay(JPanel save, MouseEvent mouseEvent) {
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
        	save.setBackground(Color.RED);
        	for(int i = 0; i < save.getComponentCount(); i++){
        		save.getComponent(i).setForeground(Color.WHITE);
        		save.getComponent(i).validate();
        	}
        	save.validate();
        }
        if(selectionne != null){
        	selectionne.setBackground(new Color(238, 238, 238));
    		for(int i = 0; i < selectionne.getComponentCount(); i++){
    			JLabel label = (JLabel) save.getComponent(i);
    			if(label.getText().startsWith(FICHIER)){
    				selectionne.getComponent(i).setForeground(Color.RED);
    			} else {
    				selectionne.getComponent(i).setForeground(Color.BLACK);
    			}
    			selectionne.getComponent(i).validate();
        	}
    		selectionne.validate();
    	}
        if(selectionne == null || !selectionne.equals(save)){
        	selectionne = save;
        } else if(selectionne.equals(save)){
        	save.setBackground(new Color(238, 238, 238));
    		for(int i = 0; i < save.getComponentCount(); i++){
    			JLabel label = (JLabel) save.getComponent(i);
    			if(label.getText().startsWith(FICHIER)){
    				save.getComponent(i).setForeground(Color.RED);
    			} else {
    				save.getComponent(i).setForeground(Color.BLACK);
    			}
        		save.getComponent(i).validate();
        	}
    		save.validate();
        	selectionne = null;
        }
	}

}
