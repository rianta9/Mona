//////////////////////////////////////////////////////
//
// * Code For Fun *_^
//
//////////////////////////////////////////////////////
package com.rianta9.mona.security;

import java.io.Serializable;

import lombok.Getter;

/**
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 17 thg 9, 2021
 * @version 1.0
 * @see 
 */

@Getter
public class UserContext implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private SelectedUserDetails selectedUserDetails;
	
	public UserContext() {
		selectedUserDetails = SelectedUserDetails.builder().build();
	}
	
	public void clear() {
		selectedUserDetails = SelectedUserDetails.builder().build();
	}
	
	public void update(SelectedUserDetails user) {
		this.selectedUserDetails = user;
	}
}
