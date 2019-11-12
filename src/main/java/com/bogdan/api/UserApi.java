package com.bogdan.api;

import com.bogdan.model.User;
import com.bogdan.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserApi {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String main(Map<String, Object> model) {

        Iterable<User> users = userRepo.findAll();
        model.put("users", users);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String firstName, @RequestParam String secondName,
                      @RequestParam int age, @RequestParam String city,
                      Map<String, Object> model) {

        User user = new User(firstName, secondName, age, city);
        userRepo.save(user);
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter,
                         Map<String, Object> model) {

        Iterable<User> users;
        if (filter != null && !filter.isEmpty()) {
            users = userRepo.findByFirstName(filter);
        } else {
            users = userRepo.findAll();
        }
        model.put("users", users);

        return "main";
    }
}
