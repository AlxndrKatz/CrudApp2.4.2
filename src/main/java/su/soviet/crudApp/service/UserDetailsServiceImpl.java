package su.soviet.crudApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import su.soviet.crudApp.dao.UserRepository;
import su.soviet.crudApp.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = repo.getUserByName(name).orElseThrow(() -> new UsernameNotFoundException("User not found " + name));
        System.out.println(user);
        System.out.println(user.getAuthorities());
        System.out.println(user.getRoles());
        return user;
    }
}
