package com.FreelancerProject.FreelancerAPI.DataAccess;

import com.FreelancerProject.FreelancerAPI.Entities.Task;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateTaskDal implements ITaskDal {

    private EntityManager entityManager;

    @Autowired
    public HibernateTaskDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Task> getAll() {
        Session session = entityManager.unwrap(Session.class);

        List<Task> tasks = session.createQuery("from Task",Task.class).getResultList();
        return tasks;
    }

    @Override

    public void add(Task task) {
        Session session = entityManager.unwrap(Session.class);
        session.save(task);
    }

    @Override
    public void update(Task task) {
        Session session = entityManager.unwrap(Session.class);
        session.update(task);
    }

    @Override
    public void delete(Task task) {
        Session session = entityManager.unwrap(Session.class);

        Task taskToDelete = session.get(Task.class, task.getTask_id());
        session.delete(taskToDelete);
    }

    @Override
    public Task getById(int id) {
        Session session = entityManager.unwrap(Session.class);

        Task task = session.get(Task.class,id);
        return task;
    }
}
