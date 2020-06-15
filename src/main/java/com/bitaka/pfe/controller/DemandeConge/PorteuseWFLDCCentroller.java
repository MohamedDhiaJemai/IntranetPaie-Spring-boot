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
import com.bitaka.pfe.services.DemandeConge.PorteuseWFLDCService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/PorteuseWFDC")
public class PorteuseWFLDCCentroller {
	
	@Autowired
	private PorteuseWFLDCService porteuseWFLDCService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<PorteuseWFLDC> save(@RequestBody PorteuseWFLDC porteuseWFLDC) {
		porteuseWFLDC = porteuseWFLDCService.addPorteuseWFLDC(porteuseWFLDC);
		return new ResponseEntity<PorteuseWFLDC>(porteuseWFLDC, HttpStatus.OK);
	}

	@GetMapping(value = "/idPorteuseWFLDC/{idPorteuseWFLDC}")
	public ResponseEntity<Optional<PorteuseWFLDC>> getCentreById(@PathVariable("idPorteuseWFLDC") Long idPorteuseWFLDC) {
		Optional<PorteuseWFLDC> optPorteuseWFLDC = Optional.empty();
		optPorteuseWFLDC = porteuseWFLDCService.getPorteuseWFLDCById(idPorteuseWFLDC);
		return new ResponseEntity<Optional<PorteuseWFLDC>>(optPorteuseWFLDC, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<Iterable<PorteuseWFLDC>> getall() {
		Iterable<PorteuseWFLDC> iterable = porteuseWFLDCService.getAllPorteuseWFLDC();
		return new ResponseEntity<Iterable<PorteuseWFLDC>>(iterable, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<List<PorteuseWFLDC>> delete(@PathVariable("id") Long id) {
		porteuseWFLDCService.deletePorteuseWFLDC(id);
		List<PorteuseWFLDC> listPorteuseWFLDC = new ArrayList<>();
		listPorteuseWFLDC = (List<PorteuseWFLDC>) porteuseWFLDCService.getAllPorteuseWFLDC();
		return new ResponseEntity<List<PorteuseWFLDC>>(listPorteuseWFLDC, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<PorteuseWFLDC> update(@PathVariable("id") Long id, @RequestBody PorteuseWFLDC porteuseWFLDC) {
		porteuseWFLDC.setIdPorteuseWFLDC(id);
		porteuseWFLDC = porteuseWFLDCService.addPorteuseWFLDC(porteuseWFLDC);
		return new ResponseEntity<PorteuseWFLDC>(porteuseWFLDC, HttpStatus.OK);
	}

	
}
