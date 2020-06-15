package com.bitaka.pfe.repositories.DemandeConge;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitaka.pfe.model.Utilisateur;
import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDC;
import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDCRole;

public interface PorteuseWFLDCRepository extends JpaRepository<PorteuseWFLDC, Long> {

}
