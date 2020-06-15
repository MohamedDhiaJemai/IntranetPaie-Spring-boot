package com.bitaka.pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitaka.pfe.model.Centre;

public interface CentreRepository extends JpaRepository<Centre, Long> {

	public Centre findByReference(String reference);

	public Centre findByLibelle(String libelle);

}
