package rs.ac.metropolitan.kanbanbackend.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.kanbanbackend.entity.Label;
import rs.ac.metropolitan.kanbanbackend.entity.Task;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.repository.TaskRepository;
import rs.ac.metropolitan.kanbanbackend.service.LabelService;
import rs.ac.metropolitan.kanbanbackend.service.TaskService;
import rs.ac.metropolitan.kanbanbackend.service.UserService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;
    private final LabelService labelService;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Integer taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("TaskService.notFound"));
    }

    @Override
    public List<Task> findAllByProjectIdAndStatusId(Integer projectId, Integer statusId) {
        return taskRepository.findAllByProjectId_ProjectIdAndStatusId_StatusId(projectId, statusId);
    }

    @Override
    public List<Task> findAllByProjectId(Integer projectId) {
        return taskRepository.findAllByProjectId_ProjectId(projectId);
    }

    @Override
    public List<Task> findAllByStatusId(Integer statusId) {
        return taskRepository.findAllByStatusId_StatusId(statusId);

    }

    @Override
    public List<Task> findAllByUserIdAndProjectIdAndStatusId(List<User> userList, Integer projectId, Integer statusId) {
        List<Task> taskList = findAllByProjectId(projectId);
        List<Task> taskFilteredList = new ArrayList<>();
        System.out.println(userList.size());
        taskList.forEach(task -> {
            if (task.getStatusId().getStatusId() == statusId) {
                if (userList.size() > 0) {
                    userList.forEach(user -> {
                        if (task.getUserList().contains(user)) {
                            if (!taskFilteredList.contains(task)) {
                                taskFilteredList.add(task);
                            }
                        }
                    });
                }
            }
        });
        return taskFilteredList;
    }

    @Override
    public Task save(Task task) {
        System.out.println(task.getDueDate());
        return taskRepository.save(task);
    }


    @Override
    public Task update(Task task) {
        System.out.println(task.getDueDate());
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public List<Label> findAllLabelListById(Integer taskId) {
        return findById(taskId).getLabelList();
    }

    @Override
    public List<Label> addLabelListById(Integer taskId, List<Label> LabelList) {
        Task task = findById(taskId);
        task.getLabelList().addAll(LabelList);
        return taskRepository.save(task).getLabelList();
    }

    @Override
    public List<Label> setLabelListById(Integer taskId, List<Label> LabelList) {
        Task task = findById(taskId);
        task.setLabelList(LabelList);
        return taskRepository.save(task).getLabelList();
    }

    @Override
    public List<Label> deleteLabelListById(Integer taskId, List<Label> LabelList) {
        Task task = findById(taskId);
        task.getLabelList().removeAll(LabelList);
        return taskRepository.save(task).getLabelList();
    }


}