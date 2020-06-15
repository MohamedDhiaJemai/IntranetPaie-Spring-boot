package com.bitaka.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;

import com.bitaka.pfe.model.Role;

public interface RoleService {

//	@PreAuthorize("hasAuthority('admin')")
	public Role addRole(Role role);

//	@PreAuthorize("hasAuthority('admin')")
	public Optional<Role> getRoleById(Long id);

//	@PreAuthorize("hasAuthority('admin')")
	public Iterable<Role> getAllRole();

//	@PreAuthorize("hasAuthority('admin')")
	public List<Role> deleteRole(Long id);

//	@PreAuthorize("hasAuthority('admin')")
	public Role updateRole(Long id, Role role);

//	@PreAuthorize("hasAuthority('admin')")
	public Role findRoleByDescription(String description);

//	@PreAuthorize("hasAuthority('admin')")
	public Role findRoleByRole(String role);

}
