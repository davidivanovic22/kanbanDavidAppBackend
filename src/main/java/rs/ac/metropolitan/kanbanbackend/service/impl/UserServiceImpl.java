package rs.ac.metropolitan.kanbanbackend.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.kanbanbackend.entity.Project;
import rs.ac.metropolitan.kanbanbackend.entity.Role;
import rs.ac.metropolitan.kanbanbackend.entity.User;
import rs.ac.metropolitan.kanbanbackend.repository.UserRepository;
import rs.ac.metropolitan.kanbanbackend.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("UserService.notFound"));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        user = findById(user.getUserId());
        user.setProjectList(user.getProjectList());
        user.setRecordStatus(user.getRecordStatus());
        return userRepository.save(user);
    }

    @Override
    public List<Project> setProjectListById(Integer userId, List<Project> projectList) {
        User user = findById(userId);
        user.setProjectList(projectList);
        return userRepository.save(user).getProjectList();
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<Role> findAllRoleListById(Integer userId) {
        return findById(userId).getRoleList();
    }

    @Override
    public List<Project> findAllProjectListById(Integer userId) {
        return findById(userId).getProjectList();
    }



    @Override
    public List<Role> setRoleListById(Integer userId, List<Role> roleList) {
        User user = findById(userId);
        user.setRoleList(roleList);
        return save(user).getRoleList();
    }

    @Override
    public List<Role> deleteRoleListById(Integer userId, List<Role> RoleList) {
        User user = findById(userId);
        user.getRoleList().removeAll(RoleList);
        return save(user).getRoleList();
    }


}