package com.example.pamphboard.dao;

import com.example.pamphboard.dto.PostDto;
import com.example.pamphboard.mapper.PostMapper;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {

  private final PostMapper postMapper;

  PostDao(PostMapper postMapper) {
    this.postMapper = postMapper;
  }

  public Long save(PostDto postDto) {
    return postMapper.insert(postDto);
  }

  public List<PostDto> findAll(RowBounds rowBounds) {
    return postMapper.selectAll(rowBounds);
  }

  public PostDto findByIdx(long postIdx) {
    return postMapper.selectById(postIdx);
  }

  public Long deleteById(long postIdx) {
    return postMapper.deleteById(postIdx);
  }

  public Long updateById(PostDto postDto) {
    return postMapper.updateById(postDto);
  }

  public int getTotalOfPost() {
    return postMapper.getTotalOfPost();
  }
}
