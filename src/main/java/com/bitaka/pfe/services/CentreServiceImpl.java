package com.bitaka.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitaka.pfe.model.Centre;
import com.bitaka.pfe.repositories.CentreRepository;

@Service
@Transactional
public class CentreServiceImpl implements CentreService {

	private CentreRepository centreRepo;

	public CentreServiceImpl(CentreRepository centreRepo) {
		super();
		this.centreRepo = centreRepo;
	}

	@Override
	public Centre addCentre(Centre centre) {
		return (centreRepo.save(centre));
	}

	@Override
	public Optional<Centre> getCentreById(Long id) {
		return (centreRepo.findById(id));
	}

	@Override
	public Iterable<Centre> getAllCentre() {
		return (centreRepo.findAll());
	}

	@Override
	public List<Centre> deleteCentre(Long id) {
		centreRepo.deleteById(id);
		return (centreRepo.findAll());
	}

	@Override
	public Centre updateCentre(Long id, Centre centre) {
		centre.setId(id);
		return (centreRepo.save(centre));
	}

	@Override
	public Centre findCentreByReference(String reference) {
		return (centreRepo.findByReference(reference));
	}

	@Override
	public Centre findCentreByLibelle(String libelle) {
		return (centreRepo.findByLibelle(libelle));
	}

}
