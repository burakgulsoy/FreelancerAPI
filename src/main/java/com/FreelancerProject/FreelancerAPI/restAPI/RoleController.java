package com.FreelancerProject.FreelancerAPI.restAPI;

import com.FreelancerProject.FreelancerAPI.business.services.IRoleService;
import com.FreelancerProject.FreelancerAPI.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    private final IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> get() {
        return roleService.getAll();
    }

    @PostMapping("/addrole")
    public void addRole(@RequestBody Role role) {
        roleService.add(role);
    }

    @PostMapping("/updaterole")
    public void updateRole(@RequestBody Role role) {
        roleService.update(role);
    }

    @PostMapping("/deleterole")
    public void deleteRole(@RequestBody Role role) {
        roleService.delete(role);
    }

    @GetMapping("/roles/{role_id}")
    public Role getById(@PathVariable int role_id) {
        return roleService.getById(role_id);
    }



}
