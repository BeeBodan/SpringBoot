package com.bogdan.repos;

import com.bogdan.model.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepoData extends CrudRepository<UserData, Long> {

    List<UserData> findByFirstName(String firstName);

}