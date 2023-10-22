package com.ivoyant.elasticsearchdemocrud.controller;

import com.ivoyant.elasticsearchdemocrud.model.College;
import com.ivoyant.elasticsearchdemocrud.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public College saveCollege(@RequestBody College college) {
        return collegeService.save(college);
    }

    @GetMapping("/{location}")
    public List<College> getByLocation(@PathVariable String location) {
        return collegeService.getByLocation(location);
    }

    @DeleteMapping
    public String deleteAll() {
        return collegeService.deleteAll();
    }

    @GetMapping("/contains/{location}")
    public List<College> getByMatchPhrase(@PathVariable String location) {
        return collegeService.getByLocationContains(location);
    }

    @GetMapping("/fuzzy/{location}")
    public List<College> getByFuzzy(@PathVariable String location) {
        return collegeService.getByLocationFuzzy(location);
    }

    @GetMapping("/startsWith/{location}")
    public List<College> getByStartswith(@PathVariable String location) {
        return collegeService.getByLocationByStartsWith(location);
    }

}
