package com.cbfacademy.Baby.Classes.Kent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import com.cbfacademy.Baby.Classes.Kent.BabyClassEntity.ClassType;


@RestController
@RequestMapping(path="/baby-classes") // Base path for all endpoints
public class BabyClassController {

    @Autowired
    private BabyClassService service; // use service to fetch data

    public BabyClassController(BabyClassService service) {
        this.service = service;
    } // Constructor injection for better testability and immutability.


    @GetMapping("/{id}")
    public BabyClassEntity getClass(@PathVariable UUID id) {
        return service.getClassById(id).orElseThrow();
    }

    @PostMapping("/add")
    public BabyClassEntity createClass(@Valid @RequestBody BabyClassEntity babyClass) {
        return service.createClass(babyClass);
    }

    @PutMapping("/{id}")
    public BabyClassEntity updateClass(@PathVariable UUID id, @Valid @RequestBody BabyClassEntity babyClass) {
        return service.updateClass(id, babyClass);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable UUID id) {
        service.deleteClass(id);
    }

     @GetMapping("/type/{type}")
    public List<BabyClassEntity> getByType(@PathVariable ClassType type) {
        return service.getClassesByType(type);
    }

    @GetMapping("/age/{months}")
    public List<BabyClassEntity> getByAge(@PathVariable int months) {
        return service.getClassesByAge(months);
    }
    @GetMapping("/upcoming")
    public List<BabyClassEntity> getUpcomingClasses() {
        return service.getUpcomingClassesWithSchedules();
    }
}


