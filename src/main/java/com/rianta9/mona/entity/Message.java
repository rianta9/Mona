//////////////////////////////////////////////////////
//
// * Code For Fun *_^
//
//////////////////////////////////////////////////////
package com.rianta9.mona.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.rianta9.mona.entity.common.Auditable;
import com.rianta9.mona.entity.common.EntityId;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 16 thg 9, 2021
 * @version 1.0
 * @see 
 */

@Entity
@Getter
@Setter
public class Message extends Auditable{
	
	@EmbeddedId
	private EntityId id;
}
