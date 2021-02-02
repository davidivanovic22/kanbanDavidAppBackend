package rs.ac.metropolitan.kanbanbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.kanbanbackend.entity.Label;

@Repository
public  interface LabelRepository extends JpaRepository<Label, Integer> {

}