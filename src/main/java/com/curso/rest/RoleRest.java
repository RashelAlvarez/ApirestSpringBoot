package com.curso.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Role;
import com.curso.model.User;
import com.curso.repo.RoleRepository;
import com.curso.repo.UserRepository;

@RestController
@RequestMapping("roles")
public class RoleRest {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/create")
	public void create(@RequestBody Role role){
		//Optional<User> userOptional= userController.findById(role.getUser().getIduser());
		
		//role.setUser(userOptional.get());
		roleRepository.save(role);
	}
	
	@GetMapping("/show")
	public List<Role> showRole(){
		return roleRepository.findAll();
	}
	
	//@PutMapping("")
	
	
	
}
