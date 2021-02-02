package rs.ac.metropolitan.kanbanbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.kanbanbackend.entity.User;


@Repository
public  interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}