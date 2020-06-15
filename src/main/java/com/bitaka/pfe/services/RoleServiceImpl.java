package com.bitaka.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitaka.pfe.model.Role;
import com.bitaka.pfe.repositories.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepo;

	public RoleServiceImpl(RoleRepository roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}

	@Override
	public Role addRole(Role role) {
		return (roleRepo.save(role));
	}

	@Override
	public Optional<Role> getRoleById(Long id) {
		return (roleRepo.findById(id));
	}

	@Override
	public Iterable<Role> getAllRole() {
		return (roleRepo.findAll());
	}

	@Override
	public List<Role> deleteRole(Long id) {
		roleRepo.deleteById(id);
		return (roleRepo.findAll());
	}

	@Override
	public Role updateRole(Long id, Role role) {
		role.setId(id);
		return (roleRepo.save(role));
	}

	@Override
	public Role findRoleByDescription(String description) {
		return (roleRepo.findByDescription(description));
	}

	@Override
	public Role findRoleByRole(String role) {
		return (roleRepo.findByRole(role));
	}

}
