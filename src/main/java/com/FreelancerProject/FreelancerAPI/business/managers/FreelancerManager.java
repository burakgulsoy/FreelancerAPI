package com.FreelancerProject.FreelancerAPI.business.managers;

import com.FreelancerProject.FreelancerAPI.business.services.IFreelancerService;
import com.FreelancerProject.FreelancerAPI.dataAccess.IFreelancerDal;
import com.FreelancerProject.FreelancerAPI.entities.Freelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FreelancerManager implements IFreelancerService {

    final IFreelancerDal freelancerDal;

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

    @Override
    public List<Freelancer> getValidatedFreelancers() {
        return this.freelancerDal.getValidatedFreelancers();
    }

    @Override
    public List<Freelancer> getUnvalidatedFreelancers() {
        return this.freelancerDal.getUnvalidatedFreelancers();
    }
}
