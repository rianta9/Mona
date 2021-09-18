/**
 * 
 */
package com.rianta9.mona.util;

/**
 * 
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 15 thg 9, 2021
 * @version 1.0
 * @see
 */
public class StringHelper {
	public static String getIdFormat(Long id) {
		return String.format("#%09d", id);
	}
}
