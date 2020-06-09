package com.demo.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.demo.backend.model.Profile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private List<Profile> profiles;

    public ProfileController(){
        profiles = new ArrayList<>();
            profiles.add(new Profile("No.1", "Kim"));
            profiles.add(new Profile("No.2", "Lee"));
            profiles.add(new Profile("No.3", "Park"));
            profiles.add(new Profile("No.4", "Choi"));
    }

    @GetMapping()
    public List<Profile> list(){
        return profiles;
    }

    @GetMapping("/{id}")
    public Profile get(@PathVariable String id){
        return profiles.stream().filter(f -> id.equals(f.getId())).findAny().orElse(null);
    }
}