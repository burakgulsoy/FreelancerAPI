package com.FreelancerProject.FreelancerAPI.business.services;

import com.FreelancerProject.FreelancerAPI.entities.Freelancer;

import java.util.List;

public interface IFreelancerService {
    List<Freelancer> getAll();

    void add(Freelancer freelancer);

    void update(Freelancer freelancer);

    void delete(Freelancer freelancer);

    Freelancer getById(int id);

    List<Freelancer> getValidatedFreelancers();

    List<Freelancer> getUnvalidatedFreelancers();

}
