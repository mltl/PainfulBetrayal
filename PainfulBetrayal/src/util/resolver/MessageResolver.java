package util.resolver;

/**
 * Version 1.0, February 2012
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
public class MessageResolver extends AbstractResolver {

	/**
	 * @see util.resolver.AbstractResolver#getSrc()
	 */
	@Override
	public String getSrc() {
		return "util/provider/properties/message.properties";
	}

}
