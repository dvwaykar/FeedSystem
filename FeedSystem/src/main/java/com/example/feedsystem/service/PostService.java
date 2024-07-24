package com.example.feedsystem.service;

import com.example.feedsystem.model.Comment;
import com.example.feedsystem.model.Group;
import com.example.feedsystem.model.Like;
import com.example.feedsystem.model.Post;
import com.example.feedsystem.repository.CommentRepository;
import com.example.feedsystem.repository.LikeRepository;
import com.example.feedsystem.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Post createPost(Long groupId, Post post) {
        post.setGroup(new Group(groupId));  // Assuming Group has a constructor accepting id
        return postRepository.save(post);
    }

    public List<Post> getPostsByGroupId(Long groupId) {
        return postRepository.findByGroupId(groupId);
    }

    public void likePost(Long postId, Like like) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        like.setPost(post);
        likeRepository.save(like);
    }

    public Comment commentPost(Long postId, Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        comment.setPost(post);
        return commentRepository.save(comment);
    }

}
