package rs.ac.metropolitan.kanbanbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.kanbanbackend.entity.Status;
import rs.ac.metropolitan.kanbanbackend.entity.dto.StatusTaskDTO;
import rs.ac.metropolitan.kanbanbackend.service.StatusService;

import java.util.List;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class StatusController {
	private final StatusService statusService;

	@GetMapping
	public ResponseEntity<List<Status>> getAll() {
		return ResponseEntity.ok(statusService.findAll());
	}

	@GetMapping("/{statusId}")
	public ResponseEntity<Status> getById(@PathVariable Integer statusId) {
		return ResponseEntity.ok(statusService.findById(statusId));
	}

//	@GetMapping("/{name}")
//	public ResponseEntity<Status> getByName(@PathVariable String name) {
//		return ResponseEntity.ok(statusService.findByName(name));
//	}

	@PostMapping
	public ResponseEntity<Status> save(@RequestBody Status status) {
		return ResponseEntity.status(201).body(statusService.save(status));
	}


	@PostMapping("/statusTaskDTO")
	public void saveStatusTaskDTO(@RequestBody StatusTaskDTO statusTaskDTO) {
		statusService.saveStatusTaskDTO(statusTaskDTO);
	}


	@PutMapping
	public ResponseEntity<Status> update(@RequestBody Status status) {
		return ResponseEntity.ok(statusService.update(status));
	}

	@DeleteMapping("/{statusId}")
	public void deleteById(@PathVariable Integer statusId) {
		statusService.deleteById(statusId);
	}

}

