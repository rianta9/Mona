//////////////////////////////////////////////////////
//
// * Code For Fun *_^
//
//////////////////////////////////////////////////////
package com.rianta9.mona.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.rianta9.mona.security.UserContext;

/**
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 17 thg 9, 2021
 * @version 1.0
 * @see 
 */

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {
	@Autowired
	private UserContext userContext;
	
	@Bean
	public AuditorAware<String> auditorProvider(){
		return () -> Optional.ofNullable(userContext.getSelectedUserDetails().getUsername());
	}
}
