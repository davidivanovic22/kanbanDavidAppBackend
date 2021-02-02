package rs.ac.metropolitan.kanbanbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.kanbanbackend.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByProjectId_ProjectIdAndStatusId_StatusId(Integer projectId, Integer statusId);

    List<Task> findAllByProjectId_ProjectId(Integer projectId);

    List<Task> findAllByStatusId_StatusId(Integer statusId);

}