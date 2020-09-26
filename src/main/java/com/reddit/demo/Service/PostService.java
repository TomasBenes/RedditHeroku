package com.reddit.demo.Service;

import com.reddit.demo.Model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> allPosts();
    Post findById (long id);
    void addPost (Post post);
    void plusVote (long id);
    void minusVote (long id);
}
