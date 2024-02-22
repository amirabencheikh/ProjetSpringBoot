package com.projetspringboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetspringboot.demo.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByUsername(String username);
	
	@Query(value = "select * from user u where u.username like :cle%", nativeQuery = true)
	List<User> getUserByStartUsername(@Param("cle") String ch);
	
	@Query(value = "select iduser from userrole ur where ur.idrole=2", nativeQuery = true)
	List<Long> getIdUserFromIdRoleStat();
	
	@Query(value = "select iduser from userrole ur where ur.idrole=?1", nativeQuery = true)
	List<Long> getIdUserFromIdRoleDyn(Long idrole);
	
	@Query(value = "select u.* from user u,userrole ur  where  u.iduser=ur.iduser and ur.idrole=?1", nativeQuery = true)
	List<User> getUsersFromIdrole(Long idrole);
	
	

}
