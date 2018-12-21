package com.store.config;

import com.store.areas.role.models.service.RoleServiceModel;
import com.store.areas.role.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private final RoleService roleService;

    @Autowired
    public DataLoader(RoleService roleService) {
        this.roleService = roleService;
    }

    public void run(ApplicationArguments args) {
        RoleServiceModel userRole = this.roleService.findByAuthority("USER");
        RoleServiceModel adminRole = this.roleService.findByAuthority("ADMIN");

        if (userRole == null) {
            RoleServiceModel roleServiceModel = new RoleServiceModel();
            roleServiceModel.setAuthority("USER");
            this.roleService.addRole(roleServiceModel);
        }

        if (adminRole == null) {
            RoleServiceModel roleServiceModel = new RoleServiceModel();
            roleServiceModel.setAuthority("ADMIN");
            this.roleService.addRole(roleServiceModel);
        }
    }
}