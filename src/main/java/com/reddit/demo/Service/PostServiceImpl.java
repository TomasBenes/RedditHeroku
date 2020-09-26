package com.reddit.demo.Service;

import com.reddit.demo.Model.Post;
import com.reddit.demo.Repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepo postRepo;

    @Autowired
    public PostServiceImpl (PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> allPosts() {
        return this.postRepo.findAll();
    }

    @Override
    public Post findById(long id) {
        return this.postRepo.findById(id).orElse(null);
    }

    @Override
    public void addPost(Post post) {
        this.postRepo.save(post);
    }

    @Override
    public void plusVote(long id) {
        Optional<Post> optionalPost = this.postRepo.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setVotes(post.getVotes() + 1);
            this.postRepo.save(post);
        }
    }

    @Override
    public void minusVote(long id) {
        Optional<Post> optionalPost = this.postRepo.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setVotes(post.getVotes() - 1);
            this.postRepo.save(post);
        }
    }
}
