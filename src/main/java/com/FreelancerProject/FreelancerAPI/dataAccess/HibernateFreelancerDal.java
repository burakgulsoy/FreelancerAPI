package com.FreelancerProject.FreelancerAPI.dataAccess;

import com.FreelancerProject.FreelancerAPI.entities.Freelancer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateFreelancerDal implements IFreelancerDal{
//    TODO: implement try catch for sessions
    private final EntityManager entityManager;

    @Autowired
    public HibernateFreelancerDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //automates session openings and closings
    public List<Freelancer> getAll() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from Freelancer",Freelancer.class).getResultList();
    }

    @Override
    public void add(Freelancer freelancer) {
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

        session.delete(session.get(Freelancer.class, freelancer.getFreelancer_id()));
    }

    @Override
    public Freelancer getById(int id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Freelancer.class, id);
    }

    @Override
    public List<Freelancer> getValidatedFreelancers() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from Freelancer where is_validated = 1",Freelancer.class).getResultList();
    }

    @Override
    public List<Freelancer> getUnvalidatedFreelancers() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from Freelancer where is_validated = 0",Freelancer.class).getResultList();
    }
}
