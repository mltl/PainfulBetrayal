package graphic.ihm.dialog.createperso.provider;

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
public enum ENUM_RACE {

	AGYLIS("Agylis"),
	ELFE("Elfe"),
	GOBELIN("Gobelin"),
	HUMAIN("Humain"),
	MORN("Morn"),
	NAIN("Nain");
	
	/** Valeur */
    public final String value;
    
    /** @param value */
    private ENUM_RACE(String value) {
        this.value = value;
    }

    /**
     * @param value
     * @return FILE_FORMAT
     */
    public static ENUM_RACE getEnumByString(String value) {
        for (ENUM_RACE v : values()) {
            if (v.value.equalsIgnoreCase(value)) {
                return v;
            }
        }
        return null;
    }
}