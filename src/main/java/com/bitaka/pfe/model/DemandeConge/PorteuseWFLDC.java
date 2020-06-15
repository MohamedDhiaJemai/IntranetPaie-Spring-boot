package com.bitaka.pfe.model.DemandeConge;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bitaka.pfe.model.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PorteuseWFLDC {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPorteuseWFLDC;

	@Column(length = 50)
	private String dateCreation;

	@Column(length = 50)
	private String dateModificationAvis;

	@Column(length = 50)
	private String commentaire;

	private int priorite;

	private Boolean autrisee;

	private Boolean visa;

	@ManyToOne
	private DemandeConge demandeConge;

	@ManyToOne
	private WorkFlowDC workFlowDC;
	
	@ManyToOne
    private Utilisateur utilisateur;

}
