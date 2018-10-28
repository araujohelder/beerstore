package com.hibicode.beerstore.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity

public class Beer {

	@Id
	@SequenceGenerator(name = "beer_seq", sequenceName = "beer_seq", allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beer_seq")
	private Long id;
	
	@NotBlank(message = "beers-1")
	private String name;
	
	@NotNull(message = "beers-2")
	private BeerType type;
	
	@NotNull(message = "beers-3")
	@DecimalMin(value = "0", message = "beers-4") // o menor valor é zero, não aceitará números negativos
	private BigDecimal volume;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Beer other = (Beer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BeerType getType() {
		return type;
	}
	public void setType(BeerType type) {
		this.type = type;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	
	
	 @JsonIgnore
     public boolean isNew() {
        return getId() == null;
     }

     @JsonIgnore
     public boolean alreadyExist() {
         return getId() != null;
     }
	
}
