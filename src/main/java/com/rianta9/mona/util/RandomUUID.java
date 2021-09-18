package com.rianta9.mona.util;

import java.util.UUID;

/**
 * 
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 15 thg 9, 2021
 * @version 1.0
 * @see
 */
public class RandomUUID {
	public static String getRandomID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
