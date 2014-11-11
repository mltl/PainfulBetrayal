package game.context.file;

import game.context.GameContext;

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
public class FileGameContext {

	/**
	 * Nom du fichier
	 */
	private String fileName;
	
	/**
	 * GameContext du fichier
	 */
	private GameContext context;

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the context
	 */
	public GameContext getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(GameContext context) {
		this.context = context;
	}
	
}
