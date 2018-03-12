package com.bjjimage.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "evento")
public class Evento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9006971394959630476L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@NotEmpty(message = "O nome do evento é obrigatório.")
	@Length(min = 3, max = 100)
	private String nome;

	@NotEmpty(message = "O nome do evento é obrigatório.")
	@Length(min = 5, max = 255)
	private String descricao;

	private Date dataCriacao;

	private Date dataAtualizacao;

	private Date dataDoEvento;
	
	@OneToMany(mappedBy = "evento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Fotografo> fotografos;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Date getDataDoEvento() {
		return dataDoEvento;
	}

	public void setDataDoEvento(Date dataDoEvento) {
		this.dataDoEvento = dataDoEvento;
	}
	
	public List<Fotografo> getFotografos() {
		return fotografos;
	}

	public void setFotografos(List<Fotografo> fotografos) {
		this.fotografos = fotografos;
	}

	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

}
