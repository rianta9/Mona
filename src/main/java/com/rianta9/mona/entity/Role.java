/**
 * 
 */
package com.rianta9.mona.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * This class is used for ...
 * @project Mona
 * @author rianta9
 * @date_created 15 thg 9, 2021
 * @version 1.0
 * @see
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int")
	private Integer roleId;
	
	@Column(nullable = false, unique = true, columnDefinition = "varchar(256)")
	private String roleCode;
	
	@Column(nullable = false, unique = true, columnDefinition = "nvarchar(256)")
	private String roleName;
}
