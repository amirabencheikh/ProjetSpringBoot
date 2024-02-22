package com.projetspringboot.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetspringboot.demo.entities.Role;
import com.projetspringboot.demo.repository.RoleRepository;
@Service
public class ServiceRoleImpl implements InterRoleService{
	@Autowired
	
	RoleRepository roleRep;

	@Override
	public Role addrole(Role role) {
		// TODO Auto-generated method stub
		return roleRep.save(role);
	}

}
