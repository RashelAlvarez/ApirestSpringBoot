package com.curso.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
