package com.FreelancerProject.FreelancerAPI.dataAccess;

import com.FreelancerProject.FreelancerAPI.entities.Role;

import java.util.List;

public interface IRoleDal {
    List<Role> getAll();

    void add(Role role);

    void update(Role role);

    void delete(Role role);

    Role getById(int id);


}
