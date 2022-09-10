package com.FreelancerProject.FreelancerAPI.DataAccess;


import com.FreelancerProject.FreelancerAPI.Entities.Task;

import java.util.List;

public interface ITaskDal {
    List<Task> getAll();

    void add(Task task);

    void update(Task task);

    void delete(Task task);

    Task getById(int id);

    List<Task> getAllToDo();
    List<Task> getAllInProgress();
    List<Task> getAllDone();

}
