package com.example.feedsystem.controller;

import com.example.feedsystem.model.Comment;
import com.example.feedsystem.model.Like;
import com.example.feedsystem.model.Post;
import com.example.feedsystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
	
    @Autowired
    private PostService postService;

    @PostMapping("/groups/{groupId}")
    public ResponseEntity<Post> createPost(@PathVariable Long groupId, @RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(groupId, post));
    }

    @GetMapping("/groups/{groupId}")
    public ResponseEntity<List<Post>> getGroupPosts(@PathVariable Long groupId) {
        return ResponseEntity.ok(postService.getPostsByGroupId(groupId));
    }

    @PostMapping("/{postId}/likes")
    public ResponseEntity<Void> likePost(@PathVariable Long postId, @RequestBody Like like) {
        postService.likePost(postId, like);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Comment> commentPost(@PathVariable Long postId, @RequestBody Comment comment) {
        return ResponseEntity.ok(postService.commentPost(postId, comment));
    }
}
