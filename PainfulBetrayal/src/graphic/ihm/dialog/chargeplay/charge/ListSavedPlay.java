package graphic.ihm.dialog.chargeplay.charge;

import game.context.GameContext;
import game.context.file.FileGameContext;
import graphic.ihm.dialog.PBDialog;
import graphic.ihm.dialog.chargeplay.AbstractListSavedPlay;
import graphic.ihm.frame.mainframe.MainFrame;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
public class ListSavedPlay extends AbstractListSavedPlay {

	protected PBDialog parent;

	public ListSavedPlay(PBDialog parent, boolean modal) {
		super(null, modal);
		this.parent = parent;
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
	
	protected void validActionPerformed(java.awt.event.ActionEvent evt) {        
		if(selectionne != null){
	        String text = getTextSelectionne(selectionne);
	        text = text.replace(HTML, "");
	        String[] split = text.split(BR);
	        //je recupere le nom du personnage, qui correcpond au nom du fichier de sauvegarde
	        String namePerso = "";
	        for(int i = 0; i < split.length; i++){
	        	if(split[i].startsWith(FICHIER)){
	        		namePerso = split[i];
	        		namePerso = namePerso.replace(FICHIER, "");
	        	}
	        }
	        Serialisation serial = new Serialisation();
	        FileGameContext loadFile = serial.loadFile(Constantes.PATH_JEU + 
	        		Constantes.SUB_PATH_SAVE + namePerso + Constantes.FORMAT_SAVE);
	        GameContext.setInstance(loadFile.getContext());
	        this.setVisible(false);
	        parent.setVisible(false);
	    	MainFrame.main(null);
		} else {
			JOptionPane.showMessageDialog(null, "Merci de sélectionner une sauvegarde", 
	    		      "Info", JOptionPane.INFORMATION_MESSAGE);
		}
    }     
	
	protected void selectPlay(JPanel save, MouseEvent mouseEvent) {
		if (save.getComponentCount() != 1){
	        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
	        	for(int i = 0; i < save.getComponentCount(); i++){
	        		save.getComponent(i).setForeground(Color.WHITE);
	        		save.getComponent(i).validate();
	        	}
        		save.setBackground(Color.RED);
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

}
