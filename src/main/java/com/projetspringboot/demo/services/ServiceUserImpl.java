package com.projetspringboot.demo.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetspringboot.demo.entities.Role;
import com.projetspringboot.demo.entities.User;
import com.projetspringboot.demo.repository.RoleRepository;
import com.projetspringboot.demo.repository.UserRepository;

@Service
public class ServiceUserImpl implements InterUserService{
	
@Autowired

UserRepository userRep;
@Autowired

RoleRepository roleRep;

	@Override
	public User adduser(User user) {
		// TODO Auto-generated method stub
		return userRep.save(user);
	}
	@Override
	public List<User> addListUser(List<User> luser) {
		// TODO Auto-generated method stub
		return userRep.saveAll(luser);
	}
	@Override
	public String adduserTestConfpass(User user) {
		// TODO Auto-generated method stub
		
		String ch="";
		if (user.getPassword().equals(user.getConfpass()))
		{
			ch="user add successfully ";
			userRep.save(user);
					
		}
		else {
			ch="conf password is wrong ";
		}
		return ch;
	}
	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		
		return userRep.findById(id).get();
	}
	@Override
	public String addUserWTUsername(User user) {
		// TODO Auto-generated method stub
		String ch = "";
		if(userRep.existsByUsername(user.getUsername())) {
			ch ="username alredy exists ";
		}
		else {
			userRep.save(user);
			ch="user added successfully";
		}
		return ch;
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRep.findAll();
	}
	@Override
	public String deleteUser(Long iduser) {
		// TODO Auto-generated method stub
		String ch="";
		if(userRep.findById(iduser).isPresent())
		{
			userRep.deleteById(iduser);
			ch="user deleted !!";
		}
		else {
			ch="user doesn't exist!!";
		}
		return ch;
	}
	@Override
	public User UpdateUser(Long id, User user) {
		// TODO Auto-generated method stub
		User usr=null;
		if (userRep.findById(id).isPresent()) {
			
		usr=userRep.findById(id).get();
		usr.setLname(user.getLname());
		usr.setFname(user.getFname());
		usr.setAdresse(user.getAdresse());
		usr.setUsername(user.getUsername());
		usr.setEmail(user.getEmail());
		
		userRep.save(usr);
		}
		return usr;
	}
	@Override
	public List<User> getUserByStartUsername(String ch) {
		// TODO Auto-generated method stub
		return userRep.getUserByStartUsername(ch);
	}
	@Override
	public User addUserRole(Long iduser, Long idrole) {
		// TODO Auto-generated method stub
		User usr = userRep.findById(iduser).get();
		Role role= roleRep.findById(idrole).get();
		
		usr.addRole(role);
		
		return userRep.save(usr);
	}
	@Override
	public List<Long> getIdUsersFromIdRoleStat() {
		// TODO Auto-generated method stub
		return userRep.getIdUserFromIdRoleStat();
	}
	@Override
	public List<Long> getIdUsersFromIdRoleDyn(Long idrole) {
		// TODO Auto-generated method stub
		return userRep.getIdUserFromIdRoleDyn(idrole);
	}
	@Override
	public List<User> getusersByIdRole(Long idrole) {
		// TODO Auto-generated method stub
		return userRep.getUsersFromIdrole(idrole);
	}

}
