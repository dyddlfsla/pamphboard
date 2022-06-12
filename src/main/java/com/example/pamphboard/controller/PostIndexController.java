package com.example.pamphboard.controller;

import com.example.pamphboard.dto.PostDto;
import com.example.pamphboard.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostIndexController {

  private final PostService postService;

  PostIndexController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/post/save")
  public String saveForm(Model model) {
    model.addAttribute("PostDto", new PostDto());
    return "/post/save";
  }

  @GetMapping("/post/list")
  public String list(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage, Model model) {
    model.addAttribute("posts", postService.findAll(currentPage));
    model.addAttribute("pagination", postService.getPostPagination(currentPage));
    return "post/list";
  }

  @GetMapping("/post/read/{postIdx}")
  public String read(@PathVariable long postIdx, Model model) {
    model.addAttribute("post", postService.findByIdx(postIdx));
    return "post/read";
  }

  @GetMapping("/post/modify/{postIdx}")
  public String modify(@PathVariable long postIdx, Model model) {
    model.addAttribute("post", postService.findByIdx(postIdx));
    return "post/modify";
  }
}
