package rs.ac.metropolitan.kanbanbackend.controller;

import rs.ac.metropolitan.kanbanbackend.entity.Label;
import rs.ac.metropolitan.kanbanbackend.entity.Task;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.service.TaskService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.kanbanbackend.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
	private final TaskService taskService;
	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<Task>> getAll() {
		return ResponseEntity.ok(taskService.findAll());
	}

	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getById(@PathVariable Integer taskId) {
		return ResponseEntity.ok(taskService.findById(taskId));
	}

	@PostMapping
	public ResponseEntity<Task> save(@RequestBody Task task) {
		return ResponseEntity.status(201).body(taskService.save(task));
	}



	@PutMapping
	public ResponseEntity<Task> update(@RequestBody Task task) {
		return ResponseEntity.ok(taskService.update(task));
	}

	@DeleteMapping("/{taskId}")
	public void deleteById(@PathVariable Integer taskId) {
		taskService.deleteById(taskId);
	}

	@GetMapping("/{taskId}/labelList")
	public ResponseEntity<List<Label>> getLabelList(@PathVariable Integer taskId) {
		return ResponseEntity.ok(taskService.findAllLabelListById(taskId));
	}

	@PostMapping("/{taskId}/labelList")
	public ResponseEntity<List<Label>> setLabelList(@PathVariable Integer taskId, @RequestBody List<Label> labelList) {
		return ResponseEntity.ok(taskService.setLabelListById(taskId, labelList));
	}

	@PutMapping("/{taskId}/labelList")
	public ResponseEntity<List<Label>> addLabelList(@PathVariable Integer taskId, @RequestBody List<Label> labelList) {
		return ResponseEntity.ok(taskService.addLabelListById(taskId, labelList));
	}

	@DeleteMapping("/{taskId}/labelList")
	public ResponseEntity<List<Label>> deleteLabelList(@PathVariable Integer taskId, @RequestBody List<Label> labelList) {
		return ResponseEntity.ok(taskService.deleteLabelListById(taskId, labelList));
	}

//	@GetMapping("/{userList}/{projectId}/taskList")
//	public ResponseEntity<List<Task>>getAllByUserId(@PathVariable Integer[] userList,@PathVariable Integer projectId) {
//		List<User> users = new ArrayList<>();
//		for(Integer userId: userList){
//			users.add(userService.findById(userId));
//		}
//		return ResponseEntity.ok(taskService.findAllByUserId(users,projectId));
//	}

}

