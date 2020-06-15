package com.bitaka.pfe.repositories.DemandeConge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitaka.pfe.model.Utilisateur;
import com.bitaka.pfe.model.DemandeConge.DemandeConge;

public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Long> {
	
	 public List<DemandeConge> findDemandeCongeByUtilisateur(Utilisateur utilisateur);

}
