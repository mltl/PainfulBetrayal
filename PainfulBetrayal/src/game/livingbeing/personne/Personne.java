package game.livingbeing.personne;

import graphic.ihm.dialog.createperso.provider.ENUM_RACE;

import java.io.Serializable;

/**
 * Version 1.0, February 2013
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
public class Personne implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2390744603041547770L;

	/** nom */
	private String NAME;

	/** carte dans laquelle se trouve le personnage */
	private String LOCALISATION;

	/** points de vie maximum */
	private Integer MAX_HP;

	/** points de magie maximum */
	private Integer MAX_MP;

	/** points de vie actuels */
	private Integer HP;

	/** points de vie actuels */
	private Integer MP;

	/** niveau du personnage */
	private Integer LVL;

	/** RACE */
	private ENUM_RACE RACE;
	
	/** sexe */
	private Integer SEXE;
	
	/** Position en largeur du perso */
	private Integer POSITION_L;

	/** Position en hauteur du perso */
	private Integer POSITION_H;
	
	/**
	 * @return the nAME
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * @param nAME the nAME to set
	 */
	public void setName(String name) {
		NAME = name;
	}

	/**
	 * @return the lOCALISATION
	 */
	public String getLocalisation() {
		return LOCALISATION;
	}

	/**
	 * @param lOCALISATION the lOCALISATION to set
	 */
	public void setLocalisation(String localisation) {
		LOCALISATION = localisation;
	}

	/**
	 * @return the mAX_HP
	 */
	public Integer getMaxHP() {
		return MAX_HP;
	}

	/**
	 * @param mAX_HP the mAX_HP to set
	 */
	public void setMaxHP(Integer maxHP) {
		MAX_HP = maxHP;
	}

	/**
	 * @return the mAX_MP
	 */
	public Integer getMaxMP() {
		return MAX_MP;
	}

	/**
	 * @param mAX_MP the mAX_MP to set
	 */
	public void setMaxMP(Integer maxMP) {
		MAX_MP = maxMP;
	}

	/**
	 * @return the hP
	 */
	public Integer getHP() {
		return HP;
	}

	/**
	 * @param hP the hP to set
	 */
	public void setHP(Integer hP) {
		HP = hP;
	}

	/**
	 * @return the mP
	 */
	public Integer getMP() {
		return MP;
	}

	/**
	 * @param mP the mP to set
	 */
	public void setMP(Integer mP) {
		MP = mP;
	}

	/**
	 * @return the lVL
	 */
	public Integer getLvl() {
		return LVL;
	}

	/**
	 * @param lVL the lVL to set
	 */
	public void setLvl(Integer lvl) {
		LVL = lvl;
	}

	/**
	 * @return the rACE
	 */
	public ENUM_RACE getRace() {
		return RACE;
	}

	/**
	 * @param rACE the rACE to set
	 */
	public void setRace(ENUM_RACE race) {
		RACE = race;
	}

	/**
	 * @return the sEXE
	 */
	public Integer getSexe() {
		return SEXE;
	}

	/**
	 * @param sEXE the sEXE to set
	 */
	public void setSexe(Integer sexe) {
		SEXE = sexe;
	}

	/**
	 * @return the pOSITION_L
	 */
	public Integer getPositionL() {
		return POSITION_L;
	}

	/**
	 * @param pOSITION_L the pOSITION_L to set
	 */
	public void setPositionL(Integer positionL) {
		POSITION_L = positionL;
	}

	/**
	 * @return the pOSITION_H
	 */
	public Integer getPositionH() {
		return POSITION_H;
	}

	/**
	 * @param pOSITION_H the pOSITION_H to set
	 */
	public void setPositionH(Integer positionH) {
		POSITION_H = positionH;
	}
	
}
