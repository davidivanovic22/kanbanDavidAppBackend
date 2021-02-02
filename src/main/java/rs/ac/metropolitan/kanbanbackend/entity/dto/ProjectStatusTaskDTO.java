package rs.ac.metropolitan.kanbanbackend.entity.dto;

import lombok.Data;
import rs.ac.metropolitan.kanbanbackend.entity.Project;

import java.util.List;

@Data
public class ProjectStatusTaskDTO {
    Project project;
    List<StatusTaskDTO> statusTaskDTOList;
}
