package com.bitaka.pfe.services.DemandeConge;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDCRole;
import com.bitaka.pfe.repositories.DemandeConge.DemandeCongeRepository;
import com.bitaka.pfe.repositories.DemandeConge.PorteuseWFLDCRoleRepository;

@Service
@Transactional
public class PorteuseWFLDCRoleServiceImpl implements PorteuseWFLDCRoleService{
	
	private PorteuseWFLDCRoleRepository porteuseWFLDCRoleRepo;
	
	public PorteuseWFLDCRoleServiceImpl(PorteuseWFLDCRoleRepository porteuseWFLDCRoleRepo) {
		super();
		this.porteuseWFLDCRoleRepo = porteuseWFLDCRoleRepo;
	}

	@Override
	public PorteuseWFLDCRole addPorteuseWFLDCRole(PorteuseWFLDCRole porteuseWFLDCRole) {
		return (porteuseWFLDCRoleRepo.save(porteuseWFLDCRole));
	}

	@Override
	public Optional<PorteuseWFLDCRole> getPorteuseWFLDCRoleById(Long idPorteuseWFLDCRole) {
		return (porteuseWFLDCRoleRepo.findById(idPorteuseWFLDCRole));
	}

	@Override
	public Iterable<PorteuseWFLDCRole> getAllPorteuseWFLDCRole() {
		return (porteuseWFLDCRoleRepo.findAll());
	}

	@Override
	public List<PorteuseWFLDCRole> deletePorteuseWFLDCRole(Long id) {
		porteuseWFLDCRoleRepo.deleteById(id);
		return (porteuseWFLDCRoleRepo.findAll());
	}

	@Override
	public PorteuseWFLDCRole updatePorteuseWFLDCRole(Long id, PorteuseWFLDCRole porteuseWFLDCRole) {
		porteuseWFLDCRole.setIdPorteuseWFLDCRole(id);
		return (porteuseWFLDCRoleRepo.save(porteuseWFLDCRole));
	}
	
	

}
