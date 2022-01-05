package com.example.pamphboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/articles/save")
  public String saveArticles() {
    return "articles-save";
  }

}