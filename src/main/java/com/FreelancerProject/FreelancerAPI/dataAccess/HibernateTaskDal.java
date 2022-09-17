package com.FreelancerProject.FreelancerAPI.dataAccess;

import com.FreelancerProject.FreelancerAPI.entities.Task;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateTaskDal implements ITaskDal {

    private final EntityManager entityManager;

    @Autowired
    public HibernateTaskDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Task> getAll() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from Task",Task.class).getResultList();
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

        return session.get(Task.class,id);
    }

    @Override
    public List<Task> getAllToDo() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from Task where task_type='TO_DO'",Task.class).getResultList();
    }

    @Override
    public List<Task> getAllInProgress() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from Task where task_type='IN_PROGRESS'",Task.class).getResultList();
    }

    @Override
    public List<Task> getAllDone() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from Task where task_type='DONE'",Task.class).getResultList();
    }
}
