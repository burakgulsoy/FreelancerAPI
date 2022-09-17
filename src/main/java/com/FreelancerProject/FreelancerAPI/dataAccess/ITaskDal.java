package com.FreelancerProject.FreelancerAPI.dataAccess;


import com.FreelancerProject.FreelancerAPI.entities.Task;

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
