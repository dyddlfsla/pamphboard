package com.example.pamphboard.dao;

import com.example.pamphboard.dto.PostDto;
import com.example.pamphboard.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {

  private PostMapper postMapper;

  @Autowired
  PostDao(PostMapper postMapper) {
    this.postMapper = postMapper;
  }

  public void savePosts(PostDto postDto) {
    postMapper.savePosts(postDto);
  }
}
