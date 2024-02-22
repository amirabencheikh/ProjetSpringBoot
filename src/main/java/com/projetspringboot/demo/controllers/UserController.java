package com.projetspringboot.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetspringboot.demo.entities.User;
import com.projetspringboot.demo.services.ServiceUserImpl;

@RestController
public class UserController {

	@Autowired
	ServiceUserImpl userserv;
	
	@PostMapping(value = "/adduser")
	
	public User addUser(@RequestBody User user) {
		
		return userserv.adduser(user);
	}
	@PostMapping(value = "/addlistuser")
public List<User> addUser(@RequestBody List<User> luser) {
		
		return userserv.addListUser(luser);
	}
	
	@PostMapping(value = "/adduserTCP")
	public String addUserTCP(@RequestBody User user) {
			
			return userserv.adduserTestConfpass(user);
		}
	
	@GetMapping(value = "/getUserById/{id}")
	public User getUserById(@PathVariable Long id) {
			
			return userserv.findUserById(id);
		}
	@PostMapping(value = "/adduserTUsername")
	public String adduserTUsername(@RequestBody User user) {
			
			return userserv.addUserWTUsername(user);
		}
	@GetMapping(value = "/getAllUser")
	public List<User> getAllUser() {
			
			return userserv.getAllUser();
		}
	@DeleteMapping(value = "/deleteUserById/{iduser}")
	public String deleteUserById(@PathVariable Long iduser) {
			
			return userserv.deleteUser(iduser);
		}
	@PutMapping(value = "/updateUser/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
			
			return userserv.UpdateUser(id, user);
		}
	@GetMapping(value = "/getUserByStartUsername/{ch}")
	public List<User> getUserByStartUsername(@PathVariable String ch) {
			
			return userserv.getUserByStartUsername(ch);
		}
	@PostMapping(value = "/addUserRole/{iduser}/{idrole}")
	public User addUserRole(@PathVariable Long iduser, @PathVariable Long idrole) {
			
			return userserv.addUserRole(iduser,idrole);
		}
	@GetMapping(value = "/getIdUsersFromIdRoleStat")
	public List<Long> getIdUsersFromIdRoleStat() {
			
			return userserv.getIdUsersFromIdRoleStat();
		}
	@GetMapping(value = "/getIdUsersFromIdRoleDyn/{idrole}")
	public List<Long> getIdUsersFromIdRoleDyn(@PathVariable Long idrole) {
			
			return userserv.getIdUsersFromIdRoleDyn(idrole);
		}
	@GetMapping(value = "/getusersByIdRole/{idrole}")
	public List<User> getUsersByIdRole(@PathVariable Long idrole) {
			
			return userserv.getusersByIdRole(idrole);
		}
}
