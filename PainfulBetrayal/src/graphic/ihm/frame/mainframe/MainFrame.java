package graphic.ihm.frame.mainframe;


import game.context.GameContext;
import game.livingbeing.personne.Personne;
import graphic.ihm.dialog.ingamemenu.DialInGameMenu;
import graphic.ihm.frame.PBFrame;
import graphic.ihm.frame.embedded.FrameGameEmbedded;

import java.awt.Dimension;
import java.io.InputStream;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.Log;

import util.constantes.Constantes;
import util.provider.SrcProvider;

 
/**
 * Version 1.0, November 2012
 *
 * Copyright (C) 2012 Collonge Florian
 * Dijon France
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
*/

/**
 * Fenetre d'affichage principale
 * 
 * @author fcollonge
 *
 */
public class MainFrame extends PBFrame {
	
	/**
	 * position en hauteur de la map
	 */
	private Integer p_h_fenetre = 0;
	
	/**
	 * position en largeur de la map
	 */
	private Integer p_l_fenetre;
	
	/**
	 * position en hauteur de la map
	 */
	private Integer p_h_perso;
	
	/**
	 * position en largeur de la map
	 */
	private Integer p_l_perso = 0;
	
	/**
	 * image du perso
	 */
	private SpriteSheet perso;
	
	/**
	 * Animation du personnage
	 */
	private Animation persoAnime;
	
	/**
	 * Animation possible du personnage de face
	 */
	private Animation persoAnimeFront;
	
	/**
	 * Animation possible du personnage de dos
	 */
	private Animation persoAnimeBack;
	
	/**
	 * Animation possible du personnage de profil gauche
	 */
	private Animation persoAnimeLeft;
	
	/**
	 * Animation possible du personnage de profil droit
	 */
	private Animation persoAnimeRight;
	
	/**
	 * Image du personnage a l'arret
	 */
	private Image persoFige;
	
	/**
	 * map
	 */
	private TiledMap tiledMap;
	
	/**
	 * taille en hauteur de la fenetre
	 */
	private static Integer height;
	
	/**
	 * taille en largeur de la fenetre
	 */
	private static Integer width;
	
	/**
	 * tableau contenant l'ensemble des interactions pour la map
	 */
	private String[][] interaction;
 
	/**
	 * Tableau contenant les elements bloquants
	 */
	private boolean[][] blocs;
	
	private static DialInGameMenu menuInGame;
	
	private Personne heros;
	
	/**
	 * @param title
	 */
	public MainFrame(String title) {
		super(title);
	}
	
	/**
	 * Constructeur avec titre par defaut
	 */
	public MainFrame() {
		super();
	}

	/**
	 * Initialise mes objets. Exécuté au lancement du jeux.
	 * @see org.newdawn.slick.BasicGame#init(org.newdawn.slick.GameContainer)
	 */
	@Override
	public void init(GameContainer container) throws SlickException {
 
		// on recupere le tileset des mouvements du personnage
		// la taille est de 32px par 32px
		GameContext context = GameContext.getInstance();
		SrcProvider srcProvider = new SrcProvider();
		// on recupere le skin du perso en fonction de la race qui a ete choisie
		heros = context.getPersonnage();
		//on recupere la position du personnage
		p_l_fenetre = heros.getPositionL();
		p_h_fenetre = heros.getPositionH();
		// si la position n'a pas ete settee on initialise a 0
		if(p_l_fenetre == null){
			p_l_fenetre = 0;
		}
		if(p_h_fenetre == null){
			p_h_fenetre = 0;
		}
		perso = new SpriteSheet(Constantes.PATH_JEU + "/" + srcProvider.getCodesLabels("image.skin." + heros.getRace().value.toLowerCase()),32,32);
		// On cree les animations de dos, face, profil droit et gauche
		persoAnimeFront = new Animation();
		persoAnimeBack = new Animation();
		persoAnimeLeft = new Animation();
		persoAnimeRight = new Animation();
        for (int frame = 0; frame < 4; frame++){
        	// on recupere image par image dans le tileset pour creer l'animation
        	persoAnimeFront.addFrame(perso.getSprite(frame, 0),100);
        	persoAnimeLeft.addFrame(perso.getSprite(frame, 1),100);
        	persoAnimeRight.addFrame(perso.getSprite(frame, 2),100);
        	persoAnimeBack.addFrame(perso.getSprite(frame, 3),100);
        }
        // la premiere image affiche est le personnage de face
        persoFige = perso.getSprite(0, 0);
		tiledMap = new TiledMap(Constantes.PATH_JEU + "/" + srcProvider.getCodesLabels("data.map.map1"));
		Integer widthMap = tiledMap.getWidth();
		Integer heightMap = tiledMap.getHeight();
		interaction = new String[widthMap][heightMap];
		blocs = new boolean[widthMap][heightMap];
		for (int x = 0; x < widthMap; x++)
		{
			for (int y = 0; y < heightMap; y++){
				for(int l = 0; l < 2; l++){
					int id = tiledMap.getTileId(x, y, l);
		            if (id != 0) { 
		            	// on cree les tableaux contenant les elements bloquants ainsi que les endroits disposant du teleport
		            	String block = tiledMap.getTileProperty(id, "block", "");
		                String tp = tiledMap.getTileProperty(id, "tp", "");
		                interaction[x][y] = tp;
		                blocs[x][y] = Boolean.valueOf(block);
		            }
		        }
		    }
		}
	}
 
