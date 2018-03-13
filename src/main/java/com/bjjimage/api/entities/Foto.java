package com.bjjimage.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import com.bjjimage.api.enums.FotoType;
import com.bjjimage.api.enums.ResolucaoType;
import com.bjjimage.api.enums.TamanhoType;

@Entity
@Table(name = "foto")
public class Foto implements Serializable {

	private static final long serialVersionUID = 4411069135381962057L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private String descricao;

	@OneToOne
	private Preco preco;

	private int quantidadeVendida;

	private boolean disponivelVenda;

	@OneToOne
	private Evento evento;

	@NotEmpty(message = "O tipo de imagem é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private FotoType fotoType;

	@NotEmpty(message = "O tamanho é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tamanho", nullable = false)
	private TamanhoType tamanho;

	@NotEmpty(message = "A resolução é obrigatória")
	@Enumerated(EnumType.STRING)
	@Column(name = "resolucao", nullable = false)
	private ResolucaoType resolucaoType;

	@NotEmpty(message = "A url é obrigatória")
	private String url;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Fotografo fotografo;

	private Date dataCriacao;

	private Date dataAtualizacao;

	private Date dataExpiracao;

	@Transient
	private Byte[] file;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
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

	public boolean isDisponivelVenda() {
		return disponivelVenda;
	}

	public void setDisponivelVenda(boolean disponivelVenda) {
		this.disponivelVenda = disponivelVenda;
	}

	public TamanhoType getTamanho() {
		return tamanho;
	}

	public void setTamanho(TamanhoType tamanho) {
		this.tamanho = tamanho;
	}

	public ResolucaoType getResolucaoType() {
		return resolucaoType;
	}

	public void setResolucaoType(ResolucaoType resolucaoType) {
		this.resolucaoType = resolucaoType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Byte[] getFile() {
		return file;
	}

	public void setFile(Byte[] file) {
		this.file = file;
	}

	public FotoType getFotoType() {
		return fotoType;
	}

	public void setFotoType(FotoType fotoType) {
		this.fotoType = fotoType;
	}

	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
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

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
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