package util.serial;

import game.context.GameContext;
import game.context.file.FileGameContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import util.constantes.Constantes;

/**
 * Version 1.0, July 2012
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
public class Serialisation {

	/**
	 * Logger
	 */
	private Logger log = Logger.getLogger(Serialisation.class.getName());
	
	/**
	 * @param path
	 * @return le tableau correspondant a la map
	 */
	public String[][] loadMap(String path){
		try {
			FileInputStream fip = new FileInputStream(path);
			ObjectInputStream oip = new ObjectInputStream(fip);
			String[][] mapStr = (String[][]) oip.readObject();
			return mapStr;
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Stocke un objet dans un fichier
	 * 
	 * @param objectToStore
	 * @param fileDest
	 */
	public void storeFile(Object objectToStore, String fileDest){
		try{
		FileOutputStream fichier = new FileOutputStream(fileDest);
		ObjectOutputStream oos = new ObjectOutputStream(fichier);
		oos.writeObject(objectToStore);
		oos.flush();
		oos.close();
		} catch(IOException e){
			log.error(e.getMessage());
		}
	}
	
	/**
	 * Methode generique de recuperation d'objet de type T dans un fichier
	 * 
	 * @param src
	 * @return l'objet contenu dans le fichier
	 * @throws IOException
	 */
	public FileGameContext loadFile(String src){
		try {
			File file = new File(src);
			if(file.exists()){
				FileInputStream fip = new FileInputStream(src);
				ObjectInputStream oip = new ObjectInputStream(fip);
				GameContext readObject = (GameContext) oip.readObject();
				oip.close();
				FileGameContext fgc = new FileGameContext();
				String name = file.getName();
				name = name.replace(Constantes.FORMAT_SAVE, "");
				fgc.setFileName(name);
				fgc.setContext(readObject);
				return fgc;
			}
			return null;
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage());
			return null;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}

	/**
	 * @return la liste des gamecontext avec le nom du fichier
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<FileGameContext> listGameContext() throws IOException, ClassNotFoundException {
		List<FileGameContext> contexts = new ArrayList<FileGameContext>();
		File save = new File(Constantes.PATH_JEU + Constantes.SUB_PATH_SAVE);
		if(!save.exists()){
			save.mkdir();
		}
		File[] listFiles = save.listFiles();
		for (File file : listFiles) {
			if(!(Constantes.LAST_PLAYED + Constantes.FORMAT_SAVE).equals(file.getName())){
				FileGameContext fgc = loadFile(file.getAbsolutePath());
				contexts.add(fgc);
			}
		}
		return contexts;
	}

	public void saveGameContext(GameContext context, String path) throws IOException {
		FileOutputStream fop = null;
		if(StringUtils.isBlank(path)){
			fop = new FileOutputStream(new File(
					Constantes.PATH_JEU + Constantes.SUB_PATH_SAVE + context.getPersonnage().getName() + 
					Constantes.FORMAT_SAVE));
		} else {
			fop = new FileOutputStream(new File(path));
		}
		ObjectOutputStream oos = new ObjectOutputStream(fop);
		oos.writeObject(context);
		oos.flush();
		fop.close();
		oos.close();
		//on sauvegarde ausi dans le last, afin de pouvoir l'afficher dans le menu principal
		FileOutputStream fopLast = new FileOutputStream(new File(
				Constantes.PATH_JEU + Constantes.SUB_PATH_SAVE + Constantes.LAST_PLAYED + 
				Constantes.FORMAT_SAVE));
		ObjectOutputStream oosLast = new ObjectOutputStream(fopLast);
		oosLast.writeObject(context);
		oosLast.flush();
		fopLast.close();
		oosLast.close();
	}

}
