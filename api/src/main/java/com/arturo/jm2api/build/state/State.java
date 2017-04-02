package com.arturo.jm2api.build.state;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class State implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idState", nullable = false)
	private Integer idState;
	
	@Column(name = "valueState", nullable = false, length = 16)
	private String valueState;

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}

	public String getValueState() {
		return valueState;
	}

	public void setValueState(String valueState) {
		this.valueState = valueState;
	}
	
}