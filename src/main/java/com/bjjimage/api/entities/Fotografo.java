package com.bjjimage.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.bjjimage.api.security.entities.Usuario;

@Entity
@Table(name = "fotografo")
public class Fotografo implements Serializable {

	private static final long serialVersionUID = -1583655813127314993L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private Usuario usuario;
	private String cpf;
	private String linkPortifolio;
	private DadoBancario bancario;
	private Date dataCriacao;
	private Date dataAtualizacao;
	
	@OneToMany(mappedBy = "fotografo", fetch = FetchType.LAZY)
	private List<Foto> fotos = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Evento evento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLinkPortifolio() {
		return linkPortifolio;
	}

	public void setLinkPortifolio(String linkPortifolio) {
		this.linkPortifolio = linkPortifolio;
	}

	public DadoBancario getBancario() {
		return bancario;
	}

	public void setBancario(DadoBancario bancario) {
		this.bancario = bancario;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
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

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
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
