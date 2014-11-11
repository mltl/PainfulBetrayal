package graphic.ihm.frame.embedded;

import javax.swing.JFrame;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.CanvasGameContainer;
import org.newdawn.slick.SlickException;

/**
 * @author fcollonge
 *
 */
public class FrameGameEmbedded extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4444166340782705576L;
	
	/**
	 * Conteneur du jeu embarque
	 */
	private CanvasGameContainer gameContainer;
	
	/**
	 * @param game
	 * @throws SlickException 
	 */
	public FrameGameEmbedded(BasicGame game) throws SlickException{
		super();
		//on enleve la barre de titre 
		this.setUndecorated(true);
		initComponents(game);
	}

	/**
	 * @param game
	 * @throws SlickException 
	 */
	private void initComponents(BasicGame game) throws SlickException {
		gameContainer = new CanvasGameContainer(game);
		this.getContentPane().add(gameContainer);
		pack();
	}

	/**
	 * @return the container
	 */
	public CanvasGameContainer getGameContainer() {
		return gameContainer;
	}

	/**
	 * @param container the container to set
	 */
	public void setContainer(CanvasGameContainer container) {
		this.gameContainer = container;
	}

}
