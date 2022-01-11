package com.example.pamphboard.service;

import com.example.pamphboard.dao.PostDao;
import com.example.pamphboard.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private PostDao postDao;

  @Autowired
  PostService(PostDao postDao) {
    this.postDao = postDao;
  }

  public void savePost(PostDto postDto) {
    postDao.savePost(postDto);
  }
}
