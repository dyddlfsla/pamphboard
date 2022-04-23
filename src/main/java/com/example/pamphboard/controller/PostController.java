package com.example.pamphboard.controller;

import com.example.pamphboard.dto.PostDto;
import com.example.pamphboard.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

  private final PostService postService;

  PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/post/save")
  public String saveForm(Model model) {
    model.addAttribute("PostDto", new PostDto());
    return "/post/save";
  }

  @GetMapping("/post/list")
  public String list(Model model) {
    model.addAttribute("foundPosts", postService.findAll());
    return "post/list";
  }

  @GetMapping("/post/read/{postIdx}")
  public String read(@PathVariable long postIdx, Model model) {
    model.addAttribute("foundPost", postService.findByIdx(postIdx));
    return "post/read";
  }

  @GetMapping("/post/modify/{postIdx}")
  public String modify(@PathVariable long postIdx, Model model) {
    model.addAttribute("foundPost", postService.findByIdx(postIdx));
    return "post/modify";
  }
}
