package com.FreelancerProject.FreelancerAPI.restAPI;

import com.FreelancerProject.FreelancerAPI.business.services.IFreelancerService;
import com.FreelancerProject.FreelancerAPI.entities.Freelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FreelancerController {

    private final IFreelancerService freelancerService;

    @Autowired
    public FreelancerController(IFreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    @GetMapping("/freelancers")
    public List<Freelancer> get() {
        return freelancerService.getAll();
    }

    @PostMapping("/addfreelancer")
    public void addFreelancer(@RequestBody Freelancer freelancer) {
        freelancerService.add(freelancer);
    }

    @PostMapping("/updatefreelancer")
    public void updateFreelancer(@RequestBody Freelancer freelancer) {
        freelancerService.update(freelancer);
    }

    @PostMapping("/deletefreelancer")
    public void deleteFreelancer(@RequestBody Freelancer freelancer) {
        freelancerService.delete(freelancer);
    }

    @GetMapping("/freelancers/{freelancer_id}")
    public Freelancer getById(@PathVariable int freelancer_id) {
        return freelancerService.getById(freelancer_id);
    }

    @GetMapping("/validatedfreelancers")
    public List<Freelancer> getValidatedFreelancers() {
        return freelancerService.getValidatedFreelancers();
    }

    @GetMapping("/unvalidatedfreelancers")
    public List<Freelancer> getUnvalidatedFreelancers() {
        return freelancerService.getUnvalidatedFreelancers();
    }

}
