package com.bitaka.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitaka.pfe.model.Centre;
import com.bitaka.pfe.model.Role;
import com.bitaka.pfe.model.Utilisateur;
import com.bitaka.pfe.repositories.UtilisateurRepository;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurRepository userRepo;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UtilisateurServiceImpl(UtilisateurRepository userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepo = userRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public Iterable<Utilisateur> getAllUser() {
		return (userRepo.findAll());
	}

	@Override
	public Optional<Utilisateur> getUserById(Long id) {
		return (userRepo.findById(id));
	}

	@Override
	public Utilisateur addUser(Utilisateur user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return (userRepo.save(user));
	}

	@Override
	public List<Utilisateur> deleteUser(Long id) {
		userRepo.deleteById(id);
		return (userRepo.findAll());
	}

	@Override
	public Utilisateur updateUser(Long id, Utilisateur user) {
		user.setId(id);
		return (userRepo.save(user));
	}

	@Override
	public List<Utilisateur> findUserByMatricule(String matricule) {
		return (userRepo.findByMatricule(matricule));
	}

	@Override
	public List<Utilisateur> findUserByNom(String nom) {
		return (userRepo.findByNom(nom));
	}

	@Override
	public Utilisateur findUserByLogin(String login) {
		return (userRepo.findByUsername(login));
	}

	@Override
	public List<Utilisateur> findUserByPrenom(String prenom) {
		return (userRepo.findByPrenom(prenom));
	}

	@Override
	public List<Utilisateur> findUserByCentre(Centre centre) {
		return (userRepo.findByCentre(centre));
	}

	@Override
	public List<Utilisateur> findUserByRole(Role role) {
		return (userRepo.findByRole(role));
	}

	@Override
	public Utilisateur findUserByUsername(String username) {
		return (userRepo.findUserByUsername(username));
	}

//	@Override
//	public Utilisateur findByUsername(String username) {
//		return (userRepo.findByUsername(username));
//	}


}
