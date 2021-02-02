package rs.ac.metropolitan.kanbanbackend.service;

import rs.ac.metropolitan.kanbanbackend.entity.Project;
import rs.ac.metropolitan.kanbanbackend.entity.Status;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.entity.dto.ProjectStatusTaskDTO;

import java.util.List;

public  interface ProjectService {

	List<Project> findAll();

	Project save(Project project);

	Project update(Project project);

	Project findById(Integer projectID);

	void deleteById(Integer projectID);

	List<Status> saveStatusList(Integer projectId, List<Status> status);

	List<User> saveUserList(Integer projectId, List<User> userList);

	void deleteStatusFromListByProjectId(Integer projectId, Integer statusId);

	List<Status> findAllStatusListById(Integer projectId);

    ProjectStatusTaskDTO findProjectStatusTaskDTOById(Integer projectId);

	ProjectStatusTaskDTO findFilteredProjectStatusTaskDTOById(Integer projectId, List<User> userList);

	List<User> findAllUserListById(Integer projectId);

}