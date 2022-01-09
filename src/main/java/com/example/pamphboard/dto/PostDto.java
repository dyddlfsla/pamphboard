package com.example.pamphboard.dto;

import java.time.LocalDateTime;

public class PostDto {

  private long idx;
  private String writer;
  private String password;
  private String title;
  private String content;
  private LocalDateTime regDate;

  public long getIdx() {
    return idx;
  }

  public void setIdx(long idx) {
    this.idx = idx;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDateTime getRegDate() {
    return regDate;
  }

  public void setRegDate(LocalDateTime regDate) {
    this.regDate = regDate;
  }
}
