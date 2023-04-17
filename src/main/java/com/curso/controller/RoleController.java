package com.curso.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Role;

public interface RoleController extends JpaRepository<Role, Integer> {

}
