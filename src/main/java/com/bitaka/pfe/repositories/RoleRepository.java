package com.bitaka.pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitaka.pfe.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRole(String role);

	public Role findByDescription(String description);

}
