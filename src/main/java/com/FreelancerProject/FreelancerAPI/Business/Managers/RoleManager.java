package com.FreelancerProject.FreelancerAPI.Business.Managers;

import com.FreelancerProject.FreelancerAPI.Business.Services.IRoleService;
import com.FreelancerProject.FreelancerAPI.DataAccess.IRoleDal;
import com.FreelancerProject.FreelancerAPI.Entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleManager implements IRoleService {

    IRoleDal iRoleDal;

    @Autowired
    public RoleManager(IRoleDal iRoleDal) {
        this.iRoleDal = iRoleDal;
    }

    @Override
    @Transactional
    public List<Role> getAll() {
       return this.iRoleDal.getAll();
    }

    @Override
    @Transactional
    public void add(Role role) {
        this.iRoleDal.add(role);
    }

    @Override
    @Transactional
    public void update(Role role) {
        this.iRoleDal.update(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        this.iRoleDal.delete(role);
    }

    @Override
    @Transactional
    public Role getById(int id) {
        return this.iRoleDal.getById(id);
    }
}
