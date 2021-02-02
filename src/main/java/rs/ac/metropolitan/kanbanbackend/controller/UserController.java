package rs.ac.metropolitan.kanbanbackend.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import rs.ac.metropolitan.kanbanbackend.entity.Project;
import rs.ac.metropolitan.kanbanbackend.entity.Role;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.service.UserService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getById(@PathVariable Integer userId) {
		return ResponseEntity.ok(userService.findById(userId));
	}

	@GetMapping("/logged-in")
	public ResponseEntity<User> loggedIn(@AuthenticationPrincipal User user) {
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		return ResponseEntity.status(201).body(userService.save(user));
	}

	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user) {
		return ResponseEntity.ok(userService.update(user));
	}

	@DeleteMapping("/{userId}")
	public void deleteById(@PathVariable Integer userId) {
		userService.deleteById(userId);
	}

	@GetMapping("/{userId}/roleList")
	public ResponseEntity<List<Role>> getRoleList(@PathVariable Integer userId) {
		return ResponseEntity.ok(userService.findAllRoleListById(userId));
	}

	@PostMapping("/{userId}/roleList")
	public ResponseEntity<List<Role>> setRoleList(@PathVariable Integer userId, @RequestBody List<Role> roleList) {
		return ResponseEntity.ok(userService.setRoleListById(userId, roleList));
	}

	@DeleteMapping("/{userId}/roleList")
	public ResponseEntity<List<Role>> deleteRoleList(@PathVariable Integer userId, @RequestBody List<Role> roleList) {
		return ResponseEntity.ok(userService.deleteRoleListById(userId, roleList));
	}


	@GetMapping("/{userId}/projectList")
	public ResponseEntity<List<Project>> getProjectList(@PathVariable Integer userId) {
		return ResponseEntity.ok(userService.findAllProjectListById(userId));
	}

	@PostMapping("/{userId}/projectList")
	public ResponseEntity<List<Project>> setProjectList(@PathVariable Integer userId, @RequestBody List<Project> projectList) {
		return ResponseEntity.ok(userService.setProjectListById(userId, projectList));
	}

}

