package com.rianta9.mona.entity.common;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.rianta9.mona.util.DateTimeUtil;

import lombok.Getter;
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
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter()
@Setter
public class Auditable {
	@CreatedDate
	@Column
	private LocalDateTime createdDate;	
	
	@LastModifiedDate
	@Column
	private LocalDateTime lastModifiedDate;
	
	@CreatedBy
	@Column(columnDefinition = "nvarchar(256)")
	private String createdBy;
	
	@LastModifiedBy
	@Column(columnDefinition = "nvarchar(256)")
	private String lastModifiedBy;
	
	public String getStringCreatedDate() {
		return DateTimeUtil.toStringType(createdDate);
	}
	
	public String getStringLastModifiedDate() {
		return DateTimeUtil.toStringType(lastModifiedDate);
	}
}
