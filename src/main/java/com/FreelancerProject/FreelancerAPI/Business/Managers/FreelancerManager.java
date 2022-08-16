package com.FreelancerProject.FreelancerAPI.Business.Managers;

import com.FreelancerProject.FreelancerAPI.Business.Services.IFreelancerService;
import com.FreelancerProject.FreelancerAPI.DataAccess.IFreelancerDal;
import com.FreelancerProject.FreelancerAPI.Entities.Freelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FreelancerManager implements IFreelancerService {

    IFreelancerDal freelancerDal;

    @Autowired
    public FreelancerManager(IFreelancerDal freelancerDal) {
        this.freelancerDal = freelancerDal;
    }

    @Override
    @Transactional
    public List<Freelancer> getAll() {
        return this.freelancerDal.getAll();
    }

    @Override
    @Transactional
    public void add(Freelancer freelancer) {
        //iş kuralları yazılır
        this.freelancerDal.add(freelancer);
    }

    @Override
    @Transactional
    public void update(Freelancer freelancer) {
        this.freelancerDal.update(freelancer);
    }

    @Override
    @Transactional
    public void delete(Freelancer freelancer) {
        this.freelancerDal.delete(freelancer);
    }

    @Override
    @Transactional
    public Freelancer getById(int id) {
        return this.freelancerDal.getById(id);
    }
}