	/**
	 * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		if(!menuInGame.isActive()){
			if (container.getInput().isKeyDown((Input.KEY_Z))) {
				// Si on appuie sur la touche z
				boolean bloc = isBlock(p_l_fenetre, p_h_fenetre + 10);
				if(!bloc){
					//a chaque modification de la position, on met a jour la position du personnage
					p_h_fenetre += 10;
					heros.setPositionH(p_h_fenetre);
					
				}
				// on recupere l'animation et l'image figee correspondante
				persoAnime = persoAnimeBack;
				persoFige = perso.getSprite(0, 3);
			} else if (container.getInput().isKeyDown(Input.KEY_S)) {
				// Si on appuie sur la touche s
				boolean bloc = isBlock(p_l_fenetre, p_h_fenetre - 10);
				if(!bloc){
					p_h_fenetre -= 10;
					heros.setPositionH(p_h_fenetre);
				}
				persoAnime = persoAnimeFront;
				persoFige = perso.getSprite(0, 0);
			} else if (container.getInput().isKeyDown(Input.KEY_Q)) {
				// Si on appuie sur la touche q
				boolean bloc = isBlock(p_l_fenetre + 10, p_h_fenetre);
				if(!bloc){
					p_l_fenetre += 10;
					heros.setPositionL(p_l_fenetre);
				}
				persoAnime = persoAnimeLeft;
				persoFige = perso.getSprite(0, 1);
			} else if (container.getInput().isKeyDown(Input.KEY_D)) {
				// Si on appuie sur la touche d
				boolean bloc = isBlock(p_l_fenetre - 10, p_h_fenetre);
				if(!bloc){
					p_l_fenetre -= 10;
					heros.setPositionL(p_l_fenetre);
				}
				persoAnime = persoAnimeRight;
				persoFige = perso.getSprite(0, 2);
			} else if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
				container.setAlwaysRender(false);
				Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				menuInGame.setLocation((int)(tailleEcran.getWidth()/2 - menuInGame.getWidth()/2), (int)(tailleEcran.getHeight()/2 - menuInGame.getHeight()/2));
				menuInGame.setVisible(true);
			} else if (container.getInput().isKeyPressed(Input.KEY_ENTER)) {
				Personne personnage = GameContext.getInstance().getPersonnage();
				personnage.setLvl(personnage.getLvl() + 1);
			}
		}
 
	}
 
	/**
	 * Méthode appelé en boucle. C'est ici qu'on gére l'affichage.
	 * @see org.newdawn.slick.Game#render(org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
 
		// on affiche la map
		tiledMap.render(p_l_fenetre, p_h_fenetre);
 
		// Et je la rajoute à ma fenetre
		p_h_perso = height/2;
		p_l_perso = width/2;
		if(container.getInput().isKeyDown(Input.KEY_D) || container.getInput().isKeyDown(Input.KEY_Q)
				|| container.getInput().isKeyDown(Input.KEY_Z) || container.getInput().isKeyDown(Input.KEY_S)){
			persoAnime.draw(p_l_perso, p_h_perso);
		} else {
			persoFige.draw(p_l_perso, p_h_perso);
		}
 
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//on recupere les dimensions de l'ecran
			Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			height = (int) tailleEcran.getHeight()/2;
			width = (int) tailleEcran.getWidth()/2;
			FrameGameEmbedded frame = new FrameGameEmbedded(new MainFrame());
			frame.setSize(width, height);
			frame.setLocation((int)(width - frame.getWidth()/2), (int)(height - frame.getHeight()/2));
			frame.setVisible(true);
			frame.getGameContainer().getContainer().setTargetFrameRate(60);
			frame.getGameContainer().start();
			frame.getGameContainer().requestFocus();
			menuInGame = new DialInGameMenu(frame, false);
 
		} catch (SlickException e) {
			Log.error(e.getMessage());
		}
	}

	/**
	 * @return the interaction
	 */
	public String[][] getInteraction() {
		return interaction;
	}

	/**
	 * @param interaction the interaction to set
	 */
	public void setInteraction(String[][] interaction) {
		this.interaction = interaction;
	}
	
	/**
	 * @param x
	 * @param y
	 * @param dir
	 * @return un boolean pour designer si la case sur laquelle on souhaite se diriger est bloquante ou pas
	 */
	public boolean isBlock(int x, int y){
		y = y - p_h_perso;
		x = x - p_l_perso;

		int pos_y = (y - 20)/32;
		int pos_x = (x - 15)/32;
		pos_y = (int)Math.round(pos_y);
		if(pos_y < 0){
			pos_y = pos_y * -1;
		}
		pos_x = (int)Math.round(pos_x);
		if(pos_x < 0){
			pos_x = pos_x * -1;
		}
		return (blocs[pos_x][pos_y] || !"".equals(interaction[pos_x][pos_y]));
		//TODO a remplacer lorsque la gestion des tp sera faite
		//return blocs[pos_x][pos_y];
	}

	/**
	 * @param srcImg
	 * @return l'image liee a la source
	 * @throws SlickException
	 */
	public Image getImage(String srcImg) throws SlickException{
		InputStream inputImg = getClass().getClassLoader().getResourceAsStream(srcImg);
		return new Image(inputImg, "", false);
	}

	/**
	 * @return the menuInGame
	 */
	public DialInGameMenu getMenuInGame() {
		return menuInGame;
	}

	/**
	 * @param menuInGame the menuInGame to set
	 */
	public void setMenuInGame(DialInGameMenu menuInGame) {
		MainFrame.menuInGame = menuInGame;
	}
	
}
