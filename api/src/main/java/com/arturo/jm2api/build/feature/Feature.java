package com.arturo.jm2api.build.feature;

import java.io.Serializable;
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
@Table(name = "features")
public class Feature implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFeature")
	private Integer idFeature;
	
	@Column(name = "valueFeature")
	private String valueFeature;
	
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "features")
    @JsonBackReference
	private Set<Build> builds;
	
	public Feature() { }

	/**
	 * @return the idFeature
	 */
	public Integer getIdFeature() {
		return idFeature;
	}

	/**
	 * @param idFeature the idFeature to set
	 */
	public void setIdFeature(Integer idFeature) {
		this.idFeature = idFeature;
	}

	/**
	 * @return the valueFeature
	 */
	public String getValueFeature() {
		return valueFeature;
	}

	/**
	 * @param valueFeature the valueFeature to set
	 */
	public void setValueFeature(String valueFeature) {
		this.valueFeature = valueFeature;
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
