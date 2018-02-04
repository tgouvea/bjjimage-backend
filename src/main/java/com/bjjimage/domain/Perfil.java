package com.bjjimage.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Document
@Data
public class Perfil implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117046352819578035L;

	@Id
	private String id;
	
	private String perfil;
	
    public Perfil() {
    }

    public Perfil(String perfil) {
        this.perfil = perfil;
    }

	
	@Override
	public String getAuthority() {
		return perfil;
	}
	

}
