package com.reddit.demo.Service;

import com.reddit.demo.Model.Post;
import com.reddit.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void addUser(User user);

    User findById(long id);

    User findByUsernamePassword (String username, String password);

    User findByUsername (String username);

    List<User> findAllUsers();

}
