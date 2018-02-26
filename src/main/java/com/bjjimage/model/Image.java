package com.bjjimage.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Document(collection="images")
@Data
public class Image {
	
	@Id
	private String id;
	
	private String description;
	
	private boolean availableForSale;
	
	private ImageType imageType;	
	
	private String url;
	
	@Transient
	private Byte[] file;
	
	@ApiModelProperty(value = "Key to identify lead search")
	private ImageType key;
		
	
    @CreatedDate
    private Date createdAt;
    
    @LastModifiedDate
    private Date lastModified;
    
    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;

	
}
