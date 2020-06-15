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

import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDC;
import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDCRole;
import com.bitaka.pfe.services.DemandeConge.PorteuseWFLDCRoleService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/PorteuseWFLDCRole")
public class PorteuseWFLDCRoleController {
	
	@Autowired
	private PorteuseWFLDCRoleService porteuseWFLDCRoleService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<PorteuseWFLDCRole> save(@RequestBody PorteuseWFLDCRole porteuseWFLDCRole) {
		porteuseWFLDCRole = porteuseWFLDCRoleService.addPorteuseWFLDCRole(porteuseWFLDCRole);
		return new ResponseEntity<PorteuseWFLDCRole>(porteuseWFLDCRole, HttpStatus.OK);
	}
	
	@GetMapping(value = "/idPorteuseWFLDC/{idPorteuseWFLDC}")
	public ResponseEntity<Optional<PorteuseWFLDCRole>> getPorteuseWFLDCRoleById(@PathVariable("idPorteuseWFLDC") Long idPorteuseWFLDCRole) {
		Optional<PorteuseWFLDCRole> optPorteuseWFLDCRole = Optional.empty();
		optPorteuseWFLDCRole = porteuseWFLDCRoleService.getPorteuseWFLDCRoleById(idPorteuseWFLDCRole);
		return new ResponseEntity<Optional<PorteuseWFLDCRole>>(optPorteuseWFLDCRole, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<Iterable<PorteuseWFLDCRole>> getall() {
		Iterable<PorteuseWFLDCRole> iterable = porteuseWFLDCRoleService.getAllPorteuseWFLDCRole();
		return new ResponseEntity<Iterable<PorteuseWFLDCRole>>(iterable, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<List<PorteuseWFLDCRole>> delete(@PathVariable("id") Long id) {
		porteuseWFLDCRoleService.deletePorteuseWFLDCRole(id);
		List<PorteuseWFLDCRole> listPorteuseWFLDCRole = new ArrayList<>();
		listPorteuseWFLDCRole = (List<PorteuseWFLDCRole>) porteuseWFLDCRoleService.getAllPorteuseWFLDCRole();
		return new ResponseEntity<List<PorteuseWFLDCRole>>(listPorteuseWFLDCRole, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<PorteuseWFLDCRole> update(@PathVariable("id") Long id, @RequestBody PorteuseWFLDCRole porteuseWFLDCRole) {
		porteuseWFLDCRole.setIdPorteuseWFLDCRole(id);
		porteuseWFLDCRole = porteuseWFLDCRoleService.addPorteuseWFLDCRole(porteuseWFLDCRole);
		return new ResponseEntity<PorteuseWFLDCRole>(porteuseWFLDCRole, HttpStatus.OK);
	}

	
	

}
