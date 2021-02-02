package rs.ac.metropolitan.kanbanbackend.entity.dto;

import lombok.Data;
import rs.ac.metropolitan.kanbanbackend.entity.Status;
import rs.ac.metropolitan.kanbanbackend.entity.Task;

import java.util.List;

@Data
public class StatusTaskDTO {
    Status status;
    List<Task> taskList;
}
