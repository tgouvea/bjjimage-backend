package com.bjjimage.api.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.bjjimage.api.security.entities.Usuario;

public class FotografoDto {

	private String nome;
	
	private String cpf;
	
	private String linkPortifolio;
	
	private DadoBancarioDto dadoBancario = new DadoBancarioDto();

}
