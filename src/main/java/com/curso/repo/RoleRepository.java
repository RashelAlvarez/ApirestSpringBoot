package com.curso.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
