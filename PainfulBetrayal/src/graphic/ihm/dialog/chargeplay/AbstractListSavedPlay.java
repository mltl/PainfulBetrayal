package graphic.ihm.dialog.chargeplay;

import game.context.file.FileGameContext;
import game.livingbeing.personne.Personne;
import graphic.ihm.dialog.PBDialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.newdawn.slick.util.Log;

import util.constantes.Constantes;
import util.resolver.MessageResolver;
import util.serial.Serialisation;

/**
 * Version 1.0, February 2013
 *
 * Copyright (C) 2012 Collonge Florian
 * Dijon France
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
*/

/**
 *
 * @author fcollonge
 */
public abstract class AbstractListSavedPlay extends PBDialog {

    /**
	 * 
	 */
	protected static final long serialVersionUID = -1890328293751873726L;
	
	/**
	 * Texte pour une sauvegarde vide
	 */
	protected static final String EMPTY_SAVE = "Sauvegarde vide";
	
	public static final String BR = "<br />";
	
	public static final String HTML = "<html>";

	public static final String FIN_HTML = "</html>";
	
	public static final String FICHIER = "Fichier : ";
	
	/**
	 * JLabel selectionne
	 */
	protected JPanel selectionne;
	
	protected PBDialog parent;
	
	/**
     * Creates new form ListSavedPlay
     */
    public AbstractListSavedPlay(PBDialog parent, boolean modal) {
        super(null, modal);
        this.parent = parent;
        this.setTitle(Constantes.GAME_TITLE + Constantes.GAME_VERSION);
        initComponents();
    }

