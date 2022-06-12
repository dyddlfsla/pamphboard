package com.example.pamphboard.controller;

import com.example.pamphboard.dto.PostDto;
import com.example.pamphboard.service.PostService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pamphboard/post")
public class PostApiController {

  private final PostService postService;

  PostApiController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/{postIdx}")
  public PostDto read(@PathVariable long postIdx) {
    return postService.findByIdx(postIdx);
  }

  @PostMapping
  public Long save(@RequestBody PostDto postDto) {
    return postService.save(postDto);
  }

  @PutMapping
  public Long update(@RequestBody PostDto postDto) {
    return postService.updateById(postDto);
  }

  @DeleteMapping("/{postIdx}")
  public Long delete(@PathVariable long postIdx) {
    return postService.deleteById(postIdx);
  }

  @PostMapping("/verify/password")
  public boolean verifyPassword(long postIdx, String password) {
    return postService.isPWCorrect(postIdx, password);
  }
}


