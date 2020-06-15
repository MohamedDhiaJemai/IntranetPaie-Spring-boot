package com.bitaka.pfe.model.DemandeConge;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bitaka.pfe.model.Role;
import com.bitaka.pfe.model.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PorteuseWFLDCRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPorteuseWFLDCRole;
	
	private int priorite;

	@ManyToOne
	private WorkFlowDC workFlowDC;
	
    @ManyToOne
    private Role role;
	

}
