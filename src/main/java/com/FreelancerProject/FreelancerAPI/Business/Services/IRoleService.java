package com.FreelancerProject.FreelancerAPI.Business.Services;

import com.FreelancerProject.FreelancerAPI.Entities.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAll();

    void add(Role role);

    void update(Role role);

    void delete(Role role);

    Role getById(int id);

}
