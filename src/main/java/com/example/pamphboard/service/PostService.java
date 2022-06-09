package com.example.pamphboard.service;

import com.example.pamphboard.dao.PostDao;
import com.example.pamphboard.dto.PostDto;
import com.example.pamphboard.dto.PostPagination;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private final PostDao postDao;
  private final BCryptPasswordEncoder passwordEncoder;

  PostService(PostDao postDao, BCryptPasswordEncoder passwordEncoder) {
    this.postDao = postDao;
    this.passwordEncoder = passwordEncoder;
  }

  public Long save(PostDto postDto) {
    return postDao.save(encryptPost(postDto));
  }

  public List<PostDto> findAll(int currentPage) {
    int startIdx = (currentPage - 1) * 15;
    RowBounds rowBounds = new RowBounds(startIdx, 15);
    return postDao.findAll(rowBounds);
  }

  public PostDto findByIdx(long postIdx) {
    return postDao.findByIdx(postIdx);
  }

  private PostDto encryptPost(PostDto postDto) {
    postDto.setPassword(passwordEncoder.encode(postDto.getPassword()));
    return postDto;
  }

  public boolean isPWCorrect(long postIdx, String password) {
    return passwordEncoder.matches(password, postDao.findByIdx(postIdx).getPassword());
  }

  public Long deleteById(long postIdx) {
    return postDao.deleteById(postIdx);
  }

  public Long updateById(PostDto postDto) {
    return postDao.updateById(postDto);
  }

  public PostPagination getPostPagination(int currentPage) {
    return new PostPagination(getTotalOfPost(), currentPage, 15, 5);
  }

  private int getTotalOfPost() {
    return postDao.getTotalOfPost();
  }
}
