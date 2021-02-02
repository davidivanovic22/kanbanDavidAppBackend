package rs.ac.metropolitan.kanbanbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.metropolitan.kanbanbackend.entity.Comment;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByTaskId_TaskId(Integer taskId);
}
