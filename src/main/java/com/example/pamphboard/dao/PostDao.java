package com.example.pamphboard.dao;

import com.example.pamphboard.dto.PostDto;
import com.example.pamphboard.mapper.PostMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {

  private PostMapper postMapper;

  @Autowired
  PostDao(PostMapper postMapper) {
    this.postMapper = postMapper;
  }

  public void save(PostDto postDto) {
    postMapper.insert(postDto);
  }

  public List<PostDto> findAll() {
    return postMapper.selectAll();
  }
}
