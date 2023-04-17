package com.curso.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.controller.RoleController;
import com.curso.controller.UserController;
import com.curso.model.Role;
import com.curso.model.User;

@RestController
@RequestMapping("roles")
public class RoleRest {
	
	@Autowired
	private RoleController roleController;
	
	@Autowired
	private UserController userController;
	
	@PostMapping("/create")
	public void create(@RequestBody Role role){
		//Optional<User> userOptional= userController.findById(role.getUser().getIduser());
		
		//role.setUser(userOptional.get());
		roleController.save(role);
	}
	
	@GetMapping("/show")
	public List<Role> showRole(){
		return roleController.findAll();
	}
	
	//@PutMapping("")
	
	
	
}
