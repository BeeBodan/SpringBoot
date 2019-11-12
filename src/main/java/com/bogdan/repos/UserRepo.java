package com.bogdan.repos;

import com.bogdan.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findByFirstName(String firstName);

}