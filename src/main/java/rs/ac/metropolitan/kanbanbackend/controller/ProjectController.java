package rs.ac.metropolitan.kanbanbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.kanbanbackend.entity.Project;
import rs.ac.metropolitan.kanbanbackend.entity.Status;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.entity.dto.ProjectStatusTaskDTO;
import rs.ac.metropolitan.kanbanbackend.service.ProjectService;
import rs.ac.metropolitan.kanbanbackend.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
	private final ProjectService projectService;
	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<Project>> getAll() {
		return ResponseEntity.ok(projectService.findAll());
	}

	@GetMapping("/{projectId}")
	public ResponseEntity<Project> getById(@PathVariable Integer projectId) {
		return ResponseEntity.ok(projectService.findById(projectId));
	}

	@PostMapping
	public ResponseEntity<Project> save(@RequestBody Project project) {
		return ResponseEntity.status(201).body(projectService.save(project));
	}


	@PostMapping("/{projectId}/statusList")
	public ResponseEntity<List<Status>> saveStatusList(@PathVariable Integer projectId, @RequestBody List<Status> statusList) {
		return ResponseEntity.status(201).body(projectService.saveStatusList(projectId, statusList));
	}


	@PostMapping("/{projectId}/statusColumnList")
	public void addStatusList(@PathVariable Integer projectId, @RequestBody List<Status> statusList) {
		projectService.addStatusList(projectId, statusList);
	}

	@PostMapping("/{projectId}/userList")
	public ResponseEntity<List<User>> saveUserList(@PathVariable Integer projectId, @RequestBody List<User> userList) {
		return ResponseEntity.status(201).body(projectService.saveUserList(projectId, userList));
	}

	@DeleteMapping("/statusList/{projectId}/{statusId}")
	public void deleteStatusFromListByProjectId(@PathVariable Integer projectId, @PathVariable Integer statusId) {
		projectService.deleteStatusFromListByProjectId(projectId, statusId);
	}

	@PutMapping
	public ResponseEntity<Project> update(@RequestBody Project project) {
		return ResponseEntity.ok(projectService.update(project));
	}

	@DeleteMapping("/{projectId}")
	public void deleteById(@PathVariable Integer projectId) {
		projectService.deleteById(projectId);
	}

	@GetMapping("/{projectId}/statusList")
	public ResponseEntity<List<Status>> getProjectList(@PathVariable Integer projectId) {
		return ResponseEntity.ok(projectService.findAllStatusListById(projectId));
	}

	@GetMapping("/{projectId}/userList")
	public ResponseEntity<List<User>> getAllUserList(@PathVariable Integer projectId) {
		return ResponseEntity.ok(projectService.findAllUserListById(projectId));
	}

	@GetMapping("/{projectId}/projectStatusTaskDTO")
	public ResponseEntity<ProjectStatusTaskDTO> getProjectStatusTaskDTO(@PathVariable Integer projectId) {
		return ResponseEntity.ok(projectService.findProjectStatusTaskDTOById(projectId));
	}

	@GetMapping("/{projectId}/{userList}")
	public ResponseEntity<ProjectStatusTaskDTO> getFilteredProjectStatusTaskDTOById(@PathVariable Integer projectId,@PathVariable Integer[] userList) {
		List<User> users = new ArrayList<>();
		for (Integer userId : userList) {
			users.add(userService.findById(userId));
		}
		return ResponseEntity.ok(projectService.findFilteredProjectStatusTaskDTOById(projectId, users));
	}


}

