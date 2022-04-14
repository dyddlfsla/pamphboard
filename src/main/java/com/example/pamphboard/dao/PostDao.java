package com.example.pamphboard.dao;

import com.example.pamphboard.dto.PostDto;
import com.example.pamphboard.mapper.PostMapper;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {

  private final PostMapper postMapper;

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
