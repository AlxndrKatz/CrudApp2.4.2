package su.soviet.crudApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.soviet.crudApp.dao.UserRepository;
import su.soviet.crudApp.model.User;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleServiceImpl roleService;


    @Override
    public void createUser(User user) {
        Optional<User> userByName = repo.getUserByName(user.getName());
        Optional<User> userByEmail = repo.getUserByEmail(user.getEmail());
        if (userByName.isEmpty() && userByEmail.isEmpty()) {
            user.setRoles(roleService.setDefaultRole());
            repo.save(user);
        }
    }

    @Override
    public User getUserById(Long id) {
        if (repo.existsById(id)) {
            return repo.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        repo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }

    @Override
    public List<User> getUsers() {
        return repo.findAll();
    }
}
