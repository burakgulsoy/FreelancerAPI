package com.FreelancerProject.FreelancerAPI.DataAccess;

import com.FreelancerProject.FreelancerAPI.Entities.Freelancer;
import com.FreelancerProject.FreelancerAPI.Entities.Role;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateRoleDal implements IRoleDal{

    private EntityManager entityManager;

    @Autowired
    public HibernateRoleDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Role> getAll() {
        Session session = entityManager.unwrap(Session.class);

        List<Role> roles = session.createQuery("from Role",Role.class).getResultList();
        return roles;
    }

    @Override
    public void add(Role role) {
        Session session = entityManager.unwrap(Session.class);
        session.save(role);
    }

    @Override
    public void update(Role role) {
        Session session = entityManager.unwrap(Session.class);
        session.update(role);
    }

    @Override
    public void delete(Role role) {
        Session session = entityManager.unwrap(Session.class);

        Role roleToDelete = session.get(Role.class, role.getRole_id());
        session.delete(roleToDelete);
    }

    @Override
    public Role getById(int id) {
        Session session = entityManager.unwrap(Session.class);

        Role role = session.get(Role.class, id);
        return role;
    }
}
