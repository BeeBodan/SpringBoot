package com.bogdan.repos;

import com.bogdan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepoRegistration extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
