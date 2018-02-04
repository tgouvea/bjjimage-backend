package com.bjjimage.domain;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="fotos")
@Data
public class Foto {
	
	@Id
	private String id;
	
	private String description;
	
	private boolean availableForSale;
	
	private boolean done;
	
	private String url;
	
	@Transient
	private Byte[] file;
	
    @CreatedDate
    private Date createdAt;
    
    @LastModifiedDate
    private Date lastModified;
    
    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;

	
}
