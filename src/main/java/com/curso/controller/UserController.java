package com.curso.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.User;

public interface UserController extends JpaRepository<User, Integer> {

}
