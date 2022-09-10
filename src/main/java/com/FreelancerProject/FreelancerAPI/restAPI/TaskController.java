package com.FreelancerProject.FreelancerAPI.restAPI;

import com.FreelancerProject.FreelancerAPI.Business.Services.ITaskService;
import com.FreelancerProject.FreelancerAPI.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> get() {
        return taskService.getAll();
    }

    @PostMapping("/addtask")
    public void addTask(@RequestBody Task task) {
        taskService.add(task);
    }

    @PostMapping("/updatetask")
    public void updateTask(@RequestBody Task task) {
        taskService.update(task);

    }

    @PostMapping("/deletetask")
    public void deleteTask(@RequestBody Task task) {
        taskService.delete(task);
    }

    @GetMapping("/tasks/{task_id}")
    public Task getById(@PathVariable int task_id) {
        return taskService.getById(task_id);
    }

    @GetMapping("/tasksToDo")
    public List<Task> getAllToDo() {
        return taskService.getAllToDo();
    }

    @GetMapping("/tasksInProgress")
    public List<Task> getAllInProgress() {
        return taskService.getAllInProgress();
    }

    @GetMapping("/tasksDone")
    public List<Task> getAllDone() {
        return taskService.getAllDone();
    }
}
