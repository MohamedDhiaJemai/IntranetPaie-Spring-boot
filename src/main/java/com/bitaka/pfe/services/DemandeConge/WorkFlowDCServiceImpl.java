package com.bitaka.pfe.services.DemandeConge;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitaka.pfe.model.Centre;
import com.bitaka.pfe.model.DemandeConge.WorkFlowDC;
import com.bitaka.pfe.repositories.DemandeConge.WorkFlowDCRepository;


@Service
@Transactional
public class WorkFlowDCServiceImpl implements WorkFlowDCService {
	
	private WorkFlowDCRepository workFlowDCRepo;
	
	public WorkFlowDCServiceImpl(WorkFlowDCRepository workFlowDCRepo) {
		super();
		this.workFlowDCRepo = workFlowDCRepo;
	}

	@Override
	public WorkFlowDC addWorkFlowDC(WorkFlowDC workFlowDC) {
		return (workFlowDCRepo.save(workFlowDC));
	}

	@Override
	public Optional<WorkFlowDC> getWorkFlowDCById(Long idWorkFlowDC) {
		return (workFlowDCRepo.findById(idWorkFlowDC));
	}

	@Override
	public Iterable<WorkFlowDC> getAllWorkFlowDC() {
		return (workFlowDCRepo.findAll());
	}

	@Override
	public List<WorkFlowDC> deleteWorkFlowDC(Long idWorkFlowDC) {
		workFlowDCRepo.deleteById(idWorkFlowDC);
		return (workFlowDCRepo.findAll());
	}

	@Override
	public WorkFlowDC updateWorkFlowDC(Long idWorkFlowDC, WorkFlowDC workFlowDC) {
		workFlowDC.setIdWorkFlowDC(idWorkFlowDC);
		return (workFlowDCRepo.save(workFlowDC));
	}

/*	@Override
	public WorkFlowDC findWorkFlowDCByCentre(String referenceCentre) {
		return (workFlowDCRepo.findWorkFlowDCByCentreReference(referenceCentre));
	}
*/
	@Override
	public WorkFlowDC findWorkFlowDCByCentre(Centre centre) {
		return (workFlowDCRepo.findWorkFlowDCByCentre(centre));
	}
	
	

}
