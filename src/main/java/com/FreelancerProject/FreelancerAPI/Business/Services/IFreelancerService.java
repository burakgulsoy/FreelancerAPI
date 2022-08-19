package com.FreelancerProject.FreelancerAPI.Business.Services;

import com.FreelancerProject.FreelancerAPI.Entities.Freelancer;

import java.util.List;

public interface IFreelancerService {
    List<Freelancer> getAll();

    void add(Freelancer freelancer);

    void update(Freelancer freelancer);

    void delete(Freelancer freelancer);

    Freelancer getById(int id);



    //get by validation

}
