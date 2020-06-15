package com.bitaka.pfe.services.DemandeConge;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDC;
import com.bitaka.pfe.repositories.DemandeConge.PorteuseWFLDCRepository;

@Service
@Transactional
public class PorteuseWFLDCServiceImpl implements PorteuseWFLDCService {
	
	private PorteuseWFLDCRepository porteuseWFLDCRepo;
	
	public PorteuseWFLDCServiceImpl(PorteuseWFLDCRepository porteuseWFLDCRepo) {
		super();
		this.porteuseWFLDCRepo = porteuseWFLDCRepo;
	}

	@Override
	public PorteuseWFLDC addPorteuseWFLDC(PorteuseWFLDC porteuseWFLDC) {
		return (porteuseWFLDCRepo.save(porteuseWFLDC));
	}

	@Override
	public Optional<PorteuseWFLDC> getPorteuseWFLDCById(Long idPorteuseWFLDC) {
		return (porteuseWFLDCRepo.findById(idPorteuseWFLDC));
	}

	@Override
	public Iterable<PorteuseWFLDC> getAllPorteuseWFLDC() {
		return (porteuseWFLDCRepo.findAll());
	}

	@Override
	public List<PorteuseWFLDC> deletePorteuseWFLDC(Long id) {
		porteuseWFLDCRepo.deleteById(id);
		return (porteuseWFLDCRepo.findAll());
	}

	@Override
	public PorteuseWFLDC updatePorteuseWFLDC(Long id, PorteuseWFLDC porteuseWFLDC) {
		porteuseWFLDC.setIdPorteuseWFLDC(id);
		return (porteuseWFLDCRepo.save(porteuseWFLDC));
	}

}
