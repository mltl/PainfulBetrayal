package sys;
import ihm.FrameInstaller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.chainsaw.Main;

/**
 * Version 1.0, February 2013
 *
 * Copyright (C) 2012 Collonge Florian
 * Gemeaux France
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
*/

/**
 * @author fcollonge
 *
 */
public class ThreadCopieFichier extends Thread{

	/**
	 * frame principale
	 */
	private FrameInstaller frame;
	
	private String path;
	
	public ThreadCopieFichier(FrameInstaller frame, String path){
		this.frame = frame;
		this.path = path;
	}
	
	/**
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		if(StringUtils.isBlank(path)){
			//si l'utilisateur n'a pas choisis de chemin, on met par defaut dans programFiles
			path = System.getenv("ProgramFiles");
		}
		
		File testDeleteImages = new File(path + "/" + FrameInstaller.NAME + "/images");
		File testDeleteMusic = new File(path + "/" + FrameInstaller.NAME + "/music");
		//on supprime les fichiers existants
		// evite les problemes si des fichiers ont ete supprimes de l'install
		if(testDeleteImages.exists()){
			testDeleteImages.delete();
		}
		if(testDeleteMusic.exists()){
			testDeleteMusic.delete();
		}
		//traitement des donnees
		InputStream resource = Main.class.getClassLoader().getResourceAsStream("resources/resources.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
		String ligne = "";
		try{
			InputStream resourceAsStream = null;
			FileOutputStream fop = null;
			while ((ligne=reader.readLine())!=null){
				resourceAsStream = Main.class.getClassLoader().getResourceAsStream("resources/" + ligne);
				File dest = new File(path + "/" + FrameInstaller.NAME + "/" + ligne);
				File parent = dest.getParentFile();
				parent.mkdirs();
				frame.getAvancementLabel().setText(frame.getAvancementLabel().getText() + "<br />" + ligne);
				fop = new FileOutputStream(path + "/" + FrameInstaller.NAME + "/" + ligne);
				IOUtils.copy(resourceAsStream, fop);
				fop.flush();
			}
			fop.close();
			resourceAsStream.close();
			//traitement de l'exe
			InputStream exe = Main.class.getClassLoader().getResourceAsStream("resources/Data/A Painful Betrayal.exe");
			if(exe == null){
				exe = Main.class.getClassLoader().getResourceAsStream("resources/Data/A Painful Betrayal.jar");
			}
			FileOutputStream fopExe = new FileOutputStream(path + "/" + FrameInstaller.NAME + "/A Painful Betrayal.exe");
			IOUtils.copy(exe, fopExe);
			fopExe.flush();
			fopExe.close();
			exe.close();
			JOptionPane.showMessageDialog(frame, "Installation réussie", "Installation réussie", JOptionPane.INFORMATION_MESSAGE);
		} catch(Exception e){
			frame.getAvancementLabel().setText(frame.getAvancementLabel().getText() + "<br />" + e.getCause());
			JOptionPane.showMessageDialog(frame, "Erreur lors de l'installation", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
