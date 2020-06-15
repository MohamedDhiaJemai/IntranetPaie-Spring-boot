package com.bitaka.pfe.services.DemandeConge;

import java.util.List;
import java.util.Optional;

import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDCRole;

public interface PorteuseWFLDCRoleService {
	
	public PorteuseWFLDCRole addPorteuseWFLDCRole(PorteuseWFLDCRole porteuseWFLDCRole);
	
	public Optional<PorteuseWFLDCRole> getPorteuseWFLDCRoleById(Long idPorteuseWFLDCRole);
	
	public Iterable<PorteuseWFLDCRole> getAllPorteuseWFLDCRole();
	
	public List<PorteuseWFLDCRole> deletePorteuseWFLDCRole(Long id);
	
	public PorteuseWFLDCRole updatePorteuseWFLDCRole(Long id, PorteuseWFLDCRole porteuseWFLDCRole);
	

}
