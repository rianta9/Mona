//////////////////////////////////////////////////////
//
// * Code For Fun *_^
//
//////////////////////////////////////////////////////
package com.rianta9.mona.entity.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

/**
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 16 thg 9, 2021
 * @version 1.0
 * @see 
 */
@Embeddable
@Data
public class EntityId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigint")
	private Long id;
}
