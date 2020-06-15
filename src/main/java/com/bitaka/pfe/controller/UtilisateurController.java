package com.bitaka.pfe.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitaka.pfe.model.Centre;
import com.bitaka.pfe.model.Role;
import com.bitaka.pfe.model.Utilisateur;
import com.bitaka.pfe.services.UtilisateurService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
//@GetMapping("/utilisateurs")
@RequestMapping(value = "/utilisateurs")
public class UtilisateurController {

	@Autowired
	private UtilisateurService userService;

	@GetMapping(value = "/all")
	public ResponseEntity<Iterable<Utilisateur>> getall() {
		Iterable<Utilisateur> iterable = userService.getAllUser();
		return new ResponseEntity<Iterable<Utilisateur>>(iterable, HttpStatus.OK);
	}

	@GetMapping(value = "/idUtilisateur/{id}")
	public ResponseEntity<Optional<Utilisateur>> getCentreById(@PathVariable("id") Long id) {
		Optional<Utilisateur> optUser = Optional.empty();
		optUser = userService.getUserById(id);
		return new ResponseEntity<Optional<Utilisateur>>(optUser, HttpStatus.OK);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Utilisateur> save(@RequestBody Utilisateur user) {
//		user.setRole(role);
//		user.setCentre(centre);
		user = userService.addUser(user);
		return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<List<Utilisateur>> delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		List<Utilisateur> listUser = new ArrayList<Utilisateur>();
		listUser = (List<Utilisateur>) userService.getAllUser();
		return new ResponseEntity<List<Utilisateur>>(listUser, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Utilisateur> update(@PathVariable("id") Long id, @RequestBody Utilisateur user) {
		user.setId(id);
		user = userService.addUser(user);
		return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
	}

	@GetMapping(value = "/matricule/{matricule}")
	public ResponseEntity<List<Utilisateur>> findByMatricule(@PathVariable("matricule") String matricule) {
		List<Utilisateur> listUser = new ArrayList<Utilisateur>();
		listUser = userService.findUserByMatricule(matricule);
		return new ResponseEntity<List<Utilisateur>>(listUser, HttpStatus.OK);
	}

	/* Find By Nom */
	@GetMapping(value = "/nom/{nom}")
	public ResponseEntity<List<Utilisateur>> findByNom(@PathVariable("nom") String nom) {
		List<Utilisateur> user = new ArrayList<Utilisateur>();
		user = userService.findUserByNom(nom);
		return new ResponseEntity<List<Utilisateur>>(user, HttpStatus.OK);
	}

	/* Find By Login */
	@GetMapping(value = "/login/{login}")
	public ResponseEntity<Utilisateur> findByLogin(@PathVariable("login") String login) {
		Utilisateur user = new Utilisateur();
		user = userService.findUserByLogin(login);
		return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
	}

	/* Find By Prenom */
	@GetMapping(value = "/prenom/{prenom}")
	public ResponseEntity<List<Utilisateur>> findByPrenom(@PathVariable("prenom") String prenom) {
		List<Utilisateur> userList = new ArrayList<Utilisateur>();
		userList = userService.findUserByPrenom(prenom);
		return new ResponseEntity<List<Utilisateur>>(userList, HttpStatus.OK);
	}

	@GetMapping(value = "/userCentre/{idCentre}")
	public ResponseEntity<List<Utilisateur>> findByCentre(@PathVariable("centre") Centre centre) {
		List<Utilisateur> userList = new ArrayList<Utilisateur>();
		userList = userService.findUserByCentre(centre);
		return new ResponseEntity<List<Utilisateur>>(userList, HttpStatus.OK);
	}

	@GetMapping(value = "/userRole/{idRole}")
	public ResponseEntity<List<Utilisateur>> findByRole(@PathVariable("role") Role role) {
		List<Utilisateur> userList = new ArrayList<Utilisateur>();
		userList = userService.findUserByRole(role);
		return new ResponseEntity<List<Utilisateur>>(userList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/usernameTest/{username}")
	public ResponseEntity<Utilisateur> findUserByUsername(@PathVariable("username") String username) {
		Utilisateur user = new Utilisateur();
		user = userService.findUserByUsername(username);
		return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
	}
	
	
//	
//	@GetMapping(value = "/email/{email}")
//	public ResponseEntity<Utilisateur> findByEmail(@PathVariable("email") String email) {
//		Utilisateur user = new Utilisateur();
//		user = userService.findByEmail(email);
//		return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
//	}

}
