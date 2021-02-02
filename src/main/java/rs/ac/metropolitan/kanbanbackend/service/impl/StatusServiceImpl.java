package rs.ac.metropolitan.kanbanbackend.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.kanbanbackend.entity.Project;
import rs.ac.metropolitan.kanbanbackend.entity.Status;
import rs.ac.metropolitan.kanbanbackend.entity.Task;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.entity.dto.StatusTaskDTO;
import rs.ac.metropolitan.kanbanbackend.repository.ProjectRepository;
import rs.ac.metropolitan.kanbanbackend.repository.StatusRepository;
import rs.ac.metropolitan.kanbanbackend.service.StatusService;
import rs.ac.metropolitan.kanbanbackend.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;
    private final ProjectRepository projectRepository;
    private final TaskService taskService;


    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Integer statusId) {
        return statusRepository.findById(statusId)
                .orElseThrow(() -> new NoSuchElementException("StatusService.notFound"));
    }

    @Override
    public Status findByName(String name) {
        return statusRepository.findByName(name);
    }

    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Status update(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public void deleteById(Integer statusId) {
        statusRepository.deleteById(statusId);
    }

    @Override
    public List<StatusTaskDTO> findStatusTaskDTOListByProjectId(Integer projectId) {
        List<StatusTaskDTO> statusTaskDTOList = new ArrayList<>();
        Project project = projectRepository.findById(projectId).get();
        project.getStatusList().forEach(status -> {
            StatusTaskDTO statusTaskDTO = new StatusTaskDTO();
            statusTaskDTO.setStatus(status);
            statusTaskDTO.setTaskList(taskService.findAllByProjectIdAndStatusId(projectId, status.getStatusId()));
            statusTaskDTOList.add(statusTaskDTO);
        });

        return statusTaskDTOList;
    }

    @Override
    public List<StatusTaskDTO> findStatusTaskDTOListByProjectIdAndUserList(Integer projectId, List<User> userList) {
        List<StatusTaskDTO> statusTaskDTOList = new ArrayList<>();
        Project project = projectRepository.findById(projectId).get();

        project.getStatusList().forEach(status -> {
            StatusTaskDTO statusTaskDTO = new StatusTaskDTO();
            statusTaskDTO.setStatus(status);
            statusTaskDTO.setTaskList(taskService.findAllByUserIdAndProjectIdAndStatusId(userList, projectId, status.getStatusId()));
            statusTaskDTOList.add(statusTaskDTO);
        });

        return statusTaskDTOList;
}

    @Override
    public void saveStatusTaskDTO(StatusTaskDTO statusTaskDTO) {
        statusTaskDTO.getTaskList().forEach(task -> {
            task.setStatusId(statusTaskDTO.getStatus());
            taskService.save(task);
        });
    }


}