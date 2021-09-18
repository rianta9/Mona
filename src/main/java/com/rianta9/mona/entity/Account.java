/**
 * 
 */
package com.rianta9.mona.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import com.rianta9.mona.entity.common.Auditable;
import com.rianta9.mona.entity.common.EntityId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * This class is used for ...
 * 
 * @project Mona
 * @author rianta9
 * @date_created 15 thg 9, 2021
 * @version 1.0
 * @see
 */

@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Account extends Auditable{
	@EmbeddedId
	private EntityId id;

	@Column(unique = true, columnDefinition = "varchar(256)")
	private String username;

	@Column(nullable = false, columnDefinition = "varchar(256)")
	private String password;

	@Column(nullable = false, columnDefinition = "varchar(256)")
	private String fullName;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDay;

	@Column(columnDefinition = "varchar(10)")
	private String gender;

	@Column(unique = true, columnDefinition = "varchar(11)")
	private String phone;

	@Column(nullable = false, unique = true, columnDefinition = "varchar(256)")
	private String email;

	@Column(columnDefinition = "nvarchar(256)")
	private String address;

	@Column(nullable = false, columnDefinition = "varchar(256)")
	private String avatar;

	@ManyToOne
	@JoinColumn(nullable = false, name = "role_id")
	private Role role;

	@Column(nullable = false)
	@ColumnDefault("1")
	private Integer status;
}
