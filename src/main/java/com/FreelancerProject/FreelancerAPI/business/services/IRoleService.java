package com.FreelancerProject.FreelancerAPI.business.services;

import com.FreelancerProject.FreelancerAPI.entities.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAll();

    void add(Role role);

    void update(Role role);

    void delete(Role role);

    Role getById(int id);

}
