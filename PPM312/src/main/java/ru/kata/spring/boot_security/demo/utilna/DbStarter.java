package ru.kata.spring.boot_security.demo.utilna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DbStarter {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DbStarter(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role admin = new Role();
        Role user = new Role();
        admin.setName("ROLE_ADMIN");
        user.setName("ROLE_USER");
        roleService.addRole(admin);
        roleService.addRole(user);
        userService.save(new User("admin",
                "admin@admin.com",
                "111111",
                Set.of(admin)));
        userService.save(new User("user",
                "user@user.com",
                "qwerty",
                Set.of(user)));
    }
}