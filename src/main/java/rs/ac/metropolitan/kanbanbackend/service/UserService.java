package rs.ac.metropolitan.kanbanbackend.service;

import rs.ac.metropolitan.kanbanbackend.entity.Project;
import rs.ac.metropolitan.kanbanbackend.entity.Role;
import rs.ac.metropolitan.kanbanbackend.entity.User;

import java.util.List;

public  interface UserService {

	List<User> findAll();

	User save(User user);

	User update(User user);

	User updateRecordStatus(Integer userId, Integer recordStatus);

	User findById(Integer userId);

	User findByUsername(String username);

	void deleteById(Integer userId);

	List<Role> findAllRoleListById(Integer userId);

	List<Project> findAllProjectListById(Integer userId);

	List<Project> setProjectListById(Integer userId, List<Project> projectList);

	List<Role> setRoleListById(Integer userId, List<Role> roleList);

	List<Role> deleteRoleListById(Integer userId, List<Role> roleList);

}