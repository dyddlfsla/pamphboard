package com.example.pamphboard.web;

import com.example.pamphboard.dto.PostDto;
import com.example.pamphboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

  private PostService postService;

  @Autowired
  PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/posts/save")
  public String savePostsForm(Model model) {
    model.addAttribute("PostDto", new PostDto());
    return "post/savePostForm";
  }

  @PostMapping("/posts/save")
  public String savePosts(@ModelAttribute PostDto postDto) {
    postService.savePosts(postDto);
    return "redirect:/";
  }
}
