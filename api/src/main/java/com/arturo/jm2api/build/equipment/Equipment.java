package com.arturo.jm2api.build.equipment;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.arturo.jm2api.build.Build;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "equipments")
public class Equipment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idEquipment")
	private Integer idEquipment;
	
	@Column(name = "valueEquiment")
	private String valueEquiment;
	
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "equipments")
    @JsonBackReference
	private Set<Build> builds = new HashSet<>();

	/**
	 * @return the idEquipment
	 */
	public Integer getIdEquipment() {
		return idEquipment;
	}

	/**
	 * @param idEquipment the idEquipment to set
	 */
	public void setIdEquipment(Integer idEquipment) {
		this.idEquipment = idEquipment;
	}

	/**
	 * @return the valueEquiment
	 */
	public String getValueEquiment() {
		return valueEquiment;
	}

	/**
	 * @param valueEquiment the valueEquiment to set
	 */
	public void setValueEquiment(String valueEquiment) {
		this.valueEquiment = valueEquiment;
	}

	/**
	 * @return the builds
	 */
	public Set<Build> getBuilds() {
		return builds;
	}

	/**
	 * @param builds the builds to set
	 */
	public void setBuilds(Set<Build> builds) {
		this.builds = builds;
	}
	
}
