package com.arturo.jm2api.build.image;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.arturo.jm2api.build.Build;

@Entity
@Table(name = "build_images")
public class Image implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idImage", nullable = false)
	private Integer idImage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "build_id")
	private Build build;
	
	@Column(name = "path", nullable = false, length = 60)
	private String path;

	public Integer getIdImage() {
		return idImage;
	}

	public void setIdImage(Integer idImage) {
		this.idImage = idImage;
	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}