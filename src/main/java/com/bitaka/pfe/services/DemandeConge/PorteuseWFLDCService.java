package com.bitaka.pfe.services.DemandeConge;

import java.util.List;
import java.util.Optional;

import com.bitaka.pfe.model.DemandeConge.PorteuseWFLDC;


public interface PorteuseWFLDCService {
	
	public PorteuseWFLDC addPorteuseWFLDC(PorteuseWFLDC porteuseWFLDC);
	
	public Optional<PorteuseWFLDC> getPorteuseWFLDCById(Long idPorteuseWFLDC);
	
	public Iterable<PorteuseWFLDC> getAllPorteuseWFLDC();
	
	public List<PorteuseWFLDC> deletePorteuseWFLDC(Long id);
	
	public PorteuseWFLDC updatePorteuseWFLDC(Long id, PorteuseWFLDC porteuseWFLDC);
	
	

}
