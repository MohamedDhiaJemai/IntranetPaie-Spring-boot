package com.bitaka.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;

import com.bitaka.pfe.model.Centre;

public interface CentreService {

//	@PreAuthorize("hasAuthority('admin')")
	public Centre addCentre(Centre centre);

//	@PreAuthorize("hasAuthority('admin')")
	public Optional<Centre> getCentreById(Long id);

//	@PreAuthorize("hasAuthority('admin')")
	public Iterable<Centre> getAllCentre();

//	@PreAuthorize("hasRole('admin')")
	public List<Centre> deleteCentre(Long id);

//	@PreAuthorize("hasRole('admin')")
	public Centre updateCentre(Long id, Centre centre);

//	@PreAuthorize("hasAuthority('admin')")
	public Centre findCentreByReference(String reference);

//	@PreAuthorize("hasAuthority('admin')")
	public Centre findCentreByLibelle(String libelle);

}
