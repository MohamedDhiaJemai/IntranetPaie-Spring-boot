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

import com.bitaka.pfe.model.Centre;
import com.bitaka.pfe.services.CentreService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/centres")
public class CentreController {

	@Autowired
	private CentreService centreService;

	@PostMapping(value = "/add")
	public ResponseEntity<Centre> save(@RequestBody Centre centre) {
		centre = centreService.addCentre(centre);
		return new ResponseEntity<Centre>(centre, HttpStatus.OK);
	}

	@GetMapping(value = "/idCentre/{id}")
	public ResponseEntity<Optional<Centre>> getCentreById(@PathVariable("id") Long id) {
		Optional<Centre> optCenter = Optional.empty();
		optCenter = centreService.getCentreById(id);
		return new ResponseEntity<Optional<Centre>>(optCenter, HttpStatus.OK);

	}

	@GetMapping(value = "/all")
	public ResponseEntity<Iterable<Centre>> getall() {
		Iterable<Centre> iterable = centreService.getAllCentre();
		return new ResponseEntity<Iterable<Centre>>(iterable, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<List<Centre>> delete(@PathVariable("id") Long id) {
		centreService.deleteCentre(id);
		List<Centre> listCentre = new ArrayList<>();
		listCentre = (List<Centre>) centreService.getAllCentre();
		return new ResponseEntity<List<Centre>>(listCentre, HttpStatus.OK);

	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Centre> update(@PathVariable("id") Long id, @RequestBody Centre centre) {
		centre.setId(id);
		centre = centreService.addCentre(centre);
		return new ResponseEntity<Centre>(centre, HttpStatus.OK);
	}

	/* Find By reference */
	@GetMapping(value = "/reference/{reference}")
	public ResponseEntity<Centre> findByReference(@PathVariable("reference") String reference) {
		Centre centre = new Centre();
		centre = centreService.findCentreByReference(reference);
		return new ResponseEntity<Centre>(centre, HttpStatus.OK);
	}

	/* Find By Libelle */
	@GetMapping(value = "/libelle/{libelle}")
	public ResponseEntity<Centre> findByLibelle(@PathVariable("libelle") String libelle) {
		Centre centre = new Centre();
		centre = centreService.findCentreByLibelle(libelle);
		return new ResponseEntity<Centre>(centre, HttpStatus.OK);
	}

}
