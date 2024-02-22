package com.projetspringboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetspringboot.demo.entities.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
