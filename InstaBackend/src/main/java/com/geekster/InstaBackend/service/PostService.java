package com.geekster.InstaBackend.service;


import com.geekster.InstaBackend.model.Post;
import com.geekster.InstaBackend.model.User;
import com.geekster.InstaBackend.repository.ICommentRepo;
import com.geekster.InstaBackend.repository.ILikeRepo;
import com.geekster.InstaBackend.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;
    @Autowired
    ICommentRepo iCommentRepo;
    @Autowired
    ILikeRepo iLikeRepo;


    public void createInstaPost(Post instaPost) {
        postRepo.save(instaPost);
    }

    public Post getPostById(Integer postId) {
      return  postRepo.findById(postId).orElseThrow();

    }

    public void removeById(Integer postId) {
        //delete all likes
        iLikeRepo.deleteById(postId);



        // delete all comments
        iCommentRepo.deleteById(postId);

        //finally delete post
        postRepo.deleteById(postId);




    }
}
