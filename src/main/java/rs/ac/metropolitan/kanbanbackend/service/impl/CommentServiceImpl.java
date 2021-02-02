package rs.ac.metropolitan.kanbanbackend.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.kanbanbackend.entity.Comment;
import rs.ac.metropolitan.kanbanbackend.repository.CommentRepository;
import rs.ac.metropolitan.kanbanbackend.service.CommentService;

import java.util.List;
import java.util.NoSuchElementException;


@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class CommentServiceImpl implements CommentService {
        private final CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment findById(Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("CommentService.notFound"));
    }

    @Override
    public List<Comment> findAllByTaskId(Integer taskId) {
        return commentRepository.findAllByTaskId_TaskId(taskId);
    }

    @Override
    public void deleteById(Integer commentId) {
       commentRepository.deleteById(commentId);
    }
}
