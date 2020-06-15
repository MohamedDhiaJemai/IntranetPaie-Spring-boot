package com.bitaka.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;

import com.bitaka.pfe.model.Centre;
import com.bitaka.pfe.model.Role;
import com.bitaka.pfe.model.Utilisateur;

public interface UtilisateurService {

//	@PreAuthorize("hasAuthority('admin')")
	public Iterable<Utilisateur> getAllUser();

//	@PreAuthorize("hasAuthority('admin')")
	public Optional<Utilisateur> getUserById(Long id);

//	@PreAuthorize("hasAuthority('admin')")
	public Utilisateur addUser(Utilisateur user);

//	@PreAuthorize("hasAuthority('admin')")
	public List<Utilisateur> deleteUser(Long id);

//	@PreAuthorize("hasAuthority('admin')")
	public Utilisateur updateUser(Long id, Utilisateur user);

//	@PreAuthorize("hasAuthority('admin')")
	public List<Utilisateur> findUserByMatricule(String matricule);

//	@PreAuthorize("hasAuthority('admin')")
	public List<Utilisateur> findUserByNom(String nom);

//	@PreAuthorize("hasAuthority('admin')")
	public Utilisateur findUserByLogin(String login);

//	@PreAuthorize("hasAuthority('admin')")
	public List<Utilisateur> findUserByPrenom(String prenom);

//	@PreAuthorize("hasAuthority('admin')")
	public List<Utilisateur> findUserByCentre(Centre centre);

//	@PreAuthorize("hasAuthority('admin')")
	public List<Utilisateur> findUserByRole(Role role);
	
	public Utilisateur findUserByUsername (String username);
	
//	public Utilisateur findByEmail (String email);

}
