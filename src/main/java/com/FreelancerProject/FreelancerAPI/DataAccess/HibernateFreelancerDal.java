package com.FreelancerProject.FreelancerAPI.DataAccess;

import com.FreelancerProject.FreelancerAPI.Entities.Freelancer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateFreelancerDal implements IFreelancerDal{

    private EntityManager entityManager;

    @Autowired
    public HibernateFreelancerDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //automates session openings and closings
    public List<Freelancer> getAll() {
        Session session = entityManager.unwrap(Session.class);

        List<Freelancer> freelancers = session.createQuery("from Freelancer",Freelancer.class).getResultList();
        return freelancers;
    }

    @Override
    public void add(Freelancer freelancer) {
        //if gerekebilir
        Session session = entityManager.unwrap(Session.class);
        session.save(freelancer);
    }

    @Override
    public void update(Freelancer freelancer) {
        Session session = entityManager.unwrap(Session.class);

        session.update(freelancer);
    }

    @Override
    public void delete(Freelancer freelancer) {
        Session session = entityManager.unwrap(Session.class);

        Freelancer freelancerToDelete = session.get(Freelancer.class, freelancer.getFreelancer_id());
        session.delete(freelancerToDelete);
    }

    @Override
    public Freelancer getById(int id) {
        Session session = entityManager.unwrap(Session.class);

        Freelancer freelancer = session.get(Freelancer.class, id);
        return freelancer;
    }

    @Override
    public List<Freelancer> getValidatedFreelancers() {
        Session session = entityManager.unwrap(Session.class);

        List<Freelancer> freelancers = session.createQuery("from Freelancer where is_validated = 1",Freelancer.class).getResultList();
        return freelancers;
    }

    @Override
    public List<Freelancer> getUnvalidatedFreelancers() {
        Session session = entityManager.unwrap(Session.class);

        List<Freelancer> freelancers = session.createQuery("from Freelancer where is_validated = 0",Freelancer.class).getResultList();
        return freelancers;
    }


}
