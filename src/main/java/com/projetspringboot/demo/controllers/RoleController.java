package com.projetspringboot.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetspringboot.demo.entities.Role;
import com.projetspringboot.demo.services.ServiceRoleImpl;


@RestController
public class RoleController {
	
	@Autowired
	ServiceRoleImpl roleserv;
	@PostMapping(value = "/addRole")
	public Role addrole(@RequestBody Role role) {
		
		return roleserv.addrole(role);
		
	}

}
