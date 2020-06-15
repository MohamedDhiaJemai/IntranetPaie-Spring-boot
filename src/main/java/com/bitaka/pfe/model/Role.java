package com.bitaka.pfe.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDCRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String role;
	
	@NotNull
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private Set<Utilisateur> users;
	
	@JsonIgnore
	@OneToMany(mappedBy="role", fetch =FetchType.LAZY)
	private Set<PorteuseWFLDCRole> porteuseWFLDCRoles;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Utilisateur> getUsers() {
		return users;
	}

	public void setUsers(Set<Utilisateur> users) {
		this.users = users;
	}

	public Role() {
		super();
	}

	public Role(Long id, String role, String description, Set<Utilisateur> users) {
		super();
		this.id = id;
		this.role = role;
		this.description = description;
		this.users = users;
	}

//	@Override
//	public String toString() {
//		return "Role [id=" + id + ", role=" + role + ", description=" + description + ", users=" + users + "]";
//	}
	
	

}
