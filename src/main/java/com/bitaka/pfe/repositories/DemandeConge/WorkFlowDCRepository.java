package com.bitaka.pfe.repositories.DemandeConge;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitaka.pfe.model.Centre;
import com.bitaka.pfe.model.Utilisateur;
import com.bitaka.pfe.model.DemandeConge.WorkFlowDC;

public interface WorkFlowDCRepository extends JpaRepository<WorkFlowDC, Long> {
	
	
	/*public WorkFlowDC findWorkFlowDCByCentreReference (String referenceCentre);*/
	
	public WorkFlowDC findWorkFlowDCByCentre(Centre Centre);
	
	

}
