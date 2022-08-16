package com.FreelancerProject.FreelancerAPI.DataAccess;

import com.FreelancerProject.FreelancerAPI.Entities.Freelancer;
import com.FreelancerProject.FreelancerAPI.Entities.Role;

import java.util.List;

public interface IRoleDal {
    List<Role> getAll();

    void add(Role role);

    void update(Role role);

    void delete(Role role);

    Role getById(int id);


}
