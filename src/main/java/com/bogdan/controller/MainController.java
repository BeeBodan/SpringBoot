package com.bogdan.controller;

import com.bogdan.model.UserData;
import com.bogdan.repos.UserRepoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserRepoData userRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {

        Iterable<UserData> users = userRepo.findAll();
        model.put("users", users);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String firstName, @RequestParam String secondName,
                      @RequestParam int age, @RequestParam String city,
                      Map<String, Object> model) {

        UserData user = new UserData(firstName, secondName, age, city);
        userRepo.save(user);
        Iterable<UserData> users = userRepo.findAll();
        model.put("users", users);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter,
                         Map<String, Object> model) {

        Iterable<UserData> users;
        if (filter != null && !filter.isEmpty()) {
            users = userRepo.findByFirstName(filter);
        } else {
            users = userRepo.findAll();
        }
        model.put("users", users);

        return "main";
    }
}
