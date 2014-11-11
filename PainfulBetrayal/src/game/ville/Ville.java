package game.ville;

/**
 * Version 1.0, July 2012
 *
 * Copyright (C) 2012 Collonge Florian
 * Dijon France
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
*/

/**
 * model pour les villes
 * 
 * @author fcollonge
 *
 */
public class Ville {

	/**
	 * Nom de la ville
	 */
	private String nom;
	
	/**
	 * position dans la largeur de la ville
	 * une position positive indique qu'elle se trouve a l'est du point (0,0)
	 * point (0,0) => Soluurean
	 */
	private Integer positionLargeur;
	
	/**
	 * position dans la hauteur de la ville
	 * une position positive indique qu'elle se trouve au nord du point (0,0)
	 * point (0,0) => Soluurean
	 */
	private Integer positionHauteur;

	/**
	 * Contentement de la ville
	 */
	private Integer contentement;
	
	/**
	 * Type de la ville (Citoyenne, economique ou militaire)
	 */
	private Integer typeVille;
	
	/**
	 * Race
	 */
	private String race;
	
	/**
	 * @return le nom de la ville
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public Integer getPositionLargeur() {
		return this.positionLargeur;
	}

	/**
	 * @param positionLargeur
	 */
	public void setPositionLargeur(Integer positionLargeur) {
		this.positionLargeur = positionLargeur;
	}

	/**
	 * @return la position en hauteur
	 */
	public Integer getPositionHauteur() {
		return this.positionHauteur;
	}

	/**
	 * @param positionHauteur the positionHauteur to set
	 */
	public void setPositionHauteur(Integer positionHauteur) {
		this.positionHauteur = positionHauteur;
	}

	/**
	 * @return the contentement
	 */
	public Integer getContentement() {
		return contentement;
	}

	/**
	 * @param contentement the contentement to set
	 */
	public void setContentement(Integer contentement) {
		this.contentement = contentement;
	}

	/**
	 * @return the typeVille
	 */
	public Integer getTypeVille() {
		return typeVille;
	}

	/**
	 * @param typeVille the typeVille to set
	 */
	public void setTypeVille(Integer typeVille) {
		this.typeVille = typeVille;
	}

	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}
	
}
