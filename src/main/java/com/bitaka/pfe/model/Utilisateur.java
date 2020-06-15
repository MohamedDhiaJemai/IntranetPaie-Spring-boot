package com.bitaka.pfe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.persistence.InheritanceType;

import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDCRole;
import com.bitaka.pfe.model.DemandeConge.DemandeConge;
import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDC;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(unique = true)
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	@NotNull
	private String telephone;
	@NotNull
	@Column(unique = true)
	private String email;
	@NotNull
	private String idccms;
	@NotNull
	private String matricule;
	
    @Transient
    private String classification;
	
	@JoinColumn(name = "Code_Role")
	@JsonProperty("role")
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	@JoinColumn(name = "Code_Centre")
	@JsonProperty("centre")
	@ManyToOne(fetch = FetchType.EAGER)
	private Centre centre;
    

    @OneToMany(mappedBy = "utilisateur",cascade= {CascadeType.MERGE, CascadeType.PERSIST})
    List<DemandeConge> demandeConges;
    
    @OneToMany(mappedBy = "utilisateur",cascade= {CascadeType.MERGE, CascadeType.PERSIST})
    List<PorteuseWFLDC> porteuseWFLDCs;
    
    

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//@JsonIgnore
	@JsonGetter
	public String getPassword() {
		return password;
	}
	
	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@JsonGetter
	public String getIdCCMS() {
		return idccms;
	}
	
	@JsonSetter
	public void setIdCCMS(String idccms) {
		this.idccms = idccms;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Utilisateur(Long id, String username, String password, String nom, String prenom, String telephone,
			String email, String idCCMS, String matricule, Role role, Centre centre) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.idccms = idCCMS;
		this.matricule = matricule;
		this.role = role;
		this.centre = centre;
	}

	public Utilisateur() {
		super();
	}

//	@Override
//	public String toString() {
//		return "Utilisateur [id=" + id + ", username=" + username + ", password=" + password + ", nom=" + nom + ", prenom="
//				+ prenom + ", telephone=" + telephone + ", email=" + email + ", idCCMS=" + idCCMS + ", matricule="
//				+ matricule + ", role=" + role + ", centre=" + centre + "]";
//	}
	
	
	
	

}
