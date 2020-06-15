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

import com.bitaka.pfe.model.DemandeConge.WorkFlowDC;
import com.bitaka.pfe.services.DemandeConge.WorkFlowDCService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/workFlowDC")
public class WorkFlowDCController {

	@Autowired
	private WorkFlowDCService workFlowDCService;

	@PostMapping(value = "/add")
	public ResponseEntity<WorkFlowDC> save(@RequestBody WorkFlowDC workFlowDC) {
		workFlowDC = workFlowDCService.addWorkFlowDC(workFlowDC);
		return new ResponseEntity<WorkFlowDC>(workFlowDC, HttpStatus.OK);
	}

	@GetMapping(value = "/idworkFlowDC/{idWorkFlowDC}")
	public ResponseEntity<Optional<WorkFlowDC>> getCentreById(@PathVariable("idWorkFlowDC") Long idWorkFlowDC) {
		Optional<WorkFlowDC> optWorkFlowDC = Optional.empty();
		optWorkFlowDC = workFlowDCService.getWorkFlowDCById(idWorkFlowDC);
		return new ResponseEntity<Optional<WorkFlowDC>>(optWorkFlowDC, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<Iterable<WorkFlowDC>> getall() {
		Iterable<WorkFlowDC> iterable = workFlowDCService.getAllWorkFlowDC();
		return new ResponseEntity<Iterable<WorkFlowDC>>(iterable, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<List<WorkFlowDC>> delete(@PathVariable("id") Long id) {
		workFlowDCService.deleteWorkFlowDC(id);
		List<WorkFlowDC> listworkFlowDC = new ArrayList<>();
		listworkFlowDC = (List<WorkFlowDC>) workFlowDCService.getAllWorkFlowDC();
		return new ResponseEntity<List<WorkFlowDC>>(listworkFlowDC, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<WorkFlowDC> update(@PathVariable("id") Long id, @RequestBody WorkFlowDC workFlowDC) {
		workFlowDC.setIdWorkFlowDC(id);
		workFlowDC = workFlowDCService.addWorkFlowDC(workFlowDC);
		return new ResponseEntity<WorkFlowDC>(workFlowDC, HttpStatus.OK);
	}

	/*
	 * @GetMapping(value = "/reference/{referenceCentre}") public
	 * ResponseEntity<WorkFlowDC> findByReference(@PathVariable("reference") String
	 * referenceCentre) { WorkFlowDC workFlowDC = new WorkFlowDC(); workFlowDC =
	 * workFlowDCService.findWorkFlowDCByCentre(referenceCentre); return new
	 * ResponseEntity<WorkFlowDC>(workFlowDC, HttpStatus.OK); }
	 */

	/*
	 * @GetMapping(value = "/reference/{idCentre}") public
	 * ResponseEntity<WorkFlowDC> findByReference(@PathVariable("idCentre") Long
	 * idCentre) { WorkFlowDC workFlowDC = new WorkFlowDC(); workFlowDC =
	 * workFlowDCService.findWorkFlowDCByIdCentre(idCentre); return new
	 * ResponseEntity<WorkFlowDC>(workFlowDC, HttpStatus.OK); }
	 */

}
