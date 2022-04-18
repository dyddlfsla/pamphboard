package com.example.pamphboard.service;

import com.example.pamphboard.dao.PostDao;
import com.example.pamphboard.dto.PostDto;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private final PostDao postDao;
  private final PasswordEncoder passwordEncoder;

  PostService(PostDao postDao, PasswordEncoder passwordEncoder) {
    this.postDao = postDao;
    this.passwordEncoder = passwordEncoder;
  }

  public Long save(PostDto postDto) {
    return postDao.save(encryptPost(postDto));
  }

  public List<PostDto> findAll() {
    return postDao.findAll();
  }

  public PostDto findByIdx(long postIdx) {
    return postDao.findByIdx(postIdx);
  }

  private PostDto encryptPost(PostDto postDto) {
    postDto.setPassword(passwordEncoder.encode(postDto.getPassword()));
    return postDto;
  }
}
