package com.bitaka.pfe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitaka.pfe.model.Role;
import com.bitaka.pfe.services.RoleService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	/* Add User */
	@PostMapping(value = "/add")
	public ResponseEntity<Role> save(@RequestBody Role role) {
		role = roleService.addRole(role);
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}

	@GetMapping(value = "/idRole/{id}")
	public ResponseEntity<Optional<Role>> getCentreById(@PathVariable("id") Long id) {
		Optional<Role> optRole = Optional.empty();
		optRole = roleService.getRoleById(id);
		return new ResponseEntity<Optional<Role>>(optRole, HttpStatus.OK);
	}

	/* Get All */
	@GetMapping(value = "/all")
	public ResponseEntity<Iterable<Role>> getall() {
		Iterable<Role> iterable = roleService.getAllRole();
		return new ResponseEntity<Iterable<Role>>(iterable, HttpStatus.OK);
	}

	/* Delete User By Id */
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<List<Role>> delete(@PathVariable("id") Long id) {
		roleService.deleteRole(id);
		List<Role> listRole = new ArrayList<>();
		listRole = (List<Role>) roleService.getAllRole();
		return new ResponseEntity<List<Role>>(listRole, HttpStatus.OK);
	}

	/* Update Role */
	@PutMapping("/update/{id}")
	public ResponseEntity<Role> update(@PathVariable("id") Long id, @RequestBody Role role) {
		role.setId(id);
		role = roleService.addRole(role);
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}

	/* Find By Description */
	@GetMapping(value = "/descripton/{description}")
	public ResponseEntity<Role> findByDescription(@PathVariable("description") String description) {
		Role role = new Role();
		role = roleService.findRoleByDescription(description);
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}

	/* Find By Role */
	@GetMapping(value = "/role/{role}")
	public ResponseEntity<Role> findByRole(@PathVariable("role") String role) {
		Role roleObj = new Role();
		roleObj = roleService.findRoleByRole(role);
		return new ResponseEntity<Role>(roleObj, HttpStatus.OK);
	}
}
