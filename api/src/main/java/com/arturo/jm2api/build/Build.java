package com.arturo.jm2api.build;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.arturo.jm2api.build.equipment.Equipment;
import com.arturo.jm2api.build.feature.Feature;
import com.arturo.jm2api.build.image.Image;
import com.arturo.jm2api.build.state.State;
import com.arturo.jm2api.build.type.Type;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Cacheable
@Table(name = "builds")
public class Build implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "price", nullable = false, length = 10, precision = 2)
	private Float price;
	
	@Column(name = "currency", nullable = false, length = 6)
	private String currency;
	
	@Column(name = "description", nullable = false, length = 6000)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private State state;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Type type;
	
	@Column(name = "ccaa", nullable = false, length = 100)
	private String ccaa;
	
	@Column(name = "city", nullable = false, length = 100)
	private String city;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "build_features", joinColumns = 
		{ @JoinColumn(name = "build_id", nullable = false, updatable = false) },
		inverseJoinColumns = 
			{ @JoinColumn(name = "feature_id", nullable = false, updatable = false) }
	)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Feature> features;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "build_equipments", joinColumns = 
		{ @JoinColumn(name = "build_id", nullable = false, updatable = false) },
		inverseJoinColumns = 
			{ @JoinColumn(name = "equipment_id", nullable = false, updatable = false) }
	)
	@JsonManagedReference
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Equipment> equipments;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "build")
	//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Image> images;
	
	@Column(name = "identifier", nullable = false, length = 100)
	private String identifier;
	
	public Build() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getCcaa() {
		return ccaa;
	}

	public void setCcaa(String ccaa) {
		this.ccaa = ccaa;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	public Set<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccaa == null) ? 0 : ccaa.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((equipments == null) ? 0 : equipments.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Build other = (Build) obj;
		if (ccaa == null) {
			if (other.ccaa != null)
				return false;
		} else if (!ccaa.equals(other.ccaa))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (equipments == null) {
			if (other.equipments != null)
				return false;
		} else if (!equipments.equals(other.equipments))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Build [id=" + id + ", price=" + price + ", currency=" + currency + ", description=" + description
				+ ", state=" + state + ", type=" + type + ", ccaa=" + ccaa + ", city=" + city + ", features=" + features
				+ ", equipments=" + equipments + ", images=" + images + ", identifier=" + identifier + "]";
	}
	
}
