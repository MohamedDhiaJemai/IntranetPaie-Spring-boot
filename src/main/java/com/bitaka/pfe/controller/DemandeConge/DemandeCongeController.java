package com.bitaka.pfe.controller.DemandeConge;

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

import com.bitaka.pfe.model.DemandeConge.DemandeConge;
import com.bitaka.pfe.services.DemandeConge.DemandeCongeService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/DemandeConge")
public class DemandeCongeController {
	
	@Autowired
	private DemandeCongeService demandeCongeService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<DemandeConge> save(@RequestBody DemandeConge demandeConge) {
		demandeConge = demandeCongeService.addDemandeConge(demandeConge);
		return new ResponseEntity<DemandeConge>(demandeConge, HttpStatus.OK);
	}
	
	@GetMapping(value = "/idDemandeConge/{id}")
	public ResponseEntity<Optional<DemandeConge>> getDemandeCongeById(@PathVariable("id") Long id) {
		Optional<DemandeConge> optDemandeConge = Optional.empty();
		optDemandeConge = demandeCongeService.getDemandeCongeById(id);
		return new ResponseEntity<Optional<DemandeConge>>(optDemandeConge, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<Iterable<DemandeConge>> getall() {
		Iterable<DemandeConge> iterable = demandeCongeService.getAllDemandeConge();
		return new ResponseEntity<Iterable<DemandeConge>>(iterable, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<List<DemandeConge>> delete(@PathVariable("id") Long id) {
		demandeCongeService.deleteDemandeConge(id);
		List<DemandeConge> listDemandeConge = new ArrayList<>();
		listDemandeConge = (List<DemandeConge>) demandeCongeService.getAllDemandeConge();
		return new ResponseEntity<List<DemandeConge>>(listDemandeConge, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<DemandeConge> update(@PathVariable("id") Long id, @RequestBody DemandeConge demandeConge) {
		demandeConge.setIdDemandeConge(id);
		demandeConge = demandeCongeService.addDemandeConge(demandeConge);
		return new ResponseEntity<DemandeConge>(demandeConge, HttpStatus.OK);
	}
	
	
	
	
	

}
