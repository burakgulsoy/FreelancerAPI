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
//        System.out.println("task id: " + task.getTask_id());
//        System.out.println("task description: "+task.getTask_description());
//        System.out.println("task type: " + task.getTask_type());
//        System.out.println("task begin date: " + task.getTask_begin_date());
//        System.out.println("task end date: " + task.getTask_end_date());
//        System.out.println("task freelancer id: " + task.getFreelancer_id());
//        System.out.println("task is updated");
    }

    @PostMapping("/deletetask")
    public void deleteTask(@RequestBody Task task) {
        taskService.delete(task);
    }

    @GetMapping("/tasks/{task_id}")
    public Task getById(@PathVariable int task_id) {
        return taskService.getById(task_id);
    }
}
