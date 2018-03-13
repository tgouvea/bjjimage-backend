package com.bjjimage.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bjjimage.api.security.entities.Usuario;

@Entity
@Table(name = "fotos_compradas")
public class FotoComprada implements Serializable {

	private static final long serialVersionUID = 4173511279088137260L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Usuario usuario;

	private String hashUsuario;

	private Foto foto;

	private int qtDownloads;

	private Date dataExpiracaoo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getHashUsuario() {
		return hashUsuario;
	}

	public void setHashUsuario(String hashUsuario) {
		this.hashUsuario = hashUsuario;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public int getQtDownloads() {
		return qtDownloads;
	}

	public void setQtDownloads(int qtDownloads) {
		this.qtDownloads = qtDownloads;
	}

	public Date getDataExpiracaoo() {
		return dataExpiracaoo;
	}

	public void setDataExpiracaoo(Date dataExpiracaoo) {
		this.dataExpiracaoo = dataExpiracaoo;
	}

}
