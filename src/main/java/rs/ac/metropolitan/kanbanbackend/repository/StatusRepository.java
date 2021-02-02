package rs.ac.metropolitan.kanbanbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.kanbanbackend.entity.Status;

@Repository
public  interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findByName(String name);
}