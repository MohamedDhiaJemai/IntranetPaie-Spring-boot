package com.bitaka.pfe.services.DemandeConge;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitaka.pfe.model.DemandeConge.DemandeConge;
import com.bitaka.pfe.repositories.DemandeConge.DemandeCongeRepository;


@Service
@Transactional
public class DemandeCongeServiceImpl implements DemandeCongeService {
	
	private DemandeCongeRepository demandeCongeCRepo;
	
	public DemandeCongeServiceImpl(DemandeCongeRepository demandeCongeCRepo) {
		super();
		this.demandeCongeCRepo = demandeCongeCRepo;
	}

	
	@Override
	public DemandeConge addDemandeConge(DemandeConge demandeConge) {
		return (demandeCongeCRepo.save(demandeConge));
	}

	@Override
	public Optional<DemandeConge> getDemandeCongeById(Long idWorkFlowDC) {
		return (demandeCongeCRepo.findById(idWorkFlowDC));
	}

	@Override
	public Iterable<DemandeConge> getAllDemandeConge() {
		return (demandeCongeCRepo.findAll());
	}

	@Override
	public List<DemandeConge> deleteDemandeConge(Long id) {
		demandeCongeCRepo.deleteById(id);
		return (demandeCongeCRepo.findAll());
	}

	@Override
	public DemandeConge updateDemandeConge(Long id, DemandeConge demandeConge) {
		demandeConge.setIdDemandeConge(id);
		return (demandeCongeCRepo.save(demandeConge));
	}


	@Override
	public DemandeConge findDemandeCongeByMatriculeUtilisateur(Long matricule) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DemandeConge findDemandeCongeByIdUtilisateur(Long idUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DemandeConge findDemandeCongeBycentre(String reference) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
