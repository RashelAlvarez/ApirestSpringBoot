package com.curso.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idrol;
	private String nombre;
	
	@ManyToOne(fetch=FetchType.LAZY, optional = false)
	@JoinColumn(name="iduser", nullable=true)
	@JsonProperty(access=Access.WRITE_ONLY)
	private User user;

	public Role() {
		
	}


	public Integer getIdrol() {
		return idrol;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public User getUser() {
		return user;
	}


	public Role(String nombre, User user) {
		super();
		this.nombre = nombre;
		this.user = user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
