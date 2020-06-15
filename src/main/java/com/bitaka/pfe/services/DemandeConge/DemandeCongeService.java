package com.bitaka.pfe.services.DemandeConge;

import java.util.List;
import java.util.Optional;

import com.bitaka.pfe.model.DemandeConge.DemandeConge;

public interface DemandeCongeService {
	
	public DemandeConge addDemandeConge(DemandeConge demandeConge);
	
	public Optional<DemandeConge> getDemandeCongeById(Long idDemandeConge);
	
	public Iterable<DemandeConge> getAllDemandeConge();
	
	public List<DemandeConge> deleteDemandeConge(Long id);
	
	public DemandeConge updateDemandeConge(Long id, DemandeConge demandeConge);
	
	public DemandeConge findDemandeCongeByMatriculeUtilisateur(Long matricule);
	
	public DemandeConge findDemandeCongeByIdUtilisateur(Long idUtilisateur);
	
	public DemandeConge findDemandeCongeBycentre(String reference);

}
