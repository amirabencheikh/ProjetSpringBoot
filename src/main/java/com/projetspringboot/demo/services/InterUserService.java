package com.projetspringboot.demo.services;

import java.util.List;

import com.projetspringboot.demo.entities.User;

public interface InterUserService {

	public User adduser (User user);
	public List<User> addListUser(List<User> luser);
	public String adduserTestConfpass(User user);
	public User findUserById(Long id);
	public String addUserWTUsername(User user);
	public List<User> getAllUser();
	public String deleteUser(Long iduser);
	public User UpdateUser(Long id, User user);
	public List<User> getUserByStartUsername(String ch);
	
	public User addUserRole(Long iduser, Long idrole);
	
	public List<Long>getIdUsersFromIdRoleStat();
	public List<Long>getIdUsersFromIdRoleDyn(Long idrole);
	public List<User>getusersByIdRole(Long idrole);
	
}
