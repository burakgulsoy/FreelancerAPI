package com.FreelancerProject.FreelancerAPI.dataAccess;

import com.FreelancerProject.FreelancerAPI.entities.Freelancer;
import java.util.List;

public interface IFreelancerDal {
    List<Freelancer> getAll();

    void add(Freelancer freelancer);

    void update(Freelancer freelancer);

    void delete(Freelancer freelancer);

    Freelancer getById(int id);

    List<Freelancer> getValidatedFreelancers();
    List<Freelancer> getUnvalidatedFreelancers();
}
