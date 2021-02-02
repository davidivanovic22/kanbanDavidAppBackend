package rs.ac.metropolitan.kanbanbackend.service;

import rs.ac.metropolitan.kanbanbackend.entity.Status;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.entity.dto.StatusTaskDTO;

import java.util.List;

public  interface StatusService {

	List<Status> findAll();

	Status save(Status status);

	Status update(Status status);

	Status findById(Integer statusID);

	Status findByName(String name);


	void deleteById(Integer statusID);

	List<StatusTaskDTO> findStatusTaskDTOListByProjectId(Integer projectId);

	List<StatusTaskDTO> findStatusTaskDTOListByProjectIdAndUserList(Integer projectId, List<User> userList);

	void saveStatusTaskDTO(StatusTaskDTO statusTaskDTO);

}