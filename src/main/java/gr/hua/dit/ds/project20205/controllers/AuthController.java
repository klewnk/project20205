package gr.hua.dit.ds.project20205.controllers;

import ch.qos.logback.core.model.Model;
import gr.hua.dit.ds.project20205.entities.Role;
import gr.hua.dit.ds.project20205.repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {


    RoleRepository roleRepository;

    public AuthController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void setup() {
        Role role_user = new Role("ROLE_USER");
        Role role_admin = new Role("ROLE_ADMIN");

        roleRepository.updateOrInsert(role_user);
        roleRepository.updateOrInsert(role_admin);
    }



    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