    /**
     * initComponents
     */
    public void initComponents() {

    	MessageResolver msgRes = new MessageResolver();
        listPlay = new javax.swing.JPanel();
        saved1_1 = new JPanel();
        saved1_1.setOpaque(true);
        saved1_2 = new JPanel();
        saved1_2.setOpaque(true);
        saved2_1 = new JPanel();
        saved2_1.setOpaque(true);
        saved2_2 = new JPanel();
        saved2_2.setOpaque(true);
        saved3_1 = new JPanel();
        saved3_1.setOpaque(true);
        saved3_2 = new JPanel();
        saved3_2.setOpaque(true);
        jPanel2 = new javax.swing.JPanel();
        charge = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        Serialisation serial = new Serialisation();
        List<FileGameContext> listContext = null;
        Integer nbContext = new Integer(0);
        try {
			listContext = serial.listGameContext();
		} catch (IOException e) {
			Log.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			Log.error(e.getMessage());
		}
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listPlay.setLayout(new java.awt.GridLayout(3, 2));
        FileGameContext context = null;
        if(!listContext.isEmpty()){
            context = listContext.get(nbContext);
            nbContext = nbContext + 1;
        }
        if(context != null){
        	Personne personnage = context.getContext().getPersonnage();
        	fillLabelWithPersonnage(personnage, saved1_1, context.getFileName());
        }
        saved1_1.addMouseListener(new MouseAdapter()  
        {  
        	public void mousePressed(MouseEvent mouseEvent) {
        		selectPlay(saved1_1, mouseEvent);
        	}
        }); 
        listPlay.add(saved1_1);

        nbContext = fillLabelWithPersonnage(listContext, nbContext, saved1_2);
        saved1_2.addMouseListener(new MouseAdapter()  
        {  
        	public void mousePressed(MouseEvent mouseEvent) {
        		selectPlay(saved1_2, mouseEvent);
        	}
        }); 
        listPlay.add(saved1_2);

        nbContext = fillLabelWithPersonnage(listContext, nbContext, saved2_1);
        saved2_1.addMouseListener(new MouseAdapter()  
        {  
        	public void mousePressed(MouseEvent mouseEvent) {
        		selectPlay(saved2_1, mouseEvent);
        	}
        }); 
        listPlay.add(saved2_1);

        nbContext = fillLabelWithPersonnage(listContext, nbContext, saved2_2);
        saved2_2.addMouseListener(new MouseAdapter()  
        {  
        		public void mousePressed(MouseEvent mouseEvent) {
            		selectPlay(saved2_2, mouseEvent);
            	}
        }); 
        listPlay.add(saved2_2);

        nbContext = fillLabelWithPersonnage(listContext, nbContext, saved3_1);
        saved3_1.addMouseListener(new MouseAdapter()  
        {  
        	public void mousePressed(MouseEvent mouseEvent) {
        		selectPlay(saved3_1, mouseEvent);
        	}
        }); 
        listPlay.add(saved3_1);

        nbContext = fillLabelWithPersonnage(listContext, nbContext, saved3_2);
        saved3_2.addMouseListener(new MouseAdapter()  
        {  
        	public void mousePressed(MouseEvent mouseEvent) {
        		selectPlay(saved3_2, mouseEvent);
        	}
			
        }); 
        listPlay.add(saved3_2);
        listPlay.setPreferredSize(new Dimension(400, 200));

        getContentPane().add(listPlay, java.awt.BorderLayout.CENTER);

        charge.setText(msgRes.getValueFromCode("list.saved.play.charge"));
        charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	validActionPerformed(evt);
            }
        });
        
        cancel.setText(msgRes.getValueFromCode("list.saved.play.cancel"));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setPreferredSize(new Dimension(400, 50));
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(charge)
                .addGap(100, 100, 100)
                .addComponent(cancel)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(charge)
                        .addComponent(cancel))
                    .addContainerGap(47, Short.MAX_VALUE))
            );

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }                

    protected Integer fillLabelWithPersonnage(List<FileGameContext> listContext,
			Integer nbContext, JPanel save) {
    	FileGameContext context = null;
    	if(listContext.size() > nbContext){
            context = listContext.get(nbContext);
            nbContext = nbContext + 1;
        }
        if(context != null){
        	Personne personnage = context.getContext().getPersonnage();
        	fillLabelWithPersonnage(personnage, save, context.getFileName());
        } else {
        	createEmptySlot(save);
        }
        return nbContext;
	}

    /**
     * @param saved3_2
     */
    protected abstract void selectPlay(JPanel save, MouseEvent mouseEvent);
    
	/**
     * Remplit un label avec les donnees tirees du personnage
     * 
     * @param personnage
     * @param save
     */
    public static void fillLabelWithPersonnage(Personne personnage, JPanel save, String fileName) {
    	if(personnage == null){
    		createEmptySlot(save);
    	} else {
    		save.setLayout(new GridLayout(5,1));
    		JLabel l4 = new JLabel(FICHIER + fileName);
    		l4.setHorizontalAlignment(JLabel.CENTER);
    		l4.setForeground(Color.RED);
    		JLabel l1 = new JLabel("Héros : " + personnage.getName());
    		l1.setHorizontalAlignment(JLabel.CENTER);
    		JLabel l2 = new JLabel("Niveau " + personnage.getLvl());
    		l2.setHorizontalAlignment(JLabel.CENTER);
    		JLabel l3 = new JLabel("Localisation : " + personnage.getLocalisation());
    		l3.setHorizontalAlignment(JLabel.CENTER);

    		save.add(new JLabel());
    		save.add(l4);
    		save.add(l1);
    		save.add(l2);
    		save.add(l3);
    		
    	}
	}

	/**
	 * @param save
	 */
	private static void createEmptySlot(JPanel save) {
		JLabel l1 = new JLabel(EMPTY_SAVE);
		l1.setForeground(new Color(153,51,255));
		save.add(l1);
		
	}

	abstract protected void validActionPerformed(java.awt.event.ActionEvent evt);        

	protected void cancelActionPerformed(java.awt.event.ActionEvent evt) {     
		this.setVisible(false);
	}
	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }
    /**
	 * @return the selectionne
	 */
	public JPanel getSelectionne() {
		return selectionne;
	}

	/**
	 * @param selectionne the selectionne to set
	 */
	public void setSelectionne(JPanel selectionne) {
		this.selectionne = selectionne;
	}
	
	/**
	 * @param selectionne
	 * @return une string contenant le texte selectionne
	 */
	protected String getTextSelectionne(JPanel selectionne) {
		String selectionneStr = HTML;
		for (int i = 0; i < selectionne.getComponentCount(); i++) {
			JLabel label = (JLabel) selectionne.getComponent(i);
			selectionneStr = selectionneStr + label.getText() + BR;
		}
		selectionneStr = selectionneStr + FIN_HTML;
		return selectionneStr;
	}    
	
	protected javax.swing.JButton charge;
	protected javax.swing.JButton cancel;
    protected javax.swing.JPanel jPanel2;
    protected javax.swing.JPanel listPlay;
    protected JPanel saved1_1;
    protected JPanel saved1_2;
    protected JPanel saved2_1;
    protected JPanel saved2_2;
    protected JPanel saved3_1;
    protected JPanel saved3_2;
}
