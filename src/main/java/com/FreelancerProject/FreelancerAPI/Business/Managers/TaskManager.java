package com.FreelancerProject.FreelancerAPI.Business.Managers;

import com.FreelancerProject.FreelancerAPI.Business.Services.ITaskService;
import com.FreelancerProject.FreelancerAPI.DataAccess.ITaskDal;
import com.FreelancerProject.FreelancerAPI.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskManager implements ITaskService {

    ITaskDal TaskDal;

    @Autowired
    public TaskManager(ITaskDal taskDal) {
        TaskDal = taskDal;
    }

    @Override
    @Transactional
    public List<Task> getAll() {
        return this.TaskDal.getAll();
    }

    @Override
    @Transactional
    public void add(Task task) {
        this.TaskDal.add(task);
    }

    @Override
    @Transactional
    public void update(Task task) {
        this.TaskDal.update(task);
    }

    @Override
    @Transactional
    public void delete(Task task) {
        this.TaskDal.delete(task);
    }

    @Override
    @Transactional
    public Task getById(int id) {
        return this.TaskDal.getById(id);
    }

    @Override
    public List<Task> getAllToDo() {
        return this.TaskDal.getAllToDo();
    }

    @Override
    public List<Task> getAllInProgress() {
        return this.TaskDal.getAllInProgress();
    }

    @Override
    public List<Task> getAllDone() {
        return this.TaskDal.getAllDone();
    }
}
