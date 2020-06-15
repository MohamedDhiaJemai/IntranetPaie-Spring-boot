package com.bitaka.pfe.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Centre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String reference;
	
	@NotNull
	private String libelle;
 
	@JsonIgnore
	@OneToMany(mappedBy = "centre", fetch = FetchType.LAZY)
	private Set<Utilisateur> users;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getReference() {
//		return reference;
//	}
//
//	public void setReference(String reference) {
//		this.reference = reference;
//	}
//
//	public String getLibelle() {
//		return libelle;
//	}
//
//	public void setLibelle(String libelle) {
//		this.libelle = libelle;
//	}
//
//	public Collection<Utilisateur> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<Utilisateur> users) {
//		this.users = users;
//	}
//
//	public Centre(Long id, String reference, String libelle, Set<Utilisateur> users) {
//		super();
//		this.id = id;
//		this.reference = reference;
//		this.libelle = libelle;
//		this.users = users;
//	}
//
//	public Centre() {
//		super();
//	}
//
////	@Override
////	public String toString() {
////		return "Centre [id=" + id + ", reference=" + reference + ", libelle=" + libelle + ", users=" + users + "]";
////	}

}
