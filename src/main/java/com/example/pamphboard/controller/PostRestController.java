package com.example.pamphboard.controller;

import com.example.pamphboard.dto.PostDto;
import com.example.pamphboard.service.PostService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostRestController {

  private final PostService postService;

  PostRestController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/api/pamphboard/post/read/{postIdx}")
  public PostDto read(@PathVariable long postIdx) {
    return postService.findByIdx(postIdx);
  }

  @PostMapping("/api/pamphboard/post/save")
  public Long save(@RequestBody PostDto postDto) {
    return postService.save(postDto);
  }

  @PutMapping("/api/pamphboard/post/update/")
  public Long update(@RequestBody PostDto postDto) {
    return postService.updateById(postDto);
  }

  @DeleteMapping("/api/pamphboard/post/delete/{postIdx}")
  public Long delete(@PathVariable long postIdx) {
    return postService.deleteById(postIdx);
  }

  @PostMapping("/api/verify/post/password")
  public boolean verifyPassword(long postIdx, String password) {
    return postService.isPWCorrect(postIdx, password);
  }
}


