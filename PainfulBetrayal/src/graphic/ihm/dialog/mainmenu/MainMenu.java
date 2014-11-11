package graphic.ihm.dialog.mainmenu;

import game.context.GameContext;
import game.context.file.FileGameContext;
import graphic.ihm.dialog.PBDialog;
import graphic.ihm.dialog.chargeplay.charge.ListSavedPlay;
import graphic.ihm.dialog.createperso.DialCreatePerso;
import graphic.ihm.dialog.mainmenu.bo.MainMenuBO;
import graphic.ihm.frame.mainframe.MainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
public class MainMenu extends PBDialog {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8090686932934185059L;
	
	/**
     * Creates new form MainMenu
     */
    public MainMenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setSize(new Dimension(500, 350));
    }

    /**
     * init
     */
    public void initComponents() {

    	MessageResolver msgRes = new MessageResolver();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        options = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        charge = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        play = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        drawPerso = new javax.swing.JPanel();
        quit = new javax.swing.JButton();
        create = new javax.swing.JButton();
        infoPerso = new JPanel();
        
        jPanel7.setLayout(new GridLayout(1, 2));
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        jPanel1.setLayout(new java.awt.GridLayout(5, 0));

        options.setText(msgRes.getValueFromCode("main.menu.btn.options"));
        options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsActionPerformed(evt);
            }
        });
        options.setMinimumSize(Constantes.SIZE_BUTTONS);
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(options)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(options)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        charge.setText(msgRes.getValueFromCode("main.menu.btn.charge"));
        charge.setMinimumSize(Constantes.SIZE_BUTTONS);
        charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(charge)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(charge)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        create.setText(msgRes.getValueFromCode("main.menu.btn.create"));
        create.setMinimumSize(Constantes.SIZE_BUTTONS);
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
        		jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(create)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
        		jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(create)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6);
        
        play.setText(msgRes.getValueFromCode("main.menu.btn.play"));
        play.setMinimumSize(Constantes.SIZE_BUTTONS);
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(play)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(play)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);

        quit.setText(msgRes.getValueFromCode("main.menu.btn.quit"));
        quit.setMinimumSize(Constantes.SIZE_BUTTONS);
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(quit)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quit)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5);
        
        jPanel7.add(jPanel1);
        
        jPanel8.setLayout(new BorderLayout());
        Serialisation serialisation = new Serialisation();
        FileGameContext context = serialisation.loadFile(Constantes.PATH_JEU + Constantes.SUB_PATH_SAVE + Constantes.LAST_PLAYED + Constantes.FORMAT_SAVE);
        if(context != null && context.getContext() != null){
        	//il s'agit de last.dat, on affiche pas le om du fichier
        	if(!Constantes.LAST_PLAYED.equals(context.getFileName())){
        		ListSavedPlay.fillLabelWithPersonnage(context.getContext().getPersonnage(), infoPerso, context.getFileName());
        	} else {
        		ListSavedPlay.fillLabelWithPersonnage(context.getContext().getPersonnage(), infoPerso, "");
        	}
        	MainMenuBO bo = new MainMenuBO();
        	JLabel label = bo.getOverviewFromRace(context.getContext().getPersonnage().getRace());
            drawPerso.add(label);
            GameContext.setInstance(context.getContext());
        }
        //TODO recuperer en fonction de la race du dernier perso joue
        jPanel8.add(drawPerso, BorderLayout.CENTER);
        jPanel8.add(infoPerso, BorderLayout.SOUTH);
        
        jPanel7.add(jPanel8);
        getContentPane().add(jPanel7);

        pack();
    }                      

    /**
     * @param evt
     */
    private void optionsActionPerformed(java.awt.event.ActionEvent evt) {          
    	//TODO faire la fenetre des options
    	JOptionPane.showMessageDialog(null, "Patience, cela arrivera bientôt !", 
    		      "Info", JOptionPane.INFORMATION_MESSAGE);
    }     
    
    /**
     * @param evt
     */
    private void createActionPerformed(java.awt.event.ActionEvent evt) {          
    	// si un context a ete sette (i.e il exites un fichier last.dat), on le supprime
    	// pour recreer une partie from scratch
    	GameContext.setInstance(null);
    	DialCreatePerso create = new DialCreatePerso(this, false);
    	Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	create.setLocation((int)(tailleEcran.getWidth()/2 - create.getWidth()/2), (int)(tailleEcran.getHeight()/2 - create.getHeight()/2));
    	create.setVisible(true);
    } 

    /**
     * @param evt
     */
    private void chargeActionPerformed(java.awt.event.ActionEvent evt) {                                       
    	ListSavedPlay savedPlay = new ListSavedPlay(this, false);
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		savedPlay.setLocation((int)(tailleEcran.getWidth()/2 - savedPlay.getWidth()/2), (int)(tailleEcran.getHeight()/2 - savedPlay.getHeight()/2));
		savedPlay.setVisible(true);
    }                                      

    /**
     * @param evt
     */
    private void playActionPerformed(java.awt.event.ActionEvent evt) {    
    	if(GameContext.getInstance() == null){
    		Serialisation serial = new Serialisation();
    		String srcLast = Constantes.PATH_JEU + Constantes.SUB_PATH_SAVE + 
    				Constantes.LAST_PLAYED + Constantes.FORMAT_SAVE;
    		File file = new File(srcLast);
    		if(file.exists()){
    			GameContext.setInstance(serial.loadFile(srcLast).getContext());
    		} else {
    			DialCreatePerso create = new DialCreatePerso(null, false);
    	    	Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	    	create.setLocation((int)(tailleEcran.getWidth()/2 - create.getWidth()/2), (int)(tailleEcran.getHeight()/2 - create.getHeight()/2));
    			create.setVisible(true);
    			this.setVisible(false);
    		}
    	}
    	this.setVisible(false);
    	
        MainFrame.main(null);
    }                                    

    /**
     * @param evt
     */
    private void quitActionPerformed(java.awt.event.ActionEvent evt) {                                     
    	System.exit(0);
    }                                    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainMenu dialog = new MainMenu(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private javax.swing.JButton charge;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel drawPerso;
    private JPanel infoPerso;
    private javax.swing.JButton options;
    private javax.swing.JButton play;
    private javax.swing.JButton quit;
    private javax.swing.JButton create;
}
