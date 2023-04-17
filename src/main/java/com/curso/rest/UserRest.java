package com.curso.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.controller.UserController;
import com.curso.model.User;

@RestController
@RequestMapping("users")
public class UserRest {

	@Autowired
	private UserController userController;

	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {

		if (user.getUsername() == null && user.getPassword() == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(userController.save(user));
	}

	@GetMapping("/show")
	public List<User> showUser() {
		return userController.findAll();
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<User> findOneById(@PathVariable int id) {
		Optional<User> userOpt = userController.findById(id);

		if (userOpt.isPresent()) {
			return ResponseEntity.ok(userOpt.get()); // devuelve status 200
		} else {
			return ResponseEntity.notFound().build(); // si no lo encuentra devuelve status 404
		}

	}

	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user) {
		if (userController.existsById(user.getIduser())) {
			return ResponseEntity.ok(userController.save(user));

		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable int id) {
		userController.deleteById(id);
		return ResponseEntity.ok().build();
		
		
	}
}
