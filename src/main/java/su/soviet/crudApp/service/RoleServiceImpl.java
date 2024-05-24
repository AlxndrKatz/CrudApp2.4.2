package su.soviet.crudApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.soviet.crudApp.dao.RoleRepository;
import su.soviet.crudApp.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repo;

    @Override
    public Set<Role> setDefaultRole() {
        Role defaultRole = repo.findById(1L).orElse(null);
        Set<Role> defaultRoles = new HashSet<>();
        defaultRoles.add(defaultRole);
        return defaultRoles;
    }
}
