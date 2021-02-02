package rs.ac.metropolitan.kanbanbackend.service.impl;

import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.kanbanbackend.entity.Project;
import rs.ac.metropolitan.kanbanbackend.entity.Status;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.entity.dto.ProjectStatusTaskDTO;
import rs.ac.metropolitan.kanbanbackend.repository.ProjectRepository;
import rs.ac.metropolitan.kanbanbackend.service.ProjectService;
import rs.ac.metropolitan.kanbanbackend.service.StatusService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final StatusService statusService;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Integer ProjectID) {
        return projectRepository.findById(ProjectID)
                .orElseThrow(() -> new NoSuchElementException("ProjectService.notFound"));
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project update(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteById(Integer ProjectID) {
        projectRepository.deleteById(ProjectID);
    }

    @Override
    public void saveStatusList(Integer projectId, List<Status> statusList) {
        Project project = findById(projectId);
        List<Status> statusList1 = new ArrayList<>();
        project.getStatusList().forEach(status -> {
            statusList1.add(status);
        });
        statusList.forEach(status -> {
            statusList1.add(status);
        });
        project.setStatusList(statusList1);
        save(project);
    }

    @Override
    public List<User> saveUserList(Integer projectId, List<User> userList) {
        Project project = findById(projectId);
        project.setUserList(userList);
        return save(project).getUserList();
    }

    @Override
    public void deleteStatusFromListByProjectId(Integer projectId, Integer statusId) {
        Project project = findById(projectId);
        Status status = statusService.findById(statusId);
        List<Status> statusList = findById(projectId).getStatusList();
        statusList.remove(status);
        project.setStatusList(statusList);
        save(project);
    }

    @Override
    public List<Status> findAllStatusListById(Integer projectId) {
        return findById(projectId).getStatusList();
    }

    @Override
    public ProjectStatusTaskDTO findProjectStatusTaskDTOById(Integer projectId) {
        ProjectStatusTaskDTO projectStatusTaskDTO = new ProjectStatusTaskDTO();
        projectStatusTaskDTO.setProject(findById(projectId));
        projectStatusTaskDTO.setStatusTaskDTOList(statusService.findStatusTaskDTOListByProjectId(projectId));
        return projectStatusTaskDTO;
    }

    @Override
    public ProjectStatusTaskDTO findFilteredProjectStatusTaskDTOById(Integer projectId, List<User> userList) {
        ProjectStatusTaskDTO projectStatusTaskDTO = new ProjectStatusTaskDTO();
        projectStatusTaskDTO.setProject(findById(projectId));
        projectStatusTaskDTO.setStatusTaskDTOList(statusService.findStatusTaskDTOListByProjectIdAndUserList(projectId, userList));
        return projectStatusTaskDTO;
    }

    @Override
    public List<User> findAllUserListById(Integer projectId) {
        return findById(projectId).getUserList();
    }


}