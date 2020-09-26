package com.reddit.demo.Repository;

import com.reddit.demo.Model.Post;
import com.reddit.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword (String username, String password);
    Optional<User> findUserByUsername (String username);
}
