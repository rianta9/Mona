//////////////////////////////////////////////////////
//
// * Code For Fun *_^
//
//////////////////////////////////////////////////////
package com.rianta9.mona.security;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 17 thg 9, 2021
 * @version 1.0
 * @see 
 */

@Builder
@Getter
@Setter
public class SelectedUserDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private String email;
	
	private String fullName;
	
	private LocalDate birthDay;
	
	private String gender;
	
	private String roleId;
}
