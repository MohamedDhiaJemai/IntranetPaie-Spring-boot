package com.bitaka.pfe.services.DemandeConge;

import java.util.List;
import java.util.Optional;

import com.bitaka.pfe.model.Centre;
import com.bitaka.pfe.model.DemandeConge.WorkFlowDC;

public interface WorkFlowDCService {
	
//	@PreAuthorize("hasAuthority('admin')")
	public WorkFlowDC addWorkFlowDC (WorkFlowDC workFlowDC);

//	@PreAuthorize("hasAuthority('admin')")
	public Optional<WorkFlowDC> getWorkFlowDCById(Long idWorkFlowDC);

//	@PreAuthorize("hasAuthority('admin')")
	public Iterable<WorkFlowDC> getAllWorkFlowDC();

//	@PreAuthorize("hasRole('admin')")
	public List<WorkFlowDC> deleteWorkFlowDC(Long idWorkFlowDC);

//	@PreAuthorize("hasRole('admin')")
	public WorkFlowDC updateWorkFlowDC(Long idWorkFlowDC, WorkFlowDC workFlowDC);

	/*
//	@PreAuthorize("hasAuthority('admin')")
	public WorkFlowDC findWorkFlowDCByCentre(String referenceCentre);
	*/
//	@PreAuthorize("hasAuthority('admin')")
	public WorkFlowDC findWorkFlowDCByCentre(Centre centre);

	

}
