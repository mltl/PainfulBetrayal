package game.livingbeing.mob;

import java.io.Serializable;

/**
 * Version 1.0, October 2012
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
public class Mob implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7057696483585590965L;

	/** NOM */
	private String NAME;
	
	/** NIVEAU */
	private Integer LEVEL;
	
	/** POINTS DE VIE */
	private Integer HP;
	
	/** POINTS DE MAGIE */
	private Integer MP;
	
	/** FORCE */
	private Integer STRENGTH;
	
	/** AGILITE */
	private Integer AGILITY;
	
	/** ENDURANCE */
	private Integer ENDURANCE;
	
	/** VITESSE */
	private Integer SPEED;
	
	/** DEXTERITE */
	private Integer DEXTERITY;
	
	/** INTELLIGENCE */
	private Integer INTELLIGENCE;
	
	/** PRECISION */
	private Integer PRECISION;
	
	/** FURTIVITE */
	private Integer STEALTH;
	
	/** COURAGE */
	private Integer COURAGE;
	
	/** AGRESSIVITE */
	private String AGGRESSION;

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
	 * @return the lEVEL
	 */
	public Integer getLevel() {
		return LEVEL;
	}

	/**
	 * @param lEVEL the lEVEL to set
	 */
	public void setLevel(Integer level) {
		LEVEL = level;
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
	public void setHP(Integer hp) {
		HP = hp;
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
	public void setMP(Integer mp) {
		MP = mp;
	}

	/**
	 * @return the sTRENGTH
	 */
	public Integer getStrength() {
		return STRENGTH;
	}

	/**
	 * @param sTRENGTH the sTRENGTH to set
	 */
	public void setStrength(Integer strength) {
		STRENGTH = strength;
	}

	/**
	 * @return the aGILITY
	 */
	public Integer getAgility() {
		return AGILITY;
	}

	/**
	 * @param aGILITY the aGILITY to set
	 */
	public void setAgility(Integer agility) {
		AGILITY = agility;
	}

	/**
	 * @return the eNDURANCE
	 */
	public Integer getEndurance() {
		return ENDURANCE;
	}

	/**
	 * @param eNDURANCE the eNDURANCE to set
	 */
	public void setEndurance(Integer endurance) {
		ENDURANCE = endurance;
	}

	/**
	 * @return the sPEED
	 */
	public Integer getSpeed() {
		return SPEED;
	}

	/**
	 * @param sPEED the sPEED to set
	 */
	public void setSpeed(Integer speed) {
		SPEED = speed;
	}

	/**
	 * @return the dEXTERITY
	 */
	public Integer getDexterity() {
		return DEXTERITY;
	}

	/**
	 * @param dEXTERITY the dEXTERITY to set
	 */
	public void setDexterity(Integer dexterity) {
		DEXTERITY = dexterity;
	}

	/**
	 * @return the iNTELLIGENCE
	 */
	public Integer getIntelligence() {
		return INTELLIGENCE;
	}

	/**
	 * @param iNTELLIGENCE the iNTELLIGENCE to set
	 */
	public void setIntelligence(Integer intelligence) {
		INTELLIGENCE = intelligence;
	}

	/**
	 * @return the pRECISION
	 */
	public Integer getPrecision() {
		return PRECISION;
	}

	/**
	 * @param pRECISION the pRECISION to set
	 */
	public void setPrecision(Integer precision) {
		PRECISION = precision;
	}

	/**
	 * @return the sTEALTH
	 */
	public Integer getStealth() {
		return STEALTH;
	}

	/**
	 * @param sTEALTH the sTEALTH to set
	 */
	public void setStealth(Integer stealth) {
		STEALTH = stealth;
	}

	/**
	 * @return the cOURAGE
	 */
	public Integer getCourage() {
		return COURAGE;
	}

	/**
	 * @param cOURAGE the cOURAGE to set
	 */
	public void setCourage(Integer courage) {
		COURAGE = courage;
	}

	/**
	 * @return the aGGRESSION
	 */
	public String getAggression() {
		return AGGRESSION;
	}

	/**
	 * @param aGGRESSION the aGGRESSION to set
	 */
	public void setAggression(String aggression) {
		AGGRESSION = aggression;
	}
	
}
