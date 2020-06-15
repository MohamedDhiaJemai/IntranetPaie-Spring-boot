package com.bitaka.pfe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitaka.pfe.model.Centre;
import com.bitaka.pfe.model.Role;
import com.bitaka.pfe.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	public List<Utilisateur> findByNom(String nom);

	public List<Utilisateur> findByPrenom(String prenom);

	public Utilisateur findByUsername(String username);
	
	public Utilisateur findUserByUsername (String username);

	public List<Utilisateur> findByMatricule(String matricule);

	public List<Utilisateur> findByCentre(Centre centre);

	public List<Utilisateur> findByRole(Role id);

}