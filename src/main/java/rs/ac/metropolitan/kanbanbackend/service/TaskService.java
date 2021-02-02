package rs.ac.metropolitan.kanbanbackend.service;

import rs.ac.metropolitan.kanbanbackend.entity.Label;
import rs.ac.metropolitan.kanbanbackend.entity.Task;
import rs.ac.metropolitan.kanbanbackend.entity.User;

import java.util.List;

public  interface TaskService {

	List<Task> findAll();

	Task save(Task task);

	Task update(Task task);

	Task findById(Integer taskId);

	List<Task> findAllByProjectIdAndStatusId(Integer projectId, Integer statusId);

	List<Task> findAllByProjectId(Integer projectId);

	List<Task> findAllByStatusId(Integer statusId);

	List<Task> findAllByUserIdAndProjectIdAndStatusId(List<User> userList, Integer projectId, Integer statusId);

	void deleteById(Integer taskId);


	List<Label> findAllLabelListById(Integer taskId);

	List<Label> addLabelListById(Integer taskId, List<Label> labelList);

	List<Label> setLabelListById(Integer taskId, List<Label> labelList);

	List<Label> deleteLabelListById(Integer TaskId, List<Label> labelList);

}